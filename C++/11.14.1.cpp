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
    X(int);//���캯��
    X operator+(int);//����+
    X operator=(int);//����=
};
struct Y{
    int i;
    Y(X);
    Y operator+(X);//����+
    Y operator+(int);
    operator int();//Y��ת��Ϊint
    Y operator=(int);//����=
};
extern X operator*(X,Y);
extern int f(X);
X X::operator+(int a)
{//+����
    i += a;
    return *this;
}
X::X(int a)
{//���캯��
    i = a;
}
X X::operator=(int a)
{//����=
    i = a;
    return *this;
}

Y::Y(X a)
{//X�͸�ֵ��Y����
    i = a.i;
}
Y::operator int()
{//Y��תint
    return i;
}
int operator+(X a,Y b)
{//X����Y�����
    return a.i + b.i;
}
Y Y::operator+(X a)
{//Y����X�����
    i += a.i;
    return *this;
}
int operator+(Y a,Y b)
{//Y�����
    int c = b;
    return a + c;
}
Y Y::operator=(int a)
{//����=
    i = a;
    return *this;
}
Y Y::operator+(int a)
{//����+
    i += a;
    return *this;
}
int f(X a)
{//f������ֵ
    return a.i;
}
int f(Y a)
{//f������ֵ
    return a.i;
}
X operator*(X a,Y b)
{//X����Y�����
    a.i *= b.i;
    return a;
}
int operator*(int a,Y b)
{//int����Y�����
    return a * b.i;
}
int operator+(int a,Y b)
{//int����Y�����
    return b+a;
}
X x = 1;
Y y = x;
int i = 2;
void reset()
{//����
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
