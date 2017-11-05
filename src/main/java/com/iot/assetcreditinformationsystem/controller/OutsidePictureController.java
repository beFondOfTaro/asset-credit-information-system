package com.iot.assetcreditinformationsystem.controller;

import com.iot.assetcreditinformationsystem.domain.OutsidePicture;
import com.iot.assetcreditinformationsystem.service.OutsidePictureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(UserController.admin_prefix)
public class OutsidePictureController {

    private static final Logger logger = LoggerFactory.getLogger(OutsidePictureController.class);

    @Autowired
    private OutsidePictureService outsidePictureService;

    /**
     * 查询所有外勤图片信息
     * @return
     */
    @GetMapping(value = "/outsidePicture")
    public List<OutsidePicture> outsidePictureList(){
        logger.info("查询所有外勤图片信息");
        return outsidePictureService.findAll();
    }

    /**
     * 添加一个外勤图片信息
     *
     * @return
     */
    @PostMapping(value = "/outsidePicture")
    public OutsidePicture outsidePictureAdd(@Valid OutsidePicture outsidePicture, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            logger.info(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        logger.info("添加一个外勤图片信息");
        return outsidePictureService.save(outsidePicture);
    }

    //根据id查询一个外勤图片信息
    @GetMapping(value = "/outsidePicture/{id}")
    public OutsidePicture outsidePictureFindOne(@PathVariable("id") Integer id){
        logger.info("根据id查询一个外勤图片信息");
        return outsidePictureService.findOne(id);
    }

    //根据id更新一个外勤图片信息
    @PutMapping(value = "/outsidePicture")
    public OutsidePicture outsidePictureUpdate(OutsidePicture outsidePicture){
        logger.info("根据id更新一个外勤图片信息");
        return outsidePictureService.save(outsidePicture);
    }

    //根据id删除一个外勤图片信息
    @DeleteMapping(value = "/outsidePicture")
    public void outsidePictureDelete(@PathVariable("id") Integer id){
        logger.info("根据id删除一个外勤图片信息");
        outsidePictureService.delete(id);
    }
}
