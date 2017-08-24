package nowcoder;

import java.util.Scanner;

/**
 * Author: fan
 * Date: 17-8-23
 * Time: 下午1:40
 * Description:
 *  This code is used to
 *  output all primes form
 *  the first num's site
 *  to another.
 */
public class prime {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a,b;
        a = in.nextInt();
        b = in.nextInt();
        primeOut(a,b);//输出
    }

    private static void primeOut(int a, int b){
        int count = 0;
        for (int i = 2; ;i++){
            boolean flag = isPrime(i);//检测是否为素数
            if(flag){
                count++;
                if (count >= a){
                    System.out.print(i);
                }else continue;
            }
            //以下满足格式要求
            if ((count-a + 1) % 10 == 0 && (count- a + 1) != 0 && flag) {
                System.out.println();
            }else if (flag && count >= a && count < b) System.out.print(" ");

            if (count >= b) break;
        }
    }
    private static boolean isPrime(int a){
        if (a == 2) return true;/*素数从2开始*/
        int b;
        int c =(int)Math.sqrt(a);
        for (b = 2;b <= c;b++){
            if (a % b == 0) break;
        }
        return b > c;
    }
}
