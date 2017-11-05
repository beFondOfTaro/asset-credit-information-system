package com.iot.assetcreditinformationsystem.controller.userAccessController;

import com.iot.assetcreditinformationsystem.domain.LocationInfo;
import com.iot.assetcreditinformationsystem.service.LocationInfoService;
import com.iot.assetcreditinformationsystem.util.ResponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class NormalLocInfController {

    private static final Logger logger = LoggerFactory.getLogger(NormalLocInfController.class);

    @Autowired
    private LocationInfoService locationInfoService;

    private final String entity = "locationinfo";

    /**
     * 根据preAssessmentReportId查询所有位置信息
     * @param preAssessmentReportId 预评报单id
     */
    @GetMapping(value = entity+"/{preAssessmentReportId}")
    public ResponseModel findLocationInfoListByPreAssessmentReportId(@PathVariable("preAssessmentReportId") Integer preAssessmentReportId){
        return locationInfoService.findLocationInfoListByPreAssessmentReportId(preAssessmentReportId);
    }

    /**
     * 添加一个位置信息
     * @param locationInfo 位置信息
     * @param bindingResult 错误信息
     */
    @PostMapping(value = entity)
    public LocationInfo locationInfoAdd(@Valid LocationInfo locationInfo, BindingResult bindingResult){
        logger.info("添加一个位置信息");
        if (bindingResult.hasErrors()){
            logger.info(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        LocationInfo locInfo = locationInfoService.findByPreAssessmentReportId(locationInfo.getPreAssessmentReportId());
        if (locInfo!=null){
            locationInfo.setId(locInfo.getId());
        }
        return locationInfoService.save(locationInfo);
    }

    /**
     * 根据preAssessmentReportId删除一条位置信息
     * @param preAssessmentReportId 预评报单id
     */
    @DeleteMapping(value = entity+"/{preAssessmentReportId}")
    public ResponseModel locationDeleteByPreAssessmentId(@PathVariable("preAssessmentReportId") Integer preAssessmentReportId){
        return locationInfoService.locationDeleteByPreAssessmentId(preAssessmentReportId);
    }
}
