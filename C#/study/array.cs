/* -------------------------------
 *  Author:fan
 *  Date:2017.7.15
 * -------------------------------
 *  Description:
 *    This code is used to explore
 *  the use of array and foreach.
 *    We can know C# allow us to
 *  transmit binarry array.
 *    When array is called, it can
 *  can be changed directly.
 * -------------------------------
 */
using System;
class Program{
  static void printarray(int[,] arr){
    for(int i = 0;i < 4;i++)
    {
      for(int j = 0;j < 2;j++)
      {
        Console.Write("Element({0},{1}) = {2}\t",i,j,arr[i,j]);
      }
      Console.WriteLine();
    }
    arr[0,1] = 7;
  }
  static void Main(){
    int[] a = new int[10];//创建数组
    int[] b = new int[] {1,2,3};
    for(int i = 0;i < 10;i++)
    {
      a[i] = i * i;//赋值
    }
    for(int i = 0;i < 10;i++)
    {
      Console.WriteLine("a[{0}] = {1}",i,a[i]);
    }

    for(int i = 0;i < 3;i++)
    {
      Console.Write("b[{0}] = {1}\t",i,b[i]);
    }
    Console.WriteLine();

    foreach(int i in a)
    {
      Console.WriteLine(i);//foreach只能进行只读访问，不能改变任何元素的值，不能显示使用
    }

    int[,] barray = new int[2,3] {{1,2,3},{4,5,6}};
    for(int i = 0;i < 2;i++)
    {
      for(int j = 0;j < 3;j++)
      {
        Console.WriteLine("b[{0}][{1}] = {2}",i,j,barray[i,j]);//注意引用的写法
      }
    }

    //交错数组
    int[][] myArray = new int[2][];//交错数组的行数固定,必须写清楚
    myArray[0] = new int[5] {1,3,5,7,9};
    myArray[1] = new int[4] {2,4,6,8};
    for(int i = 0;i < myArray.Length;i++)
    {
      Console.Write("Element({0}):",i);
      for(int j = 0;j < myArray[i].Length;j++)
      Console.Write("{0} {1}",myArray[i][j],j == (myArray[i].Length - 1) ? "" : " ");
      Console.WriteLine();
    }

    //二维数组调用
    printarray(new int[,] {{1,2},{3,4},{5,6},{7,8}});

    int[,] array2 = new[,] {{1,2},{3,4},{5,6},{7,8}};
    printarray(array2);
    Console.WriteLine("array2[0,1] = {0}",array2[0,1]);
  }
}
