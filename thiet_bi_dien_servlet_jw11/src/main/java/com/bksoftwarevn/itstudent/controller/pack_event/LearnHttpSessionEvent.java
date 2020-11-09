package com.bksoftwarevn.itstudent.controller.pack_event;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Date;


/**
 * - HttpSessionEvent là gì ?
 * - Cung cấp cho mình bao nhiện sự kiện
 * - Đối tượng đầu vào của sự kiến là gì, và đối tượng cho phéo mình làm gì
 * - Event xayra khi nào
 * => Rút ra được thêm bài học gì không
 */
@WebListener
public class LearnHttpSessionEvent implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        HttpSession httpSession = httpSessionEvent.getSession();
        System.out.println("Create Session: " + new Date().getTime());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

    }
}
