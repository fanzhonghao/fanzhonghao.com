/* -------------------------------------------
 *  Author: fanzhonghao
 *  Date: 2017.06.02
 * -------------------------------------------
 *  Description:
 *      Define
 *  class Base{
 *  public:
 *      virtual void iam() {cout << "Base\n";}
 *  };
 *  Throw it derive two class and define iam()
 *  in them, also use it to put out the name
 *  of the class. Then create their objects
 *  and call it. After this, assign sub_class's
 *  ptr to the parent class's ptr, and use it
 *  to call iam() function.
 * -------------------------------------------
 */
#include<iostream>
using namespace std;
class Base
{
public:
    virtual void iam(){cout << "Base\n" ;}//virtual function
};
class First : public Base//public inherit
{
public:
    void iam() {cout << "First\n" ;}
};
class Second : public Base //public inherit
{
public:
    void iam() {cout << "Second\n" ;}
};
int main()
{
    Base a;
    First b;
    Second c; //construct a object
    a.iam();
    b.iam();
    c.iam();//call iam() function
    Base* ptr1 = &a;
    First* ptr2 = &b;
    Second* ptr3 = &c;
    ptr1 = ptr2; //put First's object's ptr to Base's ptr
    ptr1->iam(); //call
    ptr1 = ptr3;
    ptr1->iam();
    return 0;
}
