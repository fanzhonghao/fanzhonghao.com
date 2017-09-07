
import java.util.Date;

/**
 * Author:fan
 * Date: 17-9-3
 * Time: 下午9:10
 * Description:
 *  用反射的方法得到Class的属性
 */
public class ClassTest {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("第一种方法：Object.getClass()");
        Class c1 = new Date().getClass();
        System.out.println(c1.getName());
        System.out.println("第二种方法：class语法");
        Class c2 = boolean.class;//使用.class语法获得Class对象
        System.out.println(c2.getName());
        System.out.println("第三种方法：Class.forName()");
        Class c3  = Class.forName("java.lang.String");//ClassNotFoundException
        System.out.println(c3.getName());
        System.out.println("第四种方法：包装类的Type域");
        Class c4 = Double.TYPE;
        System.out.println(c4.getName());

    }
}
