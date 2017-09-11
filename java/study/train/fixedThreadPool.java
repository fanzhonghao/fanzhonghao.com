import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Date: 17-9-11
 * Time: 下午5:59
 * Description:
 */
class MyTask implements Runnable{
    private String tname;
    public MyTask(String tname){
        this.tname = tname;
    }

    @Override
    public void run() {
        System.out.println("\n=======任务" + tname + "开始执行=======");
        for (int i = 0;i < 50;i++){
            System.out.print("[" + tname + "_" + i + "]" + "\t");
            if (i%5 == 0 && i != 0) System.out.println();
        }
        System.out.println("\n=======任务" + tname + "执行结束=======");
    }
}
public class fixedThreadPool {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(2);//创建尺寸为2的线程池
        //创建三个任务对象
        MyTask mt1 = new MyTask("MT1");
        MyTask mt2 = new MyTask("MT2");
        MyTask mt3 = new MyTask("MT3");
        //启动
        threadPool.execute(mt1);
        threadPool.execute(mt2);
        threadPool.execute(mt3);
        threadPool.shutdown();//等任务结束后关闭线程池
    }
}
