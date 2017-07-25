/* ----------------------------
 *  Date:2017.7.17
 * ----------------------------
 *  Description:
 *    This code is used to
 *  explore the use of this.
 * ----------------------------
 *  Attention:
 *    When we use one construct
 *  function to call another
 *  construct function, it just
 *  can call only one, and this
 *  must be written at the first
 *  line besides this just can be
 *  called at no_static function.
 * -----------------------------
 */
public class use_this{
  public static void main(String[] args) {
    Film f = new Film();
    System.out.println("今日为您推荐的影片如下：");
    System.out.println("片名：" + f.title);
    System.out.println("导演：" + f.director);
    System.out.println("主演：" + f.star);
    System.out.println("上映日期： " + f.showDate);
  }
}
class Film{
  String title;
  String director;
  String star;
  String showDate;
  Film(){
    this("2009年6月26日");//调用自身
  }
  Film(String showDate){
    this("《变形金刚》","迈克尔","希亚");
    this.showDate = showDate;
  }
  Film(String title,String director){
    this.title = title;
    this.director = director;
  }
  Film(String title,String director,String star){
    this(title,director);
    this.star = star;
  }
}
