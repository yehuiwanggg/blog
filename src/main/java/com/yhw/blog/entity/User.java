package com.yhw.blog.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yhw.blog.util.DateFormatTools;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author yhw123
 * @since 2019-09-16
 */
@Data
@Accessors(chain = true)
public class User {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String account;
    private String password;
    private String nikename;
    private int age;
    private int sex;
    private String phone;
    private String img;
    private Date logintime;
    private Date create_time;
    private int del;
    private String rolename;
    private String pername;
    private String email;


}
