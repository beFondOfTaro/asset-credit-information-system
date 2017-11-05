package com.iot.assetcreditinformationsystem.controller;

import com.iot.assetcreditinformationsystem.domain.City;
import com.iot.assetcreditinformationsystem.service.CityService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(UserController.admin_prefix)
public class CityController {

    private final static Logger logger = LoggerFactory.getLogger(CityController.class);

    private final String entity = "city";

    @Autowired
    private CityService cityService;

    /**
     * 查询所有城市
     * @return
     */
    @GetMapping(value = "/"+entity+"")
    public List<City> citysList(){
        logger.info("查询所有城市");
        return cityService.findAll();
    }

    /**
     * 添加一个城市
     *
     * @return
     */
    @PostMapping(value = "/"+entity+"")
    public City cityAdd(@Valid City city,
                                      BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            logger.info(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        logger.info("添加一个城市");
        return cityService.save(city);
    }

    //查询一个城市
    @GetMapping(value = "/"+entity+"/{id}")
    public City cityFindOne(@PathVariable("id") Integer id){
        logger.info("查询一个城市");
        return cityService.findOne(id);
    }

    //更新一个城市
    @PutMapping(value = "/"+entity+"")
    public City cityUpdate(@Valid City city,
                                         BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            logger.info(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        logger.info("更新一个城市");
        return cityService.save(city);
    }

    //根据id删除一个城市
    @DeleteMapping(value = "/"+entity+"/{id}")
    public void cityDelete(@PathVariable("id") Integer id){
        logger.info("根据id删除一个城市");
        cityService.delete(id);
    }
}
