package com.iot.assetcreditinformationsystem.service.serviceimp;

import com.iot.assetcreditinformationsystem.domain.Region;
import com.iot.assetcreditinformationsystem.repository.RegionRepository;
import com.iot.assetcreditinformationsystem.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RegionServiceImp implements RegionService {

    @Autowired
    private RegionRepository regionRepository;

    @Override
    public List<Region> findAll() {
        return regionRepository.findAll();
    }

    @Override
    public Region save(Region entity) {
        return regionRepository.save(entity);
    }

    @Override
    public Region findOne(Integer id) {
        return regionRepository.findOne(id);
    }

    @Override
    public Region update(Region entity) {
        return regionRepository.save(entity);
    }

    @Override
    public void delete(Integer id) {
        regionRepository.delete(id);
    }
}
