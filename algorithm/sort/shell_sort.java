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
 *  1. The follow is ascending
 *  sort.
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
    int temp = 0,j = 0;

    for (int m = 5;m < 10;m++) {//The increments is 5
      for(int i = m;i < data.length;i = i+5){
        if(data[i] >= data[i-5]){
          continue;
        }else {
          temp = data[i];
          for(j = i-5;j >= 0;j = j-5){
            data[j+5] = data[j];
            if(temp >= data[j]) break;
          }
          data[j+5] = temp;
        }
      }
    }
    for (int m = 3;m < 6;m++) {//The increments is 3
      for(int i = m;i < data.length;i = i+3){
        if(data[i] >= data[i-3]){
          continue;
        }else {
          temp = data[i];
          for(j = i-3;j >= 0;j = j-3){
            data[j+3] = data[j];
            if(temp >= data[j]) break;
          }
          data[j+3] = temp;
        }
      }
    }
    for(int i = 1;i < data.length;i++){//The increments is 1
      j = i-1;
      if(data[i] < data[j]){
        temp = data[i];
        for(;j >= 0;j--){
          data[j+1] = data[j];
          if(temp >= data[j]) break;
        }
        data[j+1] = temp;
      }else {
        continue;
      }
    }
    for(int i = 0;i < data.length;i++)
    {
      System.out.print(data[i] + "\t");
    }
    System.out.println();
  }
}
