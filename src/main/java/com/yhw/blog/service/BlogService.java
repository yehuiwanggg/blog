package com.yhw.blog.service;

import com.yhw.blog.entity.Blog;
import com.yhw.blog.entity.Page;

import java.util.List;

/**
 * @Author yhw
 */
public interface BlogService {
    int insertBlog(Blog blog);
    List<Blog> getBlog(Page page);
}
