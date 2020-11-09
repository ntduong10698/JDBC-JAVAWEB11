package com.bksoftwarevn.itstudent.filter;

import com.bksoftwarevn.itstudent.model.MyConnection;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//Trong api filter ngoài trừ việc cấu hình utf còn

/**
 * Mục đích của api: cung cấp các thao tác (thêm, sửa, xóa, tìm kiếm) đến db cho client
 *      + Muốn thao tác db cần phải có kết nối cần thư viện jdbc
 *      + Các hàm thao tác với db thì đã được code ở đâu project jdbc
 *      => copy code từ project jdbc sang project servlet
 * + Thay việc trong các servlet api thì mình viết câu lệnh nối, thì
 * chuyển phần về ApiFilter
 */
@WebFilter(filterName = "ApiFilter", urlPatterns = "/api/*")
public class ApiFilter implements Filter {

    private MyConnection myConnection = new MyConnection();

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        resp.setContentType("application/json;charset=UTF-8");
        //để connection đến db thì dùng connectDB trong lớp MyConnection
        //Nếu kết nối rồi thì connection != null, khi = null mới thực hiện kết nối
        try {
            myConnection.connectDB();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
