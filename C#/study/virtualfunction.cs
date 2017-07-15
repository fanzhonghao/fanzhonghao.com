/* -------------------------------
 *  Author:fan
 *  Date:2017.7.15
 * -------------------------------
 *  Description:
 *    This code is used to explore
 *  the use of virtual.
 * -------------------------------
 */
using System;
class vehicle //定义汽车类
{
  public float weight;
  public vehicle(float w)
  {
    weight = w;
  }
  public virtual void show()
  {
    Console.WriteLine("The weight of vehicle is:" + weight);
  }
}
class car : vehicle
{
  int passengers;
  public car(int p,float w) : base(w)
  {
    passengers = p;
  }
  public override void show()//重写虚函数的时候要写override关键字
  {
    base.show();
    Console.WriteLine("The passengers of car are:" + passengers);
  }
}
class Test{
  public static void Main()
  {
    car c1 = new car(6,100);
    c1.show();
  }
}
