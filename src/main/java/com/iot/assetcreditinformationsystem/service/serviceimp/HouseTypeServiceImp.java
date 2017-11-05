package com.iot.assetcreditinformationsystem.service.serviceimp;

import com.iot.assetcreditinformationsystem.domain.HouseType;
import com.iot.assetcreditinformationsystem.repository.HouseTypeRepository;
import com.iot.assetcreditinformationsystem.service.HouseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HouseTypeServiceImp implements HouseTypeService {

    @Autowired
    private HouseTypeRepository houseTypeRepository;

    @Override
    public List<HouseType> findAll() {
        return houseTypeRepository.findAll();
    }

    @Override
    public HouseType save(HouseType entity) {
        return houseTypeRepository.save(entity);
    }

    @Override
    public HouseType findOne(Integer id) {
        return houseTypeRepository.findOne(id);
    }

    @Override
    public HouseType update(HouseType entity) {
        return houseTypeRepository.save(entity);
    }

    @Override
    public void delete(Integer id) {
        houseTypeRepository.delete(id);
    }
}
