/* ---------------------------------
 *  Author:fan
 *  Date:2017.7.19
 * ---------------------------------
 *  Description:
 *    This code is used to describe
 *  how to start thread.
 * ---------------------------------
 */
import java.lang.Thread;
//import java.lang.Runnable;
import java.util.Date;
public class mulThread{
  public void startY(){
    ThreadY ty = new ThreadY();//创建实例
    ty.startThreadY();//启动线程
    try{
      Thread.sleep(1000);//休眠1秒
    }catch(InterruptedException e){
      e.printStackTrace();
    }
    ty.stopThreadY();
  }
  public void startX(){//开始第二个
    Runnable runnX = new ThreadX();
    Thread threadX = new Thread(runnX);//将实例放入线程
    threadX.start();//启动线程
  }
  public static void main(String[] args) {
    mulThread test = new mulThread();
    test.startY();
    test.startX();
  }
}
class ThreadY extends Thread{//继承java.lang.Thread类定义线程
  private boolean isRunState = false;//标记线程是否需要运行
  public void start(){
    this.isRunState = true;//表示线程需要运行
    super.start();
  }
  public void run(){
    int i = 0;
    try{
      while(isRunState){
        this.setName("Thread-" + i++);
        System.out.println("线程Y：" + this.getName() + "正在运行");
        Thread.sleep(200);
      }
    }catch(Exception e){

    }
    System.out.println(this.getName() + "运行结束");
  }
  public void setRunning(boolean isRunState){
    this.isRunState = isRunState;
  }
  public void startThreadY(){
    System.out.println("启动线程Y");
    this.start();
  }
  public void stopThreadY(){
    System.out.println("结束线程Y");
    this.setRunning(false);
  }
}
class ThreadX implements Runnable{//实现java.lang.Runnable接口定义线程
  private Date runDate;
  public void run(){
    System.out.println("线程X已经启动");
    this.runDate = new Date();
    System.out.println("启动时间：" + runDate.toLocaleString());
  }
}
