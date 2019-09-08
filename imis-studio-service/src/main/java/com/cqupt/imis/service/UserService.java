package com.cqupt.imis.service;

import com.cqupt.imis.service.model.User;

import java.util.List;

/**
 *
 * @author zhoujun
 * @date 2018/8/5
 */
public interface UserService {

    /**
     * 保存用户信息
     * @param user
     */
    public void saveUser(User user);

    /**
     * 获取所有的用户信息
     * @return
     */
    public List<User> getAllUsers();

}
