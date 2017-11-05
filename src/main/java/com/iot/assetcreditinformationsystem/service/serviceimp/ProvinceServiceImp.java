package com.iot.assetcreditinformationsystem.service.serviceimp;

import com.iot.assetcreditinformationsystem.domain.Province;
import com.iot.assetcreditinformationsystem.repository.ProvinceRepository;
import com.iot.assetcreditinformationsystem.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProvinceServiceImp implements ProvinceService {

    @Autowired
    private ProvinceRepository provinceRepository;

    @Override
    public List<Province> findAll() {
        return provinceRepository.findAll();
    }

    @Override
    public Province save(Province entity) {
        return provinceRepository.save(entity);
    }

    @Override
    public Province findOne(Integer id) {
        return provinceRepository.findOne(id);
    }

    @Override
    public Province update(Province entity) {
        return provinceRepository.save(entity);
    }

    @Override
    public void delete(Integer id) {
        provinceRepository.delete(id);
    }
}
