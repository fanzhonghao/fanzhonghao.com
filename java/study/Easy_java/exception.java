/* --------------------------
 *  Author:fan
 *  Date:2017.7.16
 * --------------------------
 *  Description:
 *    This code is used to
 *  explore catch exception.
 * --------------------------
 *  Attention:
 *    We can know when the
 *  error arise in try, the
 *  clause follow the error
 *  and before catch while
 *  skipped. And it will just
 *  execute one catch. But
 *  the finally will be
 *  executed.
 *    Obviously,the try...catch
 *  can nest.
 * --------------------------
 */
public class exception{
  public static void main(String[] args) {
    int array[] = {0,1,2,3,4,5,6};
    try{
      for(int i = 0;i < 10;i++)
      System.out.println("arry[" + i + "]=" + array[i]);
    }
    catch (ArrayIndexOutOfBoundsException e){
      System.out.println("array[]的长度是" + array.length + "，数组下标越界");
    }
    System.out.println("运行完毕");
  }
}
