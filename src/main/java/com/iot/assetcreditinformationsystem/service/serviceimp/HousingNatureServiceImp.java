package com.iot.assetcreditinformationsystem.service.serviceimp;

import com.iot.assetcreditinformationsystem.domain.HousingNature;
import com.iot.assetcreditinformationsystem.repository.HousingNatureRepository;
import com.iot.assetcreditinformationsystem.service.HousingNatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HousingNatureServiceImp implements HousingNatureService {

    @Autowired
    private HousingNatureRepository housingNatureRepository;

    @Override
    public List<HousingNature> findAll() {
        return housingNatureRepository.findAll();
    }

    @Override
    public HousingNature save(HousingNature entity) {
        return housingNatureRepository.save(entity);
    }

    @Override
    public HousingNature findOne(Integer id) {
        return housingNatureRepository.findOne(id);
    }

    @Override
    public HousingNature update(HousingNature entity) {
        return housingNatureRepository.save(entity);
    }

    @Override
    public void delete(Integer id) {
        housingNatureRepository.delete(id);
    }
}
