/* ----------------------------
 *  Date:2017.7.6
 * ----------------------------
 *  Description:
 *    This instruction is used
 *  to exploer the usage of
 *  protected.
 * ----------------------------
 */
#include<iostream>
using namespace std;
class Base{
public:
  Base(){};
  virtual ~Base(){};
  int get(){return int_pro;}
protected:
  int int_pro;
};
class A : public Base{
public:
  A(){};
  A(int da){int_pro = da;}
  void Print(A &obj){obj.int_pro = 24;}
  void PrintPro(){cout << "The protected data is " << int_pro <<endl;}
};
int main(int argc, char const *argv[]) {
  A aobj;
  A aobj2(5);
  aobj2.PrintPro();
  aobj.Print(aobj2);
  aobj2.PrintPro();
  //以下不能运行
  //aobj.int_pro = 8;
  return 0;
}
