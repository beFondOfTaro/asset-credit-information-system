package com.iot.assetcreditinformationsystem.controller;

import com.iot.assetcreditinformationsystem.domain.LocationInfo;
import com.iot.assetcreditinformationsystem.service.LocationInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(UserController.admin_prefix)
public class LocationInfoController {

    private final static Logger logger = LoggerFactory.getLogger(LocationInfoController.class);

    private final String entity = "locationinfo";

    @Autowired
    private LocationInfoService locationInfoService;

    /**
     * 查询所有位置信息
     * @return
     */
    @GetMapping(value = "/"+entity+"")
    public List<LocationInfo> locationInfosList(){
        logger.info("查询所有位置信息");
        return locationInfoService.findAll();
    }

    /**
     * 添加一个位置信息
     *
     * @return
     */
    @PostMapping(value = "/"+entity+"")
    public LocationInfo locationInfoAdd(@Valid LocationInfo locationInfo,
                                          BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            logger.info(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        logger.info("添加一个位置信息");
        return locationInfoService.save(locationInfo);
    }

    //根据id查询一个位置信息
    @GetMapping(value = "/"+entity+"/{id}")
    public LocationInfo locationInfoFindOne(@PathVariable("id") Integer id){
        logger.info("查询一个位置信息");
        return locationInfoService.findOne(id);
    }

    //更新一个位置信息
    @PutMapping(value = "/"+entity+"")
    public LocationInfo locationInfoUpdate(@Valid LocationInfo locationInfo,
                                             BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            logger.info(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        logger.info("更新一个位置信息");
        return locationInfoService.save(locationInfo);
    }

    //根据id删除一个位置信息
    @DeleteMapping(value = "/"+entity+"/{id}")
    public void locationInfoDelete(@PathVariable("id") Integer id){
        logger.info("根据id删除一个位置信息");
        locationInfoService.delete(id);
    }
}
