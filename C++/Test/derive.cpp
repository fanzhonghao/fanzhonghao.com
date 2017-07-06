/* ---------------------------
 *  Author:fan
 *  Date:2017.7.6
 * ---------------------------
 *  Description:
 *    This instruction is used
 *  to explore the way of
 *  writing of derive class.
 * ---------------------------
 */
#include<iostream>
using namespace std;
class Base{
  int x;
public:
  Base(int xx){x = xx;}
};
class sub : public Base{
  const char c;
  sub(int x1,char c1) : c(c1),Base(x1){}
};
class sub2 : public Base{
  const char c;
  sub2(int x2,char d1) : Base(x2),c(d1) {
    //c = d1;此处写法错误，因为c为常量，不能在函数中更该？
  }
};
class sub3 : public Base{
  const char c;
  sub3(int x3,char e1) : Base(x3),c(e1){
    //x = x3;派生类不能访问父类隐私项
  }
};
/*class sub4 : public Base{
  const char c;
  sub4(int x4,char f1) : c(f1){}
};*/  //错误，生成对象时首先调用父类的构造函数，因此要定义父类是怎样构造的。
int main(int argc, char const *argv[]) {
  return 0;
}
