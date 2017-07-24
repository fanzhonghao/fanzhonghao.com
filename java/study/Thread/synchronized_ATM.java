/* -------------------------------
 *  Author:fan
 *  Date:2017.7.24
 * -------------------------------
 *  Description:
 *    This code is descript the
 *  use of synchronized which can
 *  decorate the function that
 *  when the code executes to the
 *  locked function no matter When
 *  it just allow one thread call.
 * -------------------------------
 */
import java.lang.Thread;
public class synchronized_ATM{
  public static void main(String[] args) {
    Bank bank = new Bank();
    SyncBank sbank = new SyncBank();
    System.out.println("1.存、取线程没有采取同步时，执行存取操作时，其工作流程如下：");
    //存钱没有采取同步机制
    Thread putThread = new CashMachines(bank,"saveMoney");
    //取钱没有采取同步机制
    Thread takeThread = new CashMachines(bank,"withdrawMoney");
    putThread.start();
    takeThread.start();
    try{
      putThread.join();//等待两线程运行结束
      takeThread.join();
    }catch(Exception e){
      System.out.println("两线程运行出错：" + e.getMessage());
    }
    System.out.println();
    bank = new Bank();
    System.out.println("2.存、取线程设置同步时，执行存取操作时，其工作流程如下：");
    //创建CashMachines对象，存钱有同步机制
    putThread = new CashMachines(sbank,"sync_SaveMony");
    takeThread = new CashMachines(sbank,"sync_WithdrawMony");
    //取钱有同步机制
    putThread.start();
    takeThread.start();
  }
}
class Bank {
  private double curveMoney = 174.85;//存入银行钱数
  public void saveMoney(double putThread){//存钱没有采取同步机制
    System.out.println("当前账户中余额为：" + this.curveMoney + ";存入金额为：" + putThread);
    System.out.println("正在操作，请稍后...");
    try{
      Thread.sleep(300);
    }catch(Exception e){
      e.printStackTrace();
    }
    System.out.println("操作成功，存入金额：" + putThread);
    this.curveMoney = this.curveMoney + putThread;
    System.out.println("当前余额为： " + this.curveMoney + "元");
  }
  public void withdrawMoney(double takeThread){//取钱没有同步机制
    System.out.println("查询余额显示，当前可用余额为：" + this.curveMoney + "；取出金额为：" + takeThread);
    System.out.println("正在操作，请稍后...");
    try{
      Thread.sleep(500);
    }catch(Exception e){
      e.printStackTrace();
    }
    System.out.println("操作成功，取出金额：" + takeThread);
    this.curveMoney = this.curveMoney - takeThread;
    System.out.println("当前余额为：" + this.curveMoney + "元");
  }
}
class SyncBank{
  private double curveMoney = 174.85;
  public synchronized void sync_SaveMony(double putThread){
    System.out.println("当前账户所剩余额为： " + this.curveMoney + ";存入金额为：" + putThread);
    System.out.println("正在操作，请稍后...");
    try{
      Thread.sleep(300);
    }catch(Exception e){
      e.printStackTrace();
    }
    System.out.println("操作成功，存入金额：" + putThread);
    this.curveMoney = this.curveMoney + putThread;
    System.out.println("当前余额为： " +this.curveMoney + "元");
  }
  public synchronized void sync_WithdrawMony(double takeThread){
    System.out.println("查询余额显示，当前可用余额为：" + this.curveMoney + "；取出金额为：" + takeThread);
    System.out.println("正在操作，请稍后...");
    try{
      Thread.sleep(500);
    }catch(Exception e){
      e.printStackTrace();
    }
    System.out.println("操作成功，取出金额：" + takeThread);
    this.curveMoney = this.curveMoney - takeThread;
    System.out.println("当前余额为：" + this.curveMoney + "元");
  }
}
class CashMachines extends Thread{
  private Bank bank = null;//待访问的帐号对象
  private SyncBank sbank = null;//待访问的帐号对象
  private String account = "";//访问帐号的方法
  public CashMachines(Bank bank,String account){
    this.account = account;
    this.bank = bank;
  }
  public CashMachines(SyncBank sbank,String account){
    this.account = account;
    this.sbank = sbank;
  }
  public void run(){
    if(account.equals("saveMoney")){
      bank.saveMoney(800.0);
    }else if(account.equals("withdrawMoney")){
      bank.withdrawMoney(300.0);
    }else if(account.equals("sync_SaveMony")){
      sbank.sync_SaveMony(800.0);
    }else if(account.equals("sync_WithdrawMony")){
      sbank.sync_WithdrawMony(300.0);
    }
  }
}
