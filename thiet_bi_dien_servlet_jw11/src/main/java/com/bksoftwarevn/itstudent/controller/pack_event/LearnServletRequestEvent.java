package com.bksoftwarevn.itstudent.controller.pack_event;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import java.util.Date;

/**
 * là gì, làm được gì, khi nào xảy ra
 * ServletRequestEvent là sự kiện cho request trong servlet (request là thành phần client gửi cho server)
 * Cung cấp 2 sự kiện:
 *  + Sự kiện request được tạo ra
 *  + Sự kiện request bị hủy
 * Tương ứng với 2 sự kiện này sẽ có 2 phương thức tương ứng, khi sự kiện xảy
 * ra thì các câu lệnh trong các phương thức này sẽ được chạy
 *  + Tham số đầu vào đều là 1 đối tượng ServletRequestEvent cho phép mình lấy
 *       ra một đối tượng ServletRequest
 *          - Binh thường khi việc với servlet thì sẽ làm việc với đối tượng
 *          HttpServletRequest đối tượng này là con của đối tượng ServletRequest
 *              + Khi client giao tiếp với server thông qua request thì request
 *              có thể chấp nhận nhiều thức khác nhau: http (HttpServletRequest),
 *              fpt(giao thức trao đổi tệp tin)...
 * => Để biết khiaa nào sự kiện xảy ra thì chỉ cần in ra 1 dòng sự kiện
 * nào vừa được xảy ra tại thời điểm nào
 *
 * => Khi client gửi request đến server thì một đối tượng ServletRequest
 * sẽ được tạo ra, và đối tượng ServleRequest sẽ bị hủy ngay sau khi
 * server xử lý và trả về response (để giải phóng tài nguyên hệ thống)
 */

@WebListener //đánh dấu cho server biết đây là một file listener
public class LearnServletRequestEvent implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        //lấy ra đối tượng ServletRequest bằng hàm getServletRequest
        ServletRequest servletRequest = servletRequestEvent.getServletRequest();
        //lấy giao thức được sử dụng
        String protocol = servletRequest.getProtocol();
//        System.out.println("Destroy Request: " + protocol + " - " + new Date().getTime());
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        //lấy ra đối tượng ServletRequest bằng hàm getServletRequest
        ServletRequest servletRequest = servletRequestEvent.getServletRequest();
        //lấy giao thức được sử dụng
        String protocol = servletRequest.getProtocol();
        //System.out.println("Init Request: " + protocol + " - "  + new Date().getTime());
    }
}
