package com.gxy.web.response;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/resp1")
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("resp1..");
        /*

        // 重定向
        response.setStatus(302);
        // 设置响应头，路径要写虚拟路径
        response.setHeader("Location", "/request-demo/resp2");
        */

        // 简化方式完成重定向
        // 动态获取虚拟路径
        String contextPath = request.getContextPath();
        response.sendRedirect(contextPath + "/resp2");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
