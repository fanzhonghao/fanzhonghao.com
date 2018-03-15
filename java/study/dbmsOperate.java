import java.sql.*;
import java.util.Date;

/**
 * ----------------------
 *
 * @Author:fan
 * @Date: 18-3-15
 * Description:
 * <p>
 * -----------------------
 */
public class dbmsOperate {
    private String address;
    private String name;
    private String pasword;

    public dbmsOperate(){
        address = "jdbc:mysql://localhost:3306/chatRoomInfo";
        name = "fan";
        pasword = "@asd5211314";
    }
    public void insertData(){
        new Thread(new insert()).start();
    }
    public void printData(){
        new Thread(new output()).start();
    }
    class insert implements Runnable {
        @Override
        public void run() {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(address,name,pasword);
                if (con == null) {
                    System.out.println("数据库连接失败");
                    System.exit(-1);
                }
                Date date = new Date();
                String sql2 = "insert into info(time,data) values(?,?)";
                PreparedStatement preparedStatement;
                int i = 0;
                while (true){
                    preparedStatement = con.prepareStatement(sql2);
                    preparedStatement.setLong(1,date.getTime());
                    preparedStatement.setString(2,"test" + i);
                    preparedStatement.executeUpdate();
                    System.out.println("i = " + i++);
                    Thread.sleep(2000);
                }

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e){
                e.printStackTrace();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    class output implements Runnable{
        @Override
        public void run() {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(address,name,pasword);
                if (con == null) {
                    System.out.println("数据库连接失败");
                    System.exit(-1);
                }
                Date date = new Date();
                long time = date.getTime();
                String sql = "select data from info where time > ?";
                PreparedStatement preparedStatement;
                ResultSet resultSet;
                while (true){
//                    System.out.println("out");
                    preparedStatement = con.prepareStatement(sql);
                    preparedStatement.setLong(1,time);
                    resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()){
                        System.out.println("result: " + resultSet.getString(1));
                    }
                    Thread.sleep(2000);
                }


            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e){
                e.printStackTrace();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        dbmsOperate dbmsOperate = new dbmsOperate();
        dbmsOperate.insertData();
        dbmsOperate.printData();
    }
}

