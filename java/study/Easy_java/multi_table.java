public class multi_table{
  public static void main(String[] args) {
    for (int i = 1,j = 1;j <= 9;i++){
      System.out.print(i + "*" + j + "=" + i * j + "\t");
      if (i == j){
        i = 0;
        j++;
        System.out.println();
      }
    }
  }
}
//当输出语句为System.out.println()时输出后换行，语句为System.out.print时输出不换行
