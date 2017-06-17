/* ------------------------------
 *    algorithm:
 *    First:
 *    Place the first num at the
 *  center of the last line;
 *    Second:
 *    Place the next num at this
 *  num's lower right, at this
 *  time, there will be two
 *  conditions as followers:
 *  (1)if the lower right beyond
 *  the line of the square, then
 *  the num should be placed at
 *  the same row's first line.
 *  (2)if the lower right beyong
 *  the row, then the num should
 *  be placed at the line's first
 *  row.
 * ------------------------------
 */
import java.util.Scanner;
public class magic_square{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Please enter a odd num：");
    int n = sc.nextInt();
    if(n%2 == 0){
      System.out.println("Please rnter odd num!");
      return ;
    }
    int array[][] = new int[n][n];
    int a = n-1;
    int b = n/2;
    for(int i = 1;i < n*n;i++){
      array[a++][b++] = i;
      if(i%n == 0){
        a = a-2;
        b = b-1;
      }else{
        a = a%n;
        b = b%n;
      }
    }
    System.out.println(n + "阶幻方如下：");
    for(int i = 0;i < n;i++){
      for(int j = 0;j < n;j++){
        System.out.print(" "+array[i][j]);
      }
      System.out.println();
    }
  }
}
