package com.iot.assetcreditinformationsystem.controller;

import com.iot.assetcreditinformationsystem.domain.NoiseSource;
import com.iot.assetcreditinformationsystem.service.NoiseSourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(UserController.admin_prefix)
public class NoiseSourceController {

    private final static Logger logger = LoggerFactory.getLogger(NoiseSourceController.class);

    private final String entity = "noiseSource";

    @Autowired
    private NoiseSourceService noiseSourceService;

    /**
     * 查询所有噪音源
     * @return
     */
    @GetMapping(value = "/"+entity+"")
    public List<NoiseSource> noiseSourcesList(){
        logger.info("查询所有噪音源");
        return noiseSourceService.findAll();
    }

    /**
     * 添加一个噪音源
     *
     * @return
     */
    @PostMapping(value = "/"+entity+"")
    public NoiseSource noiseSourceAdd(@Valid NoiseSource noiseSource,
                                      BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            logger.info(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        logger.info("添加一个噪音源");
        return noiseSourceService.save(noiseSource);
    }

    //查询一个噪音源
    @GetMapping(value = "/"+entity+"/{id}")
    public NoiseSource noiseSourceFindOne(@PathVariable("id") Integer id){
        logger.info("查询一个噪音源");
        return noiseSourceService.findOne(id);
    }

    //更新一个噪音源
    @PutMapping(value = "/"+entity+"")
    public NoiseSource noiseSourceUpdate(@Valid NoiseSource noiseSource,
                                         BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            logger.info(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        logger.info("更新一个噪音源");
        return noiseSourceService.save(noiseSource);
    }

    //根据id删除一个噪音源
    @DeleteMapping(value = "/"+entity+"/{id}")
    public void noiseSourceDelete(@PathVariable("id") Integer id){
        logger.info("根据id删除一个噪音源");
        noiseSourceService.delete(id);
    }
}
