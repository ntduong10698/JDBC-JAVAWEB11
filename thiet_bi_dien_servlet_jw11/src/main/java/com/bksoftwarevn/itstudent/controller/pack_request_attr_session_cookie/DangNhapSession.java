package com.bksoftwarevn.itstudent.controller.pack_request_attr_session_cookie;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "DangNhapSession", value = "/dang-nhap-session")
public class DangNhapSession extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Để làm việc được tiếng việt cần thêm những cấu hình sau đây request, response
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(username != null && password != null
                && username.equals("root") && password.equals("root")) {
            /**
             * - Lưu trữ thông tin bằng session phạm vi lớn request attribute
             * - Session là phiên làm việc giữa client và server (phiên làm việc được
             * tính từ lúc đăng nhập đến lúc tắt hẳn trình duyệt)
             * - Phạm vi lưu trữ thông tin bằng session là phạm vi của phiên làm viêc
             * - Để làm việc với session thì cần phải thao tác với đối tượng HttpSession
             * được lấy ra từ đối tượng HttpServletRequest bằng hàm getSession();
             * => Làm sao để khi tắt trình duyệt thậm chí là tắt máy vẫn còn lưu
             * trữ được thông tin của client đã nhập => cookie
             */
            //lấy ra đối tượng session
            HttpSession session = request.getSession();
            //lưu trữ thông tin trong sessiong
            session.setAttribute("name-client", "ITStudent-Session");
            response.sendRedirect("trang-chu");
        } else {
            response.getWriter().println("<h1>Tài khoản hoặc mất khẩu không đúng!</h1>");
        }
    }
}
