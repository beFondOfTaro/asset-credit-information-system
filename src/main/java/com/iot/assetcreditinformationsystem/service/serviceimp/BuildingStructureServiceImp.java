package com.iot.assetcreditinformationsystem.service.serviceimp;

import com.iot.assetcreditinformationsystem.domain.BuildingStructure;
import com.iot.assetcreditinformationsystem.repository.BuildingStructureRepository;
import com.iot.assetcreditinformationsystem.service.BuildingStructureService;
import com.iot.assetcreditinformationsystem.util.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BuildingStructureServiceImp implements BuildingStructureService {

    @Autowired
    private BuildingStructureRepository buildingStructureRepository;

    @Override
    public List<BuildingStructure> findAll() {
        return buildingStructureRepository.findAll();
    }

    @Override
    public BuildingStructure save(BuildingStructure entity) {
        return buildingStructureRepository.save(entity);
    }

    @Override
    public BuildingStructure findOne(Integer id) {
        return buildingStructureRepository.findOne(id);
    }

    @Override
    public BuildingStructure update(BuildingStructure entity) {
        return buildingStructureRepository.save(entity);
    }

    @Override
    public void delete(Integer id) {
        buildingStructureRepository.delete(id);
    }
}
