package com.yhw.blog.config;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author yhw
 */
public class BaseController {
    @Autowired
    public HttpServletRequest request;
    @Autowired
    public HttpServletResponse response;
}
