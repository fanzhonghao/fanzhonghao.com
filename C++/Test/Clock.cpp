/* ---------------------------
 *  Author:fan
 *  Date:2017.7.7
 * ---------------------------
 *  Description:
 *    This instruction is uesd
 *  to create a class Clock
 *  that represents a time
 *  consists of an hour part
 *  and a minute part.
 * ----------------------------
 */
#include<iostream>
using namespace std;
class Clock{
  int hour,minute;
public:
  Clock(int a = 0,int b = 0) : hour(a),minute(b) {}
  void set_hour(int a){
    hour = a;
  }
  //: hour(a){}
  void set_minute(int a){
    minute = a;
  }
  //: minute(a){}
  int get_hour(){return hour;}
  int get_minute(){return minute;}
  void operator++();
  void operator-();
  void operator=(Clock);
  friend ostream& operator<<(ostream& os,const Clock& a){
    os << a.hour << ":" << a.minute;
    return os;
  }
};
void Clock::operator++(){
  minute++;
  if(minute == 60){
    minute = 0;
    hour++;
    if(hour == 24) hour = 0;
  }
}
void Clock::operator-(){
  minute--;
  if(minute == -1){
    minute = 59;
    hour--;
    if(hour == -1) hour = 23;
  }
}
void Clock::operator=(Clock a){
  set_hour(a.get_hour());
  set_minute(a.get_minute());
}

int main(int argc, char const *argv[]) {
  Clock c,d(23,59);
  cout << "Clock c is " << c <<endl;
  cout << "Clock d is " << d <<endl;

  ++d;
  c = d;
  //There can't use c = ++d; I don't know why cause it.
  cout << "-----------" <<endl;
  cout << "Clock c is " <<c <<endl;
  cout << "Clock d is " <<d <<endl;

  -c;
  Clock b(12,59);
  ++b;
  cout << "-----------" <<endl;
  cout << "Clock c is " << c <<endl;
  cout << "Clock b is " << b <<endl;
  return 0;
}
