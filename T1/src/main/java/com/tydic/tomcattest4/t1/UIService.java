package com.tydic.tomcattest4.t1;

import classes.UserInformation;
import com.alibaba.fastjson.JSONArray;
import jdbcutl.JdbcUtl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UIService {
    //成功1，失败0
    protected static int SingleCheckAndSave(List<UserInformation> arr){
        String userId = arr.get(0).getUserId();
        String userName = arr.get(0).getUserName();
        String age = arr.get(0).getAge();
        String address = arr.get(0).getAddress();
        String exInfo = arr.get(0).getExInf();

        ResultSet rs;
        String sql = "select * from tomcattest where userId ="+userId;
        try {
            rs = JdbcUtl.stmt.executeQuery(sql);
            if(rs.next()) {
                return 0;
            }else if(address==null|age==null|userName==null){
                return 0;
            }else{
                if(exInfo==null){
                    exInfo = "";
                }
                sql = "insert into tomcattest values (?,?,?,?,?)";
                PreparedStatement ps = JdbcUtl.conn.prepareStatement(sql);
                ps.setInt(1,Integer.parseInt(userId));
                ps.setString(2,userName);
                ps.setString(3,age);
                ps.setString(4,address);
                ps.setString(5,exInfo);
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 1;
    }
}
