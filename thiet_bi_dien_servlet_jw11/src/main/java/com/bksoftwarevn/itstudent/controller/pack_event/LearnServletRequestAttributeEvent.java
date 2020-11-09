package com.bksoftwarevn.itstudent.controller.pack_event;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;
import java.util.Date;


/**
 * ServletRequestAttributeEvent là sự kiện của RequestAttribute trong servlet
 * Cung cấp 3 sự kiệnL
 *      + Thêm một attribute
 *      + Sửa một attribute
 *      + Xóa một attribute
 * Đầu vào của 3 hàm đều là một đối tượng ServletRequestAttributeEvent đối tượng
 * này cho phép mình lấy ra đối tượng ServletRequest
 *
 *  Vì sao khi request đến một trang nào đấy luôn luôn chạy event replace attr
 */
@WebListener
public class LearnServletRequestAttributeEvent implements ServletRequestAttributeListener {
    @Override
    public void attributeAdded(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        ServletRequest servletRequest = servletRequestAttributeEvent.getServletRequest();
        System.out.println("Add Attr: " + servletRequest.getAttribute("test-attr") +
                " - " + new Date().getTime());
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        ServletRequest servletRequest = servletRequestAttributeEvent.getServletRequest();
        System.out.println("Remove Attr: " + servletRequest.getAttribute("test-attr") +
                " - " + new Date().getTime());
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        ServletRequest servletRequest = servletRequestAttributeEvent.getServletRequest();
        System.out.println("Replace Attr: " + servletRequest.getAttribute("test-attr") +
                " - " + new Date().getTime());
    }
}
