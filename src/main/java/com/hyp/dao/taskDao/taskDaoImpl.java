package com.hyp.dao.taskDao;

import com.hyp.pojo.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author Han
 * @data 2023/4/9
 * @apiNode
 */
@Component
@Repository
public class taskDaoImpl implements TaskDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int alterState(Integer id) {
        String sql = "update t_task set state where id=?";
        int i = jdbcTemplate.update(sql, id);
        return i;
    }

    @Override
    public List<Task> getTackByLoginName(String loginName) {
        String sql = "select * from t_task where LoginName = ?";
        return jdbcTemplate.query(sql, new Object[]{loginName}, (rs, rowNum) -> {

            Task t = new Task();
            t.setId(rs.getInt("id"));
            t.setPhone(rs.getString("phone"));
            t.setAddress(rs.getString("address"));
            t.setTaskName(rs.getString("taskName"));
            t.setKdid(rs.getString("Kdid"));
            t.setSHname(rs.getString("SHname"));
            t.setLoginName((rs.getString("loginName")));
            return t;

        });
    }

    @Override
    public int addTask(Task task) {
        String sql = "insert into t_task(id,loginName,taskName,kdid,SHname,phone,address) " +
                "value(?,?,?,?,?,?,?)";
        int update = jdbcTemplate.update(sql, null, task.getLoginName().getBytes(StandardCharsets.UTF_8)
                , task.getTaskName().getBytes(StandardCharsets.UTF_8)
                , task.getKdid().getBytes(StandardCharsets.UTF_8)
                , task.getSHname().getBytes(StandardCharsets.UTF_8)
                , task.getPhone().getBytes(StandardCharsets.UTF_8)
                , task.getAddress().getBytes(StandardCharsets.UTF_8));

        return update;
    }

    @Override
    public int deleteTaskById(String id) {
        String sql = "delete from t_task where id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
