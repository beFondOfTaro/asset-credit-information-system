package com.iot.assetcreditinformationsystem.repository;

import com.iot.assetcreditinformationsystem.domain.PreAssessmentReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PreAssessmentReportRepository extends JpaRepository<PreAssessmentReport, Integer> {

    @Query("SELECT preAssessmentReport FROM PreAssessmentReport preAssessmentReport JOIN preAssessmentReport.bank bank")
    List<PreAssessmentReport> selectAll();//查询所有报单

    List<PreAssessmentReport> findPreAssessmentReportByIsAssessed(boolean isAssessed);//通过是否被评估查询所有报单

    List<PreAssessmentReport> findPreAssessmentReportByUserIdAndIsAssessed(Integer userId,boolean isAssessed);

}
