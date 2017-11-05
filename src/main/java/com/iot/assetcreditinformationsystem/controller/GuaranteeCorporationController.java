package com.iot.assetcreditinformationsystem.controller;

import com.iot.assetcreditinformationsystem.domain.GuaranteeCorporation;
import com.iot.assetcreditinformationsystem.repository.GuaranteeCorporationRepository;
import com.iot.assetcreditinformationsystem.service.GuaranteeCorporationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(UserController.admin_prefix)
public class GuaranteeCorporationController {

    private static final Logger logger = LoggerFactory.getLogger(GuaranteeCorporation.class);

    private final String entity = "guaranteeCorporation";

    @Autowired
    private GuaranteeCorporationService guaranteeCorporationService;

    /**
     * 查询所有担保公司
     * @return
     */
    @GetMapping(value = "/"+entity+"")
    public List<GuaranteeCorporation> guaranteeCorporationList (){
        return guaranteeCorporationService.findAll();
    }

    /**
     * 添加一个担保公司
     * @param guaranteeCorporation
     * @param bindingResult
     * @return
     */
    @PostMapping(value = "/"+entity+"")
    public GuaranteeCorporation guaranteeCorporationAdd(@Valid GuaranteeCorporation guaranteeCorporation, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            logger.info(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        logger.info("添加一个担保公司");
        return guaranteeCorporationService.save(guaranteeCorporation);
    }

    //根据id查询一个担保公司
    @GetMapping(value = "/"+entity+"/{id}")
    public GuaranteeCorporation guaranteeCorporationFindOne(@PathVariable("id") Integer id){
        logger.info("根据id查询一个担保公司");
        return guaranteeCorporationService.findOne(id);
    }

    //根据id更新一个担保公司
    @PutMapping(value = "/"+entity+"")
    public GuaranteeCorporation guaranteeCorporationUpdate(GuaranteeCorporation guaranteeCorporation){
        logger.info("根据id更新一个担保公司");
        return guaranteeCorporationService.save(guaranteeCorporation);
    }

    //根据id删除一个担保公司
    @DeleteMapping(value = "/"+entity+"/{id}")
    public void guaranteeCorporationDelete(@PathVariable("id") Integer id){
        logger.info("根据id删除一个担保公司");
        guaranteeCorporationService.delete(id);
    }
}
