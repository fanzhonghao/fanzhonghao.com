/**
 * Author:fan
 * Date: 17-9-28
 * Time: 下午8:07
 * Description:
 *  Through the ThreadLocal we can
 *  put different threads' some
 *  variates in a ThreadLocal's
 *  object. That is to say different
 *  threads can use a ThreadLocal's
 *  object.
 */
public class ThreadSlot {
    private static final ThreadLocal<String> id = new ThreadLocal<String>();

    public static void main(String[] args) {
        threadDoem th = new threadDoem();
        Thread first = new Thread(th);
        Thread second = new Thread(th);
        first.setName("First");
        second.setName("Second");
        first.start();
        second.start();

    }
    private static class threadDoem implements Runnable{
        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            if (name.equals("First")) id.set("the first thread");
            else id.set("the next thread");
            System.out.println(name + " " + id.get());
        }
    }
}
