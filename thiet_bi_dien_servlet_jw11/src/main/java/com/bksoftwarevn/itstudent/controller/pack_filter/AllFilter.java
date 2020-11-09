package com.bksoftwarevn.itstudent.controller.pack_filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "AllFilter", urlPatterns = "/*")
public class AllFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        System.out.println("All Filter: " + request.getRequestURI());
        //cấu hình để có thể làm việc với utf-8
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        //text/html => bắt buộc là file html
        //application/json => biểu thị cho file trả về là file json .json
        //resp.setContentType("text/html;charset=UTF-8");
        //response.setHeader
        HttpServletResponse response = (HttpServletResponse) resp;
        response.setHeader("Access-Control-Allow-Origin", "*");
        chain.doFilter(req, response); // chấp nhận cho request chuyến đến servlet
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
