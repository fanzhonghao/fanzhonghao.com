/* ---------------------------------
 *  Author:fan
 *  Date:2017.7.18
 * ---------------------------------
 *  Description:
 *    This code is used to explore
 *  the use of Formatter class. and
 *  use it to normalize the date.
 * ---------------------------------
 *  Attention:
 *  日期和时间格式转换符所代表的含义
 *  a:星期的缩写
 *  b或h:月的缩写
 *  c:完整的日期和时间，eg: 星期三 一月 02 15：06：52 CST 2008
 *  d:两位数字的日（前面补0） eg: 02
 *  e:两位数字的日(不补0) eg: 2
 *  j:一年中的第几天(三位，补0)
 *  k:两位数字的小时(不补0) 0~23
 *  l:两位数字的小时(不补0) 1~12
 *  m:两位数字的月(补0)
 *  p:上午/下午的标志
 *  r:12小时时间
 *  s:从1970-01-01 0时开始的秒数
 *  y:两位数的年(补0)
 *  z:相对与GMT的时区差
 *  A:星期的完整拼写 eg:星期三
 *  B:月的完整拼写 eg:一月
 *  C:年的前两位数字(前面补0)
 *  D:美国格式的日期(月/日/年)
 *  F:ISO 8061 日期
 *  H:两位数字的小时(补0) 0～23
 *  I:两位数字的小时(补0) 1～12
 *  L:3位数字的毫秒(补0)
 *  M:两位数字的分钟(补0)
 *  N:9位数字的毫秒(前面补0)
 *  P:上午/下午标志
 *  Q:从1970-01-01 0时开始的毫秒数
 *  R:24小时时间(无秒)
 *  S:两位数字的秒钟(补0)
 *  T:24小时时间
 *  Y:4位数的年(前补0)
 *  Z:时区缩写
 * -------------------------------
 */
import java.util.Date;
import java.util.Formatter;
public class timeFormat{
  public static void main(String[] args) {
    Formatter fmt = new Formatter(System.out);//创建一个Formatter类的对象
    Date date = new Date();
    Object[] obj = new Object[1];
    obj[0] = date;
    fmt.format("当前系统显示的时间和日期为：%tc\n",obj);
    fmt.format("当前的日期为[中国格式的日期]：%tF\n",obj);
    fmt.format("当前的日期为[美国格式的日期]：%tD\n",obj);
    fmt.format("今天是星期几？：%tA\n",obj);
    fmt.format("现在时间为[24小时制]：%tT\n",obj);
    fmt.format("现在时间为[12小时制]：%tR\n",obj);
    fmt.format("现在是几月份：%tB\n",obj);
    fmt.format("今天是几号：%te号\n",obj);

  }
}
