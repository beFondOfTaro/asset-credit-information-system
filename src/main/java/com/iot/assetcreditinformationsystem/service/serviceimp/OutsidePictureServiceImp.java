package com.iot.assetcreditinformationsystem.service.serviceimp;

import com.iot.assetcreditinformationsystem.domain.OutsidePicture;
import com.iot.assetcreditinformationsystem.repository.OutsidePictureRepository;
import com.iot.assetcreditinformationsystem.service.OutsidePictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OutsidePictureServiceImp implements OutsidePictureService {

    @Autowired
    private OutsidePictureRepository outsidePictureRepository;

    @Override
    public List<OutsidePicture> findAll() {
        return outsidePictureRepository.findAll();
    }

    @Override
    public OutsidePicture save(OutsidePicture entity) {
        return outsidePictureRepository.save(entity);
    }

    @Override
    public OutsidePicture findOne(Integer id) {
        return outsidePictureRepository.findOne(id);
    }

    @Override
    public OutsidePicture update(OutsidePicture entity) {
        return outsidePictureRepository.save(entity);
    }

    @Override
    public void delete(Integer id) {
        outsidePictureRepository.delete(id);
    }

    @Override
    public List<OutsidePicture> findByPreAssessmentReportId(Integer preAssessmentReportId) {
        return outsidePictureRepository.findByPreAssessmentReportId(preAssessmentReportId);
    }
}
