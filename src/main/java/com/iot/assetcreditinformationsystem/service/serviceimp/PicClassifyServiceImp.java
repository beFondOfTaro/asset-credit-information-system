package com.iot.assetcreditinformationsystem.service.serviceimp;

import com.iot.assetcreditinformationsystem.domain.PicClassify;
import com.iot.assetcreditinformationsystem.repository.PicClassifyRepository;
import com.iot.assetcreditinformationsystem.service.PicClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PicClassifyServiceImp implements PicClassifyService {

    @Autowired
    private PicClassifyRepository picClassifyRepository;

    @Transactional
    @Override
    public List<PicClassify> findAll() {
        return picClassifyRepository.findAll();
    }

    @Transactional
    @Override
    public PicClassify save(PicClassify entity) {
        return picClassifyRepository.save(entity);
    }

    @Transactional
    @Override
    public PicClassify findOne(Integer id) {
        return picClassifyRepository.findOne(id);
    }

    @Transactional
    @Override
    public PicClassify update(PicClassify entity) {
        return picClassifyRepository.save(entity);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        picClassifyRepository.delete(id);
    }
}
