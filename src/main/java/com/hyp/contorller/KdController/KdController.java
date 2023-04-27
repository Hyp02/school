package com.hyp.contorller.KdController;

import com.hyp.pojo.Admin;
import com.hyp.pojo.KD;
import com.hyp.pojo.User;
import com.hyp.service.KdService.KdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Han
 * @data 2023/4/9
 * @apiNode
 */
@Controller
@RequestMapping("/kd")
public class KdController {
    @Autowired
    KdService kdService;

    @RequestMapping("/KuaiDiIssued")
    public String KdIssue(HttpServletRequest req) {
        return "KuaiDiIssued";
    }

    @RequestMapping("/getKdByName/{name}")
    public String getKdByName(@PathVariable String name) {
        KD kdByName = kdService.getKdByName(name);
        System.out.println("快递信息为=====" + kdByName);
        return "KuaiDiInfo";
    }

    @RequestMapping(value = "/AddKdInfo", method = RequestMethod.POST)
    public String addKdInfo(KD kd) {
        String path;
        int i = kdService.issuedKD(kd);
        if (i > 0) {
            //添加成功
            path = "redirect:/kd/getAllKdInfo";
        } else {
            path = "redirect:/AddKdFail";
        }
        return path;
    }

    @RequestMapping(value = "/getAllKdInfo", method = RequestMethod.GET)
    public String getAllKfInfo(Model model, HttpServletRequest req) {
        if(req.getSession().getAttribute("login") instanceof User){
            User user = (User) req.getSession().getAttribute("login");
            if (user != null) {
                //已经登录
                List<KD> allKdInfo = kdService.getAllKdInfo();
                System.out.println(allKdInfo);
                model.addAttribute("kdList", allKdInfo);
                return "KuaiDiInfo";
            }
        }
        if(req.getSession().getAttribute("login") instanceof Admin){
            Admin admin = (Admin) req.getSession().getAttribute("login");
            if (admin != null) {
                //已经登录
                List<KD> allKdInfo = kdService.getAllKdInfo();
                System.out.println(allKdInfo);
                model.addAttribute("kdList", allKdInfo);
                return "KuaiDiInfo";
            }
        }
        return "NotLogin";

    }
}
