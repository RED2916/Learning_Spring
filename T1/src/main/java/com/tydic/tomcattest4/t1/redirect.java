package com.tydic.tomcattest4.t1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "re-direct",value = "/redirect")
public class redirect extends HttpServlet {
    private String redirect_ad;

    @Override
    public void init() {
        redirect_ad = "http://www.baidu.com";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(redirect_ad);
    }
}
