package com.bksoftwarevn.itstudent.controller.pack_filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * + Filter là gì:
 *      Filter có chức năng tiền xử lý request trước khi servlet
 *      và hậu xử lý response trước khi trả về clien
 * + Mô hình filter:
 * + Các hàm trong 1 filter:
 *      - init(): chỉ được chạy 1 lần duy nhất khi deploy hệ thống
 *      - doFilter(): lặp đi lặp lại nhiều lần mỗi khi có request tương ứng
 *      - destroy(): chỉ được chay 1 lần duy nhất khi tắt hệ thống.
 * => Filter được sử dụng trong các trường hợp nào:
 *  - Bảo mật: ở trang web sẽ có một trang yêu cầu phải đăng nhập
 *      mời được vào. Filter có chức nằng kiểm tra mỗi lần request đến
 *      xem client đã đăng nhập hay chứa nếu rồi cho qua và chuyển request
 *      đến servlet, còn nếu chưa thì trả về thông báo không có quyền.
 *  - Cấu hình cho các servlet: (hướng dẫn sử dụng filter, demo xem phân
 *  cấp filter)
 *  => Phân cấp của filter chính là phân cấp url
 */
@WebFilter(filterName = "LearnFilter")
public class LearnFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
