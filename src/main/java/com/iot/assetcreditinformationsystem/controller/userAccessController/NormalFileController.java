package com.iot.assetcreditinformationsystem.controller.userAccessController;

import com.iot.assetcreditinformationsystem.service.FileService;
import com.iot.assetcreditinformationsystem.util.ResponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

@RestController
public class NormalFileController {

    private static final Logger logger = LoggerFactory.getLogger(NormalFileController.class);

    @Autowired
    private FileService fileService;

    @PostMapping(value = "fileupload/{preAssessmentReportId}/{isOverride}")
    public ResponseModel fileUpload(@RequestParam("file") MultipartFile[] files,
                                    @PathVariable("preAssessmentReportId") Integer preAssessmentReportId,
                                    @RequestParam("picClassify") String picClassify,
                                    @PathVariable("isOverride") boolean isOverride,//是否覆盖原本类别的照片
                                    @RequestParam("userid") Integer userId) {
        logger.info("用户id:"+userId+",报单id："+preAssessmentReportId+"，文件上传开始");
        ResponseModel responseModel = new ResponseModel(fileService.filesUpload(
                files,userId,preAssessmentReportId,picClassify,isOverride
            )
        );
        logger.info("用户id:"+userId+",报单id："+preAssessmentReportId+"，文件上传结束");
        return responseModel;
    }

    @GetMapping(value = "filedownload")
    public void filesDownload(@RequestParam("fileName") String fileName,
                                      @RequestParam("userid") Integer userId,
                                      HttpServletResponse httpServletResponse){
        logger.info("用户id:"+userId+",请求下载文件:"+fileName);
        fileService.fileDownload(httpServletResponse, fileName);
        logger.info("用户id:"+userId+",文件"+fileName+"下载结束");
    }

    @PostMapping(value = "filedelete")
    public ResponseModel filesDelete(@RequestParam("fileName") String fileName,
                                     @RequestParam("userid") Integer userId){
        logger.info("用户id:"+userId+",请求删除文件："+fileName);
        ResponseModel responseModel = fileService.fileDelete(fileName);
        logger.info("用户id:"+userId+",文件:fileName 已删除！");
        return responseModel;
    }
}
