/* --------------------------------
 *  Author:fan
 *  Date:2017.7.15
 * --------------------------------
 *  Description:
 *    This instruction is used to
 *  explore the use of ref. We can
 *  use it to change the value of
 *  the data easily.
 * --------------------------------
 */
using System;
class Program{
  public void swap(ref int x,ref int y)//引用
  {
    Console.WriteLine("Before swap: x = {0},y = {1}.",x,y);
    int temp = x;
    x = y;
    y = temp;
    Console.WriteLine("After swap: x = {0},y = {1}.",x,y);
  }
}
class Test{
  static void Main(){
    int i = 1,j = 2;
    Console.WriteLine("Main()中，调用前： i = {0}, j = {1}.",i,j);
    Program program = new Program();
    program.swap(ref i,ref j);//调用引用
    Console.WriteLine("Main()中，调用后： i = {0}, j = {1}.",i,j);
    Console.WriteLine();
  }
}
