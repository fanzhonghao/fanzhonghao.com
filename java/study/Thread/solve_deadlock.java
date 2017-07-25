import java.lang.Thread;
public class solve_deadlock{
  static String[] keys = new String[] {"第1把钥匙","第2把钥匙"};
  static class DoorKey1 extends Thread{//静态内部类
    public void run(){
      synchronized (keys[0]){//在同一时间只能有一个类访问
        System.out.println("我拿起了" + keys[0] + "，在等着朋友用" + keys[1] + "开防盗门");
        try{
          Thread.sleep(100);
        }catch(Exception e){
          System.out.println("线程休眠出错：" + e.getMessage());
        }
        synchronized (keys[1]){
          System.out.println("我又拿出来" + keys[1] + "打开了防盗门");
        }
      }
    }
  }
  static class DoorKey2 extends Thread{
    public void run(){
      synchronized (keys[0]){
        System.out.println("\n朋友拿出了" + keys[0] + "，在等待我用" + keys[1] + "开防盗门");
        try{
          Thread.sleep(100);
        }catch(Exception e){
          System.out.println("线程休眠出错：" + e.getMessage());
        }
        synchronized (keys[1]){
          System.out.println("朋友又拿出了" + keys[1] + "打开了防盗门");
        }
      }
    }
  }
  static class GoWrong extends Thread{//静态守护线程类
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
        System.out.println("守护线程：程序正在运行......");
      }
    }
  }
  public static void main(String[] args) {
    DoorKey1 one = new DoorKey1();
    DoorKey2 two = new DoorKey2();
    GoWrong daemon = new GoWrong();
    one.start();
    two.start();
    daemon.start();
  }
}
