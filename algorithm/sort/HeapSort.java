package algorithms;

import java.util.Random;

/**
 * ----------------------
 *
 * @Author:fan
 * @Date: 18-3-20
 * Description:
 * <p>堆排序
 * -----------------------
 */
public class HeapSort {
    private int[] array = new int[100];
    private int size;//保存未排序的数组大小
    public HeapSort(){
        Random r= new Random();
        for (int i = 0;i < 100;i++)
            array[i] = r.nextInt(1000);
        size = 100;
    }

    public static void main(String[] args) {
        HeapSort h = new HeapSort();
        h.createHeap();
        for (;h.size > 0;){
            h.change(0,h.size-1);
            h.size--;
            h.keepHeap(0);
        }
        for (int i = 0;i < 100;i++)
            System.out.print(h.array[i] + "\t");
    }
    /*
    创建堆
     */
    void createHeap(){
        for (int i = (size-1)/2;i >= 0;i--)
            keepHeap(i);
    }
    /*
    向下保持大顶堆
     */
    void keepHeap(int num){
        int maxSite = num;//最大元素的位置
        if (array[maxSite] < array[2*num+1]){
            maxSite = 2*num+1;
        }
        if (2*num+2 < size){
            if (array[maxSite] < array[2*num+2])
                maxSite = 2*num+2;
        }
        if (maxSite != num){
            change(num,maxSite);
            if(maxSite <= (size - 2) / 2)
            keepHeap(maxSite);
        }
    }
    /*
    交换大小数组中元素的位置
     */
    void change(int small,int big){
        int temp = array[small];
        array[small] = array[big];
        array[big] = temp;
    }
}

