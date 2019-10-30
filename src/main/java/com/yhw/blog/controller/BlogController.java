package com.yhw.blog.controller;

import com.yhw.blog.entity.Blog;
import com.yhw.blog.entity.Page;
import com.yhw.blog.service.BlogService;
import com.yhw.blog.util.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author yhw
 */
@RestController
@RequestMapping("/blog/")
@Slf4j
public class BlogController {
    @Autowired
    BlogService blogService;

    @RequestMapping("insertBlog")
    public ResponseData insertBlog(@RequestBody Blog blog){
        return new ResponseData(200,"成功",blog.getUserid(),blogService.insertBlog(blog));
    }

    @RequestMapping("getBlog")
    public ResponseData getBlog(@RequestBody Page p){
        List<Blog> blogs=blogService.getBlog(p);

        if (blogs.size()==0){
            return new ResponseData(201,"没有更多数据",null,null);
        }
        return new ResponseData(200,"成功",null,blogs);
    }
}
