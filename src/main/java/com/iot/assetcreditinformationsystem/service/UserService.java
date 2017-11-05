package com.iot.assetcreditinformationsystem.service;

import com.iot.assetcreditinformationsystem.domain.User;
import com.iot.assetcreditinformationsystem.util.token.Token;

import java.util.Map;

public interface UserService extends BaseService<User> {

    Token userLogin(String username, String password);

    boolean userLogout(Integer userId);
}
