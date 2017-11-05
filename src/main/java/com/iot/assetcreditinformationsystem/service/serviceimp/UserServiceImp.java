package com.iot.assetcreditinformationsystem.service.serviceimp;

import com.iot.assetcreditinformationsystem.domain.User;
import com.iot.assetcreditinformationsystem.repository.UserRepository;
import com.iot.assetcreditinformationsystem.service.UserService;
import com.iot.assetcreditinformationsystem.util.token.DigestModel;
import com.iot.assetcreditinformationsystem.util.token.Token;
import com.iot.assetcreditinformationsystem.util.token.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenUtil tokenUtil;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User entity) {
        return userRepository.save(entity);
    }

    @Override
    public User findOne(Integer id) {
        return userRepository.findOne(id);
    }

    @Override
    public User update(User entity) {
        return userRepository.save(entity);
    }

    @Override
    public void delete(Integer id) {
        userRepository.delete(id);
    }

    @Override
    public Token userLogin(String username, String password) {
        User user = userRepository.findUserByUsernameAndPassword(username,password);
        if(user!=null){
            String digest = tokenUtil.createDigest(new DigestModel(user.getId()));//根据userId生成模型创建digest
            return new Token(user.getId(),digest);
        }
        else {
            return null;
        }
    }

    @Override
    public boolean userLogout(Integer userId) {
        return tokenUtil.deleteToken(userId);
    }
}
