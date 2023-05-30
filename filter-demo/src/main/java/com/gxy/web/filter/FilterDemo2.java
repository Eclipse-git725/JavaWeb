package com.gxy.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

// @WebFilter("/hello.jsp")
@WebFilter("/*")
public class FilterDemo2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("2.filter demo ..");
        // 放行
        chain.doFilter(request, response);

        // 放行后逻辑
        System.out.println("4.after filter..");
    }

    @Override
    public void destroy() {

    }
}
