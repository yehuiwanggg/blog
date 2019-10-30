package com.yhw.blog.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author yhw
 */
@Data
public class ActionLog {
    private int id;
    private String action;
    private Date atime;
    private int userid;
}
