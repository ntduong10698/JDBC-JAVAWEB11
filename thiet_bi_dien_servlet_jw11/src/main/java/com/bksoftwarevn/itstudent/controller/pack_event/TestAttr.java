package com.bksoftwarevn.itstudent.controller.pack_event;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TestAttr", value = "/test-attr")
public class TestAttr extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //thêm
        request.setAttribute("test-attr", 1);
        //xóa
        request.removeAttribute("test-attr");
        //sửa
        request.setAttribute("test-attr", 2);
        //=> sự kiện xảy ra như nào, cơ chế của setAttribute hoạt động như nào
       //=> cơ chế của setAttribute nếu key chưa tồn tại thì sẽ thêm thông tin
       //nếu key đã tồn tại thì sửa thông tin
    }
}
