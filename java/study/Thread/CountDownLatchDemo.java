import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author:fan
 * Date: 17-9-28
 * Time: 下午9:14
 * Description:
 *  The startSignal stop any thread to
 *  execute before the main thread has
 *  been prepared. And the doneSignal
 *  will makes the main thread wait
 *  all threads have stopped.
 */
public class CountDownLatchDemo {
    final static int n = 3;

    public static void main(String[] args) {
        final CountDownLatch startSignal = new CountDownLatch(1);
        final CountDownLatch doneSignal = new CountDownLatch(n);
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    report("Entered run()");
                    startSignal.await();//wait until told to proceed
                    report("doing work");
                    Thread.sleep((int)(Math.random() * 1000));
                    doneSignal.countDown();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            private void report(String s){
                System.out.println(System.currentTimeMillis() + ": " + Thread.currentThread() + ": " + s);
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(n);
        for (int i = 0;i < n;i++){
            executorService.execute(r);
        }
        try {
            System.out.println("Main thread doing sth");
            Thread.sleep(1000);
            startSignal.countDown();    //let all threads proceed
            System.out.println("main thread doing sth else");
            doneSignal.await();
            executorService.shutdownNow();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
