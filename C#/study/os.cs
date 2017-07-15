using System;
class os{
  static double price1 = 123456.3;
  static double price2 = 123.321475;

  public static void Main(string[] args)
  {//C输出货币值
    Console.WriteLine("The price is {0:C}.", price1);//price1将取代{0:C}，此处默认为小数为两位
    Console.WriteLine("The price is {0:C3}.",price2);//此处小数取三位，最后四舍五入

    int value1 = 236;
    int value2 = -24;
    Console.WriteLine("value1 = {0:D}.",value1);//输出十进制整数
    Console.WriteLine("value1 = {0:D5}.",value1);//输出十进制整数，并占5位，空格用0补充
    Console.WriteLine("value2 = {0:D}.",value2);
    Console.WriteLine("value2 = {0:D5}.",value2);

    Console.WriteLine("price1 = {0:E}.",price1);//科学计数法
    Console.WriteLine("price1 = {0:e10}.",price1);//得到确定的精度

    Console.WriteLine("price1 = {0:F}.",price1);//输出定点数，缺省时精确到小数点后两位
    Console.WriteLine("price1 = {0:f3}.",price1);//可以改变小数点后面的个数

    Console.WriteLine("price1 = {0:g3}.",price1);
    Console.WriteLine("price2 = {0:G3}.",price2);
    //输出常规数，如果用科学记数法表示数字时指数大于-5而且小于精度说明符，则使用定点表示法，否则使用科学计数法

    Console.WriteLine("price1 = {0:n6}.",price1);//将数字转换为"d,ddd,ddd..."形式的字符,小数点后面不够用0补全

    Console.WriteLine("price1 = {0:p6}.",price1);//输出百分比的形式

    //自定义格式
    Console.WriteLine("price1 = {0:00000000}.",price1);//输出7位整数，不够用0补全
    Console.WriteLine("price1 = {0:00.00}.",price1);//输出有两位小数

    Console.WriteLine("price1 = {0:#########}.",price1);//#和0类似，但不输出多余的字符

    //WriteLine:输出并换行
    //Write:输出但不换行

    //输入
    int i;
    string char1;
    Console.WriteLine("Please put in a string and the first char is a number.");
    i = Console.Read() - '0';//得到输入的第一个字符，但是确定为int型
    char1 = Console.ReadLine();//得到输入的一行字符串
    Console.WriteLine();
    Console.WriteLine("i = {0}.",i);
    Console.WriteLine("char1 = {0}.",char1);

    //位运算符
    i = 3;//11
    int b = 4;//100
    Console.WriteLine("3&4 = {0}.",i&b);//&为按位与
    Console.WriteLine("3|4 = {0}.",i|b);//|按位或
    Console.WriteLine("3^4 = {0}.",i^b);//按位异或
    Console.WriteLine("~3 = {0}，~4 = {1}.",~i,~b);//按位取反    ???
    Console.WriteLine("3<<1 = {0}.",i<<1);//左移，相当于乘以2
    Console.WriteLine("3>>1 = {0}.",i>>1);//右移，相当于除以2
  }
}
