package com.yhw.blog.service.impl;

import com.yhw.blog.entity.ActionLog;
import com.yhw.blog.mapper.ActionLogMapper;
import com.yhw.blog.service.ActionLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author yhw
 */
@Service
public class ActionLogServiceImpl implements ActionLogService {
    @Autowired
    ActionLogMapper actionLogMapper;
    @Override
    public int insertLog(ActionLog actionLog) {
        return actionLogMapper.insertLog(actionLog);
    }

    @Override
    public List<ActionLog> getActionLogList() {
        return actionLogMapper.getActionLogList();
    }
}
