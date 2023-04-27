package com.hyp.service.UserService;

import com.hyp.pojo.User;

/**
 * @author Han
 * @data 2023/4/6
 * @apiNode
 */
public interface userService {
    User findUserById(Integer id);
    User findUserByName(String username);
    User login(String username,String password);
    int register(User user);
    User findByEmail(String email);
    User findByPhone(String phone);
    User getAdmin(String admin);
    int deleteById(Integer id);

}
