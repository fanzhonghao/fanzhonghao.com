#include<iostream>
using namespace std;
struct S
{
    int x,y;

};
struct T
{
    char *p;
    char *q;
};
class C : S,T
{
public:
    C(int a,int b,char *m,char *n)
    {
        x = a,y = b;
        p = m,q = n;
    }
    void print();
};
void C::print()
{
    cout << x << " " << y << " " << *p << " " << *q <<endl;
}
int main()
{
    char m = 'm',n = 'n';
    C a(1,2,&m,&n);
    a.print();
}
