/*
    Attention
*/
public class plusplus{
  public static void main(String[] args) {
    int j = 0;
    int k = 0;
    for(int i = 0;i < 100;i++){
      j = j++;
      k = ++k;
    }
    System.out.println("j = " + j);
    System.out.println("k = " + k);
  }
}
