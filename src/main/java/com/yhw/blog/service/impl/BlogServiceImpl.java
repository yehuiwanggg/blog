package com.yhw.blog.service.impl;

import com.yhw.blog.entity.Blog;
import com.yhw.blog.entity.Page;
import com.yhw.blog.mapper.BlogMapper;
import com.yhw.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author yhw
 */
@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogMapper blogMapper;

    @Override
    public int insertBlog(Blog blog) {
        return blogMapper.insertBlog(blog);
    }

    @Override
    public List<Blog> getBlog(Page page) {
        return blogMapper.getBlog(page);
    }
}
