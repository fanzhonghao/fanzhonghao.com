import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class jdbc_test{
  public static void main(String[] args) {
    Connection con;
    try {
        Class.forName("com.mysql.jdbc.Driver");//加载驱动器
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","@asd5211314");//连接本地数据库
        if (con != null)System.out.println("连接成功");
      }catch (Exception e) {
        e.printStackTrace();
        System.out.println("连接失败");
      }
  }
}
