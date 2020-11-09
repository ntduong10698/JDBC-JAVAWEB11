package com.bksoftwarevn.itstudent.controller.pack_request_attr_session_cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TestCookie", value = "/test-cookie")
public class TestCookie extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Một phương thức do thì luôn có 2 tham số truyền vào
        //HttpServletRequest chứa các thông tin người dùng truyền lên server
        //HttpServletResponse chứa kết quả trả về sau khi server xử lý
        //phân biệt request, response

        //Đọc thông tin được lưu trữ bằng request attribute
        //String nameClient = (String) request.getAttribute("name-client");

        //Đọc thông tin được lưu trữ bằng session
        //HttpSession session = request.getSession();
        //String nameClient = (String) session.getAttribute("name-client");

        //Đọc thông tin lưu trữ bằng cookie
        //Các thông tin cookie được lưu trữ trong máy người dùng đươc gửi
        //lên dưới đạng một mảng các đối tượng Cookie chứa thông tin được
        //lưu trữ
        Cookie cookies[] = request.getCookies();
        //Trong các đối cookie nằm trong mảng được client đưa lên chứa thông
        //tin được lưu dưới dạng key value.
        String nameClient = null;
        for (Cookie c: cookies) {
            if(c!= null && c.getName().equals("name-client")) {
                nameClient = c.getValue();
                break;
            }
        }
        //Có 2 cách ghi đè thông tin cookie
        // + Duyệt vòng for tìm đúng cookie và thay đổi dữ liêu
        // + Sử dụng ghi đè cookie
        Cookie cookie = new Cookie("name-client", "ITStudent");
        response.addCookie(cookie);
        response.getWriter().println("<h1>Test Cookie: "+nameClient+"</h1>");
    }
}
