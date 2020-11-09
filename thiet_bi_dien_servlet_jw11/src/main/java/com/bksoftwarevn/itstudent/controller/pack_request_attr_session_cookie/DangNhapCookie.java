package com.bksoftwarevn.itstudent.controller.pack_request_attr_session_cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "DangNhapCookie", value = "/dang-nhap-cookie")
public class DangNhapCookie extends HttpServlet {
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
             * - Lưu trữ thông tin trong cookie phạm vi lớn hơn session
             * - 2 cách lưu trữ trên là sử dụng lưu trữ thông tin trên server
             * còn cookie sử dụng cơ chế lưu trữ thông tin trên client.
             * - Cookie là các tập tin văn bản được lưu trữ ở trong trình duyêt
             * người dùng
             * - Để lưu trữ được thông tin (thì cơ chế phải khác hẳn 2 kỹ
             * thuât trên) phải tạo ra một đối tượng Cookie chứa thông tin
             * người dùng đã đăng nhập và sau đó gửi thông tin này cho client
             * lưu trữ
             */
            //tạo ra đối tượng cookie chứa thông tin
            Cookie cookie = new Cookie("name-client", "ITStudent-Cookie");
            cookie.setMaxAge(24*3600);//thời gian sống của cookie
            //gửi cookie này cho client lưu trữ
            //cookie.setPath("/thiet_bi_dien_servlet_jw11_war/trang-chu"); //giới hạn cookie chỉ hoạt động trong uri nào
            response.addCookie(cookie);
            response.sendRedirect("trang-chu");
            //Chức năng đăng nhập sẽ thường sử dụng cookie cho nên cần phải
            //học thêm 1 số chơ chế để cấu hình cookie.
            //  + Giới hạn phạm vi hoạt động cookie
            //  + Ghi đè cookie
        } else {
            response.getWriter().println("<h1>Tài khoản hoặc mất khẩu không đúng!</h1>");
        }
    }
}
