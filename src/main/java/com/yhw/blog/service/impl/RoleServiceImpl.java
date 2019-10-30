package com.yhw.blog.service.impl;

import com.yhw.blog.entity.Role;
import com.yhw.blog.mapper.RoleMapper;
import com.yhw.blog.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author yhw
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleMapper roleMapper;

    @Override
    public List<Role> getRoleList() {
        return roleMapper.getRoleList();
    }
}
