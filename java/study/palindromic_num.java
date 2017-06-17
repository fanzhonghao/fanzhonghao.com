/* ---------------------
 *  This code is used to
 * print the palindromic
 * num between 100 and
 * 1000
 * ---------------------
 */
 import java.util.Scanner;
 public class palindromic_num{
   public static void main(String[] args) {
     System.out.println("The palindromic num between 100 and 1000 are as follows: ");
     int num = 1;
     for (int i = 100;i < 1000;i++){
       if(palindromic(i)){
         System.out.print(i + " ");
         num++;
       }
       if(num % 11 == 0){
         System.out.println();
         num = 1;
       }
     }
     System.out.println();
   }
   public static boolean palindromic(int n){
     int m = reverse(n);
     if (m == n){
       return true;
     }else{
       return false;
     }
   }
   public static int reverse(int n){
     int a,b;
     a = n % 10;//个位
     n /= 10;
     b = n % 10;//十位
     n /= 10;
     return a * 100 + b * 10 + n;
   }
 }
