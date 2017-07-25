/* --------------------------------
 *  Author:fan
 *  Date:2017.7.19
 * --------------------------------
 *  Description:
 *    This code is used to describe
 *  the deal between seller and
 *  buyer.
 * --------------------------------
 *  Attention:
 *    We use wait() makes the
 *  thread be waiting and use
 *  notify() to awake it.
 * --------------------------------
 */
import java.util.Random;
import java.lang.Thread;
public class productAndConsumption{
  public static void main(String[] args) {
    Alipay alipay = new Alipay(2);//创建两个支付宝类
    //创建并启动线程
    new Seller("卖家-一抹红",alipay,5).start();
    new Seller("卖家-小不不",alipay,7).start();
    new Buyer("买家-淘之妖妖",alipay,101).start();
    new Buyer("买家-相信美丽",alipay,102).start();
  }
}
class Alipay{//支付宝，用于网上买卖交易
  private final String[] deal;
  private int n;//标识存入支付宝的交易数量
  private int m;//标识支出支付宝的交易数量
  private int count;//缓存内的交易数量
  public Alipay(int count){
    this.deal = new String[count];
    this.m = 0;
    this.n = 0;
    this.count = 0;
  }
  public synchronized void storage(String alipay){//往支付宝中存款
    System.out.println("淘宝用户 ID=" + Thread.currentThread().getName() + "\t支付宝存入" + alipay);
    try{
      while(count >= deal.length){
        wait();//线程等待
      }
      deal[n] = alipay;//放置支付宝帐号于数组
      n = (n+1) % deal.length;
      count++;
      notifyAll();//通知所有等待该对象的线程
    }catch(Exception e){
      System.out.println("支付宝存入功能出现错误：" + e.getMessage());
    }
  }
  public synchronized String outlay(){//从支付宝支出
    String alipay = null;
    try{
      while(count <= 0){
        wait();
      }
      alipay = deal[m];//取出指定的支付宝帐号
      m = (m+1) % deal.length;
      count--;
      notifyAll();
    }catch(Exception e){
      System.out.println("支付宝支付功能出现错误：" + e.getMessage());
    }
    System.out.println("淘宝用户 ID=" + Thread.currentThread().getName() + "\t支付宝支出" + alipay);
    return alipay;
  }
}
class Buyer extends Thread{//买家线程
  private final Random random;
  private final Alipay alipay;
  private static int id = 0;//交易的流水号
  public Buyer(String name,Alipay alipay,long seed){
    super(name);
    this.alipay = alipay;
    this.random = new Random(seed);
  }
  public void run(){
    try{
      while(true){
        Thread.sleep(random.nextInt(1000));//随机休眠
        String flowerID = "交易流水帐号：" + nextId();
        alipay.storage(flowerID);
      }
      }catch(Exception e){
    }
  }
  private static synchronized int nextId(){
    return id++;
  }
}
class Seller extends Thread{//卖家线程
  private final Random random;
  private final Alipay alipay;
  public Seller(String name,Alipay alipay,long seed){
    super(name);
    this.alipay = alipay;
    this.random = new Random(seed);
  }
  public void run(){//实现Thread类的方法，启动线程
    try{
      while(true){
        String alipay = this.alipay.outlay();
        Thread.sleep(random.nextInt(1000));
      }
    }catch(Exception e){
      System.out.println("买家支付预付款出错：" + e.getMessage());
    }
  }
}
