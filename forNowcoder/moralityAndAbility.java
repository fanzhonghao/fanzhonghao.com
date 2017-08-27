import java.util.Scanner;

/**
 * Author:fan
 * Date: 17-8-27
 * Time: 下午7:59
 * Description:
 *  https://www.nowcoder.com/pat/6/problem/4041
 */
public class moralityAndAbility {
    public static void main(String[] args) {
        int total,min,pre;
        Scanner in = new Scanner(System.in);
        total = in.nextInt();
        min = in.nextInt();
        pre = in.nextInt();
        int first = 0,second = 0,third = 0,forth = 0;

        student[] stu = new student[100000];
        for(int i = 0;i < total;i++){
            stu[i] = new student();
        }
        for (int i = 0;i < total;i++){
            stu[i].id = i;
            stu[i].no = in.nextInt();
            stu[i].grade = in.nextInt();
            stu[i].score = in.nextInt();
            stu[i].total = stu[i].grade + stu[i].score;
        }

        int[] firstGroup = new int[100000];
        int[] secondGroup = new int[100000];
        int[] thirdGroup = new int[100000];
        int[] forthGroup = new int[100000];
        for (int i = 0;i < total;i++){
            if (stu[i].grade < min || stu[i].score < min) continue;
            if (stu[i].grade >= pre && stu[i].score >= pre){
                firstGroup[first++] = stu[i].id;
                insertSort(firstGroup,first-1,stu);
            }else if (stu[i].grade >= pre && stu[i].score >= min){
                secondGroup[second++] = stu[i].id;
                insertSort(secondGroup,second-1,stu);
            }else if (stu[i].grade >= stu[i].score && stu[i].score >= min){
                thirdGroup[third++] = stu[i].id;
                insertSort(thirdGroup,third-1,stu);
            }else if (stu[i].grade >= min && stu[i].score >= min){
                forthGroup[forth++] = stu[i].id;
                insertSort(forthGroup,forth-1,stu);
            }
        }

        System.out.println(first+second+third+forth);
        for (int i = 0;i < first;i++){
            System.out.println(stu[firstGroup[i]].no + " " + stu[firstGroup[i]].grade + " " + stu[firstGroup[i]].score);
        }
        for (int i = 0;i < second;i++){
            System.out.println(stu[secondGroup[i]].no + " " + stu[secondGroup[i]].grade + " " + stu[secondGroup[i]].score);
        }
        for (int i = 0;i < third;i++){
            System.out.println(stu[thirdGroup[i]].no + " " + stu[thirdGroup[i]].grade + " " + stu[thirdGroup[i]].score);
        }
        for (int i = 0;i < forth;i++){
            System.out.println(stu[forthGroup[i]].no + " " + stu[forthGroup[i]].grade + " " + stu[forthGroup[i]].score);
        }

    }

    private static void insertSort(int[] a,int b,student[] stu){
        for (int i = b;i > 0;i--){
            if (stu[a[i]].total > stu[a[i-1]].total  || (stu[a[i]].total == stu[a[i-1]].total && stu[a[i]].grade > stu[a[i-1]].grade)){
                int temp = a[i];
                a[i] = a[i-1];
                a[i-1] = temp;
            } else break;
        }
    }

    private static class student{
        student(){}
        int id;//记录是第几个
        int no;//考号
        int grade,score;//德分，才分
        int total;
    }

}
