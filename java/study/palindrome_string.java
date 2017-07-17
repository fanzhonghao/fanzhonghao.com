/* -------------------------
 *  Author:fan
 *  Date:2017.7.17
 * -------------------------
 *  Description:
 *    This code is used to
 *  judge whether the string
 *  is a palindrome string.
 * -------------------------
 */
import java.util.Scanner;
public class palindrome_string{
  public static void main(String[] args) {
    System.out.println("Pleease enter a string: ");
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    StringBuffer sb = new StringBuffer(str);//字符串缓存类
    sb.reverse();//反转
    int n = 0;
    /*for(int i = 0;i < str.length();i++){
      if(str.charAt(i) == sb.charAt(i)){
        n++;
      }
    }*/
    
    for(int i = 0;i < str.length();i++,n++){
      if(str.charAt(i) != sb.charAt(i)) break;
    }

    if(n == str.length()){
      System.out.println(str + "是回文");
    }else{
      System.out.println(str + "不是回文");
    }
  }
}
