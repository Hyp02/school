package com.hyp.contorller;

import com.hyp.pojo.Admin;
import com.hyp.pojo.Files;
import com.hyp.pojo.User;
import com.hyp.service.PrintService.PrintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Han
 * @data 2023/4/8
 * @apiNode
 */
@Controller
public class viewController {
    @Autowired
    PrintService printService;

    @RequestMapping("/alreadyLogin")
    public String viewJump(HttpServletRequest req, Model model) {
        if (req.getSession().getAttribute("login")==null){
            //如果没有登录，跳转到登录页面
            return "NotLogin";
        }
        User loginUser;
        if (req.getSession().getAttribute("login") instanceof User) {
            //如果session域中存储的是User
            loginUser = (User) req.getSession().getAttribute("login");
            if (loginUser.getUsername().equals("printBoos")) {
                //登录的如果是打印店老板，直接跳转到打印的地方
                List<Files> files = printService.downFiles();
                model.addAttribute("files", files);
                return "printBoos";
            }
        }
        if (req.getSession().getAttribute("login") instanceof Admin){
            Admin login = (Admin) req.getSession().getAttribute("login");
            if (login.getUsername().equals("superAdmin")){
                //如果是超级管理员
                return "SuperAdmin";
            }
        }
        //如果既不是超管也不是打印老板，呢就到登录后的页面
        return "alreadyLogin";
    }
}
