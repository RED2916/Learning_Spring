package com.tydic.tomcattest4.t1;

import classes.UserInformation;
import jdbcutl.JdbcUtl;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.tydic.tomcattest4.t1.HelloServlet.SessionTest;

//对于form-data而言，@M...这个annotation是不能省的
//@WebServlet(name = "ReceiveInformForm",value = "/receive-inform-form")
@MultipartConfig
public class ReceiveInformForm  extends HttpServlet {
    @Override
    public void init(){
        JdbcUtl.ConnectTomcattest();
    }

    public int DealForm(HttpServletRequest req, HttpServletResponse resp) throws IOException {

//        System.out.println(req.getMethod());
//        System.out.println(req.getHeaderNames().nextElement());//没有nextElement就只有地址

        String userId = req.getParameter("userId");
        String userName = req.getParameter("userName");//直接在url上写没问题->已解决，form-data需要多加一个annotation
        String age = req.getParameter("age");
        String address = req.getParameter("address");
        String exInf = req.getParameter("exInf");
        UserInformation UI = new UserInformation(userId,userName,age,address,exInf);
        List<UserInformation> UiAll = new ArrayList<>();
        UiAll.add(UI);

        PrintWriter out = resp.getWriter();
        if(UIService.SingleCheckAndSave(UiAll)==1){
            out.println("Succeed");
        }else{
            out.println("Fail");
        }
        out.close();
        return 0;
    }

    protected static int CookiesTest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Cookie cookie =null;
        Cookie[] cookies = null;

        cookies = req.getCookies();
        System.out.println(cookies.length);
        cookie = cookies[1];
        String Test=cookie.getValue();
        System.out.println(Test);

        PrintWriter out = resp.getWriter();
        out.println(Test);
        out.close();
        return 1;
    }
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HelloServlet.SessionTest(req);//外部函数

        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");

        DealForm(req,resp);

    }



    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        req.setCharacterEncoding("charset=UTF-8");//会导致错误，可能是表单的编码的原因

        //        统一转doGet
        this.doGet(req,resp);
    }

    @Override
    public void destroy() {
        try {
            JdbcUtl.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
