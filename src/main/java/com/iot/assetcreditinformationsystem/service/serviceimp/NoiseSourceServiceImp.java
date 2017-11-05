package com.iot.assetcreditinformationsystem.service.serviceimp;

import com.iot.assetcreditinformationsystem.domain.NoiseSource;
import com.iot.assetcreditinformationsystem.repository.NoiseSourceRepository;
import com.iot.assetcreditinformationsystem.service.NoiseSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NoiseSourceServiceImp implements NoiseSourceService {

    @Autowired
    private NoiseSourceRepository noiseSourceRepository;

    @Override
    public List<NoiseSource> findAll() {
        return noiseSourceRepository.findAll();
    }

    @Override
    public NoiseSource save(NoiseSource entity) {
        return noiseSourceRepository.save(entity);
    }

    @Override
    public NoiseSource findOne(Integer id) {
        return noiseSourceRepository.findOne(id);
    }

    @Override
    public NoiseSource update(NoiseSource entity) {
        return noiseSourceRepository.save(entity);
    }

    @Override
    public void delete(Integer id) {
        noiseSourceRepository.delete(id);
    }
}
