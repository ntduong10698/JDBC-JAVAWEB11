package com.bksoftwarevn.itstudent.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Servlet là một class bình thường và extends HttpServlet
 * Một servlet nó có 1 một số hàm quan trọng như sauL
 *  init(): chỉ chạy 1 lần khi servlet được tạo ra
 *  destroy(): chỉ chạy 1 lần khi hủy servlet
 *  service(): chạy đi chạy lại nhiều lần và gọi các hàm tương ứng để
 *  xử lý request doGet, doPut, doDelete, doPOST
 * Client và Server giao tiếp qua giao thức HTTP.
 * HTTP cung cấp 4 phương thức:
 *      + GET: lấy dữ liệu
 *      + PUT: sửa dữ liêu
 *      + DELETE: xóa dữ liệu
 *      + POST: Đẩy dữ liệu (thêm dữ liệu)
 * Khi client giao tiếp với server ngoài chỉ ra cần truy cập đến url nào
 * thì cần thêm sử dụng phương thức nào trong 4 phương thức trên.
 * + Khi truy cập bằng trình duyệt phương thức mặc định sẽ là GET. Để gọi
 * được các phương thức khác sẽ phải sử dụng thêm một số công cụ hỗ trỡ khác
 * hoặc gọi bằng công cụ khác (postman)_
 */
@WebServlet(name = "TrangChu")
public class TrangChu extends HttpServlet {
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
        response.getWriter().println("<h1>Trang Chu: "+nameClient+"</h1>");
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
