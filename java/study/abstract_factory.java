/* --------------------------------
 *  Date:2017.7.17
 * --------------------------------
 *  Description:
 *    This code is used to descript
 *  abstract factory pattern.
 * --------------------------------
 */
public class abstract_factory{
  public static void main(String[] args) {
    PropertyOfBook garden = ShowBooks.getProperty("计算机型");//传入参数调用方法获得实例
    Book bookname = garden.getBookName();
    Book author = garden.getAuthor();
    Book price = garden.getPrice();
    System.out.println("书的名字：" + bookname.getName());
    System.out.println("书的作者：" + author.getName());
    System.out.println("书的价格：" + price.getName());
  }
}
class Book{
  String name;
  public Book(String name){
    this.name = name;
  }
  public String getName(){
    return name;
  }
  public void setName(String name){
    this.name = name;
  }
}
abstract class PropertyOfBook{//书的属性
  public abstract Book getAuthor();
  public abstract Book getPrice();
  public abstract Book getBookName();
}
class Computer extends PropertyOfBook{
  public Book getAuthor(){
    return new Book("张三");
  }
  public Book getBookName(){
    return new Book("Java web");
  }
  public Book getPrice(){
    return new Book("88.00");
  }
}
class English extends PropertyOfBook{
  public Book getAuthor(){
    return new Book("小红");
  }
  public Book getBookName(){
    return new Book("English");
  }
  public Book getPrice(){
    return new Book("22.00");
  }
}
class Health extends PropertyOfBook{
  public Book getAuthor(){
    return new Book("李四");
  }
  public Book getBookName(){
    return new Book("人类长寿");
  }
  public Book getPrice(){
    return new Book("23.00");
  }
}
class ShowBooks{
  private static PropertyOfBook po;
  public static PropertyOfBook getProperty(String type){
    po = new Computer();//默认为计算机类
    if(type.equals("英语类"))
      po = new English();
    if(type.equals("健康类"))
      po = new Health();
    return po;
  }
}
