/**
 * Author:fan
 * Date: 17-9-8
 * Time: 下午4:54
 * Description:
 */
public class Customer extends Thread {
    Box2 produce;
    private String name;

    public Customer(Box2 produce,String name){
        this.name = name;
        this.produce = produce;
    }
    @Override
    public void run() {
        for (int i = 0;i < 5;i++){
            if (produce != null) System.out.println(name + ": " + produce.get());

            try {
                sleep((int)(Math.random() * 100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
