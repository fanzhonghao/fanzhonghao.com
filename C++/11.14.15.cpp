/*  -----------------------
 *  Author : fanzhonghao
 *  Date : 2017.5.23
 *  -----------------------
 *      Define a type Vec4
 *  as a vector of four
 *  floats.
 *  -----------------------
 */

#include<iostream>
using namespace std;
class Vec4{
public:
    float data[4];
    Vec4(float a[]);
    float operator[](int);          //取值
    void operator+(Vec4);           //相加
    void operator-(Vec4);           //相减
    void operator*(Vec4);           //相乘
    void operator/(Vec4);           //相除
    void operator=(float a[]);      //赋值
    void operator+=(Vec4);          //相加并赋值
    void operator-=(Vec4);          //相减并赋值
    void operator*=(Vec4);          //相乘并赋值
    void operator/=(Vec4);


    void operator+(float);          //相加
    void operator-(float);          //相减
    void operator*(float);          //相乘
    void operator/(float);          //相除
    void operator+=(float);         //相加并赋值
    void operator-=(float);         //相减并赋值
    void operator*=(float);         //相乘并赋值
    void operator/=(float);         //相除并赋值
    void operator=(float a);        //赋值

    void print();                   //输出
};
Vec4::Vec4(float a[])
{
    for(int i = 0;i < 4;i++)
    {
        data[i] = a[i];
    }
}
float Vec4::operator[](int a)
{
    return data[a];
}
void Vec4::operator+(Vec4 a)
{

    for(int i = 0;i < 4;i++)
        cout << data[i] + a[i] << "\t";
    cout << endl;
}
void Vec4::operator-(Vec4 a)
{
    for(int i = 0;i < 4;i++)
        cout << data[i] - a.data[i] << "\t";
    cout << endl;
}
void Vec4::operator*(Vec4 a)
{
    for(int i = 0;i < 4;i++)
        cout << data[i] * a.data[i] << "\t";
    cout << endl;
}
void Vec4::operator/(Vec4 a)
{
    for(int i = 0;i < 4;i++)
        cout << data[i] / a.data[i] << "\t";
    cout << endl;
}
void Vec4::operator=(float a[])
{
    for(int i = 0;i < 4;i++)
        data[i] = a[i];
}
void Vec4::operator+=(Vec4 a)
{
    for(int i = 0;i < 4;i++)
        data[i] += a.data[i];
}
void Vec4::operator-=(Vec4 a)
{
    for(int i = 0;i < 4;i++)
        data[i] -= a.data[i];
}
void Vec4::operator*=(Vec4 a)
{
    for(int i = 0;i < 4;i++)
        data[i] *= a.data[i];
}
void Vec4::operator/=(Vec4 a)
{
    for(int i = 0;i < 4;i++)
        data[i] /= a.data[i];
}
void Vec4::operator+(float a)
{
    for (int i = 0;i < 4;i++)
        cout << data[i] + a << "\t";
    cout << endl;
}
void Vec4::operator-(float a)
{
    for(int i = 0;i < 4;i++)
        cout << data[i] - a << "\t";
    cout << endl;
}
void Vec4::operator*(float a)
{
    for(int i = 0;i < 4;i++)
        cout << data[i] * a << "\t";
    cout << endl;
}
void Vec4::operator/(float a)
{
    for(int i = 0;i < 4;i++)
        cout << data[i] / a << "\t";
    cout <<endl;
}
void Vec4::operator+=(float a)
{
        for(int i = 0;i < 4;i++)
            data[i] += a;
}
void Vec4::operator-=(float a)
{
        for(int i = 0;i < 4;i++)
            data[i] -= a;
}
void Vec4::operator*=(float a)
{
        for(int i = 0;i < 4;i++)
            data[i] *= a;
}
void Vec4::operator/=(float a)
{
        for(int i = 0;i < 4;i++)
            data[i] /= a;
}
void Vec4::print()
{
    for(int i = 0;i < 4;i++)
        cout << data[i] << "\t";
    cout << endl;
}
int main()
{
    float data[4],data2[4];
    cout << "Please enter four numbers : ";
    for(int i = 0;i < 4;i++)
        cin>>data[i];
    cout << "Please enter four numbers : ";
    for(int i = 0;i < 4;i++)
        cin>>data2[i];
    Vec4 a(data);
    Vec4 b(data2);
    cout << "a = ";
    a.print();
    cout<< "b = ";
    b.print();
    cout << "a + b = "<<endl;
    a + b;

    cout << "a + 10.0 = "<<endl;
    a + 10.0;

    cout<< "b - 10.0 = "<<endl;
    b - 10.0;

    cout << "a * b = "<<endl;
    a * b;

    cout << "b * 10 = "<<endl;
    b * 10;

    a = data;
    b = data2;
    cout << "a / b = "<<endl;
    a / b;

    cout<< "b / 10 = "<<endl;
    b / 10;

    cout<< "a += b ; a = "<<endl;
    a += b;
    a.print();
    cout<< "b += 10.0 ; b = "<<endl;
    b += 10.0;
    b.print();

    a = data;
    b = data2;
    cout<< "a *= b ; a = "<<endl;
    a *= b;
    a.print();
    cout<< "b /= 10.0 ; b = "<<endl;
    b /= 10.0;
    b.print();
}
