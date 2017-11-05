package com.iot.assetcreditinformationsystem.controller;

import com.iot.assetcreditinformationsystem.domain.ParkingCondition;
import com.iot.assetcreditinformationsystem.service.ParkingConditionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(UserController.admin_prefix)
public class ParkingConditionController {

    private final static Logger logger = LoggerFactory.getLogger(ParkingConditionController.class);

    private final String entity = "parkingCondition";

    @Autowired
    private ParkingConditionService parkingConditionService;

    /**
     * 查询所有停车状况
     * @return
     */
    @GetMapping(value = "/"+entity+"")
    public List<ParkingCondition> parkingConditionsList(){
        logger.info("查询所有停车状况");
        return parkingConditionService.findAll();
    }

    /**
     * 添加一个停车状况
     *
     * @return
     */
    @PostMapping(value = "/"+entity+"")
    public ParkingCondition parkingConditionAdd(@Valid ParkingCondition parkingCondition,
                                      BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            logger.info(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        logger.info("添加一个停车状况");
        return parkingConditionService.save(parkingCondition);
    }

    //查询一个停车状况
    @GetMapping(value = "/"+entity+"/{id}")
    public ParkingCondition parkingConditionFindOne(@PathVariable("id") Integer id){
        logger.info("查询一个停车状况");
        return parkingConditionService.findOne(id);
    }

    //更新一个停车状况
    @PutMapping(value = "/"+entity+"")
    public ParkingCondition parkingConditionUpdate(@Valid ParkingCondition parkingCondition,
                                         BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            logger.info(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        logger.info("更新一个停车状况");
        return parkingConditionService.save(parkingCondition);
    }

    //根据id删除一个停车状况
    @DeleteMapping(value = "/"+entity+"/{id}")
    public void parkingConditionDelete(@PathVariable("id") Integer id){
        logger.info("根据id删除一个停车状况");
        parkingConditionService.delete(id);
    }
}
