
import java.util.Scanner;
/**
 * Author: fan
 * Date: 17-8-23
 * Time: 下午3:30
 * Description:
 *  https://www.nowcoder.com/questionTerminal/7335f56d49e946c2a7cd2a93661b293b
 */
public class Meet {
    public static void main(String[] args) {
        String a,b,c,d;
        Scanner in = new Scanner(System.in);
        a = in.next();
        b = in.next();
        c = in.next();
        d = in.next();
        char[] e = new char[60];
        char[] f = new char[60];
        int count = 0;

        for (int i = 0;i < a.length();i++){
            if (a.charAt(i) >= 'A' && a.charAt(i) <= 'Z'){
                e[count++] = a.charAt(i);
            }
        }

        count = 0;
        for (int i = 0;i < b.length();i++){

            if (b.charAt(i) >= 'A' && b.charAt(i) <= 'Z'){
                f[count++] = b.charAt(i);
            }
        }
        char[] time = new char[2];   //前两个时间
        int tim = 0;
        int flag = 0;
        int i,j;
        for (i = 0;i < e.length;i++){
            for (j = 0;j < f.length;j++){
                if (e[i] == f[j]) break;
            }
            if (j < f.length && e[i] == f[j]) {
                time[flag++] = e[i];
                break;
            }
        }
        for (i = 0;i < a.length();i++)
            if (a.charAt(i) == time[0])
                break;

        i = a.indexOf(time[0]);

        for (i++;i < a.length() && i < b.length();i++){
            if (a.charAt(i) == b.charAt(i)){
                time[flag] = a.charAt(i);
                break;
            }
        }

        for ( i = 0;i < c.length() && i < d.length();i++){
            if (c.charAt(i) == d.charAt(i) &&((c.charAt(i) >= 'a' && c.charAt(i) <= 'z')||(c.charAt(i) >= 'A' && c.charAt(i) <= 'Z'))){
                tim = i;
                break;
            }
        }
        switch (time[0]){
            case 'A':
                System.out.print("MON "); break;
            case 'B':
                System.out.print("TUE "); break;
            case 'C':
                System.out.print("WED "); break;
            case 'D':
                System.out.print("THU "); break;
            case 'E':
                System.out.print("FRI "); break;
            case 'F':
                System.out.print("SAT "); break;
            case 'G':
                System.out.print("SUN "); break;
        }
        switch (time[1]){
            case '0': case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9':
                System.out.print("0" + (time[1] - '0') + ":"); break;
            case 'A':
                System.out.print(10 + ":"); break;
            case 'B':
                System.out.print(11 + ":"); break;
            case 'C':
                System.out.print(12 + ":"); break;
            case 'D':
                System.out.print(13 + ":"); break;
            case 'E':
                System.out.print(14 + ":"); break;
            case 'F':
                System.out.print(15 + ":"); break;
            case 'G':
                System.out.print(16 + ":"); break;
            case 'H':
                System.out.print(17 + ":"); break;
            case 'I':
                System.out.print(18 + ":"); break;
            case 'J':
                System.out.print(19 + ":"); break;
            case 'K':
                System.out.print(20 + ":"); break;
            case 'L':
                System.out.print(21 + ":"); break;
            case 'M':
                System.out.print(22 + ":"); break;
            case 'N':
                System.out.print(23 + ":"); break;
        }
        if(tim < 10){
            System.out.print("0" + tim);
        }else System.out.print(tim);
    }
}
