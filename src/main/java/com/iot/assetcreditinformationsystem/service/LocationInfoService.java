package com.iot.assetcreditinformationsystem.service;

import com.iot.assetcreditinformationsystem.domain.LocationInfo;
import com.iot.assetcreditinformationsystem.util.ResponseModel;

public interface LocationInfoService extends BaseService<LocationInfo> {

    LocationInfo findByPreAssessmentReportId(Integer preAssessmentReportId);

    ResponseModel findLocationInfoListByPreAssessmentReportId(Integer preAssessmentReportId);

    ResponseModel deleteById(Integer id);

    ResponseModel locationDeleteByPreAssessmentId(Integer preAssessmentReportId);
}
