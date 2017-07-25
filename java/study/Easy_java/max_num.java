import java.util.Random;
public class max_num{
  public static void main(String[] args) {
    int max = 0;
    int i = 0;
    int n1 = 0;
    System.out.println("随机生成的10个随机数如下：");
    do{
      n1 = (int) (Math.random() * 100);//0~99
      if (i == 0){
        max = n1;
      }else if (n1 > max){
        max = n1;
      }
      i++;
      System.out.print(n1 + "  ");
    }while(i < 10);
    System.out.println("\n最大值为：" + max);
  }
}
