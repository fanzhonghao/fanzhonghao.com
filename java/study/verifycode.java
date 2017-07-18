/* -------------------------------
 *  Author:fan
 *  Date:2017.7.18
 * -------------------------------
 *  Description:
 *    This code is used to realize
 *  autogenerate verifycode.
 * -------------------------------
 *  Attention:
 *    public int nextInt(int n)
 *  generate a random num which is
 *  between 0 and n while 0 is
 *  included but n is not.
 * -------------------------------
 *  Besides:
 *    There have others random
 *  function. Such as nextFloat(),
 *  nextDouble(),nextGaussion()
 *  and so on.
 * -------------------------------
 */
import java.util.Random;
public class verifycode{
  static Random rd = new Random();
  public static void main(String[] args) {
    numCode();
    charCode();
    chineseCode();
    mixCode();
    System.out.println();
  }
  public static void numCode(){//0~9
    System.out.print("获取的5位数组验证码：");
    for(int i = 0;i < 5;i++){
      int n = rd.nextInt(10);
      System.out.print(n + " ");
    }
    System.out.println();
  }
  public static void charCode(){//字母和标点符号
    System.out.print("\n获取的五位字符验证码：");
    for(int i = 0;i < 5;i++){
      int n = 65 + rd.nextInt(58);
      System.out.print((char) n + " ");
    }
    System.out.println();
  }
  public static void chineseCode(){
    System.out.print("\n获取的五位汉字验证码：");
    for(int i = 0;i < 5;i++){
      int n = 10000 + rd.nextInt(10000);
      System.out.print((char) n + " ");
    }
    System.out.println();
  }
  public static void mixCode(){//混合验证码
    System.out.print("\n获取的五位混合验证码：");
    for(int i = 0;i < 5;i++){
      int n = rd.nextInt(123);
      if(n < 65){
        System.out.print(n % 10 + " ");
      }else{
        System.out.print((char) n + " ");
      }
    }
  }
}
