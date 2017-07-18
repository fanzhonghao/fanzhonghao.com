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
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class getSystemTime{
  public static void main(String[] args) {
    getSystemTime.date_Format();
    getSystemTime.GregorianCalendar_Format();
    getSystemTime.Simple_Format();
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
  public static void GregorianCalendar_Format(){
    System.out.println();
    System.out.println("GregorianCalendar_Format类获取日历的使用示例如下：");
    DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);
    //创建一个GregorianCalendar_Format日历对象
    GregorianCalendar gc = new GregorianCalendar();
    gc.setTime(new Date());//将日历系统的时间和日期设置给gc
    System.out.println("今日是：" + df.format(gc.getTime()));
    //将Day_OF_WEEK的值设置为Monday
    gc.set(GregorianCalendar.DAY_OF_WEEK,GregorianCalendar.MONDAY);
    System.out.println("在本周内，星期一的日期为：" + df.format(gc.getTime()));
    int count = 0;
    System.out.println("寻找5个9号为星期一的日期：");
    while(count < 5){
      gc.add(GregorianCalendar.DAY_OF_MONTH,7);//设置7天为一个周期
      if (gc.get(GregorianCalendar.DAY_OF_MONTH) == 9){
        count++;
        System.out.println(df.format(gc.getTime()));
      }
    }
    GregorianCalendar call = new GregorianCalendar();
    call.set(GregorianCalendar.DAY_OF_MONTH,GregorianCalendar.FRIDAY);
    count = 0;
    System.out.println("在本年的12月份中，是星期四的日历如下：");
    while(count < 4){
      call.add(GregorianCalendar.DAY_OF_YEAR,7);
      if(call.get(GregorianCalendar.MONTH) == 11){
        count++;
        System.out.println(df.format(call.getTime()));
      }
    }
  }

  public static void Simple_Format(){
    System.out.println();
    System.out.println("SimpleDateFormat类获取系统当前的时间如下：");
    //创建一个日期格式化，日期的形式为yyyy.mm.dd G 'at' HH:mm:ss z
    SimpleDateFormat bartDateFormat = new SimpleDateFormat("EEEE-MMMM-dd-yyyy");
    //创建一个日期格式化，日期的形式为yyyy.MM.dd G 'at' HH:mm:ss z
    SimpleDateFormat b = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
    //创建一个日期个格式化，日期的形式为EEE,MMM d, ''yy
    SimpleDateFormat b1 = new SimpleDateFormat("EEE, MMM d, ''yy");
    //创建一个日期格式化，日期的形式为h:mm a
    SimpleDateFormat b2 = new SimpleDateFormat("h:mm a");
    //创建一个日期格式化，日期的形式为EEE, d MMM yyyy HH:mm:ss Z
    SimpleDateFormat b3 = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
    //创建一个日期格式化，日期的形式为yyMMddHHmmssZ
    SimpleDateFormat b4 = new SimpleDateFormat("yyMMddHHmmssZ");
    Date date = new Date();
    System.out.println("第一种表现形式：" + bartDateFormat.format(date));
    System.out.println("第二种表现形式：" + b.format(date));
    System.out.println("第三种表现形式：" + b1.format(date));
    System.out.println("第四种表现形式：" + b2.format(date));
    System.out.println("第五种表现形式：" + b3.format(date));
    System.out.println("第六种表现形式：" + b4.format(date));
  }

}
