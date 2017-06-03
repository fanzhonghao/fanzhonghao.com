#include<iostream>
#include<ctime>
#include<stdlib.h>
using namespace std;
struct Date{
    int year,month,day;
};
Date chu_shi;
int b[12] = {31,28,31,30,31,30,31,31,30,31,30,31};
int leap(int a)
{//»ÚƒÍ
    if (a%4 == 0 && a%100 != 0 || a%400 == 0) return 1;
    else return 0;
}
int jisuan(Date& a)
{
   // cout<<a.year<<" "<<a.month<<" "<<a.day;
    int days = 0;
    if(a.year < chu_shi.year) {cout<<endl<<"error"<<endl;exit(1);}
    for(;a.year > chu_shi.year;){
        if(leap(chu_shi.year) == 1) days += 366;
        else days += 365;
        chu_shi.year++;
    }

    if(leap(chu_shi.year) == 1) b[1] = 29;
    for(;a.month > chu_shi.month;){
        days += b[chu_shi.month-1];
        chu_shi.month++;
    }

    if(a.day > chu_shi.day){
        days += a.day-chu_shi.day;
    }
    return days;
}
void chu_shi_hua()
{
    chu_shi.year = 1970;
    chu_shi.month = 1;
    chu_shi.day = 1;
}
void timeto1970(Date time1)
{
    tm time;
    time.tm_mday = time1.day;
    time.tm_mon = time1.month;
    time.tm_year = time1.year - 1970;
    cout<<time.tm_year<<" "<<time.tm_mon<<" "<<time.tm_mday;
}
int main()
{
    Date time;
    chu_shi_hua();
    cin>>time.year>>time.month>>time.day;
    timeto1970(time);
    cout<<endl<<"days = "<<jisuan(time);
    return 0;
}
