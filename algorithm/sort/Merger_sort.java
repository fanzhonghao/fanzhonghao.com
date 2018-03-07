package algorithms;

import java.util.Random;

/* *
 * ----------------------
 *
 * @Author:fan
 * @Date: 18-3-7
 * Description:
 *  使用归并算法进行排序
 * -----------------------
 * Thought:
 *  这个方法合并已经排序好的数
 * 组来进行排序。
 * -----------------------
 */
public class Merger_sort {
    public static void main(String[] args) {
        Random r = new Random();
        int[] a = new int[100];
        for (int i = 0;i < 100;i++){
            a[i] = r.nextInt(500);
        }
        new Merger_sort().merger_sort(a,0,99);
        for (int i = 0;i < 100;i++){
            if (i % 10 == 0) System.out.println();
            System.out.print(a[i] + "\t");
        }
    }
    /*
    merger_sort():将数组拆分
    merger():将数组合并
     */
    private void merger_sort(int a[],int min,int max){
        if (min < max){
            int mid = (min + max) / 2;
            merger_sort(a,min,mid);
            merger_sort(a,mid+1,max);
            merger(a,min,mid,max);
        }
    }
    /*
    merger():将数组合并
     */
    private void merger(int a[],int min,int mid,int max){
        int n1 = mid - min + 1;//前半个数组元素个数
        int n2 = max - mid;//后半个数组元素个数
        int[] a1 = new int[n1+1];//存储前半个数组
        for (int i = 0;i < n1;i++){
            a1[i] = a[i+min];
        }
        int[] a2 = new int[n2+1];//存储后半个数组
        for (int i = 0;i < n2;i++){
            a2[i] = a[i+mid+1];
        }
        a1[n1] = 1000;//flag
        a2[n2] = 1000;//flag
        int t1 = 0,t2 = 0;
        int num = max - min + 1;//原数组传入个数
        for (int i = min;i <= max;i++){
            a[i] = a1[t1] < a2[t2] ? a1[t1++] : a2[t2++];
        }
    }
}
