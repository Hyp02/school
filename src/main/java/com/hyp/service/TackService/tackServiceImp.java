package com.hyp.service.TackService;

import com.hyp.dao.taskDao.TaskDao;
import com.hyp.pojo.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Han
 * @data 2023/4/9
 * @apiNode
 */
@Service
public class tackServiceImp implements TackService {
    @Autowired
    TaskDao taskDao;

    @Override
    public int alterState(Integer id) {
        return taskDao.alterState(id);
    }

    @Override
    public List<Task> getTaskByLoginName(String loginName) {
        return taskDao.getTackByLoginName(loginName);
    }

    @Override
    public int addTask(Task task) {
        return taskDao.addTask(task);
    }

    @Override
    public int deleteTaskById(String id) {
        return taskDao.deleteTaskById(id);
    }
}
