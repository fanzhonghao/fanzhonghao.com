/* ---------------------------------
 *  Author:fan
 *  Date:2017.7.25
 * ---------------------------------
 *  Description:
 *    This code is used to compare
 *  the time each method used to
 *  sort 1000 nums.
 *    The methods are Bubble sort,
 *  select sort, quick sort, insert
 *  sort and shell sort.
 * ---------------------------------
 */
import java.util.Random;
public class compare_time{
  public static void main(String[] args) {
    int data[] = new int[1001];
    Random rd = new Random();
    for(int i = 0;i < 1000;i++) data[i] = rd.nextInt(2000);
    int data1[] = data;
    int data2[] = data;
    int data3[] = data;
    int data4[] = data;
    int data5[] = data;
    long start = System.currentTimeMillis();
    Bubble_sort(data);
    print(data);
    long end = System.currentTimeMillis();
    System.out.println("冒泡排序用时：" + (end - start));

    start = System.currentTimeMillis();
    select_sort(data1);
    print(data1);
    end = System.currentTimeMillis();
    System.out.println("选择排序用时：" + (end - start));

    start = System.currentTimeMillis();
    insert_sort(data2);
    print(data2);
    end = System.currentTimeMillis();
    System.out.println("插入排序用时：" + (end - start));

    start = System.currentTimeMillis();
    shell_sort1(data3);
    Qprint(data3);
    end = System.currentTimeMillis();
    System.out.println("希尔排序（5,3,1）用时：" + (end - start));

    start = System.currentTimeMillis();
    shell_sort2(data5);
    Qprint(data5);
    end = System.currentTimeMillis();
    System.out.println("希尔排序（7,3,1）用时：" + (end - start));

    start = System.currentTimeMillis();
    QSort(data3,0,1000);
    Qprint(data3);
    end = System.currentTimeMillis();
    System.out.println("快速排序用时：" + (end - start));

  }
  public static void Bubble_sort(int a[]){//冒泡排序
    int temp = 0;
    for(int i = 0;i < a.length - 1;i++){
      for(int j = a.length - 2;j > i;j--){
        if(a[i] > a[j]){
          temp = a[i];
          a[i] = a[j];
          a[j] = temp;
        }
      }
    }
  }

  public static void select_sort(int array[]){
    int temp = 0;
    for(int i = 0;i < array.length-1;i++){
      for(int j = i+1;j < array.length-1;j++){
        if(array[i] > array[j]){
          temp = array[i];
          array[i] = array[j];
          array[j] = temp;
        }
      }
    }
  }

  public static void insert_sort(int array[]){
    int j = 0,temp;
    for(int i = 1;i < array.length-1;i++){
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
  }

  public static void shell_sort1(int data[]){
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
  }

  public static void shell_sort2(int data[]){
    int temp = 0,j = 0;
    for (int m = 7;m < 14;m++) {//The increments is 7
      for(int i = m;i < data.length;i = i+7){
        if(data[i] >= data[i-7]){
          continue;
        }else {
          temp = data[i];
          for(j = i-7;j >= 0;j = j-7){
            data[j+7] = data[j];
            if(temp >= data[j]) break;
          }
          data[j+7] = temp;
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

  public static void print(int a[]){
    for(int i = 0;i < 1000;i++){
      System.out.print(a[i] + "\t");
    }
    System.out.println();
  }

  public static void Qprint(int a[]){
    for(int i = 1;i < 1001;i++){
      System.out.print(a[i] + "\t");
    }
    System.out.println();
  }

}
