/* ----------------------------
 *  Author:fan
 *  Date:2017.7.25
 * ----------------------------
 *  Description:
 *    This is a quick sort.
 * ----------------------------
 */
import java.util.Random;
public class quick_sort{
  public static void main(String[] args) {
    int data[] = new int[21];
    Random rd = new Random();
    for(int i = 1;i < 21;i++) data[i] = rd.nextInt(50);
    System.out.println("排序前：");
    print(data);
    QSort(data,0,data.length-1);
    System.out.println("排序后：");
    print(data);
  }
  public static void print(int a[]){
    for(int i = 1;i < a.length;i++){
      System.out.print(a[i] + "\t");
    }
    System.out.println();
  }

  public static void QSort(int a[],int low,int high)
  {
      int pivotloc;
      if(low < high)
      {
          pivotloc = partition(a,low,high);
          QSort(a,low,pivotloc-1);
          QSort(a,pivotloc+1,high);
      }
  }
  public static int partition(int a[],int low,int high)
  {
      int i,j,pivotkey;
      a[0] = a[low];
      pivotkey = a[0];
      i = low;
      j = high;
      while(i < j)
      {
          while(i < j && a[j] >= pivotkey) j--;
          a[i] = a[j];
          while(i < j && a[i] <= pivotkey) i++;
          a[j] = a[i];
      }
      a[i] = a[0];
      return i;
  }
}
