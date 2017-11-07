package com.iot.assetcreditinformationsystem.service.serviceimp;

import com.iot.assetcreditinformationsystem.domain.GuaranteeCorporation;
import com.iot.assetcreditinformationsystem.repository.GuaranteeCorporationRepository;
import com.iot.assetcreditinformationsystem.service.GuaranteeCorporationService;
import com.iot.assetcreditinformationsystem.util.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class GuaranteeCorporationServiceImp implements GuaranteeCorporationService {

    @Autowired
    private GuaranteeCorporationRepository guaranteeCorporationRepository;

    @Override
    public List<GuaranteeCorporation> findAll() {
        return guaranteeCorporationRepository.findAll();
    }

    @Override
    public GuaranteeCorporation save(GuaranteeCorporation entity) {
        return guaranteeCorporationRepository.save(entity);
    }

    @Override
    public GuaranteeCorporation findOne(Integer id) {
        return guaranteeCorporationRepository.findOne(id);
    }

    @Override
    public GuaranteeCorporation update(GuaranteeCorporation entity) {
        return guaranteeCorporationRepository.save(entity);
    }

    @Override
    public void delete(Integer id) {
        guaranteeCorporationRepository.delete(id);
    }
}
