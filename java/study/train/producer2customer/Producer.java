/**
 * Author:fan
 * Date: 17-9-8
 * Time: 下午4:54
 * Description:
 */
public class Producer extends Thread{
    Box2 produce;
    private  String name;

    public Producer(Box2 produce,String name) {
        this.name = name;
        this.produce = produce;
    }

    @Override
    public void run() {
        for (int i = 0;i < 5;i++){
            produce.put(i);
            System.out.println("Producer: " + i);
            try {
                this.sleep((int)(Math.random() * 100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
