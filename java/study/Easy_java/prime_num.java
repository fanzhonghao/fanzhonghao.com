/* -----------------------
 *    Print the prime nums
 *  between 1 and 200
 * -----------------------
 */

import java.util.Arrays;
public class prime_num{
  private static boolean[] primeNumber(int num){
    if (num <= 0){
      System.out.println("范围必须大于0");
      return null;
    }
    boolean [] primes = new boolean[num+1];
    primes[1] = false;
    Arrays.fill(primes, 2,num+1,true);
    int n = (int)Math.sqrt(num);
    for(int i = 1;i < n;i++){
      if(primes[i]){
        for(int j = 2*i;j <= num;j += i){
          primes[j] = false;
        }
      }
    }
    return primes;
  }
  public static void showPrimeNumber(int num){
    boolean [] primes = primeNumber(num);
    int n = 0;
    if(primes != null){
      for(int i = 1;i < primes.length;i++){
        if(primes[i]){
          System.out.print(i + " ");
          if(++n%10 == 0)
          System.out.println();
        }
      }
      System.out.println();
    }
    System.out.println("一共有" + n + "个");
  }
  public static void main(String[] args) {
    int num = 100;
    System.out.println("范围在" + num + "内的质数有：");
    showPrimeNumber(num);
  }
}
