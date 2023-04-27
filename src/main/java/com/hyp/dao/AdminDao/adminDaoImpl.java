package com.hyp.dao.AdminDao;

import com.hyp.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.nio.charset.StandardCharsets;

/**
 * @author Han
 * @data 2023/4/16
 * @apiNode
 */
@Repository
public class adminDaoImpl implements AdminDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Admin findAdminNameAndPwd(String username, String password) {
        String sql = "select id,username,password,Email,phone_num from t_admins where username=? and password=? ";
        Admin admin = jdbcTemplate.query(sql, new Object[]{username, password}, rs -> {
            if (rs.next()){
            Admin a = new Admin();
            a.setId(rs.getInt("id"));
            a.setUsername(rs.getString("username"));
            a.setPassword(rs.getString("password"));
            a.setEmail(rs.getString("email"));
            a.setPhone_num(rs.getString("phone_num"));
            return a;
            }else {
                return null;
            }
        });
        return admin;
    }

    @Override
    public int addAdmin(Admin admin) {
        String sql = "insert into t_admins(id,username,password,Email,phone_num) " +
                "value(?,?,?,?,?)";
        return jdbcTemplate.update(sql,null,admin.getUsername().getBytes(StandardCharsets.UTF_8)
                ,admin.getPassword().getBytes(StandardCharsets.UTF_8)
                ,admin.getEmail().getBytes(StandardCharsets.UTF_8)
                ,admin.getPhone_num().getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public int deleteAdminById(Integer id) {
        String sql = "delete from t_admins where id = ?";
        int update = jdbcTemplate.update(sql, id);
        return update;
    }

}
