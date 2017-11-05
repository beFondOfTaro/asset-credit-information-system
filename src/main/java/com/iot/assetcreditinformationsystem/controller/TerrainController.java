package com.iot.assetcreditinformationsystem.controller;

import com.iot.assetcreditinformationsystem.domain.Terrain;
import com.iot.assetcreditinformationsystem.service.TerrainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = UserController.admin_prefix)
public class TerrainController {

    private final static Logger logger = LoggerFactory.getLogger(TerrainController.class);

    private final String entity = "terrain";

    @Autowired
    private TerrainService terrainService;

    /**
     * 查询所有地势
     * @return
     */
    @GetMapping(value = "/"+entity+"")
    public List<Terrain> terrainsList(){
        logger.info("查询所有地势");
        return terrainService.findAll();
    }

    /**
     * 添加一个地势
     *
     * @return
     */
    @PostMapping(value = "/"+entity+"")
    public Terrain terrainAdd(@Valid Terrain terrain,
                                      BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            logger.info(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        logger.info("添加一个地势");
        return terrainService.save(terrain);
    }

    //查询一个地势
    @GetMapping(value = "/"+entity+"/{id}")
    public Terrain terrainFindOne(@PathVariable("id") Integer id){
        logger.info("查询一个地势");
        return terrainService.findOne(id);
    }

    //更新一个地势
    @PutMapping(value = "/"+entity+"")
    public Terrain terrainUpdate(@Valid Terrain terrain,
                                         BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            logger.info(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        logger.info("更新一个地势");
        return terrainService.save(terrain);
    }

    //根据id删除一个地势
    @DeleteMapping(value = "/"+entity+"/{id}")
    public void terrainDelete(@PathVariable("id") Integer id){
        logger.info("根据id删除一个地势");
        terrainService.delete(id);
    }
}
