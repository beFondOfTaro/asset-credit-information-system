package com.iot.assetcreditinformationsystem.service.serviceimp;

import com.iot.assetcreditinformationsystem.domain.OutsideSurvey;
import com.iot.assetcreditinformationsystem.repository.OutsideSurveyRepository;
import com.iot.assetcreditinformationsystem.service.OutsideSurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OutsideSurveyServiceImp implements OutsideSurveyService {

    @Autowired
    private OutsideSurveyRepository outsideSurveyRepository;

    @Override
    public List<OutsideSurvey> findAll() {
        return outsideSurveyRepository.findAll();
    }

    @Override
    public OutsideSurvey save(OutsideSurvey entity) {
        return outsideSurveyRepository.save(entity);
    }

    @Override
    public OutsideSurvey findOne(Integer id) {
        return outsideSurveyRepository.findOne(id);
    }

    @Override
    public OutsideSurvey update(OutsideSurvey entity) {
        return outsideSurveyRepository.save(entity);
    }

    @Override
    public void delete(Integer id) {
        outsideSurveyRepository.delete(id);
    }

    @Override
    public List<OutsideSurvey> findByPreAssessmentReportId(Integer preAssessmentId) {
        return outsideSurveyRepository.findByPreAssessmentReportId(preAssessmentId);
    }
}
