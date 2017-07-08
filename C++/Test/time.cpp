/* ------------------------------------------
 *  Author:fan
 *  Date:2017.6.25
 * ------------------------------------------
 *    This instruction is
 *  used to implement the
 *  follow code:
 *  class Date{
 *    //...
 *  public:
 *    Date(int u = 1970,int m = 1;int d = 1);
 *    boolean isLeapYear(const Date d);
 *    void print();
 *  };
 * ------------------------------------------
 */
#include<iostream>
using namespace std;
class Date{
  int year,month,day;
public:
  Date(int,int,int);
  //构造函数为Date(int y=1970,int m=1,int d=1)时，错误
  //Date(int y,int m,int d);可以
  bool isLeapYear(const Date d);
  void print();
};
Date::Date(int y=1970,int m=1,int d=1){
  year = y;
  month = m;
  day = d;
}
bool Date::isLeapYear(const Date d){
  return (d.year % 4 == 0 && d.year % 100 != 0) || (d.year % 400 == 0);
}
void Date::print(){
  cout << year << "." << month << "." << day <<endl;
}
int main(int argc, char const *argv[]) {
  Date a;
  a.print();
  return 0;
}
