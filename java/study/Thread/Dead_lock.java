/* ------------------------------
 *  Author:fan
 *  Date:2017.7.25
 * ------------------------------
 *  Description:
 *    This code is used to
 *  explore the dead lock.
 *    When the system's resource
 *  is limit, it may fight for it
 *  that becomes dead lock.
 *    run()'s synchronized() is
 *  synchronized block.
 * ------------------------------
 */
import java.lang.Thread;
public class Dead_lock{
  static String[] keys = new String[] {"第1把钥匙","第2把钥匙"};
  static class DoorKey1 extends Thread{//第一把钥匙 静态内部类
    public void run(){
      synchronized  (keys[0]){//在同一时间只能有一个类访问
        System.out.println("我拿起了" + keys[0] + "开门，却打不开，准备一下" + keys[1]);
        try{
          Thread.sleep(100);
        }catch (Exception e) {
          System.out.println("线程休眠出错：" + e.getMessage());
        }
        synchronized (keys[1]){
          System.out.println("于是，我又拿起了" + keys[1]);
        }
      }
    }
  }
  static class DoorKey2 extends Thread{//第二把钥匙 静态内部类
    public void run(){
      synchronized (keys[1]){
        System.out.println("这时，朋友拿出了" + keys[1] + "，在等待" + keys[0] + "拔出来");
        try{
          Thread.sleep(100);
        }catch(Exception e){
          System.out.println("线程休眠出错：" + e.getMessage());
        }
        synchronized (keys[0]){
          System.out.println("朋友拿起了" + keys[1]);
        }
      }
    }
  }
  static class GoWrong extends Thread{
    public GoWrong(){
      this.setDaemon(true);
    }
    public void run(){
      while (true){
        try{
          Thread.sleep(1000);
        }catch(Exception e){
          System.out.println("线程休眠出错：" + e.getMessage());
        }
        System.out.println("守护线程：钥匙在锁里，却拔不出来");
      }
    }
  }
  public static void main(String[] args) {
    DoorKey1 one = new DoorKey1();
    DoorKey2 two = new DoorKey2();
    GoWrong wrong = new GoWrong();
    one.start();
    two.start();
    wrong.start();
  }
}
