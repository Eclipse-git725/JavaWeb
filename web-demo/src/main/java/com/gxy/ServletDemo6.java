package com.gxy;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//urlPattern：一个servlet可以配置多个访问路径
//@WebServlet(urlPatterns = {"/demo6", "/demo7"})
//@WebServlet(urlPatterns = "/user/select")
//@WebServlet(urlPatterns = "/user/*")
//@WebServlet(urlPatterns = "*.do")
//@WebServlet(urlPatterns = "/") 不建议写这个
@WebServlet(urlPatterns = "/*")
public class ServletDemo6 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo7 get..");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo7 post..");
    }
}
