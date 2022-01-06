package com.tydic.tomcattest4.t1;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;


import classes.UserInformation;
import com.alibaba.fastjson.JSONArray;
import jdbcutl.JdbcUtl;

//@WebServlet(name = "ReceiveInform",value = "/receive-inform")
public class ReceiveInform extends HttpServlet {
    @Override
    public void init(){
        JdbcUtl.ConnectTomcattest();
    }
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //        统一转doPost
        this.doPost(req,resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");

        DealJson(req,resp);
//        req.getParameter("")
    }

    @Override
    public void destroy() {
        try {
            JdbcUtl.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //接收json
    public static int DealJson(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        StringBuilder stringbuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            stringbuilder.append(line);
            System.out.println(line);
        }
        reader.close();

        PrintWriter out = resp.getWriter();
        JSONArray JsonList = new JSONArray();
        //目前只能处理单体目标，多个目标需要循环和逗号，其次此方法中“[]”似乎不允许省略
        String InputString = "["+stringbuilder.toString()+"]";
//        System.out.println(InputString);
        JsonList=JSONArray.parseArray(InputString);
        List<UserInformation> arr = JSONArray.parseArray(InputString, UserInformation.class);

        if(UIService.SingleCheckAndSave(arr)==1){
            out.println("Succeed");
        }else{
            out.println("Fail");
        }
        out.close();

        return 1;
    }
}
