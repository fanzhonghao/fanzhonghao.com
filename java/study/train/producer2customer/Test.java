/**
 * Author:fan
 * Date: 17-9-8
 * Time: 下午4:55
 * Description:
 *      实现生产者与消费者，没有同步的状态和同步之后的状态
 * 其中Box表示未同步，Box2表示同步
 */
public class Test {
    public static void main(String[] args) {
        Box2 produce = new Box2();
        Producer p = new Producer(produce,"Producer");
        Customer c = new Customer(produce,"Customer");
        p.start();
        c.start();
    }
}
