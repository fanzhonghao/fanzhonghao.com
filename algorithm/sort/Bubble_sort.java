/* -----------------------------
 *  Author:fan
 *  Date:2017.7.24
 * -----------------------------
 *  Description:
 *    This is a bubble sort.
 * -----------------------------
 *  Thought:
 *    This method through
 *  comparing the two nums which
 *  are neighbouring to decide
 *  where to settle it.
 * -----------------------------
 */
public class Bubble_sort{
  public static void main(String[] args) {
    int array1[] = new int[] {2,3,5,6,4,9,7,8};
    int temp = 0;
    for(int i = 0;i < array1.length;i++){
      for(int j = array1.length - 1;j > i;j--){
        if(array1[i] > array1[j]){
          temp = array1[i];
          array1[i] = array1[j];
          array1[j] = temp;
        }
      }
    }
    for(int i = 0;i < array1.length;i++){
      System.out.print(array1[i] + "\t");
    }
    System.out.println();
    for(int i = 0;i < array1.length;i++){
      for(int j = array1.length - 1;j > i;j--){
        if(array1[i] < array1[j]){
          temp = array1[i];
          array1[i] = array1[j];
          array1[j] = temp;
        }
      }
    }
    for(int i = 0;i < array1.length;i++){
      System.out.print(array1[i] + "\t");
    }
    System.out.println();
  }
}
