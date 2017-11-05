package com.iot.assetcreditinformationsystem.controller;

import com.iot.assetcreditinformationsystem.domain.Region;
import com.iot.assetcreditinformationsystem.service.RegionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(UserController.admin_prefix)
public class RegionController {

    private final static Logger logger = LoggerFactory.getLogger(RegionController.class);

    private final String entity = "region";

    @Autowired
    private RegionService regionService;

    /**
     * 查询所有区
     * @return
     */
    @GetMapping(value = "/"+entity+"")
    public List<Region> regionsList(){
        logger.info("查询所有区");
        return regionService.findAll();
    }

    /**
     * 添加一个区
     *
     * @return
     */
    @PostMapping(value = "/"+entity+"")
    public Region regionAdd(@Valid Region region,
                                      BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            logger.info(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        logger.info("添加一个区");
        return regionService.save(region);
    }

    //查询一个区
    @GetMapping(value = "/"+entity+"/{id}")
    public Region regionFindOne(@PathVariable("id") Integer id){
        logger.info("查询一个区");
        return regionService.findOne(id);
    }

    //更新一个区
    @PutMapping(value = "/"+entity+"")
    public Region regionUpdate(@Valid Region region,
                                         BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            logger.info(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        logger.info("更新一个区");
        return regionService.save(region);
    }

    //根据id删除一个区
    @DeleteMapping(value = "/"+entity+"/{id}")
    public void regionDelete(@PathVariable("id") Integer id){
        logger.info("根据id删除一个区");
        regionService.delete(id);
    }
}
