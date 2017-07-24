/* -----------------------------
 *  Author:fan
 *  Date:2017.7.24
 * -----------------------------
 *  Description:
 *    This is a Shell sort.
 * -----------------------------
 *  Thought:
 *    Through setting different
 *  increment to sort the data
 *  by some times. We choose
 *  insert sorting to process
 *  sorting partly.
 *    There we set three
 *  increments which are 5,3 and
 *  1.
 * -----------------------------
 */
 import java.util.Random;
public class shell_sort{
  public static void main(String[] args) {
    int data[] = new int[20];
    Random rd = new Random();
    for(int i = 0;i < 20;i++) data[i] = rd.nextInt(50);
    System.out.println("排序前：");
    for(int i = 0;i < data.length;i++)
    {
      System.out.print(data[i] + "\t");
    }
    System.out.println();
    System.out.println("排序后：");
    int temp = 0;


    for(int i = 0;i < data.length;i++)
    {
      System.out.print(data[i] + "\t");
    }
    System.out.println();
  }
}
