/* -----------------------------------
 *  Author:fan
 *  Date:2017.7.23
 * -----------------------------------
 *  Description:
 *    This code is used to explore the
 *  use of yield(). When we call this
 *  function we make the thread yield
 *  which means the yield() function
 *  force the current thread come to
 *  an end and only we use start()
 *  function can we awake the thread.
 * -----------------------------------
 */ 
import java.util.Date;
import java.text.DateFormat;
import java.util.Formatter;
import java.lang.Thread;
import java.util.Vector;
import java.text.SimpleDateFormat;
public class Thread_concession{//操作线程让步的类
  private Vector vector = new Vector();
  private DateFormat dateFormat = new SimpleDateFormat("HH-mm-ss:SSSS");
  private boolean isFlag = false;
  private class Yield extends Thread{
    public Yield(){
      this.setName("接收文件");//设置线程名称
      this.setDaemon(true);//如果SendFile线程结束，则该线程自动结束
    }
    public void run(){
      while(!isFlag){
        try{
          Thread.sleep(100);
        }catch(InterruptedException e){
          System.out.println("唤醒异常：" + e.getMessage());
        }
        if(vector.size() == 0){
          System.out.println(dateFormat.format(new Date()) + "\t向量集合中没有文件，执行yield操作");
          Thread.yield();//调用线程让步
        }else{
          String ss = (String) vector.remove(0);
          System.out.println(dateFormat.format(new Date()) + "\t取到文件，名为" + ss);
        }
      }
    }
  }
  private class SendFile extends Thread{//发送文件类
    private String[] files = new String[] {"新闻文件","国内旅游向导","山水名画欣赏","发家致富说明"};
    public SendFile(){
      this.setName("发送文件");
    }
    public void run(){
      try{
        for(int i = 0;i < files.length;i++){//循环使线程休眠
          Thread.sleep(201);
          vector.add(files[i]);//添加文件
        }
        Thread.sleep(100);
      }catch(InterruptedException e){
        System.out.println("唤醒异常：" + e.getMessage());
      }
    }
  }
  public static void main(String[] args) {
    Thread_concession text = new Thread_concession();
    text.new Yield().start();
    text.new SendFile().start();
  }
}
