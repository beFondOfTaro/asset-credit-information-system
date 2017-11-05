package com.iot.assetcreditinformationsystem.controller.userAccessController;

import com.iot.assetcreditinformationsystem.service.OutsidePictureService;
import com.iot.assetcreditinformationsystem.util.ResponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NormalOutPicController {

    private static final Logger logger = LoggerFactory.getLogger(NormalOutPicController.class);

    @Autowired
    private OutsidePictureService outsidePictureService;

    private final String entity = "outsidepicture";

    @GetMapping(value = entity)
    public ResponseModel findByPreAssessmentReportId(@RequestParam("preAssessmentReportId") Integer preAssessmentReportId,
                                                     @RequestParam("userid") Integer userId){
        logger.info("用户id:"+userId+",获取报单id为"+preAssessmentReportId+"的所有文件名");
        ResponseModel responseModel = new ResponseModel(outsidePictureService.findByPreAssessmentReportId(preAssessmentReportId));
        logger.info("用户id:"+userId+",获取报单id为"+preAssessmentReportId+"的所有文件名完成!");
        return responseModel;
    }
}
