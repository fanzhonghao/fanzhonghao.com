/* ---------------
 *  Author:fan
 *  Date:2017.7.9
 * ---------------
 */
#include<iostream>
using namespace std;
class C{
  int value;
public:
  C(int v) :value(v) {}
  bool operator<(C& b){
    if(value < b.value) return true;
    return false;
  }
  int getValue() {return value;}
};
double getMin(double a,double b){
  cout <<"(double,double)" <<"\t";
  if(a < b) return a;
  else return b;
}
C getMin(C a,C b){
  cout << "(C , C)" <<"\t";
  if(a < b) return a;
  else return b;
}
int main(int argc, char const *argv[]) {
  C c1(-9),c2(90);
  cout << getMin(10,99) <<endl;
  cout << getMin(1.2,2.3) <<endl;
  cout << getMin(10,2.3) <<endl;
  cout << getMin(c1,2).getValue() <<endl;
  return 0;
}
/*
可见转换时先向基本类型转换，最后想自定义类型转换
*/
