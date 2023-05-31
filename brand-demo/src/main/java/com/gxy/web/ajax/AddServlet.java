package com.gxy.web.ajax;

import com.alibaba.fastjson.JSON;
import com.gxy.pojo.Brand;
import com.gxy.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/ajax/addServlet")
public class AddServlet extends HttpServlet {
    private BrandService brandService = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 接受数据
        // String brandName = request.getParameter("brandName"); // 无法接受json数据

        // 获取请求体数据
        BufferedReader br = request.getReader();
        String params = br.readLine();

        // 反序列化（json转对象）
        Brand brand = JSON.parseObject(params, Brand.class);
        System.out.println(brand);

        // 调用service添加
        brandService.add(brand);

        // 响应数据
        response.getWriter().write("success");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
