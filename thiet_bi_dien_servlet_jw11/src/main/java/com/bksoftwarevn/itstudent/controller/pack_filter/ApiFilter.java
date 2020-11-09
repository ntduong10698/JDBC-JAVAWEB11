package com.bksoftwarevn.itstudent.controller.pack_filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//khi làm việc với filter cần quan tâm filter xử lý cho nhứng url nào
//nếu là url api thì luôn luôn phải tuân thủ cú pháp sau:
// /api/v1/product, /api/v2/category
@WebFilter(filterName = "ApiFilter", urlPatterns = "/api/*")
public class ApiFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        System.out.println("Api Filter: " + request.getRequestURI());
        //cấu hình
        resp.setContentType("application/json;charset=UTF-8");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
