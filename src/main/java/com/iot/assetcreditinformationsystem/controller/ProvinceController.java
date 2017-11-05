package com.iot.assetcreditinformationsystem.controller;

import com.iot.assetcreditinformationsystem.domain.Province;
import com.iot.assetcreditinformationsystem.service.ProvinceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(UserController.admin_prefix)
public class ProvinceController {

    private final static Logger logger = LoggerFactory.getLogger(ProvinceController.class);

    private final String entity = "province";

    @Autowired
    private ProvinceService ProvinceService;

    /**
     * 查询所有省份
     * @return
     */
    @GetMapping(value = "/"+entity+"")
    public List<Province> ProvincesList(){
        logger.info("查询所有省份");
        return ProvinceService.findAll();
    }

    /**
     * 添加一个省份
     *
     * @return
     */
    @PostMapping(value = "/"+entity+"")
    public Province ProvinceAdd(@Valid Province Province,
                                      BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            logger.info(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        logger.info("添加一个省份");
        return ProvinceService.save(Province);
    }

    //查询一个省份
    @GetMapping(value = "/"+entity+"/{id}")
    public Province ProvinceFindOne(@PathVariable("id") Integer id){
        logger.info("查询一个省份");
        return ProvinceService.findOne(id);
    }

    //更新一个省份
    @PutMapping(value = "/"+entity+"")
    public Province ProvinceUpdate(@Valid Province Province,
                                         BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            logger.info(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        logger.info("更新一个省份");
        return ProvinceService.save(Province);
    }

    //根据id删除一个省份
    @DeleteMapping(value = "/"+entity+"/{id}")
    public void ProvinceDelete(@PathVariable("id") Integer id){
        logger.info("根据id删除一个省份");
        ProvinceService.delete(id);
    }
}
