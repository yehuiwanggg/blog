package com.yhw.blog.mapper;

import com.yhw.blog.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yhw123
 * @since 2019-09-16
 */
@Repository
public interface UserMapper {

    List<User> getUserList();

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
