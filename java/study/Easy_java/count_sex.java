/* ---------------------
 *    count the present
 *  student group by
 *  sex.
 * ---------------------
 *    Description:
 *    There use 0 and 1
 *  to stand for boy and
 *  girl. Also, we use
 *  0 and 1 to stand for
 *  whether they attend.
 * ---------------------
 */
import java.util.Random;//引入Random函数
public class count_sex{
  public static void main(String[] args) {
    int sum_girl = 0;
    int sum_boy = 0;
    String sexy [] = new String[50];
    Random rd = new Random();
    System.out.println("随机生成的各个学生的情况如下：");
    for(int i = 0;i < sexy.length;i++){
      int lsex = rd.nextInt(2);
      int rate = rd.nextInt(2);
      sexy[i] = lsex + "," + rate;/*the former stand sex while the latter stand attend*/
      System.out.print(sexy[i] + "  ");
      if((i + 1) % 10 == 0)
        System.out.println();
    }
    for(int i = 0;i < sexy.length;i++){
      String a [] = sexy[i].split(",");
      if(a[0].equals("0") && a[1].equals("1")){
        sum_boy++;
      }else if(a[0].equals("1") && a[1].equals("1")){
        sum_girl++;
      }
    }
    System.out.println("出席的女学生的人数为：" + sum_girl);
    System.out.println("出席的男学生的人数为：" + sum_boy);
  }
}
