import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Author:fan
 * Date: 17-9-28
 * Time: 下午9:58
 * Description:
 */
public class SynchronizationBarrier {
    public static void main(String[] args) {
        float[][] matrix = new float[3][3];
        int counter = 0;
        for (int row = 0;row < matrix.length;row++){
            for (int col = 0;col < matrix[0].length;col++)
                matrix[row][col] = counter++;
        }
        dump(matrix);//输出数组
        System.out.println();
        Solver solver = new Solver(matrix);
        System.out.println();
        dump(matrix);
    }
    static void dump(float[][] matrix){//输出数组
        for (int row = 0;row < matrix.length;row++){
            for (int col = 0;col < matrix[0].length;col++)
                System.out.println(matrix[row][col] + " ");
            System.out.println();
        }
    }
}
class Solver{
    final int n;
    final float[][] data;
    final CyclicBarrier barrier;

    class Worker implements Runnable{
        int myRow;
        boolean done = false;
        Worker(int row){
            myRow = row;
        }
        boolean done(){
            return done;
        }
        void processRow(int myRow){
            System.out.println("Processing row: " + myRow);
            for (int i = 0;i < n;i++){
                data[myRow][i] *= 10;
            }
            done = true;
        }
        @Override
        public void run() {
            while (!done()){
                processRow(myRow);
                try {
                    barrier.await();//等待，知道所有参与者都在同步屏障上调用了await()方法
                }catch (InterruptedException e){
                    return;
                }catch (BrokenBarrierException e){
                    return;
                }
            }
        }
    }
    public Solver(float[][] matrix){
        data = matrix;
        n = matrix.length;
        barrier = new CyclicBarrier(n, new Runnable() {
            @Override
            public void run() {
                mergeRows();
            }
        });
        for (int i = 0;i < n;i++){
            new Thread(new Worker(i)).start();
        }
        waitUntilDone();
    }
    void mergeRows(){
        System.out.println("merging");
        synchronized ("abc"){
            "abc".notify();
        }
    }
    void waitUntilDone(){
        synchronized ("abc"){
            try {
                System.out.println("main thread waiting");
                "abc".wait();
                System.out.println("main thread notified");
            }catch (InterruptedException e){
                System.out.println("main thread interrupted");
            }
        }
    }
}
