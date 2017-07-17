/* -------------------------------
 *  Author:fan
 *  Date:2017.7.17
 * -------------------------------
 *  Description:
 *    This code is used to use
 *  regular expression to inspect
 *  whether the num is a phone_num.
 * -------------------------------
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;/*import java.util.regex.* 此包中实现正则表达式*/
public class phone_num{
  private static String REG_EXP = "^([0-9]{3}-?[0-9]{8})|([0-9]{4}-?[0-9]{7})$";/*正则表达式*/
  /*^为开始符， $为结束符*/ 
  /* 使用String类中的matches()方法利用正则表达式匹配的方法*/
  public static boolean useMatches(String phoneNum){
    if(phoneNum != null){
      return phoneNum.matches(REG_EXP);
    }else{
      return false;
    }
  }
  /* 使用Pattern的compile()方法和Matcher的matcher()方法共同匹配*/
  public static boolean usePattern(String phoneNum){
    Pattern p = Pattern.compile(REG_EXP);
    Matcher m = p.matcher(phoneNum);
    return m.matches();
  }
  public static void main(String[] args) {
    String phoneNum = "210-12345678";
    System.out.println(phoneNum + " 是一个合法的电话号码格式吗？ " + phone_num.useMatches(phoneNum));
    System.out.println(phoneNum + " 是一个合法的电话号码格式吗？ " + phone_num.usePattern(phoneNum));
    phoneNum = "210-12345678";
    System.out.println(phoneNum + " 是一个合法的电话号码格式吗？ " + phone_num.useMatches(phoneNum));
    System.out.println(phoneNum + " 是一个合法的电话号码格式吗？ " + phone_num.usePattern(phoneNum));
    phoneNum = "0439-1234567";
    System.out.println(phoneNum + " 是一个合法的电话号码格式吗？ " + phone_num.useMatches(phoneNum));
    System.out.println(phoneNum + " 是一个合法的电话号码格式吗？ " + phone_num.usePattern(phoneNum));
    phoneNum = "010-88888888888";
    System.out.println(phoneNum + " 是一个合法的电话号码格式吗？ " + phone_num.useMatches(phoneNum));
    System.out.println(phoneNum + " 是一个合法的电话号码格式吗？ " + phone_num.usePattern(phoneNum));
    phoneNum = "04ff-666ab##5";
    System.out.println(phoneNum + " 是一个合法的电话号码格式吗？ " + phone_num.useMatches(phoneNum));
    System.out.println(phoneNum + " 是一个合法的电话号码格式吗？ " + phone_num.usePattern(phoneNum));
  }
}
