package com.hyp.contorller.UserController;

import com.hyp.pojo.Admin;
import com.hyp.pojo.User;
import com.hyp.service.AdminService.AdminService;
import com.hyp.service.UserService.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Han
 * @data 2023/4/5
 * @apiNode
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private userService userService;
    @Autowired
    private AdminService adminService;

    @RequestMapping(value = {"/findByName/{username}"})
    public String findById(@PathVariable String username) {
        User userById = userService.findUserByName(username);
        System.out.println(userById);
        return "login";
    }
    @RequestMapping(value = {"/findUserById/{id}"})
    public String findById(@PathVariable Integer id) {
        User userById = userService.findUserById(id);
        System.out.println(userById);
        return "login";
    }

    /**
     * 用户注册实现
     * @param user
     * @return
     */
    @RequestMapping(value = "/UserRegister")
    public String register(User user , Model model){
        User userByName = userService.findUserByName(user.getUsername());
        User byEmail = userService.findByEmail(user.getEmail());
        User byPhone = userService.findByPhone(user.getPhone_num());
        if (userByName!=null){
            model.addAttribute("registerError", "用户名已被他人使用！");
            return "forward:/nameEmailPhoneError";
        }
        if (byEmail!=null){
            model.addAttribute("registerError", "邮箱已被他人使用！");

            return "forward:/nameEmailPhoneError";
        }
        if (byPhone!=null){
            model.addAttribute("4 ", "手机号已被他人使用！");

            return "forward:/nameEmailPhoneError";
        }
        int i = userService.register(user);
        String path = null;
        if (i>0){
            model.addAttribute("register", 1);
            path = "forward:/register_success_remind";
        }
        System.out.println(i);
        return path;

    }

    /**
     * 用户登录实现
     * @return
     */
    @RequestMapping("UserLogin")
    private String login(String username,String password,HttpServletRequest httpServletRequest){
        //如果是是普通用户
        User user = userService.login(username, password);
        Admin admin = adminService.AdminLogin(username, password);
        String path;
        if (user!=null){
            //用户登录成功
            //获取一个session，放入user对象页面跳转时使用
            httpServletRequest.getSession().setAttribute("login", user);
            path = "forward:/login_success_remind";
        }else if (admin!= null){
            //管理员登录成功
            httpServletRequest.getSession().setAttribute("login", admin);
            path = "forward:/adminLoginSuccess";
        }else {
            path = "forward:/login_fail_remind";
        }
        return path;
    }



}
