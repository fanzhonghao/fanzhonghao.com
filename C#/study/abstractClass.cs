/* ---------------------------------
 *  Author:fan
 *  Date:2017.7.15
 * ---------------------------------
 *  Description:
 *    This code is used to explore
 *  the use of abstract class and
 *  abstract function.
 *    We know we can not instance
 *  the abstract class directly and
 *  also we must realize all abstract
 *  function in the subclass.
 * ----------------------------------
 *  Attention:
 *    The abstract function must be
 *  declear in the abstract class.
 */
using System;
class Program
{
  abstract class shapes{//abstract class
    abstract public int area();//abstract function
  }
  class square : shapes
  {
    int side = 0;
    public square(int n)
    {
      side = n;
    }
    public override int area()
    {
      return side * side;
    }
    static void Main()
    {
      square sq = new square(12);
      Console.WriteLine("Area of the square = {0}",sq.area());
    }
  }
}
