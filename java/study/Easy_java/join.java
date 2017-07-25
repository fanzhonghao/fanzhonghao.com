public class join{
  public static void main(String[] args) {
    MatchMarry group1 = new MatchMarry("TOM","SUSAN");
    MatchMarry group2 = new MatchMarry("张三","李小红");
    MatchMarry group3 = new MatchMarry("安妮","罗伯特");
    MatchMarry group4 = new MatchMarry("TOM","安妮");
    MatchMarry group5 = new MatchMarry("SUSAN","张三");
    System.out.println("速配婚姻介绍所，宗旨是保证发扬\"携子之手 与子偕老\"的精神");
    group1.start();
    try{
      group1.join();//等待线程运行结束
    }catch(InterruptedException e){
      System.out.println("唤醒异常：" + e.getMessage());
    }
    group2.start();
    try {
      group2.join();
    }catch(InterruptedException e){
      System.out.println("唤醒异常：" + e.getMessage());
    }
    group3.start();
    try {
      group3.join();
    }catch(InterruptedException e){
      System.out.println("唤醒异常：" + e.getMessage());
    }
    group4.start();
    try {
      group4.join();
    }catch(InterruptedException e){
      System.out.println("唤醒异常：" + e.getMessage());
    }
    group5.start();
    try {
      group5.join();
    }catch(InterruptedException e){
      System.out.println("唤醒异常：" + e.getMessage());
    }
    System.out.println("速配结束！");
  }
}
class MatchMarry extends Thread{//测试速配类
  private String name;//人员名称
  private String otherName;//结婚对象
  private boolean isMarry = false;
  public MatchMarry(String name,String otherName){
    this.name = name;
    this.otherName = otherName;
  }
  public void run(){
    try{
      int person = (int) Math.floor(Math.random() * 10 + 1);
      if(person % 2 == 0){
        isMarry = true;
      }else{
        isMarry = false;
      }
      if(!isMarry){
        System.out.println(name + "可以与" + otherName + "结婚，祝福你们");
      }else {
        System.out.println(otherName + "已婚，红色警告，对待婚姻不要有二心");
      }
      Thread.sleep(200);
    }catch(InterruptedException e){
      System.out.println("唤醒异常：" + e.getMessage());
    }
  }
}
