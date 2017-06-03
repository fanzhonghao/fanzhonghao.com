/* -----------------------
 *  Author: fanzhonghao
 *  Date: 2017.06.03
 * -----------------------
 *  Description:
 *    count how many nums
 *  belong to which zero
 * -----------------------
 */
#include<iostream>
#include<stdio.h>
using namespace std;
struct zero{
    int min;
    int max;
    int no;//the num of zeros
};
class Histogram{
    int min,max,n;//the zero's min and max num
public:
    zero did[10];
    void init();
    Histogram(int a,int b,int c);
    int getmin();
    int getmax();
    void huafen();
    int count(int a[],int n);
    void print();
};
void Histogram::init()
{
  for (int i = 0;i < 10;i++)
    did[i].no = 0;
}
Histogram::Histogram(int a,int b,int c)
{
    min = a;
    max = b;
    n = c;
}
int Histogram::getmin()
{
    return min;
}
int Histogram::getmax()
{
    return max;
}
void Histogram::huafen()
{
    for(int i = 0;i < n;i++)
    {
        did[i].min = min + ((max - min) / n) * i;
        did[i].max = did[i].min + (max - min) / n;
    }
}
int Histogram::count(int a[],int n)
{
    for(int i = 0;i < n;i++)
    {
        if(a[i] < getmin() || a[i] > getmax()){cout<<"The num put in error!";return 0;}
        if(a[i] >= getmin() && a[i] <= did[0].max) {did[0].no++;continue;}
        for(int j = 1;j < n;j++)
        {
            if(a[i] > did[j].min && a[i] <= did[j].max){did[j].no++;continue;}
        }
    }
}
void Histogram::print()
{
    for(int i = 0;i < n;i++)
        cout<<did[i].min<<" ~ "<<did[i].max<<" : "<<did[i].no<<endl;
}
int main()
{
    int min,max,n;
    cout<<"Please put in min num : ";
    cin>>min;
    cout<<"Please put in max num : ";
    cin>>max;
    cout<<"Please put in how many segments : ";
    cin>>n;
    Histogram x(min,max,n);
    x.init();
    if((max - min) % n != 0) {cout<<"error!"<<endl; return 0;}
    x.huafen();
    int a[100];
    int num;
    cout<<"Please put in how many the nums :";
    cin>>num;
    cout<<"Please put in the nums of the area : "<<endl;
    for(int i = 0;i < num;i++)
        cin>>a[i];
    x.count(a,num);

    cout<<endl;
    x.print();
    return 0;
}
