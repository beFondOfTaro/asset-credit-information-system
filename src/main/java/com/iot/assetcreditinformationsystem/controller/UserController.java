package com.iot.assetcreditinformationsystem.controller;

import com.iot.assetcreditinformationsystem.domain.User;
import com.iot.assetcreditinformationsystem.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

import static com.iot.assetcreditinformationsystem.controller.UserController.admin_prefix;


@RestController
@RequestMapping(value = admin_prefix)
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    private final String entity = "user";

    public static final String admin_prefix = "admin";

    /**
     * 查询所有用户
     * @return
     */
    @GetMapping(value = "/"+entity)
    public List<User> UserList(){
        logger.info("查询所有用户");
        return userService.findAll();
    }

    /**
     * 添加一个用户
     *
     * @return
     */
    @PostMapping(value = "/"+entity)
    public User userAdd(@Valid User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            logger.info(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        logger.info("添加一个用户");
        return userService.save(user);
    }

    //根据id查询一个用户
    @GetMapping(value = "/"+entity+"/{id}")
    public User userFindOne(@PathVariable("id") Integer id){
        logger.info("根据id查询一个用户");
        return userService.findOne(id);
    }

    //根据id更新一个用户
    @PutMapping(value = "/"+entity)
    public User userUpdate(User user){
        logger.info("根据id更新一个用户");
        return userService.save(user);
    }

    //根据id删除一个用户
    @DeleteMapping(value = "/"+entity)
    public void userDelete(@PathVariable("id") Integer id){
        logger.info("根据id删除一个用户");
        userService.delete(id);
    }

}

