/* -------------------------------
 *  Author:fan
 *  Date:2017.7.19
 * -------------------------------
 *  Description:
 *    This code is used to record
 *  the time of the code execute.
 * -------------------------------
 *  Attention:
 *    currentTimeMillis()是以毫秒为
 *  单位获取计算机上的时间，返回long型，
 *  记录的是当前时间与1970年1月1日0时之
 *  间的时间差。
 * -------------------------------
 */
public class record_time{
  public static void main(String[] args) {
    try{
      long start = System.currentTimeMillis();//记录程序开始执行时间
      System.out.println("开始执行时间为：" + start);
      Thread.sleep(3000);//休眠3000ms,该处必须报告异常并捕获或声明以便抛出
      long end = System.currentTimeMillis();//记录程序结束时间
      System.out.println("结束执行时间为：" + end);
      System.out.println("共执行了：" + (end - start) + "毫秒");
    } catch (InterruptedException e1){
      e1.printStackTrace();
    }
  }
}
