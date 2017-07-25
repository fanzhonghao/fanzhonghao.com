import java.util.Scanner;//判断润年
public class Leap{
  public static void main(String[] args) {
    System.out.println("Please enter the year which you want to judge: ");
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();//从控制台获取录入的信息
    if (str.length() != 4){//判断输入是否为合法的年份
      System.out.println("Please enter quadruolicity!!");
    }
    int year = Integer.parseInt(str);//将字符串转换为int型
    boolean flag1 = year % 400 == 0;
    boolean flag2 = (year % 4 == 0) && (year % 100 != 0);
    String message = (flag1 || flag2) ? "is leap" : "Not leap";
    System.out.println(year + " " + message);
  }
}
