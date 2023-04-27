package com.hyp.service.AdminService;

import com.hyp.pojo.Admin;

/**
 * @author Han
 * @data 2023/4/16
 * @apiNode
 */
public interface AdminService {
    Admin AdminLogin(String username,String pwd);
    int addAdmin(Admin admin);
    int deleteAdminById(Integer id);
}
