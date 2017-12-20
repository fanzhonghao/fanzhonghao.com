import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author:fan
 * Date: 17-10-5
 * Time: 下午7:15
 * Description:
 *  重入锁
 */
public class ReenTrantLockDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        final ReentrantLock lock = new ReentrantLock();

        class Worker implements Runnable{
            private final String name;
            Worker(String name){
                this.name = name;
            }

            @Override
            public void run() {
                lock.lock();//获得锁
                try {
                    if (lock.isHeldByCurrentThread())//判断锁是否由当前线程持有
                        System.out.printf("Thread %s entered critical section. %n",name);
                    System.out.printf("Thread %s performing work. %n",name);
                    try {
                        Thread.sleep(2000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.printf("Thread %s finished working. %n",name);
                }finally {
                    lock.unlock();//释放锁
                }
            }
        }
        executorService.execute(new Worker("Thread A"));
        executorService.execute(new Worker("Thread B"));
        try {
            executorService.awaitTermination(5, TimeUnit.SECONDS);//线程池等待5秒
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        executorService.shutdownNow();//线程池关闭
    }
}
