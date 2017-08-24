
import java.util.Scanner;

/**
 * Author: fan
 * Date: 17-8-24
 * Time: 下午5:39
 * Description:
 *  https://www.nowcoder.com/pat/6/problem/4045
 */
public class numBlackHole {
    public static void main(String[] args) {
        int a;
        Scanner in = new Scanner(System.in);
        a = in.nextInt();
        if (a % 1111 == 0) {
            System.out.println(a + " - " + a + " = 0000");
            return;
        }
        int temp = a;
        for (;;){
            int max = num(temp,0),min = num(temp,1);
            temp = max - min;

            System.out.print(max + " - ");
            if(min < 10)
            {
                System.out.println("000" + min + " = " + temp);
            }else if (min < 100){
                System.out.println("00" + min + " = " + temp);
            }else if (min < 1000){
                System.out.println("0" + min + " = " + temp);
            }else System.out.println(min + " = " + temp);

//            min + " = " + temp;
            if (temp == 6174) break;
        }

    }
    private static int num(int a,int flag){//flag为1为升序，为0为降序
        int[] b = new int[4];
        b = sort(a);
        if (flag == 1){
            return b[0]*1000 + b[1]*100 + b[2]*10 + b[3];
        }else return b[3]*1000 + b[2]*100 + b[1]*10 + b[0];
    }
    private static int[] sort(int a){//升序
        int[] b = new int[4];
        for (int i = 0;i < 4;i++){
            b[i] = a%10;
            a /= 10;
        }
        for (int i = 0; i < 4; i++) {//冒泡
            for (int j = 3; j > i; j--)
                if (b[i] > b[j]) {
                    int temp = b[i];
                    b[i] = b[j];
                    b[j] = temp;
                }
        }
        return b;
    }

}
