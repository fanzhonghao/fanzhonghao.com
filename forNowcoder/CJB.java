
import java.util.Scanner;

/**
 * Author: fan
 * Date: 17-8-24
 * Time: 下午4:37
 * Description:
 *  https://www.nowcoder.com/pat/6/problem/4044
 */
public class CJB {
    public static void main(String[] args) {
        int no;
        Scanner in = new Scanner(System.in);
        no = in.nextInt();
        String[] A = new String[105];
        String[] B = new String[105];
        for (int i = 0;i < no;i++){
            A[i] = in.next();
            B[i] = in.next();
        }
        int[] c = new int[2];
        int[] j = new int[2];
        int[] b = new int[2];
        c[0] = c[1] = j[0] = j[1] = b[0] = b[1] = 0;//记录双方用什么赢的多

        int no1 = 0,no2 = 0,no3 = 0;//记录A方胜、平、负的次数
        for (int i = 0;i < no;i++){
            switch (judge(A[i],B[i])){
                case -1:
                    switch (B[i]){
                        case "B": b[1]++;break;
                        case "C": c[1]++;break;
                        case "J": j[1]++;break;
                    }
                    no3++;break;
                case 0:
                    no2++;break;
                case 1:
                    switch (A[i]){
                        case "B": b[0]++;break;
                        case "C": c[0]++;break;
                        case "J": j[0]++;break;
                    }
                    no1++;break;
            }
        }
        System.out.println(no1 + " " + no2 + " " + no3);
        System.out.println(no3 + " " + no2 + " " + no1);


        if (max(c[0],j[0],b[0]) == 1){
            System.out.print("B ");
        }else if (max(c[0],j[0],b[0]) == 0){
            System.out.print("C ");
        }else System.out.print("J ");

        if (max(c[1],j[1],b[1]) == 1){
            System.out.println("B");
        }else if (max(c[0],j[0],b[0]) == 0){
            System.out.println("C");
        }else System.out.println("J");
    }
    public static int judge(String a,String b){
        if (a.equals(b)) return 0;
        if (a.equals("C") && b.equals("J")) return 1;
        if (a.equals("C") && b.equals("B")) return -1;
        if (a.equals("J") && b.equals("B")) return 1;
        if (a.equals("J") && b.equals("C")) return -1;
        if (a.equals("B") && b.equals("C")) return 1;
        if (a.equals("B") && b.equals("J")) return -1;
        System.out.println("error");
        return 2;
    }
    public static int max(int c,int j,int b){
        if (b >= c && b >= j) return 1;
        if (c >= b && c >= j) return 0;
        if (j >= b && j >= c) return -1;
        System.out.println("Error");
        return 2;
    }

}
