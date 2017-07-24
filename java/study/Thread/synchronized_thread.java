/* ----------------------------------
 *  Author:fan
 *  Date:2017.7.24
 * ----------------------------------
 *  Description:
 *    This code is used to explore
 *  the use of synchronized()
 *  function.
 * ----------------------------------
 */
import java.lang.Thread;
public class synchronized_thread{
  public static void main(String[] args) {
    SyncThred t1 = new SyncThred();
    new Thread(t1,"线程1").start();//创建线程并启动它
    new Thread(t1,"线程2").start();
    System.out.println(t1.Perform());
  }
}
class SyncThred implements Runnable{
  private int x = 5;
  private int y = 5;
  public synchronized void run(){//定义SyncThred的同步方法
    for(int i = 0;i < 4;i++){
      x++;
      y++;
      try{
        Thread.sleep(200);
      }catch(InterruptedException e){
        System.out.println("线程出错");
      }
      System.out.println(Thread.currentThread().getName() + "x = " + x + ",y = " + y);
    }
  }
  public synchronized String Perform(){
    String name = Thread.currentThread().getName();
    return "当前正在运行的线程：" + name;
  }
}
