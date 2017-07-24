/* --------------------------------
 *  Author:fan
 *  Date:2017.7.24
 * --------------------------------
 *  Description:
 *    This is a insert sort.
 * --------------------------------
 *  Thought:
 *    This method through using
 *  each num compare with those
 *  nums which are sorted and then
 *  insert it at suit site.
 * --------------------------------
 */
import java.util.Random;
public class insert_sort{
  public static void main(String[] args) {
    int array[] = new int[10];
    Random rd = new Random();
    for(int i = 0;i < 10;i++){
      array[i] = rd.nextInt(20);
    }
    System.out.println("排序前：");
    for(int i = 0;i < array.length;i++){
      System.out.print(array[i] + "\t");
    }
    System.out.println();
    System.out.println("排序后：");
    int temp = 0,j = 0;
    for(int i = 1;i < array.length;i++){
      j = i-1;
      if(array[i] < array[j]){
        temp = array[i];
        for(;j >= 0;j--){
          array[j+1] = array[j];
          if(temp >= array[j]) break;
        }
        array[j+1] = temp;
      }else {
        continue;
      }
    }
    for(int i = 0;i < array.length;i++){
      System.out.print(array[i] + "\t");
    }
    System.out.println();
  }
}
