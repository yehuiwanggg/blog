package com.yhw.blog.service.impl;

import com.yhw.blog.entity.User;
import com.yhw.blog.mapper.UserMapper;
import com.yhw.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yhw123
 * @since 2019-09-16
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;



    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public int checkAccount(String account) {
        return userMapper.checkAccount(account);
    }



    @Override
    public User login(User user) {
        return userMapper.login(user);
    }

    @Override
    public List<User> getUserRole(int id) {
        return userMapper.getUserRole(id);
    }

    @Override
    public List<User> getUserPermission(int id) {
        return userMapper.getUserPermission(id);
    }

    @Override
    public int roleUser(int id) {

        return userMapper.roleUser(id);
    }

    @Override
    public int loginlog(String account) {
        return userMapper.loginlog(account);
    }

    @Override
    public User getUser(int id) {
        return userMapper.getUser(id);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }
}
