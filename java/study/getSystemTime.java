/* -------------------------
 *  Author:fan
 *  Date:2017.7.18
 * -------------------------
 *  Description:
 *    This code is used to
 *  get the current System
 *  time.
 * -------------------------
 */ 
import java.util.Date;
import java.text.DateFormat;
public class getSystemTime{
  public static void main(String[] args) {
    getSystemTime.date_Format();
  }
  public static void date_Format(){
    System.out.println("使用date_Formate类获取系统日期的示例如下：");
    Date date = new Date();
    DateFormat shortDateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.SHORT);
    DateFormat mediumDateFormat = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM);
    DateFormat longDateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG);
    DateFormat fullDateFormat = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL);
    System.out.println("采用SHORT模式表示的日期为：" + shortDateFormat.format(date));
    System.out.println("采用MEDIUM模式表示的日期为：" + mediumDateFormat.format(date));
    System.out.println("采用LONG模式表示的日期为：" + longDateFormat.format(date));
    System.out.println("采用FULL模式表示的日期为：" + fullDateFormat.format(date));
  }
}
