package com.iot.assetcreditinformationsystem.repository;

import com.iot.assetcreditinformationsystem.domain.OutsideSurvey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OutsideSurveyRepository extends JpaRepository<OutsideSurvey,Integer> {

    List<OutsideSurvey> findByPreAssessmentReportId(Integer preAssessmentId);
}
