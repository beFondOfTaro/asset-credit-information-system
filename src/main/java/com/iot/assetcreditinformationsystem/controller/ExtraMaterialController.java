package com.iot.assetcreditinformationsystem.controller;

import com.iot.assetcreditinformationsystem.domain.ExtraMaterial;
import com.iot.assetcreditinformationsystem.service.ExtraMaterialService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(UserController.admin_prefix)
public class ExtraMaterialController {

    private final static Logger logger = LoggerFactory.getLogger(ExtraMaterialController.class);

    private final String entity = "extramaterial";

    @Autowired
    private ExtraMaterialService extraMaterialService;

    /**
     * 查询所有个人及家庭房屋登记记录信息证明
     * @return
     */
    @GetMapping(value = "/"+entity+"")
    public List<ExtraMaterial> extraMaterialsList(){
        logger.info("查询所有个人及家庭房屋登记记录信息证明");
        return extraMaterialService.findAll();
    }

    /**
     * 添加一个个人及家庭房屋登记记录信息证明
     *
     * @return
     */
    @PostMapping(value = "/"+entity+"")
    public ExtraMaterial extraMaterialAdd(@Valid ExtraMaterial extraMaterial,
                                                BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            logger.info(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        logger.info("添加一个个人及家庭房屋登记记录信息证明");
        return extraMaterialService.save(extraMaterial);
    }

    //查询一个个人及家庭房屋登记记录信息证明
    @GetMapping(value = "/"+entity+"/{id}")
    public ExtraMaterial extraMaterialFindOne(@PathVariable("id") Integer id){
        logger.info("查询一个个人及家庭房屋登记记录信息证明");
        return extraMaterialService.findOne(id);
    }

    //更新一个个人及家庭房屋登记记录信息证明
    @PutMapping(value = "/"+entity+"")
    public ExtraMaterial extraMaterialUpdate(@Valid ExtraMaterial extraMaterial,
                                                   BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            logger.info(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        logger.info("更新一个个人及家庭房屋登记记录信息证明");
        return extraMaterialService.save(extraMaterial);
    }

    //根据id删除一个个人及家庭房屋登记记录信息证明
    @DeleteMapping(value = "/"+entity+"/{id}")
    public void extraMaterialDelete(@PathVariable("id") Integer id){
        logger.info("根据id删除一个个人及家庭房屋登记记录信息证明");
        extraMaterialService.delete(id);
    }
}
