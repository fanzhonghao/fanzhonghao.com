/* -------------------------------
 *  Author:fan
 *  Date:2017.7.24
 * -------------------------------
 *  Description:
 *    This is a select sort.
 * -------------------------------
 *  Thought:
 *    This method through finding
 *  out the mininum num over and
 *  over and then insert it at the
 *  suit site.The follow is
 *  ascending sort.
 * -------------------------------
 */
import java.util.Random;
public class select_sort{
  public static void main(String[] args) {
    Random rd = new Random();
    int array[] = new int[10];
    for(int i = 0;i < 10;i++){
      array[i] = rd.nextInt(20);
    }
    System.out.println("排序前：");
    for(int i = 0;i < array.length;i++){
      System.out.print(array[i] + "\t");
    }
    System.out.println("\n排序后：");
    int temp = 0;
    for(int i = 0;i < array.length;i++){
      for(int j = i+1;j < array.length;j++){
        if(array[i] > array[j]){
          temp = array[i];
          array[i] = array[j];
          array[j] = temp;
        }
      }
    }
    for(int i = 0;i < array.length;i++){
      System.out.print(array[i] + "\t");
    }
    System.out.println();
  }
}
