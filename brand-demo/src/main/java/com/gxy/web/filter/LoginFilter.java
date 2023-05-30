package com.gxy.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
// 登录验证的过滤器
@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        // 判断访问资源路径是否和登录注册相关
        String[] urls = {"/login.jsp", "/imgs/", "/css/", "/loginServlet", "/register.jsp", "/registerServlet",
                "/checkCodeServlet"};

        // 获取当前访问资源的路径
        String requestURI = req.getRequestURI().toString();
        for(String u : urls){
            if(requestURI.contains(u)){
                // 找到了
                chain.doFilter(request, response);
                return;
            }
        }

        // 1.判断session是否有user

        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");

        // 2. 判断use是否为null
        if(user != null){
            // 登陆过
            chain.doFilter(request, response);
        }else{
            // 没登陆
            req.setAttribute("login_msg", "您尚未登录");
            req.getRequestDispatcher("/login.jsp").forward(req,response);
        }
    }

    @Override
    public void destroy() {

    }
}
