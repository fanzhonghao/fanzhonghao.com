/* -----------------------------------
 *  Author:fan
 *  Date:2017.5.22
 * ------------------------------------
 *    In the following program, which
 *  conversion are used in each express?
 *    struct X{
 *       int i;
 *       X(int);
 *       X operator+(int);
 *       };
 *    struct Y{
 *       int i;
 *       Y(X);
 *       Y operator+(X);
 *       operator int();
 *       };
 *    extern X operator*(X,Y);
 *    extern int f(X);
 *    X x = 1;
 *    Y y = x;
 *    int i = 2;
 *    int main()
 *    {
 *       i + 10; y + 10; y + 10 * y;
 *       x + y + i; x * x + i; f(7);
 *       f(y); y + y; 106 + y;
 *    }
 *    Modify the program so that it will
 *  run and print the values of each
 *  legal expression.
 * ------------------------------------
 */


#include<iostream>
using namespace std;
struct Y;
struct X{
    int i;
    X(int);//构造函数
    X operator+(int);//重载+
    X operator=(int);//重载=
};
struct Y{
    int i;
    Y(X);
    Y operator+(X);//重载+
    Y operator+(int);
    operator int();//Y型转换为int
    Y operator=(int);//重载=
};
extern X operator*(X,Y);
extern int f(X);
X X::operator+(int a)
{//+重载
    i += a;
    return *this;
}
X::X(int a)
{//构造函数
    i = a;
}
X X::operator=(int a)
{//重载=
    i = a;
    return *this;
}

Y::Y(X a)
{//X型赋值给Y对象
    i = a.i;
}
Y::operator int()
{//Y型转int
    return i;
}
int operator+(X a,Y b)
{//X型与Y型相加
    return a.i + b.i;
}
Y Y::operator+(X a)
{//Y型与X型相加
    i += a.i;
    return *this;
}
int operator+(Y a,Y b)
{//Y型相加
    int c = b;
    return a + c;
}
Y Y::operator=(int a)
{//重载=
    i = a;
    return *this;
}
Y Y::operator+(int a)
{//重载+
    i += a;
    return *this;
}
int f(X a)
{//f函数赋值
    return a.i;
}
int f(Y a)
{//f函数赋值
    return a.i;
}
X operator*(X a,Y b)
{//X型与Y型相乘
    a.i *= b.i;
    return a;
}
int operator*(int a,Y b)
{//int型与Y型相乘
    return a * b.i;
}
int operator+(int a,Y b)
{//int型与Y型相加
    return b+a;
}
X x = 1;
Y y = x;
int i = 2;
void reset()
{//重置
    x = 1;
    y = x;
    i = 2;
}
int main()
{

    cout<<"i + 10 = "<<i+10<<endl;
    reset();
    cout<<"y + 10 = "<<y+10<<endl;
    reset();
    cout<<"y + 10 * y = "<<y+10*y<<endl;
    reset();
    cout<<"x + y + i = "<<x+y+i<<endl;
    reset();
    cout<<"x + x + i = "<<x+x+i<<endl;
    reset();
    cout<<"f(7) = "<<f(7)<<endl;
    reset();
    cout<<"f(y) = "<<f(y)<<endl;
    reset();
    cout<<"y + y = "<<y+y<<endl;
    reset();
    cout<<"106 + y = "<<106+y<<endl;
    return 0;
}
