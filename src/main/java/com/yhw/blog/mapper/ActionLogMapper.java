package com.yhw.blog.mapper;

import com.yhw.blog.entity.ActionLog;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author yhw
 */
@Repository
public interface ActionLogMapper {
    int insertLog(ActionLog actionLog);
    List<ActionLog> getActionLogList();
}
