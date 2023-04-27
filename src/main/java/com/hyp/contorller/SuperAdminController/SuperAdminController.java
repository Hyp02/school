package com.hyp.contorller.SuperAdminController;

import com.hyp.pojo.Admin;
import com.hyp.service.AdminService.AdminService;
import com.hyp.service.UserService.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Han
 * @data 2023/4/11
 * @apiNode
 */
@Controller
@ResponseBody
@RequestMapping(value = "superAdmin", produces = "application/json;charset=utf-8")
public class SuperAdminController {
    @Autowired
    AdminService adminService;
    @Autowired
    userService userService;

    @RequestMapping(value = "/addAdmin", produces = "application/json;charset=utf-8")
    public String addAdmin(Admin admin) {
        int i = adminService.addAdmin(admin);
        if (i > 0) {

            return "添加管理员成功";
        }
        return "操作失败";
    }

    @RequestMapping(value = "deleteAdmin", produces = "application/json;charset=utf-8")
    public String deleteAdminById(String id) {
        int i = adminService.deleteAdminById(Integer.parseInt(id));
        if (i > 0) {
            return "删除管理员成功";
        }
        return "操作失败";
    }

    @RequestMapping(value = "deleteUser", produces = "application/json;charset=utf-8")
    public String deleteUserById(String id) {
        int i = userService.deleteById(Integer.parseInt(id));
        if (i > 0) {
            return "删除用户成功";
        }
        return "操作失败";
    }

}
