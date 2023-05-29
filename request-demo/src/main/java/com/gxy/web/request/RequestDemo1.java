package com.gxy.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/req1")
public class RequestDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getMethod();
        System.out.println(method);
        String contextPath = req.getContextPath();  // 获取虚拟目录
        System.out.println(contextPath);
        StringBuffer requestURL = req.getRequestURL();
        System.out.println(requestURL);
        String requestURI = req.getRequestURI();
        System.out.println(requestURI);
        String queryString = req.getQueryString();  // 获取请求参数
        System.out.println(queryString);

        String header = req.getHeader("user-agent");    //获取请求头，user-agent是浏览器版本信息
        System.out.println(header);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取post请求体

        BufferedReader br = req.getReader();    // 获取字符输入流
        String line = br.readLine();   // 读取数据
        System.out.println(line);

    }
}
