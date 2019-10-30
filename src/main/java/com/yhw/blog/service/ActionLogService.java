package com.yhw.blog.service;

import com.yhw.blog.entity.ActionLog;

import java.util.List;

/**
 * @Author yhw
 */
public interface ActionLogService {
    int insertLog(ActionLog actionLog);
    List<ActionLog> getActionLogList();
}
