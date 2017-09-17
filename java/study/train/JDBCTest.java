import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Author:fan
 * Date: 17-9-15
 * Time: 下午9:56
 * Description:
 *      This program use jdbc
 * to connect the mysql database.
 */
public class JDBCTest {
    public static void main(String[] args) {
        Connection con;
        try {
            Class.forName("com.mysql.jdbc.Driver");//加载驱动器
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school_roll","root","@asd5211314");//连接本地数据库
            if (con != null)System.out.println("与DBeaver CE连接成功");
            List list = new ArrayList();
            String[] tableType = {"TABLE"};//指定要进行查询的表类型
            DatabaseMetaData databaseMetaData = con.getMetaData();//调用与数据库建立连接方法
            ResultSet resultSet = databaseMetaData.getTables(null,null,"%",tableType);//获取DatabaseMetaData实例

            while (resultSet.next()){//获取数据库中所有数据表集合
                list.add(resultSet.getString("TABLE_NAME"));
            }
            System.out.println("数据库中表的信息");
            System.out.println(list);
            list.clear();
            System.out.println("查询之前的list");
            System.out.println(list);
            System.out.println("查询之后的list,数据库中表的信息");

            String sql = "show tables;";//查询的sql语句
            try {
                Statement statement = con.createStatement();//实例化Statement对象
                ResultSet rs = statement.executeQuery(sql);//执行sql语句
                while (rs.next()){
                    list.add(rs.getString(1));
                }
                System.out.println(list);
                list.clear();
            }catch (Exception e){
                e.printStackTrace();
            }

            System.out.println("查询class表");
            sql = "select * from class;";
            try {
                Statement statement = con.createStatement();
                ResultSet rs = statement.executeQuery(sql);
                while (rs.next()){
                    list.add(rs.getString(1));
                    list.add(rs.getString(2));
                }
                for (int i = 0;i < list.size();i++){
                    System.out.print(list.get(i) + " ");
                    if ((i+1) % 2 == 0) System.out.println();
                }
                list.clear();
            }catch (Exception e){
                e.printStackTrace();
            }

            sql = "CREATE TABLE Test" +
                    "(name CHAR(10));";
            try {
                Statement statement = con.createStatement();
                statement.executeUpdate(sql);

                sql = "show tables;";
                ResultSet rs = statement.executeQuery(sql);
                while (rs.next()){
                    list.add(rs.getString(1));
                }
                System.out.println("创建Test表后数据库中的表：");
                System.out.println(list);
                list.clear();
            }catch (Exception e){
                e.printStackTrace();
            }

            sql = "drop table Test;";
            try {
                Statement statement = con.createStatement();
                statement.executeUpdate(sql);
                sql = "show tables;";
                ResultSet rs = statement.executeQuery(sql);
                while (rs.next()){
                    list.add(rs.getString(1));
                }
                System.out.println("执行删除后数据库中的表");
                System.out.println(list);
                list.clear();
            }catch (Exception e){
                e.printStackTrace();
            }

            con.close();//断开与数据库的连接
            System.out.println("断开连接");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("连接失败");
        }finally {

        }
    }
}
