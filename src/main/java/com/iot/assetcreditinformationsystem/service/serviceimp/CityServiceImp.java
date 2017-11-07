package com.iot.assetcreditinformationsystem.service.serviceimp;

import com.iot.assetcreditinformationsystem.domain.City;
import com.iot.assetcreditinformationsystem.repository.CityRepository;
import com.iot.assetcreditinformationsystem.service.CityService;
import com.iot.assetcreditinformationsystem.util.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CityServiceImp implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public City save(City entity) {
        return cityRepository.save(entity);
    }

    @Override
    public City findOne(Integer id) {
        return cityRepository.findOne(id);
    }

    @Override
    public City update(City entity) {
        return cityRepository.save(entity);
    }

    @Override
    public void delete(Integer id) {
        cityRepository.delete(id);
    }
}
