package com.yhw.blog.service;

import com.yhw.blog.entity.User;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yhw123
 * @since 2019-09-16
 */
public interface UserService {


    int insertUser(User user);
    int checkAccount(String account);
    User login(User user);

    List<User> getUserRole(int id);
    List<User> getUserPermission(int id);
    int roleUser(int id);
    int loginlog(String account);
    User getUser(int id);
    int updateUser(User user);
}
