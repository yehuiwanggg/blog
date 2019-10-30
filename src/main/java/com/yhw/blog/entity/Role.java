package com.yhw.blog.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author yhw
 */
@Data
public class Role {
    private int id;
    private String rolename;
    private String role;
    private Date createtime;
}
