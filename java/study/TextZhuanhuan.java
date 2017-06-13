import java.util.Scanner;
public class TextZhuanhuan{//定义一个进制转换类
  public static int ZhuanToTen(int a, String str){//其它进制转换为十进制
    double d = 0;
    String subString;
    for (int i = 0; i < str.length(); i++)
    {
      subString = str.substring(i, i+1);
      if (a == 16){
        subString = sixteenToNumber(subString);
      }
      d += Integer.parseInt(subString) * Math.pow(a,str.length() - i -1);
    }
    return (int) d;
  }
  public static String TenToNumber(int a,String str){//十进制转换成其它进制
    int current = Integer.parseInt(str);
    String opResult = "";
    if (a == 16)
    {
      while (current >= a)
      {//判断输入的数是否大于16,大于则进一
        opResult += sixteenNumberToChar(current % a);
        current /= a;
      }
      if (current != 0)
        opResult += sixteenNumberToChar(current);
    }else{
      while (current >= a){
        opResult += current % a;
        current /= a;
      }
      if (current != 0)
        opResult += current;
    }
    String riResult = "";//倒序二进制字符串
    for (int i = opResult.length() - 1;i >= 0;i--)
    {
      riResult = riResult + opResult.substring(i,i+1);
    }
    return riResult;
  }
  public static String sixteenToNumber(String s){//十六进制字母对应数字
    String num = "";
    if (s.equals("A") || s.equals("a"))
      num = "10";
    else if (s.equals("B") || s.equals("b"))
      num = "11";
    else if (s.equals("C") || s.equals("c"))
      num = "12";
    else if (s.equals("D") || s.equals("d"))
      num = "13";
    else if (s.equals("E") || s.equals("e"))
      num = "14";
    else if (s.equals("F") || s.equals("f"))
      num = "15";
    else
      num = s;
    return num;
  }
  public static String sixteenNumberToChar(int num)
  {//十六进制数字对应字母
    String c = "";
    if(num == 10)
      c = "A";
    else if (num == 11)
      c = "B";
    else if (num == 12)
      c = "C";
    else if (num == 13)
      c = "D";
    else if (num == 14)
      c = "E";
    else if (num == 15)
      c = "F";
    else
      c = String.valueOf(num);
    return c;
  }
  public static void main(String[] args) {
    String number;
    int a,b;
    String result = "";
    String stop = "";
    Scanner read = new Scanner(System.in);//得到用户输入的值
    do{
      System.out.println("输入三个整数：待转换的数据 要转换之前的进制 要转换后的进制");
      number = read.next();
      a = read.nextInt();
      b = read.nextInt();
      stop = "Quit";
    }while (stop != "Quit");
    try{
      if (a != 10)
      {
        String temp = String.valueOf(ZhuanToTen(a,number));
        result = String.valueOf(TenToNumber(b,temp));
      }else{
        result = String.valueOf(TenToNumber(b,number));
      }
      System.out.println(a + "进制的数：" + number + "，转换成" + b + "进制的数为：" + result);
    }catch (Exception e){
      System.out.println("转换失败，请正确输入！");
      System.exit(-1);
    }
  }
}
