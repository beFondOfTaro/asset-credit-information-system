package com.iot.assetcreditinformationsystem.service.serviceimp;

import com.iot.assetcreditinformationsystem.domain.ExtraMaterial;
import com.iot.assetcreditinformationsystem.repository.ExtraMaterialRepository;
import com.iot.assetcreditinformationsystem.service.ExtraMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ExtraMaterialServiceImp implements ExtraMaterialService {

    @Autowired
    private ExtraMaterialRepository extraMaterialRepository;

    @Override
    public List<ExtraMaterial> findAll() {
        return extraMaterialRepository.findAll();
    }

    @Override
    public ExtraMaterial save(ExtraMaterial entity) {
        return extraMaterialRepository.save(entity);
    }

    @Override
    public ExtraMaterial findOne(Integer id) {
        return extraMaterialRepository.findOne(id);
    }

    @Override
    public ExtraMaterial update(ExtraMaterial entity) {
        return extraMaterialRepository.save(entity);
    }

    @Override
    public void delete(Integer id) {
        extraMaterialRepository.delete(id);
    }
}
