package com.tydic.tomcattest4.t1;

import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public static int AddCookies(HttpServletResponse response) throws UnsupportedEncodingException {
        Cookie T1 = new Cookie("T1", URLEncoder.encode("Test1","UTF-8"));
        Cookie T2 = new Cookie("T2", URLEncoder.encode("Test2","UTF-8"));

        T1.setMaxAge(60*5);
        T2.setMaxAge(60*5);

        T1.setDomain("localhost");//不用"."
        T2.setDomain("localhost");
        response.addCookie(T1);
        response.addCookie(T2);
        return 1;
    }

    public static int SessionTest(HttpServletRequest request){

        HttpSession session = request.getSession(true);//创建 or 获取
        System.out.println(session);
        Date createTime = new Date(session.getCreationTime());
        Date lastAccessTime = new Date(session.getLastAccessedTime());

        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(createTime);
        System.out.println(lastAccessTime);

        Integer visitCount = new Integer(0);
        String visitCountKey = new String("visitCount");
        String userNameKey = new String("userName");
        String userName = new String("czh");

        if (session.isNew()){
            session.setAttribute(userNameKey,userName);
        }else{
            visitCount = (Integer) session.getAttribute(visitCountKey);
            //这个位置可能存在问题，从首页（index.jsp）进入会导致visitCount是空指针（可能首页已经生成了一个session）
            if(visitCount==null){
                visitCount = 0;
            }else{
                visitCount=visitCount+1;
            }

            session.setAttribute(userNameKey,userName);
        }
        session.setAttribute(visitCountKey,visitCount);
        System.out.println(visitCount);
        return 1;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SessionTest(request);//不能从首页访问？？

        response.setContentType("text/html;charset=UTF-8");
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}