package com.hyp.service.UserService;

import com.hyp.dao.UserDao.UserDao;
import com.hyp.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author Han
 * @data 2023/4/6
 * @apiNode
 */
@Service
@Component
public class UserServiceImpl implements userService{
    @Autowired
    private UserDao userDao;


    @Override
    public User findUserById(Integer id) {
        User userById = userDao.findUserById(id);
        return userById;
    }


    @Override
    public User findUserByName(String username) {
        User userByName = userDao.findUserByName(username);
        return userByName;
    }

    @Override
    public User login(String  username,String password) {
        return userDao.findUserByNameAndPwd(username,password);
    }

    @Override
    public int register(User user) {
        return userDao.saveUser(user);
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findEmail(email);
    }

    @Override
    public User findByPhone(String phone) {
        return userDao.findUserByPhone(phone);
    }

    @Override
    public User getAdmin(String admin) {
        return userDao.getAdmin(admin);
    }

    @Override
    public int deleteById(Integer id) {
        return userDao.deleteUserById(id);
    }
}
