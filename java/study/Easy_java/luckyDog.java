/* --------------------------------
 *  Author:fan
 *  Date:2017.7.19
 * --------------------------------
 *  Description:
 *    This code is used to describe
 *  the use of list by solve the
 *  Joseph ring.
 * --------------------------------
 */
import java.util.List;
import java.util.Iterator;
import java.util.LinkedList;
public class luckyDog{
  public static void main(String[] args) {
    LinkedList lucky = new LinkedList();
    int number,cnt;
    for(number = 1;number <= 100;++number){
      lucky.addLast(number);
    }
    cnt = 100;
    number = 0;
    Iterator it = lucky.iterator();
    while(cnt > 1){
      if(it.hasNext()){//还有下一个元素
        it.next();//下一个
        ++number;
      }else{//已计数到尾部，置为头部
        it = lucky.iterator();
      }
      //删除
      if(number == 14){
        number = 0;
        it.remove();
        --cnt;
      }
    }
    System.out.println("幸运儿编号：" + lucky.element());
  }
}
