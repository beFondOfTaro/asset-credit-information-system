package com.iot.assetcreditinformationsystem.controller;

import com.iot.assetcreditinformationsystem.domain.PicClassify;
import com.iot.assetcreditinformationsystem.service.PicClassifyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(UserController.admin_prefix)
public class PicClassifyController {

    private final static Logger logger = LoggerFactory.getLogger(PicClassifyController.class);

    @Autowired
    private PicClassifyService picClassifyService;

    /**
     * 查询所有图片类别
     * @return
     */
    @GetMapping(value = "/picClassify")
    public List<PicClassify> preAssessmentReportsList(){
        logger.info("查询所有图片类别");
        return picClassifyService.findAll();
    }

    /**
     * 添加一个图片类别
     *
     * @return
     */
    @PostMapping(value = "/picClassify")
    public PicClassify preAssessmentReportAdd(@Valid PicClassify preAssessmentReport,
                                                      BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            logger.info(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        logger.info("添加一个图片类别");
        return picClassifyService.save(preAssessmentReport);
    }

    //查询一个图片类别
    @GetMapping(value = "/picClassify/{id}")
    public PicClassify preAssessmentReportFindOne(@PathVariable("id") Integer id){
        logger.info("查询一个图片类别");
        return picClassifyService.findOne(id);
    }

    //更新一个图片类别
    @PutMapping(value = "/picClassify")
    public PicClassify preAssessmentReportUpdate(@Valid PicClassify preAssessmentReport,
                                                         BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            logger.info(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        logger.info("更新一个图片类别");
        return picClassifyService.save(preAssessmentReport);
    }

    //删除一个图片类别
    @DeleteMapping(value = "/picClassify")
    public void preAssessmentReportDelete(@PathVariable("id") Integer id){
        logger.info("删除一个图片类别");
        picClassifyService.delete(id);
    }
}
