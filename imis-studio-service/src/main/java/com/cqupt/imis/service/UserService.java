package com.cqupt.imis.service;

import com.cqupt.imis.service.model.User;

import java.util.List;

/**
 * Created by zhoujun on 2018/8/5.
 */
public interface UserService {
    public void saveUser(User user);

    public List<User> getAllUsers();

}
