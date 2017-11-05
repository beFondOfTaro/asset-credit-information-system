package com.iot.assetcreditinformationsystem.service.serviceimp;

import com.iot.assetcreditinformationsystem.domain.Terrain;
import com.iot.assetcreditinformationsystem.repository.TerrainRepository;
import com.iot.assetcreditinformationsystem.service.TerrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TerrainServiceImp implements TerrainService {

    @Autowired
    private TerrainRepository terrainRepository;

    @Override
    public List<Terrain> findAll() {
        return terrainRepository.findAll();
    }

    @Override
    public Terrain save(Terrain entity) {
        return terrainRepository.save(entity);
    }

    @Override
    public Terrain findOne(Integer id) {
        return terrainRepository.findOne(id);
    }

    @Override
    public Terrain update(Terrain entity) {
        return terrainRepository.save(entity);
    }

    @Override
    public void delete(Integer id) {
        terrainRepository.delete(id);
    }
}
