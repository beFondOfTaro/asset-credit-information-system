package com.iot.assetcreditinformationsystem.service;

import com.iot.assetcreditinformationsystem.domain.OutsidePicture;

import java.util.List;

public interface OutsidePictureService extends BaseService<OutsidePicture> {

    List<OutsidePicture> findByPreAssessmentReportId(Integer preAssessmentReportId);
}
