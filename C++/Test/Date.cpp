/* ---------------------------------
 *  Author:fan
 *  Date:2017.7.7
 * ---------------------------------
 *  Description:
 *    This instruction is used
 *  to implement a class hierarchy
 *  whit Date as the base class with
 *  a virtual method print().
 * ---------------------------------
 */
#include<iostream>
using namespace std;
class Date{
  int year,month,day;
public:
  int get_year() {return year;}
  int get_month() {return month;}
  int get_day() {return day;}
  Date(int a,int b,int c) {
    year = a;
    month = b;
    day = c;
  }
  virtual void print(){
    cout << month << "-" << day << "-" << year <<endl;
  }
};
class EurDate : public Date{
public:
  EurDate(int a,int b,int c) : Date(a,b,c) {}
  void print() {
    cout << get_day() << "-" << get_month() << "-" << get_year() <<endl;
  }
};
class ChsDate : public Date{
public:
  ChsDate(int a,int b,int c) : Date(a,b,c) {}
  void print() {
    cout << get_year() << "年" << get_month() << "月" << get_day() << "日" <<endl;
  }
};
int main(int argc, char const *argv[]) {
  Date *dp[3];
  dp[0] = new Date(2007,7,5);
  dp[1] = new EurDate(2007,7,5);
  dp[2] = new ChsDate(2007,7,5);
  for(int i = 0;i < 3;i++){
    dp[i]->print();
    delete dp[i];
  }
  return 0;
}
