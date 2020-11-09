package com.bksoftwarevn.itstudent.controller.pack_url_pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//2 url cho 1 servlet xử lý
//định dạng của url tất viết thường các từ phần phần cách nhau: _, -
//Nhưng chỉ nên dùng đồng nhất 1 kiểu -
@WebServlet(name = "LearnUrlPattern", urlPatterns = {"/learn-url-pattern/*","/hoc-url-pattern"})
public class LearnUrlPattern extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("<h1>Learn Url Pattern</h1>");
        //lấy ra url
        response.getWriter().println("<h2>"+request.getRequestURL()+"</h2>");
        //lây ra uri
        response.getWriter().println("<h2>"+request.getRequestURI()+"</h2>");
        //lấy ra servlet path
        response.getWriter().println("<h2>"+request.getServletPath()+"</h2>");
        //lấy ra pathInfo
        response.getWriter().println("<h2>"+request.getPathInfo()+"</h2>");
        //query String trên url phải nằm sau dấu ? chứa các dữ liệu mà
        //người dùng muốn truyền lên server theo dạng key=value&key1=value1
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        response.getWriter().println(id+" "+name);
    }
}
