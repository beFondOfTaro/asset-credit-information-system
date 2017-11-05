package com.iot.assetcreditinformationsystem.controller.userAccessController;

import com.iot.assetcreditinformationsystem.domain.LocationInfo;
import com.iot.assetcreditinformationsystem.service.LocationInfoService;
import com.iot.assetcreditinformationsystem.service.PreAssessmentReportService;
import com.iot.assetcreditinformationsystem.util.ResponseModel;
import com.iot.assetcreditinformationsystem.util.token.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NormalPreAssRepController {

    private final static Logger logger = LoggerFactory.getLogger(NormalPreAssRepController.class);

    private final String entity = "preassessmentreport";

    @Autowired
    private PreAssessmentReportService preAssessmentReportService;


    /**
     * 查询待评估房屋信息
     * @param userId 用户id (token)
     * @param digest 消息摘要(token)
     * @param isAssessed 是否评估（默认未评估）
     * @return
     */
    @GetMapping("/myhouse/{assessed}")
    public ResponseModel preAssessmentReportList(
            @RequestParam("userid") Integer userId,
            @RequestParam("digest") String digest,
            @PathVariable("assessed") boolean isAssessed){
        Token token = new Token(userId,digest);
        logger.info("查询用户id为"+token.getUserId()+"的待评估房屋信息");
        List data =  preAssessmentReportService.findPreAssessmentReportByUserIdAndIsAssessed(token.getUserId(),isAssessed);
        return new ResponseModel(data);
    }
}
