/* ---------------------
 *    This code used to
 *  calculate a num's
 *  factorial but the
 *  num in no small than
 *  13.
 */
import java.util.Scanner;
public class factorial{
  public static void main(String[] args) {
    System.out.println("Please enter a positive integer：");
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();
    int layer = num;
    int j = 1;
    if (num > 12){
      System.out.println("The num is too big!");
      return ;
    }else if (num == 1){
      System.out.println(num + "'s factorial num is: 1");
      return ;
    }else if (num < 1){
      System.out.println("The num is too small!");
      return ;
    }
    loop : while (true){
      layer = layer * (num - j);
      j++;
      if (j == num)
        break loop;
    }
    System.out.println(num + "'s factorial num is: " + layer);
  }
}
