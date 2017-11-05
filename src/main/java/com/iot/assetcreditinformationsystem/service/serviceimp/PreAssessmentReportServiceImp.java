package com.iot.assetcreditinformationsystem.service.serviceimp;

import com.iot.assetcreditinformationsystem.domain.PreAssessmentReport;
import com.iot.assetcreditinformationsystem.repository.PreAssessmentReportRepository;
import com.iot.assetcreditinformationsystem.service.PreAssessmentReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class PreAssessmentReportServiceImp implements PreAssessmentReportService {

    @Autowired
    private PreAssessmentReportRepository preAssessmentReportRepository;

    @Override
    public List<PreAssessmentReport> findAll() {
        return preAssessmentReportRepository.findAll();
    }

    @Override
    public PreAssessmentReport save(PreAssessmentReport entity) {
        return preAssessmentReportRepository.save(entity);
    }

    @Override
    public PreAssessmentReport findOne(Integer id) {
        return preAssessmentReportRepository.findOne(id);
    }

    @Override
    public PreAssessmentReport update(PreAssessmentReport entity) {
        return preAssessmentReportRepository.save(entity);
    }

    @Override
    public void delete(Integer id) {
        preAssessmentReportRepository.delete(id);
    }

    @Override
    public List<PreAssessmentReport> selectAll() {
        return preAssessmentReportRepository.selectAll();
    }

    @Override
    public List<Map<String,Object>> findHouseIsAssessed(boolean isAssessed) {
        List<Map<String,Object>> data = new ArrayList<>();
        Map<String,Object> houseData;
        List<PreAssessmentReport> preAssessmentReportList = preAssessmentReportRepository.findPreAssessmentReportByIsAssessed(isAssessed);
        for (PreAssessmentReport preAssessmentReport : preAssessmentReportList){
            houseData = getHouseInfoFromPreAssRep(preAssessmentReport);
            data.add(houseData);
        }
        return data;
    }

    @Override
    public List<Map<String,Object>> findPreAssessmentReportByUserIdAndIsAssessed(Integer userId, boolean assessed) {
        List<Map<String,Object>> data = new ArrayList<>();
        Map<String,Object> houseData;
        List<PreAssessmentReport> preAssessmentReportList = preAssessmentReportRepository.findPreAssessmentReportByUserIdAndIsAssessed(userId,assessed);
        for (PreAssessmentReport preAssessmentReport : preAssessmentReportList){
            houseData = getHouseInfoFromPreAssRep(preAssessmentReport);
            data.add(houseData);
        }
        return data;
    }

    private Map<String,Object> getHouseInfoFromPreAssRep(PreAssessmentReport preAssessmentReport){
        Map<String, Object> data = new HashMap<>();
        data.put("id",preAssessmentReport.getId());
        data.put("isAssessed",preAssessmentReport.isAssessed());
        data.put("houseName", preAssessmentReport.getHouseName());
        data.put("guaCor",preAssessmentReport.getGuaranteeCorporation());
        data.put("bank", preAssessmentReport.getBank().getName());
        data.put("bankBranch", preAssessmentReport.getBankBranch());
        data.put("city", preAssessmentReport.getCity());
        data.put("region", preAssessmentReport.getRegion());
        data.put("street", preAssessmentReport.getStreet());
        data.put("area",preAssessmentReport.getArea());
        data.put("loanAmount", preAssessmentReport.getLoanAmount());
        data.put("remarks",preAssessmentReport.getRemarks());
        return data;
    }
}
