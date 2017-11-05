package com.iot.assetcreditinformationsystem.controller;

import com.iot.assetcreditinformationsystem.domain.ParkingLotCondition;
import com.iot.assetcreditinformationsystem.service.ParkingLotConditionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(UserController.admin_prefix)
public class ParkingLotConditionController {

    private final static Logger logger = LoggerFactory.getLogger(ParkingLotConditionController.class);

    private final String entity = "parkingLotCondition";

    @Autowired
    private ParkingLotConditionService parkingLotConditionService;

    /**
     * 查询所有车位状况
     * @return
     */
    @GetMapping(value = "/"+entity+"")
    public List<ParkingLotCondition> parkingLotConditionsList(){
        logger.info("查询所有车位状况");
        return parkingLotConditionService.findAll();
    }

    /**
     * 添加一个车位状况
     *
     * @return
     */
    @PostMapping(value = "/"+entity+"")
    public ParkingLotCondition parkingLotConditionAdd(@Valid ParkingLotCondition parkingLotCondition,
                                      BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            logger.info(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        logger.info("添加一个车位状况");
        return parkingLotConditionService.save(parkingLotCondition);
    }

    //查询一个车位状况
    @GetMapping(value = "/"+entity+"/{id}")
    public ParkingLotCondition parkingLotConditionFindOne(@PathVariable("id") Integer id){
        logger.info("查询一个车位状况");
        return parkingLotConditionService.findOne(id);
    }

    //更新一个车位状况
    @PutMapping(value = "/"+entity+"")
    public ParkingLotCondition parkingLotConditionUpdate(@Valid ParkingLotCondition parkingLotCondition,
                                         BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            logger.info(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        logger.info("更新一个车位状况");
        return parkingLotConditionService.save(parkingLotCondition);
    }

    //根据id删除一个车位状况
    @DeleteMapping(value = "/"+entity+"/{id}")
    public void parkingLotConditionDelete(@PathVariable("id") Integer id){
        logger.info("根据id删除一个车位状况");
        parkingLotConditionService.delete(id);
    }
}
