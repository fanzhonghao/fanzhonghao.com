import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Date: 17-9-9
 * Time: 上午11:58
 * Description:
 *      定时器定时执行任务
 */
public class TimerThread {
    public static void main(String[] args) {
        Timer timer = new Timer();//创建定时器类
        TimerTask tt1 = new MyTask(1);
        timer.schedule(tt1,200);//0.2秒后执行任务
        TimerTask tt2 = new MyTask(2);
        timer.schedule(tt2,500,1000);//0.5秒后每隔1秒执行一次
        TimerTask tt3 = new MyTask(3);
        Date date = new Date(System.currentTimeMillis() + 1000);
        timer.schedule(tt3,date);//在指定时间1秒后执行任务
        try {
            Thread.sleep(3000);//休眠3秒
        }catch (InterruptedException e){
            System.out.println("出现错误： " + e.getMessage());
        }
        timer.cancel();//终止定时器取消定时器中的任务
        System.out.println("任务定时器已经取消");
    }
}
class MyTask extends TimerTask{
    private int taskID = 0;//任务编号
    public MyTask(int id){
        this.taskID = id;
    }

    @Override
    public void run() {
        System.out.println("开始执行第" + this.taskID + "个任务，执行时间为： " + new Date().toLocaleString());
    }
}
