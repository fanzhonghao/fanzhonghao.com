/* -------------------------------
 *  Author:fan
 *  Date:2017.6.28
 * -------------------------------
 *  Description:
 *    This instruction is used
 *  to identity the sequence of
 *  the construction of subclass's
 *  object and some functions to
 *  realize it.
 * -------------------------------
 */
#include<iostream>
using namespace std;
class A{
  int data;
public:
  A(){cout << "A" <<endl;}
  A(int a) : data(a) {}
};
class B : public A{
public:
  B(int a){cout << "B" << endl;}
};
class C{
public:
  C(int a){cout << "C" <<endl;}
};
class D :public C{
public:
  D(int a):C(a)
  {cout << "D" <<endl;}
};
int main(int argc, char const *argv[]) {
  B b(3);
  D d(4);
  return 0;
}
