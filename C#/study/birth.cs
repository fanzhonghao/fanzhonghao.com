using System;
class month{
  static int[] a = new int[24]{1,3,5,7,9,11,2,3,6,7,10,11,4,5,6,7,12,0,8,9,10,11,12,0};
  public void show(int d){
    for(int i = d * 6;i < d * 6 + 6;i++){
      if(i % 3 == 0) Console.WriteLine();
      if(a[i] == 0) continue;
      Console.Write(a[i] + "\t");
    }
    Console.WriteLine();
  }
}
class Day{
  static int[] a = new int[80] {1,3,5,7,9,11,13,15,17,19,21,23,25,27,29,31,2,3,6,7,10,11,14,15,18,19,22,23,26,30,31,0,
  4,5,6,7,12,13,14,15,20,21,22,23,28,29,30,31,8,9,10,11,12,13,14,15,24,25,26,27,28,29,30,31,16,17,18,19,20,21,22,23,24,
  25,26,27,28,29,30,31};
  public void show(int d){
    for(int i = d * 16;i < d * 16 + 16;i++){
      if(i % 4 == 0) Console.WriteLine();
      if(a[i] == 0) continue;
      Console.Write(a[i] + "\t");
    }
    Console.WriteLine();
  }
}
class Test{
  public static void Main(){
    month mon = new month();
    Console.WriteLine("以下1表示是，0表示不是。");
    Console.WriteLine("你的生日的月份在这里面吗？");
    mon.show(0);
    int a1 = Console.Read() - '0';
    for(;;)
    {
      if(a1 == 1 || a1 == 0) break;
      Console.WriteLine();
      Console.WriteLine("请输入0或1");
      a1 = Console.Read() - '0';
    }
    Console.WriteLine();
    Console.WriteLine("你的生日的月份在这里面吗？");
    mon.show(1);
    int a2 = Console.Read() - '0';
    for(;;)
    {
      if(a2 == 1 || a2 == 0) break;
      Console.WriteLine();
      Console.WriteLine("请输入0或1");
      a2 = Console.Read() - '0';
    }
    Console.WriteLine();
    Console.WriteLine("你的生日的月份在这里面吗？");
    mon.show(2);
    int a3 = Console.Read() - '0';
    for(;;)
    {
      if(a3 == 1 || a3 == 0) break;
      Console.WriteLine();
      Console.WriteLine("请输入0或1");
      a3 = Console.Read() - '0';
    }
    Console.WriteLine();
    Console.WriteLine("你的生日的月份在这里面吗？");
    mon.show(3);
    int a4 = Console.Read() - '0';
    for(;;)
    {
      if(a4 == 1 || a4 == 0) break;
      Console.WriteLine();
      Console.WriteLine("请输入0或1");
      a4 = Console.Read() - '0';
    }
    Console.WriteLine();

    Day day = new Day();
    Console.WriteLine("你的生日的日期在里面吗？");
    day.show(0);
    int d1 = Console.Read() - '0';
    for(;;)
    {
      if(d1 == 1 || d1 == 0) break;
      Console.WriteLine();
      Console.WriteLine("请输入0或1");
      d1 = Console.Read() - '0';
    }
    Console.WriteLine();

    Console.WriteLine("你的生日的日期在里面吗？");
    day.show(1);
    int d2 = Console.Read() - '0';
    for(;;)
    {
      if(d2 == 1 || d2 == 0) break;
      Console.WriteLine();
      Console.WriteLine("请输入0或1");
      d2 = Console.Read() - '0';
    }
    Console.WriteLine();

    Console.WriteLine("你的生日的日期在里面吗？");
    day.show(2);
    int d3 = Console.Read() - '0';
    for(;;)
    {
      if(d3 == 1 || d3 == 0) break;
      Console.WriteLine();
      Console.WriteLine("请输入0或1");
      d3 = Console.Read() - '0';
    }
    Console.WriteLine();

    Console.WriteLine("你的生日的日期在里面吗？");
    day.show(3);
    int d4 = Console.Read() - '0';
    for(;;)
    {
      if(d4 == 1 || d4 == 0) break;
      Console.WriteLine();
      Console.WriteLine("请输入0或1");
      d4 = Console.Read() - '0';
    }
    Console.WriteLine();

    Console.WriteLine("你的生日的日期在里面吗？");
    day.show(4);
    int d5 = Console.Read() - '0';
    for(;;)
    {
      if(d5 == 1 || d5 == 0) break;
      Console.WriteLine();
      Console.WriteLine("请输入0或1");
      d5 = Console.Read() - '0';
    }
    Console.WriteLine();

    Console.Write("你的生日为：");
    int mon1 = a4 * 8 + a3 * 4 + a2 * 2 + a1;
    int day1 = d5 * 16 + d4 * 8 + d3 * 4 + d2 * 2 + d1;
    Console.WriteLine(mon1 + "月" + day1 + "日");
    Console.Read();
  }
}
