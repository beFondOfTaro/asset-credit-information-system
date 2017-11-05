package com.iot.assetcreditinformationsystem.repository;

import com.iot.assetcreditinformationsystem.domain.LocationInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationInfoRepository extends JpaRepository<LocationInfo,Integer> {

    LocationInfo findByPreAssessmentReportId(Integer preAssessmentReportId);

    void deleteByPreAssessmentReportId(Integer preAssessmentReportId);
}
