package cn.wulei.interceptor;

import cn.wulei.entity.Admin;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminLoginInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("执行了拦截器");
        request.getParameter("name");
        request.getParameter("pwd");
        String str=request.getRequestURI();
        System.out.println(str);
        HttpSession session=request.getSession();
        Admin admin= (Admin) session.getAttribute("admin");
        System.out.println(admin);
        return true;
    }
}
