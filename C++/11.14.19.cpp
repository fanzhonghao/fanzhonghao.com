/* ----------------------
 *  Author : fan
 *  Data : 2017.05.30
 * ----------------------
 *  Description :
 *    This complete class
 *  Ptr_to_T and test it
 * ---------------------- 
 */
#include <iostream>
#include<stdlib.h>
#define T int
using namespace std;
class Ptr_to_T{
  T* p;
  T* array;
  int size;
public:
  Ptr_to_T(T* p,T* v,int s);        //约束到大小为s的数组v,初始值为p
  Ptr_to_T(T* p);                   //约束到单个对象，初始值为p

  Ptr_to_T& operator++();           //前缀
  Ptr_to_T operator++(int);         //后缀

  Ptr_to_T& operator--();           //前缀
  Ptr_to_T operator--(int);         //后缀

  T& operator*();                  //前缀
  T* operator->();
  T check();                       //检查越界
  void operator=(Ptr_to_T&);
};
void Ptr_to_T::operator=(Ptr_to_T& a)
{
    p = a.p;
    array = a.array;
    size = a.size;
}
Ptr_to_T::Ptr_to_T(T* p,T* v,int s)
{
  p = p;
  array = v;
  size = s;
}
Ptr_to_T::Ptr_to_T(T* p)
{
    p = p;
    array = p;
    size = 1;
}
T Ptr_to_T::check()
{
    if (p < array || p >= array + size)
    {
        cout << "over boundary" <<endl;
        return 1;
    }
    return 0;
}
Ptr_to_T& Ptr_to_T::operator++()
{
    p++;
    if(check())
    {
        p--;
        return *this;
    }
    return *this;
}
Ptr_to_T Ptr_to_T::operator++(int)
{
    p++;
    if(check())
    {
        p--;
        return *this;
    }
    return *this;
}
Ptr_to_T& Ptr_to_T::operator--()
{
    p--;
    if(check())
    {
        p++;
        return *this;
    }
    return *this;
}
Ptr_to_T Ptr_to_T::operator--(int)
{
    p--;
    if(check())
    {
        p++;
        return *this;
    }
    return *this;
}
T& Ptr_to_T::operator*()
{
    check();
    return *p;
}
T* Ptr_to_T::operator->()
{
    check();
    return p;
}
int main(int argc, char const *argv[]) {
    T p,v[20],a;
    Ptr_to_T b(&p,v,a);
    b++;
    b--;
    Ptr_to_T c(&a);
    b = c;
    ++b;
    --b;
    *b = a;

    return 0;
 }
