package com.iot.assetcreditinformationsystem.controller;

import com.iot.assetcreditinformationsystem.service.FileService;
import com.iot.assetcreditinformationsystem.util.ResponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping(UserController.admin_prefix)
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private FileService fileService;

    @PostMapping(value = "/fileupload/{preAssessmentReportId}")
    public ResponseModel fileUpload(@RequestParam("file") MultipartFile[] files,
                                    @PathVariable("preAssessmentReportId") Integer preAssessmentReportId,
                                    @RequestParam("picClassify") String picClassify,
                                    @RequestParam(value = "isOverride",defaultValue = "false") boolean isOverride,//是否覆盖原本类别的照片
                                    @RequestParam("userid") Integer userId
                                    ) {
        return new ResponseModel(fileService.filesUpload(files,userId,preAssessmentReportId,picClassify,isOverride));
    }
}
