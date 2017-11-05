package com.iot.assetcreditinformationsystem.controller;

import com.iot.assetcreditinformationsystem.domain.PreAssessmentReport;
import com.iot.assetcreditinformationsystem.repository.PreAssessmentReportRepository;
import com.iot.assetcreditinformationsystem.service.PreAssessmentReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(UserController.admin_prefix)
public class PreAssessmentReportController {

    private final static Logger logger = LoggerFactory.getLogger(PreAssessmentReportController.class);
    
    private final String entity = "preassessmentreports";

    @Autowired
    private PreAssessmentReportRepository preAssessmentReportRepository;

    @Autowired
    private PreAssessmentReportService preAssessmentReportService;

    /**
     * 查询所有预评报单
     * @return
     */
    @GetMapping(value = "/"+entity+"")
    public List<PreAssessmentReport> preAssessmentReportsList(){
        logger.info("查询所有预评报单");
        return preAssessmentReportService.findAll();
    }

    @GetMapping(value = "/")
    public List<PreAssessmentReport> selectAll(){
        logger.info("查询所有预评报单");
        return preAssessmentReportService.selectAll();
    }

    /**
     * 添加一个预评报单
     *
     * @return
     */
    @PostMapping(value = "/"+entity+"")
    public PreAssessmentReport preAssessmentReportAdd(@Valid PreAssessmentReport preAssessmentReport,
                                                      BindingResult bindingResult){
    if (bindingResult.hasErrors()){
        logger.info(bindingResult.getFieldError().getDefaultMessage());
        return null;
    }
        logger.info("添加一个预评报单");
        return preAssessmentReportService.save(preAssessmentReport);
    }

    //查询一个预评报单
    @GetMapping(value = "/"+entity+"/{id}")
    public PreAssessmentReport preAssessmentReportFindOne(@PathVariable("id") Integer id){
        logger.info("查询一个预评报单");
        return preAssessmentReportService.findOne(id);
    }

    //更新一个预评报单
    @PutMapping(value = "/"+entity+"")
    public PreAssessmentReport preAssessmentReportUpdate(@Valid PreAssessmentReport preAssessmentReport,
                                                         BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            logger.info(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        logger.info("更新一个预评报单");
        return preAssessmentReportService.save(preAssessmentReport);
    }

    //根据id删除一个预评报单
    @DeleteMapping(value = "/"+entity+"/{id}")
    public void preAssessmentReportDelete(@PathVariable("id") Integer id){
        logger.info("根据id删除一个预评报单");
        preAssessmentReportService.delete(id);
    }

    /**查询房屋信息
     *
     * @param isAssessed 是否已评估
     * @return 房屋信息列表
     */
    @GetMapping(value = "/house/{assessed}")
    public List<Map<String,Object>> houseToBeAssessedList(@PathVariable("assessed") boolean isAssessed){
        logger.info("查询所有用户的房屋信息");
        return preAssessmentReportService.findHouseIsAssessed(isAssessed);
    }

}
