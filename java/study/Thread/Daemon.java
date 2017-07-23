/* ----------------------------------
 *  Author:fan
 *  Date:2017.7.23
 * ----------------------------------
 *  Description:
 *    This code is used to explore
 *  the use of daemon, any thread can
 *  be test whether it is a daemon by
 *  isDaemon() function which is in
 *  Thread class. We use setDaemon()
 *  to set daemon when the parameter
 *  is true. And the setDaemon()
 *  function must be executed before
 *  the thread be executed.
 * ----------------------------------
 *  Attention:
 *    Any subclass which is inherited
 *  from Thread, the run() function
 *  must be realize.
 * ----------------------------------
 */ 
import java.lang.Thread;
public class Daemon{
  public static void main(String[] args) {
    Defensor defensor = new Defensor();//默认情况下，父类Defensor为普通线程
    defensor.start();
    try{
      Thread.sleep(500);
    }catch(InterruptedException e){
      System.out.println("唤醒异常：" + e.getMessage());
    }
  }
}
class Defensor extends Thread{
  public void run(){
    System.out.print("当霸天虎在袭击地球的危难关头，守护神是否采取自我保护？");
    System.out.println(this.isDaemon() ? "是" : "没有");//测试该线程是否为守护线程
    System.out.println("守护神是机器卫兵的组合，个性善良");
    Human people = new Human();
    //设置守护线程，在本程序中将其子类people设置为守护线程，即被保护对象
    people.setDaemon(true);//设置为守护线程
    people.start();
    try{
      Thread.sleep(1000);
    }catch(InterruptedException e){
      System.out.println("唤醒异常：" + e.getMessage());
    }finally{
      System.out.println("守护神舍身捍卫地球，保护人类安全");
    }
    System.out.println("守护神。。。");
  }
}
class Human extends Thread{
  public void run(){
    System.out.print("人类安全是否被保护？");
    System.out.println(this.isDaemon() ? "是" : "没有");
    System.out.println("现有5处场所人类处于危险中！");
    int i = 0;
    try{
      while(i < 5){
        System.out.println("第" + (1 + i++) + "处场所的人类");
        Thread.sleep(200);
      }
    }catch(InterruptedException e){
      System.out.println("唤醒异常：" + e.getMessage());
    }finally{
      System.out.println("守护神尽心尽力");
    }
    System.out.println("终于脱离危险");
  }
}
