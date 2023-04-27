package com.hyp.service.AdminService;

import com.hyp.dao.AdminDao.AdminDao;
import com.hyp.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.jar.JarEntry;

/**
 * @author Han
 * @data 2023/4/16
 * @apiNode
 */
@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    AdminDao adminDao;
    @Override
    public Admin AdminLogin(String username, String pwd) {
        return adminDao.findAdminNameAndPwd(username,pwd);
    }

    @Override
    public int addAdmin(Admin admin) {
        return adminDao.addAdmin(admin);
    }

    @Override
    public int deleteAdminById(Integer id) {
        return adminDao.deleteAdminById(id);
    }
}
