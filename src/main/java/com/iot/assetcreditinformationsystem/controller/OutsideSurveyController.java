package com.iot.assetcreditinformationsystem.controller;

import com.iot.assetcreditinformationsystem.domain.OutsideSurvey;
import com.iot.assetcreditinformationsystem.service.OutsideSurveyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(UserController.admin_prefix)
public class OutsideSurveyController {

    private static final Logger logger = LoggerFactory.getLogger(OutsideSurveyController.class);
    
    private final String entity = "outsidesurvey";

    @Autowired
    private OutsideSurveyService outsideSurveyService;

    /**
     * 查询所有外勤勘察信息
     * @return
     */
    @GetMapping(value = "/"+entity+"")
    public List<OutsideSurvey> outsideSurveyList(){
        logger.info("查询所有外勤勘察信息");
        return outsideSurveyService.findAll();
    }

    /**
     * 添加一个外勤勘察信息
     *
     * @return
     */
    @PostMapping(value = "/"+entity+"")
    public OutsideSurvey outsideSurveyAdd(@Valid OutsideSurvey outsideSurvey, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            logger.info(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        logger.info("添加一个外勤勘察信息");
        return outsideSurveyService.save(outsideSurvey);
    }

    //根据id查询一个外勤勘察信息
    @GetMapping(value = "/"+entity+"/{id}")
    public OutsideSurvey outsideSurveyFindOne(@PathVariable("id") Integer id){
        logger.info("根据id查询一个外勤勘察信息");
        return outsideSurveyService.findOne(id);
    }

    //根据id更新一个外勤勘察信息
    @PutMapping(value = "/"+entity+"")
    public OutsideSurvey outsideSurveyUpdate(OutsideSurvey outsideSurvey){
        logger.info("根据id更新一个外勤勘察信息");
        return outsideSurveyService.save(outsideSurvey);
    }

    //根据id删除一个外勤勘察信息
    @DeleteMapping(value = "/"+entity+"")
    public void outsideSurveyDelete(@PathVariable("id") Integer id){
        logger.info("根据id删除一个外勤勘察信息");
        outsideSurveyService.delete(id);
    }

    /**
     * 查询当前项目的外勤勘察信息
     * @param userName 用户名
     * @param preAssessmentId 项目id
     * @return
     */
    @GetMapping(value = "/{username}/outsidesurvey/{preassessmentid}")
    public List<OutsideSurvey> outsideSurveyList(@PathVariable("username") String userName,@PathVariable("preassessmentid") Integer preAssessmentId){
        return outsideSurveyService.findByPreAssessmentReportId(preAssessmentId);
    }
}
