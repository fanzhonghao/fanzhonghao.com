/* -------------------------
 *    This code is used to
 *  print calendar.
 * -------------------------
 */
import java.util.Scanner;
public class print_calendar{
  static int year, weekDay;
  public static boolean isLeapYear(int year){//judge whether it is a leap year
    return ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0));
  }
  public static int firstWeekDayOfYear(int year){//calculate what day is the first day of the year
    long day = year * 365;
    for(int i = 1; i < year;i++){
      if(isLeapYear(i)){
        day += 1;
      }
    }
    return (int) day % 7;
  }
  public static int getMonthOfDays(int month){
    switch (month){
      case 1: case 3: case 5: case 7: case 8: case 10: case 12:
          return 31;
      case 4: case 6: case 9: case 11: return 30;
      case 2:
          return isLeapYear(year) ? 29 : 28;
      default:
          return 0;
    }
  }
  public static void showMonths(){
    for(int m = 1;m <= 12;m++){
      System.out.println(m + "月");
      System.out.println("Sunday Monday Tuesday Wednesday Thursday Friday Saturday");
      for(int j = 1;j <= weekDay;j++){
        System.out.print("        ");
      }
      int monthDay = getMonthOfDays(m);
      for(int d = 1;d <= monthDay;d++){
        if(d < 10)
            System.out.print("  " + "0" + d + "    ");
        else
            System.out.print("  " + d + "    ");
        weekDay = (weekDay + 1) % 7;
        if (weekDay == 0)
            System.out.println();
      }
      System.out.println();
    }
  }
  public static void main(String[] args) throws Exception {
    System.out.print("Please enter the year：");
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    year = Integer.parseInt(str);//将整型对象Integer转换为int型
    weekDay = firstWeekDayOfYear(year);
    System.out.println("\n         " + year + "年       ");
    showMonths();
  }
}
