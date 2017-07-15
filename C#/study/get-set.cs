/* ----------------------------
 *  Author:fan
 *  Date:2017.7.15
 * ----------------------------
 *  Description:
 *    This code is used to
 *  explore the use of get
 *  and set in the class.
 * ----------------------------
 *  Get:
 *    Through it we know get
 *  and set can help us to
 *  get or set the value which
 *  is private. This help us
 *  to control the access to
 *  the private value.
 * ----------------------------
 *  Attention :
 *    we can set the access to
 *  set and get at a same time.
 *  Such as: When we set the
 *  get is private we can't set
 *  the access to set. And it's
 *  access must above the
 *  attribute's access at the
 *  limit on the call.
 * ----------------------------
 */
using System;
class Program{
  class time{
    private double seconds;
    public double hour
    {
      public get {return seconds/3600;}
      set {seconds = value * 3600;} //此处的value的值应该在使用set的时候给出
    }
  }
  static void Main(){
    time t = new time();
    t.hour = 24;
    Console.WriteLine("Time in hours:"+t.hour);
  }
}
