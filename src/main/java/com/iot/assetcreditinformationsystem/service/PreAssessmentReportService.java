package com.iot.assetcreditinformationsystem.service;

import com.iot.assetcreditinformationsystem.domain.PreAssessmentReport;

import java.util.List;
import java.util.Map;

public interface PreAssessmentReportService extends BaseService<PreAssessmentReport> {

    List<PreAssessmentReport> selectAll();

    List<Map<String,Object>> findHouseIsAssessed(boolean isAssessed);

    List<Map<String,Object>> findPreAssessmentReportByUserIdAndIsAssessed(Integer userId,boolean isAssessed);

}
