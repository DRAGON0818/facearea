package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
/**
 * Hello world!
 */
public class App {
    private static Connection conn;
    private static PreparedStatement pst;
    public static final String user = "plmda1";
    public static final String pwd = "fotileplm#33";
    public static final String url = "jdbc:oracle:thin:@192.168.100.31:1521:pplmdb1";
    public static final String forName = "oracle.jdbc.driver.OracleDriver";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName(forName);
        conn = DriverManager.getConnection(url, user, pwd);
        conn.setAutoCommit(false);
        String sql = "update mpart set smemo='冻结' where del=0 and wkaid<>'3' and facearea='是'";
        pst = conn.prepareStatement(sql);
        int i=pst.executeUpdate();
        conn.commit();
        System.out.println(new Date()+" 共修改"+i+"条数据");
    }
}
