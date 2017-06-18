public class char_decoding{
  public static void main(String[] args) throws Exception{
    //ISO8859-1拉丁文
    System.out.println("ISO8859-1 字符集与gb2312之间的转换：");
    String str = new String("大家好".getBytes("gb2312"),"ISO8859-1");
    //将gb2312字符集转码为ISO8859-1字符集
    String str1 = new String(str.getBytes("ISO8859-1"),"gb2312");
    //将ISO8859-1字符集转码为gb2312字符集
    System.out.println("ISO8859-1字符集：" + str + "\ngb2312字符集：" + str1);
    //KOI8俄文
    System.out.println("\nKOI8字符集与gb2312之间的转换");
    String str2 = new String("你好".getBytes("gb2312"),"KOI8");
    //将gb2312字符集转码为KOI8字符集
    String str3 = new String(str2.getBytes("KOI8"),"gb2312");
    //将KOI8字符集转码为gb2312字符集
    System.out.println("KOI8字符集：" + str2 + "\ngb2312字符集：" + str3);
  }
}
