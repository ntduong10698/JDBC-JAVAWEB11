package com.bksoftwarevn.itstudent.controller.pack_request_dispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TestRequestDispatcher", value = "/test-request-dispatcher")
public class TestRequestDispatcher extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //do có 2 cơ chế forward và include cần test nên cho người quyết định
        //khi nào dùng forward và khi nào dùng include
        String forward = request.getParameter("forward");
        response.getWriter().println("<h1>Forward :"+forward+"</h1>");
    }
}
