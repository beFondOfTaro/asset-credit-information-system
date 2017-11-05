package com.iot.assetcreditinformationsystem.controller;

import com.iot.assetcreditinformationsystem.domain.BankBranch;
import com.iot.assetcreditinformationsystem.service.BankBranchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(UserController.admin_prefix)
public class BankBranchController {

    private static final Logger logger = LoggerFactory.getLogger(BankBranchController.class);

    private final String entity = "bankbranch";

    @Autowired
    private BankBranchService bankBranchService;

    /**
     * 查询所有银行支行
     * @return
     */
    @GetMapping(value = "/"+entity+"")
    public List<BankBranch> bankBranchList(){
        logger.info("查询所有银行支行");
        return bankBranchService.findAll();
    }

    /**
     * 添加一个银行支行
     *
     * @return
     */
    @PostMapping(value = "/"+entity+"")
    public BankBranch bankBranchAdd(@Valid BankBranch bankBranch, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            logger.info(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        logger.info("添加一个银行支行");
        return bankBranchService.save(bankBranch);
    }

    //根据id查询一个银行支行
    @GetMapping(value = "/"+entity+"/{id}")
    public BankBranch bankBranchFindOne(@PathVariable("id") Integer id){
        logger.info("根据id查询一个银行支行");
        return bankBranchService.findOne(id);
    }

    //根据id更新一个银行支行
    @PutMapping(value = "/"+entity+"")
    public BankBranch bankBranchUpdate(BankBranch bankBranch){
        logger.info("根据id更新一个银行支行");
        return bankBranchService.save(bankBranch);
    }

    //根据id删除一个银行支行
    @DeleteMapping(value = "/"+entity+"")
    public void bankBranchDelete(@PathVariable("id") Integer id){
        logger.info("根据id删除一个银行支行");
        bankBranchService.delete(id);
    }
}
