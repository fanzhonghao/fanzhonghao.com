import java.util.Scanner;//输入

public class Zhuanhuan{
  public static int ZhuanToTen(String num,int a){//num为数字，a为进制
    int result = 0;
    String subString;
    for (int i = 0;i < num.length();i++)
    {
      subString = num.substring(i,i+1);
      if (a == 16){
        if (subString >= "A" & subString <= "B"){

        }
      }
    }
  }

  public static void main(String[] args) {
    String num;
    int a,b;
    Scanner read = new Scanner(System.in);//得到用户输入的值
    System.out.println("输入三个整数：待转换的数据 要转换之前的进制 要转换后的进制");
    num = read.next();//输入字符串
    a = read.nextInt();//输入整型
    b = read.nextInt();//输入整型

  }
}
