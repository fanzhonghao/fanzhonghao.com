/* -------------------------------
 *  Author:fan
 *  Date:2017.6.28
 * -------------------------------
 *  Description:
 *    This instruction is used to
 *  descript the copy constructor.
 * -------------------------------
 */
#include<iostream>
using namespace std;
class A{
  int data;
public:
  A(int a) : data(a){}
  A (const A& a){*this = a;}
  void print(){
    cout << data <<endl;
  }
};
int main(int argc, char const *argv[]) {
  A a(3);
  A b(a);
  a.print();
  b.print();
  return 0;
}
