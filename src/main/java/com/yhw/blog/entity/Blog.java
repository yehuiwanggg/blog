package com.yhw.blog.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author yhw
 */
@Data
public class Blog {
    private int id;
    private String title;
    private String content;
    private int del;
    private int clicknum;
    private int agreenum;
    private int commentnum;
    private Date createtime;
    private Date deltime;
    private int userid;
}
