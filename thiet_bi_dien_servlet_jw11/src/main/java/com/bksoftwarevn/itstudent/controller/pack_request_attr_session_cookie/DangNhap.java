package com.bksoftwarevn.itstudent.controller.pack_request_attr_session_cookie;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * - Tìm hiểu vể stateless, stateful, phân biệt stateless và statefull
 * Http là giao thức stateless.
 * - Stateless được hiểu là cơ chế không lưu trữ trạng thái làm việc với request trước đó của client.
 * Cách hoạt động của stateless:
 * - Để đăng nhập thì client phải request đến trang đăng nhập và truyền tài
 * khoản mật khẩu nếu đăng nhập thành công thì chuyển sang trang chủ. Nhưng
 * ở tại trang chủ không có một thông tin nào thể hiện client đã đăng nhập hay chưa.
 * => Cải tiết chức năng đăng nhập của mình làm sao giống facebook nhất
 * phân biệt được client nào đã đăng nhập hay chưa.
 *      + Để biết user đã đăng nhập hay chưa thì cần lưu thông tin của client
 *      đã đăng nhập rồi.
 *      + Cần phải sử dụng các cơ chế sau để lưu thông tin người dùng
 *          - request attribute
 *          - session
 *          - cookie
 *  => Mỗi cơ chế trên đều có một phạm vi lưu trữ thông tin khác nhau, tùy từng
 *  trường hợp nến biết cần phải sử dụng cơ chế nào.
 */
@WebServlet(name = "DangNhap", value = "/dang-nhap")
public class DangNhap extends HttpServlet {
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
            //khi đăng nhập thành công mới lưu trữ thông tin
            /**
             * Thực hiện lưu trữ thông tin bằng request attribute
             * Phân tích sendRedirect và forward dưới góc nhìn request:
             *  + sendRedirect: đầu tiên gửi 1 request đến trang đăng nhập,
             *      nếu đăng nhập thành công, gửi thêm 1 request đến trang chủ
             *      để hiện thị nội dung trang chủ: (2 request )
             *  + forward: gửi 1 request đến trang đăng nhập, nếu đăng nhập
             *      thành công sẽ chuyển hướng trong server và trả về
             *      kết quả của trang chủ: (1 request)
             * => Phạm vi lưu trữ thông tin của request attribute là 1 trong 1
             * request
             * => Làm sao để thông tin tồn tại trong tap 2...n thì cần một
             * phạm vi lưu trữ thông tin rộng hơn.
             */
            RequestDispatcher rd = request.getRequestDispatcher("trang-chu");
            //Thực hiện lưu trữ thông tin client đã đăng nhập thành cộng
            //bằng cơ chế request attribute sẽ dụng hàm setAttribute trong
            //đối tượng HttpServletRequest
            request.setAttribute("name-client", "ITStudent");
            rd.forward(request, response);
        } else {
            response.getWriter().println("<h1>Tài khoản hoặc mất khẩu không đúng!</h1>");
        }
    }
}
