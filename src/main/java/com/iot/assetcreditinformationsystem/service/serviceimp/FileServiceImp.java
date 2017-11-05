package com.iot.assetcreditinformationsystem.service.serviceimp;

import com.iot.assetcreditinformationsystem.domain.OutsidePicture;
import com.iot.assetcreditinformationsystem.domain.PicClassify;
import com.iot.assetcreditinformationsystem.repository.OutsidePictureRepository;
import com.iot.assetcreditinformationsystem.repository.PicClassifyRepository;
import com.iot.assetcreditinformationsystem.service.FileService;
import com.iot.assetcreditinformationsystem.util.ResponseModel;
import com.iot.assetcreditinformationsystem.util.fileUtil.FileUtil;
import com.iot.assetcreditinformationsystem.util.fileUtil.ResponseFileInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FileServiceImp implements FileService {

    private static final Logger logger = LoggerFactory.getLogger(FileServiceImp.class);

    @Autowired
    private OutsidePictureRepository outsidePictureRepository;

    @Autowired
    private PicClassifyRepository picClassifyRepository;

    @Autowired
    private FileUtil fileUtil;

    @Value("${fileUploadPath}")
    private String fileUploadPath;

    @Override
    public List<Map<String,Object>> filesUpload(MultipartFile[] files,
                                                Integer userId,
                                                Integer preAssessmentReportId,
                                                String picClassify,
                                                boolean isOverride)
    {
        List<Map<String,Object>> data = new ArrayList<>();
        //如果要覆盖，先删除原本上传的此类型照片
        if (isOverride){
            List<OutsidePicture> outsidePictureList = outsidePictureRepository.findByPicClassifyId(
                    picClassifyRepository.findByClassify(picClassify).getId()
            );
            for (OutsidePicture o : outsidePictureList){
                if (new File(o.getPic()).delete()){
                    outsidePictureRepository.delete(o.getId());
                    logger.info("原文件已删除");
                }
            }
        }
        Integer count = 1;
        logger.info("总共"+files.length+"个文件");
        for (MultipartFile file : files){
            //将每一个文件的上传封装成一个方法，单独进行事物处理
            fileUpload(file,count,data,picClassify,userId,preAssessmentReportId);
            count++;
        }
        return data;
    }

    //本类内部调用,由于事务处理必须为public
    @Transactional
    public void fileUpload(MultipartFile file,
                           Integer count,
                           List<Map<String,Object>> data,
                           String picClassify,
                           Integer userId,
                           Integer preAssessmentReportId)
    {
        String path;
        Map<String,Object> fileResponseInfo = new HashMap<>();
        OutsidePicture outsidePicture = new OutsidePicture();
        outsidePicture.setPreAssessmentReportId(preAssessmentReportId);
        if (!file.isEmpty()){
            //构造文件存储路径为存储仓库+用户ID+报单ID+类别
            //区分存储路径是否有/
            if (fileUploadPath.trim().lastIndexOf("/") == (fileUploadPath.trim().length()-1)){
                path = fileUploadPath+userId+"/"+preAssessmentReportId+"/"+picClassify+"/";
            }
            else {
                path = fileUploadPath + "/" + userId + "/"+ preAssessmentReportId+"/"+picClassify+"/";
            }
            ResponseFileInfo responseFileInfo = fileUtil.fileUpload(file,path);
            if (responseFileInfo.isSuccessful()){
                //根据照片类型获取该类型的id
                PicClassify picClassifyObj =  picClassifyRepository.findByClassify(picClassify);
                if (picClassifyObj!=null){
                    Integer picClassifyId =  picClassifyObj.getId();
                    //写入文件信息到outside_picture表
                    //存储pic为上传仓库的相对路径
                    String responseFileAbsPath = responseFileInfo
                            .getFile()
                            .getAbsolutePath()
                            .replace("\\","/");
                    outsidePicture.setPic(
                            responseFileAbsPath.substring(
                                    responseFileAbsPath.indexOf(fileUploadPath)+fileUploadPath.length()
                            )
                    );
                    outsidePicture.setPicClassifyId(picClassifyId);
                    outsidePictureRepository.save(outsidePicture);
                    logger.info("第"+count+"个文件上传成功");
                    fileResponseInfo.put("fileName",file.getOriginalFilename());
                    fileResponseInfo.put("status", ResponseModel.SUCCESS_MSG);
                    data.add(fileResponseInfo);
                }
                else {
                    logger.warn("未知照片类型,第"+count+"个文件上传失败");
                    fileResponseInfo.put("fileName",file.getOriginalFilename());
                    fileResponseInfo.put("status", ResponseModel.FAILED_MSG);
                    data.add(fileResponseInfo);
                }
            }
            else{
                logger.warn("第"+count+"个文件上传失败");
                fileResponseInfo.put("fileName",file.getOriginalFilename());
                fileResponseInfo.put("status", ResponseModel.FAILED_MSG);
                data.add(fileResponseInfo);
            }
        }
        else {
            logger.warn("第"+count+"个文件为空，上传失败");
        }
    }

    @Override
    public void fileDownload(HttpServletResponse httpServletResponse,String fileName) {
        File file;
        if (fileUploadPath.trim().lastIndexOf("/") == (fileUploadPath.trim().length()-1)){
            file = new File(fileUploadPath+fileName);
        }
        else {
            file = new File(fileUploadPath+"/"+fileName);
        }
        fileUtil.fileDownload(httpServletResponse,file);
    }

    @Override
    public ResponseModel fileDelete(String fileName) {
        ResponseModel responseModel;
        File file;
        if (fileUploadPath.trim().lastIndexOf("/") == (fileUploadPath.trim().length()-1)){
            file = new File(fileUploadPath+fileName);
        }
        else {
            file = new File(fileUploadPath+"/"+fileName);
        }
        if ( file.delete()){
            outsidePictureRepository.delete(outsidePictureRepository.findByPic(fileName));
            responseModel = new ResponseModel(ResponseModel.SUCCESS_MSG);
        }
        else {
            responseModel = new ResponseModel(400,ResponseModel.FAILED_MSG);
        }
        return responseModel;
    }
}
