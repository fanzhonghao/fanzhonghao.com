/*17*/
/*------------------------------------------------
*   Author: fan
*   Data: 2017/5/15
*-------------------------------------------------
*   Define two classes, each with a static member,
*   so that the construction of each static member
*   involves a reference to the other.
*-------------------------------------------------
*Description
*/
#include<iostream>
using namespace std;
class B;
class A{
public:
    static B b;
    int no;
    A(int a){
        no = a;
    };
};
class B{
public:
    static A a;
    int no2;
    B(int b){
        no2 = b;
    };
};
A Obj1(1);
B Obj2(2);
B A::b = Obj2;
A B::a = Obj1;
int main()
{
    cout << Obj1.no << endl;
    cout << A::b.no2 << endl;
    cout << Obj2.no2 << endl;
    cout << B::a.no << endl;
}
