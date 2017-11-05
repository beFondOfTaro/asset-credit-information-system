package com.iot.assetcreditinformationsystem.service.serviceimp;

import com.iot.assetcreditinformationsystem.domain.ProjectType;
import com.iot.assetcreditinformationsystem.repository.ProjectTypeRepository;
import com.iot.assetcreditinformationsystem.service.ProjectTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProjectTypeServiceImp implements ProjectTypeService {

    @Autowired
    private ProjectTypeRepository projectTypeRepository;

    @Override
    public List<ProjectType> findAll() {
        return projectTypeRepository.findAll();
    }

    @Override
    public ProjectType save(ProjectType entity) {
        return projectTypeRepository.save(entity);
    }

    @Override
    public ProjectType findOne(Integer id) {
        return projectTypeRepository.findOne(id);
    }

    @Override
    public ProjectType update(ProjectType entity) {
        return projectTypeRepository.save(entity);
    }

    @Override
    public void delete(Integer id) {
        projectTypeRepository.delete(id);
    }
}
