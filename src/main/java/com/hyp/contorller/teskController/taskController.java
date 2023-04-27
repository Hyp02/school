package com.hyp.contorller.teskController;

import com.hyp.pojo.Admin;
import com.hyp.pojo.HelpGet;
import com.hyp.pojo.Task;
import com.hyp.pojo.User;
import com.hyp.service.AdminService.AdminService;
import com.hyp.service.HelpGetService.HelpGetService;
import com.hyp.service.KdService.KdService;
import com.hyp.service.TackService.TackService;
import com.hyp.service.UserService.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author Han
 * @data 2023/4/9
 * @apiNode
 */
@Component
@RequestMapping("/task")
public class taskController {
    @Autowired
    TackService tackService;
    @Autowired
    KdService kdService;
    @Autowired
    HelpGetService helpGetService;
    @Autowired
    userService userService;
    @Autowired
    AdminService adminService;

    @RequestMapping(value = "/deleteTaskAndHelp/{id}", method = RequestMethod.DELETE)
    public String deleteTaskAndHelp(@PathVariable("id") String id, HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        System.out.println("删除进来了");
        //点击完成送货后，在任务表中将任务删除，在help表中将信息删除，根据kdid
        int i = helpGetService.deleteHelpUserById(id);
        int i1 = tackService.deleteTaskById(id);
        String username = null;
        if (req.getSession().getAttribute("login") instanceof User){
            User login = (User) req.getSession().getAttribute("login");
            username = login.getUsername();
        }
        if (req.getSession().getAttribute("login") instanceof Admin){
            Admin admin = (Admin) req.getSession().getAttribute("login");
            username = admin.getUsername();
        }
        String redirectUrl = "/task/getSelfInfo/" + username;
        System.out.println(redirectUrl);
        resp.setContentType("text/html;charset=UTF-8"); // 设置响应头部信息
        return "redirect:" + new String(redirectUrl.getBytes(StandardCharsets.UTF_8), "ISO-8859-1");
    }

    //点击我的信息，查询 任务数据库中的任务，根据已经登录的这个人的用户名
    @RequestMapping("/getSelfInfo/{loginName}")
    public String getSelfInfo(@PathVariable String loginName, HttpServletRequest req) {
        //将任务信息添加到t_task中
        //tackService.addTask()
        //根据登录名取出任务信息，用于在任务列表显示快递信息
        List<Task> taskInfoList = tackService.getTaskByLoginName(loginName);
        List<HelpGet> helpGetList = helpGetService.getHelpGet(loginName);

        System.out.println("任务=======" + taskInfoList);
        System.out.println("帮取列表=======" + helpGetList);
        //加入到任务列表中
        if (req.getSession().getAttribute("login") != null) {
            //已经登录
            req.getSession().setAttribute("taskInfoList", taskInfoList);
            //将代取人信息放到session中,用来在我的信息页面显示
            req.getSession().setAttribute("helpUserInfoList", helpGetList);
            return "selfInfo";
        }
        return "NotLogin";
    }

    @RequestMapping("/addTask")
    public String addTask(Task task, Model model, HelpGet helpGet, HttpServletRequest req,
                          @RequestParam("SHname") String issuedName) {

        if (req.getSession().getAttribute("login") instanceof User) {
            //如果不是管理员，没有权限取快递
            model.addAttribute("helpAdmin", "对不起，您还不是平台“代取员");
            return "helpFail";
        }
        //User loginUser = (User) req.getSession().getAttribute("login");
        //System.out.println("登陆的人" + loginUser.getUsername());
        //将任务信息添加到任务表中
        int i = tackService.addTask(task);
        //在快递表中根据取货码删除(发布页面消失)
        int i1 = kdService.deleteKdByKdId(task.getKdid());
        //将点击帮取的那个人的信息存储到t_help_user;
        helpGetService.saveHelpUserInfo(helpGet);
        req.getSession().setAttribute("issuedName", issuedName);
        return "helpSuccess";
    }


}
