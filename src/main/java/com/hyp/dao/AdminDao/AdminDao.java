package com.hyp.dao.AdminDao;

import com.hyp.pojo.Admin;

/**
 * @author Han
 * @data 2023/4/16
 * @apiNode
 */

public interface AdminDao {

    Admin findAdminNameAndPwd(String username,String password);
    int addAdmin(Admin admin);
    int deleteAdminById(Integer id);

}
