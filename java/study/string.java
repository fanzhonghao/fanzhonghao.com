/* -------------------------------
 *  Author:fan
 *  Date:2017.7.16
 * -------------------------------
 *  Description:
 *    This code is used to explore
 *  the use of string.
 * -------------------------------
 */
public class string{
  public static void main(String[] args) {
    String s = "abcd";
    String s1 = "efgh";
    String s2 = "ijklm";
    String s3 = "abcd";
    String s4 = "ABCD";
    s = s.concat(s1);//链接
    s = s.concat(s2);
    System.out.println("s = " + s);
    System.out.println("s3 = " + s3);
    System.out.println("s4 = " + s4);
    if(s3.equals(s4)){//判等
      System.out.println("s3 = s4");
    }else{
      System.out.println("s3 != s4");
    }
    if(s3.equalsIgnoreCase(s4)){//判等，忽略大小写
      System.out.println("s3 = s4");
    }else{
      System.out.println("s3 != s4");
    }

    String s5 = "abcdABCDabcd";
    int a = s5.indexOf("a".codePointAt(0));//返回“a”第一次出现的Unicode代码处索引
    int b = s5.indexOf("a");//返回字符"a"第一次出现的位置
    int c = s5.indexOf("a".codePointAt(0),3);//从指定的位置开始搜索，返回第一次出现该字符的Unicode代码的索引
    int d = s5.indexOf("a",3);//从指定位置开始搜索，返回第一次出现的索引
    int e = s5.lastIndexOf("a");//返回最后依次出现字符"a"的索引

    System.out.println("a第一次出现的位置：" + a);
    System.out.println("a第一次出现的位置：" + b);
    System.out.println("a从第三位开始，第一次出现的位置：" + c);
    System.out.println("a从第三位开始，第一次出现的位置：" + d);
    System.out.println("a最后一次出现的位置：" + e);
    System.out.println("a的长度为：" + s5.length());
    String s6 = s5.replace('a','e');//字符替换
    System.out.println(s6);
    String s7 = "One:Two:Three";
    String[] s8 = s7.split(":");//字符串分割
    for(int i = 0;i < s8.length;i++){
      System.out.print(" " + s8[i]);
    }
    System.out.println();
    String s9 = s7.substring(3);//截取子串，从参数开始，包括三
    String s10 = s7.substring(0,3);//截取子串，从0到3.但不包括三
    System.out.println(s9);
    System.out.println(s10);
  }
}
