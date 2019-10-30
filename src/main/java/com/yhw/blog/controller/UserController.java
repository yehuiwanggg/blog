package com.yhw.blog.controller;


import com.yhw.blog.entity.Role;
import com.yhw.blog.entity.User;
import com.yhw.blog.service.RoleService;
import com.yhw.blog.service.UserService;
import com.yhw.blog.util.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yhw123
 * @since 2019-09-16
 */
@RestController
@RequestMapping("/user/")
@Slf4j
public class UserController{
    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @RequestMapping("login")
    public ResponseData login(@RequestBody User user,HttpServletRequest request){
        HttpSession session=request.getSession();

        if (userService.login(user)==null){
            return new ResponseData(2001,"用户名或密码不正确");
        }
        userService.loginlog(user.getAccount());
        User userinfo=userService.login(user);
        if (userinfo.getDel()==1){
            return new ResponseData(2002,"该账号已被禁用");
        }
        session.setAttribute("user",userinfo);

        System.out.println(session.getAttribute("user")+"");
        return new ResponseData(200,"登录成功",userinfo.getId(),userinfo);
    }

    @RequestMapping("register")
    public ResponseData register(@RequestBody User user){
        if (user.getAccount()==null || user.getPassword() ==null){
            return new ResponseData(2003,"参数为错误");
        }
        if (userService.checkAccount(user.getAccount())>0){
            return new ResponseData(2004,"该用户已存在");
        }
        //注册用户
        userService.insertUser(user);
        //默认普通用户
        userService.roleUser(user.getId());
        return new ResponseData(200,"注册成功",user.getId(),null);
    }
    @RequestMapping("test")
    public ResponseData test(){
        List<User> userList=userService.getUserPermission(1);
        for (User user:userList
             ) {
            System.out.println(user.getNikename()+","+user.getRolename()+","+user.getPername());
        }

//        List<Role> roleList=roleService.getRoleList();
//        for (Role role: roleList) {
//            System.out.println("id:"+role.getId()+",name:"+role.getRolename());
//        }
        return new ResponseData(300,"zz");
    }

    @RequestMapping("checkAccount")
    public ResponseData checkAccount(@RequestBody User user ){
        if (userService.checkAccount(user.getAccount())>0){
            return new ResponseData(2004,"用户名已存在");
        }

        return new ResponseData(200,"该用户名未注册");
    }
    @RequestMapping("loginout")
    public ResponseData loginout(User user,HttpServletRequest request){
//        request.getSession().invalidate();
        return new ResponseData(200,"退出成功",user.getId(),null);
    }

    @RequestMapping("delUser")
    public ResponseData delUser(User user){
        return new ResponseData(200,"删除成功",user.getId(),null);
    }

    @RequestMapping("getUser")
    public ResponseData getUser(int id){
        return new ResponseData(200,"请求成功",id,userService.getUser(id));
    }

    @RequestMapping("updateUser")
    public ResponseData updateUser(@RequestBody User user){
        userService.updateUser(user);
        return new ResponseData(200,"修改成功",user.getId(),userService.getUser(user.getId()));
    }
}

