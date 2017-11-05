package com.iot.assetcreditinformationsystem.service.serviceimp;

import com.iot.assetcreditinformationsystem.domain.LocationInfo;
import com.iot.assetcreditinformationsystem.repository.LocationInfoRepository;
import com.iot.assetcreditinformationsystem.service.LocationInfoService;
import com.iot.assetcreditinformationsystem.util.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LocationInfoServiceImp implements LocationInfoService {

    @Autowired
    private LocationInfoRepository locationInfoRepository;

    public LocationInfoServiceImp() {
    }

    @Override
    public List<LocationInfo> findAll() {
        return locationInfoRepository.findAll();
    }

    @Override
    public LocationInfo save(LocationInfo entity) {
        return locationInfoRepository.save(entity);
    }

    @Override
    public LocationInfo findOne(Integer id) {
        return locationInfoRepository.findOne(id);
    }

    @Override
    public LocationInfo update(LocationInfo entity) {
        return locationInfoRepository.save(entity);
    }

    @Override
    public void delete(Integer id) {
        locationInfoRepository.delete(id);
    }

    @Override
    public LocationInfo findByPreAssessmentReportId(Integer preAssessmentReportId) {
        return locationInfoRepository.findByPreAssessmentReportId(preAssessmentReportId);
    }

    @Override
    public ResponseModel findLocationInfoListByPreAssessmentReportId(Integer preAssessmentReportId) {
        locationInfoRepository.findByPreAssessmentReportId(preAssessmentReportId);
        return new ResponseModel(locationInfoRepository.findAll());
    }

    @Override
    public ResponseModel deleteById(Integer id) {
        try {
            locationInfoRepository.delete(id);
            return new ResponseModel();
        } catch (Exception e) {
            return new ResponseModel(HttpStatus.BAD_REQUEST.value(),e.getMessage());
        }
    }

    @Override
    public ResponseModel locationDeleteByPreAssessmentId(Integer preAssessmentReportId) {
        try {
            locationInfoRepository.deleteByPreAssessmentReportId(preAssessmentReportId);
            return new ResponseModel();
        } catch (Exception e) {
            return new ResponseModel(HttpStatus.BAD_REQUEST.value(),e.getMessage());
        }
    }
}
