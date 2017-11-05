package com.iot.assetcreditinformationsystem.controller.userAccessController;

import com.iot.assetcreditinformationsystem.service.UserService;
import com.iot.assetcreditinformationsystem.util.ResponseModel;
import com.iot.assetcreditinformationsystem.util.token.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class NormalUserController {

    private static final Logger logger = LoggerFactory.getLogger(NormalUserController.class);

    @Autowired
    private UserService userService;

    private final String entity = "user";

    @PostMapping(value = "/login")
    @CrossOrigin//ajax跨域请求
    public ResponseModel userLogin(@RequestParam("username") String username,
                                   @RequestParam("password") String password){
        logger.info("----------用户登录---------\nusername="+username+"\npassword="+password);
        ResponseModel response;
        Token token = userService.userLogin(username,password);
        if (token!=null){
            response = new ResponseModel(token);
        }
        else {
            response = new ResponseModel(500,"登录失败，用户名或密码错误");
        }
        return response;
    }

    @GetMapping(value = "/logout/{userid}")
    public ResponseModel userLogout(@PathVariable("userid") Integer userId){
        boolean isOk = userService.userLogout(userId);
        return new ResponseModel(isOk ? 200 : 500, isOk ? ResponseModel.SUCCESS_MSG : ResponseModel.FAILED_MSG);
    }

}
