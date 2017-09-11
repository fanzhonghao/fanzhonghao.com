
/**
 * Date: 17-9-11
 * Time: 下午6:24
 * Description:
 */
public class applyWasteClear {
    public static void main(String[] args) {
        //获得该应用程序的Runtime对象
        Runtime rt = Runtime.getRuntime();
        //打印当前JVM使用的总内存存量与可使用内存量
        System.out.println("当前JVM使用的总内存量为：" + rt.totalMemory());
        //申请垃圾收集器运行
        System.gc();
        //休眠主线程，提高申请垃圾收集器运行的成功率
        try {
            Thread.sleep(100);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("创建10000000个垃圾对象前JVM中可使用的内存量为：" + rt.freeMemory());
        //创建10000000个“垃圾”对象
        for (int i = 0;i < 10000000;i++){
            new java.lang.String("Rubbish");
        }
        System.out.println("创建10000000个垃圾对象后JVM中可使用的内存量为：" + rt.freeMemory());
        System.gc();
        try {
            Thread.sleep(100);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("申请垃圾收集器运行后JVM中可使用的内存量为：" + rt.freeMemory());
    }
}
