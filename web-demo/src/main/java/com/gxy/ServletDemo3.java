package com.gxy;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(value = "/demo3", loadOnStartup = 1)
public class ServletDemo3 implements Servlet {
    ServletConfig config;
    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
        System.out.println("init");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("Servlet hello world~");
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }



    @Override
    public String getServletInfo() {
        return null;
    }


}
