/* -------------------------------
 *  Author:fan
 *  Date:2017.7.15
 * -------------------------------
 *  Description:
 *    This code is used to explore
 *  the use of output parameter.
 * -------------------------------
 *  Thought:
 *    Through this code, we know
 *  though the function just can
 *  return one parameter, we can
 *  use output parameter to return
 *  more parameter that if we need.
 *  The output parameter's final
 *  result is the value that is
 *  assigned in the function that
 *  we have called.
 * -------------------------------
 */
using System;
class Program{
  public int GetResultAndRem(int i,int j,out int k)
  {
    int Result;
    Result = i/j;
    k = i%j;
    return Result;
  }
}
class Test{
  static void Main(){
    int Result;
    int Remu = 100;
    Program program1 = new Program();
    Result = program1.GetResultAndRem(8,5,out Remu);
    Console.WriteLine("The result and remain of 8/5 is {0} and {1}.",Result,Remu);
    Console.WriteLine();
  }
}
