package com.iot.assetcreditinformationsystem.controller;

import com.iot.assetcreditinformationsystem.domain.HouseType;
import com.iot.assetcreditinformationsystem.service.HouseTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(UserController.admin_prefix)
public class HouseTypeController {

    private final static Logger logger = LoggerFactory.getLogger(HouseTypeController.class);

    private final String entity = "houseType";

    @Autowired
    private HouseTypeService houseTypeService;

    /**
     * 查询所有房屋类型
     * @return
     */
    @GetMapping(value = "/"+entity+"")
    public List<HouseType> houseTypesList(){
        logger.info("查询所有房屋类型");
        return houseTypeService.findAll();
    }

    /**
     * 添加一个房屋类型
     *
     * @return
     */
    @PostMapping(value = "/"+entity+"")
    public HouseType houseTypeAdd(@Valid HouseType houseType,
                                      BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            logger.info(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        logger.info("添加一个房屋类型");
        return houseTypeService.save(houseType);
    }

    //查询一个房屋类型
    @GetMapping(value = "/"+entity+"/{id}")
    public HouseType houseTypeFindOne(@PathVariable("id") Integer id){
        logger.info("查询一个房屋类型");
        return houseTypeService.findOne(id);
    }

    //更新一个房屋类型
    @PutMapping(value = "/"+entity+"")
    public HouseType houseTypeUpdate(@Valid HouseType houseType,
                                         BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            logger.info(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        logger.info("更新一个房屋类型");
        return houseTypeService.save(houseType);
    }

    //根据id删除一个房屋类型
    @DeleteMapping(value = "/"+entity+"/{id}")
    public void houseTypeDelete(@PathVariable("id") Integer id){
        logger.info("根据id删除一个房屋类型");
        houseTypeService.delete(id);
    }
}
