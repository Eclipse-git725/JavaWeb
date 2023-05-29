package com.gxy.web.request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

// 中文乱码解决
@WebServlet("/req4")
public class RequestDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 解决乱码  POST.getReader
        // request.setCharacterEncoding("UTF-8");

        // 1. 获取username
        String username = request.getParameter("username");


        // 解决乱码 Get
        // 先对乱码数据进行编码，转成字节数组
        byte[] bytes = username.getBytes(StandardCharsets.ISO_8859_1);
        // 对字节数组解码
        username = new String(bytes, StandardCharsets.UTF_8);
        System.out.println(username);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
