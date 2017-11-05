package com.iot.assetcreditinformationsystem.controller;

import com.iot.assetcreditinformationsystem.domain.ProjectType;
import com.iot.assetcreditinformationsystem.service.ProjectTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = UserController.admin_prefix)
public class ProjectTypeController {

    private final static Logger logger = LoggerFactory.getLogger(ProjectTypeController.class);

    private final String entity = "projectType";

    @Autowired
    private ProjectTypeService projectTypeService;

    /**
     * 查询所有项目类型
     * @return
     */
    @GetMapping(value = "/"+entity+"")
    public List<ProjectType> projectTypesList(){
        logger.info("查询所有项目类型");
        return projectTypeService.findAll();
    }

    /**
     * 添加一个项目类型
     *
     * @return
     */
    @PostMapping(value = "/"+entity+"")
    public ProjectType projectTypeAdd(@Valid ProjectType projectType,
                                                      BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            logger.info(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        logger.info("添加一个项目类型");
        return projectTypeService.save(projectType);
    }

    //查询一个项目类型
    @GetMapping(value = "/"+entity+"/{id}")
    public ProjectType projectTypeFindOne(@PathVariable("id") Integer id){
        logger.info("查询一个项目类型");
        return projectTypeService.findOne(id);
    }

    //更新一个项目类型
    @PutMapping(value = "/"+entity+"")
    public ProjectType projectTypeUpdate(@Valid ProjectType projectType,
                                                         BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            logger.info(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        logger.info("更新一个项目类型");
        return projectTypeService.save(projectType);
    }

    //根据id删除一个项目类型
    @DeleteMapping(value = "/"+entity+"/{id}")
    public void projectTypeDelete(@PathVariable("id") Integer id){
        logger.info("根据id删除一个项目类型");
        projectTypeService.delete(id);
    }
}
