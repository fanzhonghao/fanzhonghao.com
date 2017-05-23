/*  -----------------------
 *  Author : fanzhonghao
 *  Date : 2017.5.23
 *  -----------------------
 *        String类
 *  -----------------------
 */


#include<iostream>
using namespace std;
class String{
    struct Srep;           //表示
    Srep *rep;
public:
    class Cref;           //引用char
    class Range{};       //用于异常
};
struct String::Srep{
    char* s;                //到元素的指针
    int sz;                 //字符个数
    int n;                  //引用计数
    Srep(int nsz, const char* p)
    {
        n = l;
        sz = nsz;
        s = new char[sz+l]; //为结束符增加空间
        strcpy(s,p);
    }
    ~Srep(){delete[] s; }
    Srep* get_own_copy()    //需要时克隆
    {
        if (n == l) return this;
        n--;
        return new Srep(sz,s);
    }
    void assign(int nsz, const char* p)
    {
        if(sz != nsz){
            delete[] s;
            sz = nsz;
            s = new char[sz+l];
        }
        strcpy(s,p);
    }
private:                    //防止复制
    Srep(const Srep&);
    Srep& operator=(const Srep&);
};
int main()
{
    return 0;
}
