package com.iot.assetcreditinformationsystem.controller;

import com.iot.assetcreditinformationsystem.domain.Bank;
import com.iot.assetcreditinformationsystem.service.BankService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(UserController.admin_prefix)
public class BankController {
    private static final Logger logger = LoggerFactory.getLogger(BankController.class);

    @Autowired
    private BankService bankService;

    /**
     * 查询所有银行
     * @return
     */
    @GetMapping(value = "/bank")
    public List<Bank> bankList(){
        logger.info("查询所有银行");
        return bankService.findAll();
    }

     /**
     * 添加一个银行
     *
     * @return
     */
    @PostMapping(value = "/bank")
    public Bank bankAdd(@Valid Bank bank, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            logger.info(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        logger.info("添加一个银行");
        return bankService.save(bank);
    }

    //根据id查询一个银行
    @GetMapping(value = "/bank/{id}")
    public Bank bankFindOne(@PathVariable("id") Integer id){
        logger.info("根据id查询一个银行");
        return bankService.findOne(id);
    }

    //根据id更新一个银行
    @PutMapping(value = "/bank")
    public Bank bankUpdate(Bank bank){
        logger.info("根据id更新一个银行");
        return bankService.save(bank);
    }

    //根据id删除一个银行
    @DeleteMapping(value = "/bank")
    public void bankDelete(@PathVariable("id") Integer id){
        logger.info("根据id删除一个银行");
        bankService.delete(id);
    }
}
