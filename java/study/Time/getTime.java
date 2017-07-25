/* -----------------------------
 *  Author:fan
 *  Date:2017.7.18
 * -----------------------------
 *  Description:
 *    This code is used to get
 *  the time after 1970.01.01
 *  and the unit of it is
 *  millisecond.
 * -----------------------------
 */
import java.util.Date;
public class getTime{
  public static void main(String[] args) {
    Date date = new Date();
    //调用Date类的getTime()方法
    System.out.println("距1970年1月1日00:00:00时间已经过了" + date.getTime() + "毫秒");
    //Date类的toGMTString()方法，该方法已过时
    //System.out.println("当前时间：" + date.toGMTString());
  }
}
