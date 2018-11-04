package com.cqupt.imis.service.impl;

import com.cqupt.imis.common.exceptions.SystemException;
import com.cqupt.imis.common.utils.ArgumentUtil;
import com.cqupt.imis.mapper.UserMapper;
import com.cqupt.imis.models.UserDao;
import com.cqupt.imis.service.UserService;
import com.cqupt.imis.service.model.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by zhoujun on 2018/8/5.
 */
@Service
@Slf4j
public class UserServiceImpl  implements UserService{
    @Resource
    UserMapper userMapper;

    private final Logger logger= LoggerFactory.getLogger(getClass());
    @Override
    public void saveUser(User user) {
        ArgumentUtil.agrgumentValid(user);
        user.setPassword(user.getStudentId());
        user.setGrade(user.getGrade()+"级");
        logger.info("开始保存user信息");
        try{
            userMapper.insert(convertUserToDao(user));
        }
        catch (Exception e){
            logger.error("保存user信息失败",e);
            throw new SystemException(e.getMessage());
        }
        logger.info("保存user信息成功");
    }

    @Override
    public List<User> getAllUsers() {
        List<UserDao> userDaos=userMapper.selectAll();
        return convertDaosToUsers(userDaos);
    }

    //// TODO: 2018/8/5  改写成工具类的方式
    private UserDao convertUserToDao(User user){
        ArgumentUtil.agrgumentValid(user);
        UserDao userDao=new UserDao();
        userDao.setPassword(user.getPassword());
        userDao.setEmail(user.getEmail());
        userDao.setGrade(user.getGrade());
        userDao.setImg(user.getImg());
        userDao.setInfo(user.getInfo());
        userDao.setMainStation(user.getMainStation());
        userDao.setGitHubAddress(user.getGitHubAddress());
        userDao.setName(user.getName());
        userDao.setResume(user.getResume());
        userDao.setStudentId(user.getStudentId());
        return userDao;
    }
    private User convertDaoToUser(UserDao userDao){
        ArgumentUtil.agrgumentValid(userDao);
        User user=new User();
        user.setEmail(userDao.getEmail());
        user.setGrade(userDao.getGrade());
        user.setImg(userDao.getImg());
        user.setInfo(userDao.getInfo());
        user.setMainStation(userDao.getMainStation());
        user.setName(userDao.getName());
        user.setResume(userDao.getResume());
        user.setStudentId(userDao.getStudentId());
        user.setGitHubAddress(userDao.getGitHubAddress());
        return user;
    }
    private List<User> convertDaosToUsers(List<UserDao> userDaos){
        if(CollectionUtils.isEmpty(userDaos)){
            return null;
        }
        List<User> users=userDaos.stream().map(userDao -> convertDaoToUser(userDao)).collect(Collectors.toList());
        return  users;
    }
}
