/* -------------------------------
 *  Author:fan
 *  Date:2017.7.17
 * -------------------------------
 *  Description:
 *    This code is use to realize
 *  the singleton pattern.
 * -------------------------------
 */
public class singleton_pattern{
  public static void main(String[] args) {
    Singleton object1 = Singleton.getSingleton();//调用方法获得实例
    Singleton object2 = Singleton.getSingleton();
    System.out.println("用Singleton类实现单例模式的实例如下：");
    System.out.println("调用next()方法前：");
    System.out.println("object1.amount = " + object1.getAmount());
    System.out.println("object2.amount = " + object2.getAmount());
    object1.next();//调用方法
    System.out.println("\n调用next()方法后：");
    System.out.println("object1.amount = " + object1.getAmount());
    System.out.println("object2.amount = " + object2.getAmount());
  }
}
class Singleton{
  private static int amount = 5;
  private static Singleton singleton = new Singleton();//Singleton的唯一实例
  private Singleton(){//创建private私有构造函数的目的是为防止外界构造

  }
  public static Singleton getSingleton(){
    return singleton;//获取Singleton实例
  }
  public synchronized int getAmount(){
    //synchronized关键字表示方法是线程同步
    return amount;//在任一时刻最多只能有一个线程进入该方法
  }
  public synchronized void next(){
    amount++;
  }
}
