package com.iot.assetcreditinformationsystem.controller;

import com.iot.assetcreditinformationsystem.domain.HousingNature;
import com.iot.assetcreditinformationsystem.service.HousingNatureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(UserController.admin_prefix)
public class HousingNatureController {

    private final static Logger logger = LoggerFactory.getLogger(HousingNatureController.class);

    private final String entity = "housingnature";

    @Autowired
    private HousingNatureService housingNatureService;

    /**
     * 查询所有房屋性质
     * @return
     */
    @GetMapping(value = "/"+entity+"")
    public List<HousingNature> housingNaturesList(){
        logger.info("查询所有房屋性质");
        return housingNatureService.findAll();
    }

    /**
     * 添加一个房屋性质
     *
     * @return
     */
    @PostMapping(value = "/"+entity+"")
    public HousingNature housingNatureAdd(@Valid HousingNature housingNature,
                                      BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            logger.info(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        logger.info("添加一个房屋性质");
        return housingNatureService.save(housingNature);
    }

    //查询一个房屋性质
    @GetMapping(value = "/"+entity+"/{id}")
    public HousingNature housingNatureFindOne(@PathVariable("id") Integer id){
        logger.info("查询一个房屋性质");
        return housingNatureService.findOne(id);
    }

    //更新一个房屋性质
    @PutMapping(value = "/"+entity+"")
    public HousingNature housingNatureUpdate(@Valid HousingNature housingNature,
                                         BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            logger.info(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        logger.info("更新一个房屋性质");
        return housingNatureService.save(housingNature);
    }

    //根据id删除一个房屋性质
    @DeleteMapping(value = "/"+entity+"/{id}")
    public void housingNatureDelete(@PathVariable("id") Integer id){
        logger.info("根据id删除一个房屋性质");
        housingNatureService.delete(id);
    }
}
