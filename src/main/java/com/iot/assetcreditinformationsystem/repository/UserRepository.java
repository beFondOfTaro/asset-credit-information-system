package com.iot.assetcreditinformationsystem.repository;

import com.iot.assetcreditinformationsystem.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User,Integer> {

    User findUserByUsernameAndPassword(String username,String password);
}
