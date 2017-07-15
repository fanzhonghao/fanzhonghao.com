/* ------------------------
 *  Author:fan
 *  Date:2017.6.20
 * ------------------------
 *  Description:
 *    This instruction is
 *  used to implement the
 *  class IntArray.
 * ------------------------
 */
#include<iostream>
using namespace std;
class IntArray{
  int* pa;
  int sz;
public:
  IntArray(int);
  IntArray(IntArray&);
  ~IntArray();
  void operator++(int);
  int* operator[](int);
};
IntArray::IntArray(int a){
  sz = a;
  pa = new int[sz];
}
IntArray::IntArray(IntArray& a){
  sz = a.sz;
  *this = a;
}
IntArray::~IntArray(){
  if(*pa)
  delete [] pa;
}
void IntArray::operator++(int){
  int* p = new int(3);
  int* q = pa;
  *p = *q + 1;
  p++;
  q++;
  *p = *q + 1;
  p++;
  q++;
  *p = *q + 1;
  p = p - 2;
  pa = p;
}
int* IntArray::operator[](int a)
{
  int* s;
  s = pa;
  for(int i = 0;i < a;i++)
  {
    s++;
  }
  return s;
}
int main(int argc, char const *argv[]) {
  IntArray ia(3),ib(ia);
  for(int i = 0;i < 3;i++)
  {
    *(ia[i]) = i+5;
  }
  ib++;
  for(int j = 0;j < 3;j++)
  {
    cout << *(ia[j]) << "  ";
  }
  cout <<endl;
  for(int k = 0;k < 3;k++)
  {
    cout << *(ib[k]) << "  ";
  }
  cout << endl;
  return 0;
}
