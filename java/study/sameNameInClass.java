/* -----------------------------
 *  Date:2017.7.17
 * -----------------------------
 *  Description:
 *    This code is used to
 *  descript how to visit the
 *  cases which have functions'
 *  that have same names.
 * -----------------------------
 */
public class sameNameInClass{
  public static void main(String[] args) {
    System.out.println("在继承关系中，同名变量的覆盖与隐藏的执行内容如下：");
    ChildClass child = new ChildClass();
    System.out.println("创建了ChildClass对象，ChildClass的属性信息如下：");
    System.out.println("name: " + child.name + "; age: " + child.age + "; kind: " + child.classvar);
    //此时得到的都是ChildClass类的变量值
    //将ChildClass类型转换成ParentClass对象
    ParentClass parent = child;
    System.out.println("将创建的ChildClass对象赋值给ParentClass对象，其属性信息如下：");
    System.out.println("name: " + parent.name + "; age: " + parent.age + "; kind: " + parent.classvar);
    //此时得到的都是ParentClass类的变量值
    System.out.println("子类可以访问父类被隐藏的实例变量 name: " + child.getParentName());
    System.out.println("子类可以访问父类被隐藏的实例变量 age: " + child.getParentAge());
    System.out.println("子类可以访问父类被隐藏的静态变量 kind: " + ChildClass.getParentKind());
    System.out.println();
    //测试继承时方法的覆盖与隐藏问题
    System.out.println("在继承关系中，同名方法的覆盖与隐藏的执行内容如下：");
    child.getName();//实例方法
    child.getClassVar();//静态方法
    parent.getName();//实例方法
    parent.getClassVar();//静态方法
  }
}
class ParentClass{
  public static String classvar = "sameNameInClass.Interitance.ParentClass";//类变量，ParentClass的类别
  public static int age = 50;
  public String name = "ParentClass";
  public static String getClassVar(){
    //静态方法中操作的只有类变量
    System.out.println("ParentClass的getClassVar()方法被调用！");
    return classvar;
  }
  public static int getAge(){
    System.out.println("ParentClass的getAge()方法被调用！");
    return age;
  }
  public String getName(){
    System.out.println("ParentClass的getName()方法被调用！");
    return this.name;
  }
  //final方法，将ParentClass的减1
  public final int getPreviousAage(){
    System.out.println("ParentClass的getPreviousAage()方法被调用！");
    return --age;
  }
}
class ChildClass extends ParentClass{
  public static String classvar = "sameNameInClass.Interitance.ChildClass";
  public int age = 25;//实例变量
  public String name = "ChildClass";//实例变量
  //静态方法
  public static String getClassVar(){
    System.out.println("ChildClass的getClassVar()方法被调用！");
    return classvar;
  }
  public static String getParentKind(){
    return ParentClass.classvar;
  }
  //实例方法
  public String getName(){
    System.out.println("ChildClass的getName()方法被调用！");
    return this.name;
  }
  public String getParentName(){
    return super.name;
  }
  public String getParentAge(){
    return super.name;
  }
}
