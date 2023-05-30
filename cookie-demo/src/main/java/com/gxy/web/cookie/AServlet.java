package com.gxy.web.cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/aServlet")
public class AServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 发送cookie
        // 1. 创建cookie
        // Cookie cookie = new Cookie("name", "zs");

        // 存储中文
        String value = "张三";
        value = URLEncoder.encode(value, "UTF-8");
        System.out.println("存储数据:" + value);
        Cookie cookie = new Cookie("name", value);

        // 设置存活时间
        // cookie.setMaxAge(60*60*24*7);

        // 2. response发送
        response.addCookie(cookie);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
