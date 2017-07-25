/* -----------------------------
 *    Look for the narcissistic
 *  number between 100 and 999.
 * -----------------------------
 * Description:
 *    The narcissistic number
 *  is the num like ABC which
 *  meet A^3 + B^3 + C^3 = ABC
 * -----------------------------
 */
public class narci_num{
  public static void main(String[] args) {
    narci_num num = new narci_num();//创建本类的实例，用于调用本类的方法
    int sum;
    System.out.println("100~999之间的水仙花数为：");
    for ( int i = 100;i <= 999;i++){
      int a = num.getSumOfCubic(i / 100);//调用方法
      int b = num.getSumOfCubic((i / 10) % 10);
      int c = num.getSumOfCubic(i % 10);
      sum = a + b + c;
      if(sum == i){
        System.out.print(i + "  ");
      }
    }
    System.out.println();
  }
  public int getSumOfCubic(int num){
    num = num * num * num;
    return num;
  }
}
