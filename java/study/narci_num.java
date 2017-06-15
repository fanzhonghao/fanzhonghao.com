/* -----------------------------
 *    Look for the narcissistic
 *  number between 100 and 999.
 * -----------------------------
 * Description:
 *    The narcissistic number
 *  is the num like ABC which
 *  meet A^2 + B^2 + C^2 = ABC
 * ----------------------------- 
 */
public class narci_num{
  public static void main(String[] args) {
    narci_num fc02 = new narci_num();
    int sum;
    System.out.println("100~999之间的水仙花数为：");
    for ( int i = 100;i <= 999;i++){
      int a = fc02.getSumOfCubic(i / 100);
      int b = fc02.getSumOfCubic((i / 10) % 10);
      int c = fc02.getSumOfCubic(i % 10);
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
