package com.iot.assetcreditinformationsystem.controller;

import com.iot.assetcreditinformationsystem.domain.BuildingStructure;
import com.iot.assetcreditinformationsystem.service.BuildingStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(UserController.admin_prefix)
public class BuildingStructureController {

    private static final Logger logger = LoggerFactory.getLogger(BuildingStructureController.class);

    private final String entity = "buildingstructure";

    @Autowired
    private BuildingStructureService buildingStructureService;

    /**
     * 查询所有建筑结构
     * @return
     */
    @GetMapping(value = "/"+entity+"")
    public List<BuildingStructure> buildingStructureList(){
        logger.info("查询所有建筑结构");
        return buildingStructureService.findAll();
    }

    /**
     * 添加一个建筑结构
     *
     * @return
     */
    @PostMapping(value = "/"+entity+"")
    public BuildingStructure buildingStructureAdd(@Valid BuildingStructure buildingStructure, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            logger.info(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        logger.info("添加一个建筑结构");
        return buildingStructureService.save(buildingStructure);
    }

    //根据id查询一个建筑结构
    @GetMapping(value = "/"+entity+"/{id}")
    public BuildingStructure buildingStructureFindOne(@PathVariable("id") Integer id){
        logger.info("根据id查询一个建筑结构");
        return buildingStructureService.findOne(id);
    }

    //根据id更新一个建筑结构
    @PutMapping(value = "/"+entity+"")
    public BuildingStructure buildingStructureUpdate(BuildingStructure buildingStructure){
        logger.info("根据id更新一个建筑结构");
        return buildingStructureService.save(buildingStructure);
    }

    //根据id删除一个建筑结构
    @DeleteMapping(value = "/"+entity+"/{id}")
    public void buildingStructureDelete(@PathVariable("id") Integer id){
        logger.info("根据id删除一个建筑结构");
        buildingStructureService.delete(id);
    }
}
