/* ---------------------------
 *  Date:2017.7.17
 * ---------------------------
 *  Description:
 *    Through this code we can
 *  know something about the
 *  inherit between classes.
 * ---------------------------
 */
public class inherit{
  public static void main(String[] args) {
    Car1 c = new Car1();
    System.out.println("第一辆汽车的详细信息如下：");
    System.out.println("生产厂家：" + c.produce);
    c.showColor();
    c.showModel();
    Car1 c1 = new Car1("银白色");
    System.out.println("\n第二辆车的详细信息如下：");
    System.out.println("生产厂家：" + c1.produce);
    c1.showColor();
    c1.showModel();
    Car1 c2 = new Car1("蓝色","卡车","天津一汽");
    System.out.println("\n第三辆汽车的详细信息如下：");
    System.out.println("生产厂家：" + c2.produce);
    c2.showColor();
    c2.showModel();
  }
}
class Car{
  String color;
  String model;
  public Car(){
    this.color = "红色";
    this.model = "轿车";
  }
  public Car(String color,String model){
    this.color = color;
    this.model = model;
  }
  public void showColor(){
    System.out.println("车的颜色：" + this.color);
  }
  public void showModel(){
    System.out.println("车的类型：" + this.model);
  }
}
class Car1 extends Car{//继承
  String produce;
  Car1(String color,String model,String produce){
    super(color,model);//调用父类的构造方法
    this.produce = produce;
  }
  Car1(String color){
    this.color = color;
    this.produce = "广州本田";
  }
  Car1(){
    this("黑色");
  }
}
