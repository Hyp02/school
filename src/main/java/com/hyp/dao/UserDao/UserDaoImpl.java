package com.hyp.dao.UserDao;

import com.hyp.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.nio.charset.StandardCharsets;

/**
 * @author Han
 * @data 2023/4/5
 * @apiNode
 */
@Component
@Repository
public class UserDaoImpl implements UserDao {
    /*将jdbcTemplate自动装配*/
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public User findUserById(Integer id) {
        String sql = "select id,username,password,Email,phone_num from t_user where id=?";

        User user = jdbcTemplate.query(sql, new Object[]{id}, rs -> {
            if (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setEmail(rs.getString("email"));
                u.setPhone_num(rs.getString("phone_num"));
                return u;
            } else {
                return null;
            }
        });
        return user;
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert  into t_user(username,`password`,Email,phone_num)" +
                                 "value(?,?,?,?)";
        return jdbcTemplate.update(sql, user.getUsername().getBytes(StandardCharsets.UTF_8)
                ,user.getPassword().getBytes(StandardCharsets.UTF_8)
                ,user.getEmail().getBytes(StandardCharsets.UTF_8)
                ,user.getPhone_num().getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public User findUserByName(String username) {
        String sql = "select id,username,password,Email,phone_num from t_user where username=?";
        User user = jdbcTemplate.query(sql, new Object[]{username}, rs -> {
            if (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setEmail(rs.getString("email"));
                u.setPhone_num(rs.getString("phone_num"));
                return u;
            } else {
                return null;
            }
        });
        return user;
    }

    @Override
    public User findEmail(String email) {
        String sql = "select id,username,password,Email,phone_num  from t_user where Email = ? ";

        User user = jdbcTemplate.query(sql, new Object[]{email}, rs -> {
            if (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setEmail(rs.getString("email"));
                u.setPhone_num(rs.getString("phone_num"));
                return u;
            } else {
                return null;
            }
        });
        return user;
    }

    @Override
    public User findUserByNameAndPwd(String username, String password) {
        String sql = "select id,username,password,Email,phone_num from t_user where  username=? and password=? ";
        User user = jdbcTemplate.query(sql, new Object[]{username,password}, rs -> {
            if (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setEmail(rs.getString("email"));
                u.setPhone_num(rs.getString("phone_num"));
                return u;
            } else {
                return null;
            }
        });
        return user;
    }
    @Override
    public User findUserByPhone(String phone ){
        String sql = "select id,username,password,Email,phone_num from t_user where  phone_num=? ";
        User user = jdbcTemplate.query(sql, new Object[]{phone}, rs -> {
            if (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setEmail(rs.getString("email"));
                u.setPhone_num(rs.getString("phone_num"));
                return u;
            } else {
                return null;
            }
        });
        return user;
    }

    @Override
    public User getAdmin(String admin) {
        String sql = "select id,username,password,Email,phone_num from t_user where username=?";
        User user = jdbcTemplate.query(sql, new Object[]{admin}, rs -> {
            if (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setEmail(rs.getString("email"));
                u.setPhone_num(rs.getString("phone_num"));
                return u;
            } else {
                return null;
            }
        });
        return user;
    }

    @Override
    public int deleteUserById(Integer id) {
        String sql = "delete from t_user where id = ?";
        return jdbcTemplate.update(sql,id);
    }


}
