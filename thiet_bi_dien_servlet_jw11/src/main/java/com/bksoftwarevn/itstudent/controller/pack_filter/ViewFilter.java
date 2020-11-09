package com.bksoftwarevn.itstudent.controller.pack_filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//tùy từng project
//quy đinh tất cả file view đều có dang /view/*
@WebFilter(filterName = "ViewFilter", urlPatterns = "/view/*")
public class ViewFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        System.out.println("View Filter: " + request.getRequestURI());
        resp.setContentType("text/html;charset=UTF-8");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
