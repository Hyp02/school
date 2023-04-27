package com.hyp.service.TackService;

import com.hyp.pojo.Task;

import java.util.List;

/**
 * @author Han
 * @data 2023/4/9
 * @apiNode
 */
public interface TackService {
    int alterState(Integer id);
    List<Task> getTaskByLoginName(String loginName);
    int addTask(Task task);
    int deleteTaskById(String id);
}
