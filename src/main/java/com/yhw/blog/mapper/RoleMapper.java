package com.yhw.blog.mapper;

import com.yhw.blog.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author yhw
 */
@Repository
public interface RoleMapper {
    List<Role> getRoleList();
}
