/**
 * Date: 17-9-11
 * Time: 下午6:38
 * Description:
 */
class Rubbish{
    Rubbish brother;//定义对自身的引用
    String rname;
    public Rubbish(){

    }
    public Rubbish(String rname){
        this.rname = rname;
    }
    public void finalize(){//在回收前被调用
        System.out.println(this.rname + "对象成为垃圾，并被收集");
    }
}
public class wasteNotThread {
    public static void main(String[] args) {
        Rubbish r1 = new Rubbish("孤岛1");
        Rubbish r2 = new Rubbish("孤岛2");
        Rubbish r3 = new Rubbish("孤岛3");
        //让三个对象引用形成一个环
        r1.brother = r2;
        r2.brother = r3;
        r3.brother = r1;
        //断绝环与外界的联系，形成孤岛
        r1 = null;
        r2 = null;
        r3 = null;
        System.gc();
        try {
            //主线程休眠，提高申请成功的机会
            Thread.sleep(100);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
