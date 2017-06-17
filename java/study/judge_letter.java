/* ---------------------------
 *    This code is used to
 *  judge the letter whether
 *  it is a vowel letter.
 * ---------------------------
 */
public class judge_letter{
  public static void main(String[] args)throws Exception {//调用read()方法而抛出的异常，此处IOException不可用**
    System.out.println("Please enter a letter：");
    char ch = (char) System.in.read();//gain the letter
    int num = (int) ch;
    if(num < 65 || num > 122 || (num > 90) && (num < 97)){
      System.out.println("Error, please enter the right letter!");
    }else{
      switch (ch){
        case 'a': case 'A': case 'e': case 'E': case 'i': case 'I':
        case 'o': case 'O': case 'u': case 'U':
            System.out.println(ch + "是元音字母");
            break;
        default:
            System.out.println(ch + "是辅音字母");
      }
    }
  }
}
