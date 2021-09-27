package cn.wulei.controller;

import cn.wulei.entity.Admin;
import cn.wulei.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @RequestMapping("login")
    public String login(String name, String pwd, HttpSession session) {

        Admin admin=adminService.loginAdmin(name,pwd);
        if (admin!=null){
            //request.setAttribute("admin",admin);
            session.setAttribute("admin",admin);
            return "main";
        }
        session.setAttribute("errmsg","密码错误");
        System.out.println("密码错误！@！！！！");
        return "login";
    }

    @RequestMapping("regist")
    public String registAdmin(String myname,String mypwd,HttpServletRequest request){
        Admin admin=new Admin();
        admin.setaName(myname);
        admin.setaPass(mypwd);
        int num=adminService.register(admin);
        if (num>0){
            request.setAttribute("msg","注册成功!");
        }else {
            request.setAttribute("msg","注册失败!");
            return "regist";
        }
        return "login";
    }

}
