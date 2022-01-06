package jdbcutl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class JdbcUtl {

    public static Connection conn;
    public static Statement stmt;
    public static int ConnectTomcattest(){
        String schema_name = "com.tydic";
        String user = "czh";
        String password = "231017";
        String url = "jdbc:mysql://localhost:3306/"+schema_name+"?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC&characterEncoding=utf-8";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//1.加载驱动
            conn = DriverManager.getConnection(url,user,password);//2.获得数据库连接
            stmt = conn.createStatement();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
