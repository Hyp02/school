package com.hyp.dao.taskDao;

import com.hyp.pojo.Task;

import java.util.List;

/**
 * @author Han
 * @data 2023/4/9
 * @apiNode
 */
public interface TaskDao {
    /**
     * 修改任务状态
     * @param id
     * @return
     */
    int alterState(Integer id);

    /**
     * 根据已经登录的用户名获取这个人的任务列表
     * @param loginName
     * @return
     */
    List<Task> getTackByLoginName(String loginName);

    /**
     * 添加任务信息，帮取使用，点击帮取存储到任务表中
     * @param task
     * @return
     */
    int addTask(Task task);

    /**
     * 根据任务表中的id删除任务
     * @param id
     * @return
     */
    int deleteTaskById(String id);

}