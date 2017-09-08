/**
 * Author:fan
 * Date: 17-9-8
 * Time: 下午6:56
 * Description:
 */
public class Box2 {
    private int a;
    private boolean flag = false;
    public Box2() {}
    public synchronized void put(int a){
        while (flag == true){
            try {
                //等待取走数据
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        this.a = a;
        flag = true;
        notifyAll();
    }

    public synchronized int get() {
        while (flag == false){
            try {
                //等待写入数据
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        flag = false;
        notifyAll();
        return a;
    }
}
