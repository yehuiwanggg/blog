package com.yhw.blog.mapper;

import com.yhw.blog.entity.Blog;
import com.yhw.blog.entity.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author yhw
 */
@Repository
public interface BlogMapper {
    int insertBlog(Blog blog);
    List<Blog> getBlog(Page page);
}
