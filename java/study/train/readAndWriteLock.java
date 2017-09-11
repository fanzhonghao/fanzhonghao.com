import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Date: 17-9-11
 * Time: 下午6:10
 * Description:
 */
class MyResource{
    // 读/写锁对象成员
    public ReadWriteLock lock = new ReentrantReadWriteLock(false);
    //被读/写资源
    private String msg = "init";

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
//进行读/写任务的用户类
class MyUser implements Runnable{
    private String uname;
    //任务功能号 0-读 1-写
    private int functionCode;
    //写任务要写的内容
    private String msg;
    //要访问的资源
    private MyResource mr;

    public MyUser(String uname,int functionCode,String msg,MyResource mr){
        this.uname = uname;
        this.functionCode = functionCode;
        this.msg = msg;
        this.mr = mr;
    }

    @Override
    public void run() {
        if (functionCode == 0){
            //读任务
            try {
                //获取读锁
                mr.lock.readLock().lock();
                System.out.println(uname + "用户成功操作，读出内容为：" + mr.getMsg());
                Thread.sleep(2000);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                mr.lock.readLock().unlock();//释放读锁
            }
        }else {//写锁
            try {
                mr.lock.writeLock().lock();
                mr.setMsg(msg);
                System.out.println(uname + "用户成功进行写操作，写入内容为：" + mr.getMsg());
                Thread.sleep(2000);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                mr.lock.writeLock().unlock();
            }
        }
    }
}
public class readAndWriteLock {
    public static void main(String[] args) {
        MyResource mr = new MyResource();
        ExecutorService threadPool = Executors.newFixedThreadPool(4);//创建线程池
        threadPool.execute(new MyUser("User1",0,null,mr));
        threadPool.execute(new MyUser("User2",0,null,mr));
        threadPool.execute(new MyUser("User3",1,"Hello World",mr));
        threadPool.shutdown();

    }
}
