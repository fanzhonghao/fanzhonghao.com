/* ------------------------
 *  Author:fan
 *  Date:2017.7.9
 * ------------------------
 */
#include<iostream>
using namespace std;
class intnumber{
  int value;
public:
  intnumber(int value){this->value = value;}
  intnumber& operator*=(int v){value *= v;return *this;}
  friend void operator<<(ostream& outf,intnumber& n){outf<<n.value<<endl;}
};
template<class T> const char* cmp(T a,T b){return "<T>";}
const char* cmp(intnumber a,intnumber b) {return "<intnumber>";}
const char* cmp(intnumber a,int b) {return "<intnumber,int>";}
const char* cmp(float a,float b) {return "<float,float>";}
/*const char* cmp(int a,int b) {return "<int,int>";}*/
int main(int argc, char const *argv[]) {
  intnumber a(1),b(2);
  b*=10;
  cout << "b=" <<b;
  cout << cmp(a,b) <<endl;
  cout << cmp(a,0) <<endl;
  cout << cmp(1,0) <<endl;
  return 0;
}
/*
cout:
b=20
<intnumber>
<intnumber,int>
<T>
首先匹配的是精确匹配，之后是模板匹配，然后才是转化匹配
*/
