/* ---------------------------
 *  Author:fan
 *  Date:2017.7.17
 * ---------------------------
 *  Description:
 *    This code is used to
 *  descript the easy factory
 *  pattern.
 * ---------------------------
 *  Attention:
 *    This pattern is just
 *  used to create a interface.
 * ----------------------------
 */
public class easy_factory_pattern{
  public static void main(String[] args) {
    try{
      Person person = Recruitment.findWork("Middle_Programmer");
      System.out.println("请谈谈自己的工作经历。");
      person.experience();
    }catch(Exception e){
      System.out.println("招聘工作出现问题");
    }finally{
      System.out.println("......");
    }
  }
}
class Recruitment{
  public static Person findWork(String s) throws Exception{
    if(s.equalsIgnoreCase("Low_Programmer")){
      //判断传入参数返回不同的实现类
      return new Low_Programmer();
    }else if(s.equalsIgnoreCase("Middle_Programmer")){
      return new Middle_Programmer();
    }else if(s.equalsIgnoreCase("High_Programmer")){
      return new High_Programmer();
    }else {
      throw new Exception();
    }
  }
}
interface Person{
  public void experience();
}
class Low_Programmer implements Person{
  public void experience(){
    System.out.println("我刚走出大学校们，目前只有不到一年的工作经验！");
  }
}
class Middle_Programmer implements Person{
  public void experience(){
    System.out.println("我已经毕业一年多了，目前有两年多的工作经验！");
  }
}
class High_Programmer implements Person{
  public void experience(){
    System.out.println("我已经毕业很多年了，目前有五年多的工作经验！");
  }
}
