package com.bksoftwarevn.itstudent.controller.pack_request_dispatcher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Điều hướng request trong servlet
 *      + Request Dispatcher
 *      + sendRedirect
 * => Tìm hiểu về 2 cơ chế và rút ra khi nào nên dùng 1 trong 2 cơ chế này
 */

/**
 * Request Dispatcher là 1 interface cung cấp cơ chế điều hướng request
 *  Có 2 cơ chế điều hướng:
 *      + Gửi request của client đến một tài nguyên khác trên server: forward
 *      + Bao gồm một tài nguyên khác trên server: include
 *  => Đều liên quan đến một tài nguyên khác trên server nên tạo ra một Sevelet
 *  TestRequestDispatcher để demo
 *  +> Phân tích khác nhau giữa cơ chế forward và include
 *      + Forward: điều hướng request sang một tài nguyên khác và chỉ hiện thị nội dụng của tài nguyên đó
 *      + Include: bao gồm cả nội dụng trả về của trang yêu cầu và cả trang bao gồm
 */

//Bài tập: Làm chức năng đăng nhập

/**
 * Tạo servlet đăng nhập cho người dùng truyền thông tin username và password
 * nếu username = root và password = root thì chuyển đến trang chủ,
 * còn nếu khác in ra Tài khoản hoặc mật khẩu không chính xác!.
 */
@WebServlet(name = "LearnRequestDispatcher", value = "/learn-request-dispatcher")
public class LearnRequestDispatcher extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("<h1>Learn Request Dispatcher</h1>");
        String forward = request.getParameter("forward");
        //để sử dụng được 2 cơ chế forward và include thì cần phải
        //lấy ra được đối tượng RequestDispatcher
        // nằm trong đối tượng HttpServletRequest
        RequestDispatcher rd = request.getRequestDispatcher("test-request-dispatcher");
        if(forward != null && forward.equals("true")) {
            //thực hiện forward
            rd.forward(request, response);
        } else {
            //thực hiện include
            rd.include(request, response);
        }
    }
}
