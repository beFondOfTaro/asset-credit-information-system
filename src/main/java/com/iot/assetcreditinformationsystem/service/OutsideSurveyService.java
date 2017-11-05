package com.iot.assetcreditinformationsystem.service;

import com.iot.assetcreditinformationsystem.domain.OutsideSurvey;

import java.util.List;

public interface OutsideSurveyService extends BaseService<OutsideSurvey> {

    List<OutsideSurvey> findByPreAssessmentReportId(Integer preAssessmentId);

}
