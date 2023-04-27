package com.hyp.dao.UserDao;

import com.hyp.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * @author Han
 * @data 2023/4/5
 * @apiNode
 */

public interface UserDao {
    /**
     * 根据用户名查找User
     * @param id
     * @return
     */
    User findUserById(Integer id);

    /**
     * 将传入的用户保存
     * @return 返回数据库受影响的行数
     */
    int saveUser(User user);
    /**
     * 根据用户名查询
     * @param userName
     * @return
     */
    User findUserByName(String userName);

    /**
     * 查找邮箱是否被使用
     * @param email
     * @return 返回null就是没有被使用
     */
    User findEmail(String email);

    /**
     * 根据用户名和密码查找用户
     * @param username
     * @param password
     * @return
     */
    User findUserByNameAndPwd(String username,String password);
    User findUserByPhone(String phone);
    User getAdmin(String admin);
    /**
     * 根据用户id删除用户
     */
    int deleteUserById(Integer id);
}
