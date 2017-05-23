/*  -----------------------
 *  Author : fanzhonghao
 *  Date : 2017.5.23
 *  -----------------------
 *        String��
 *  -----------------------
 */


#include<iostream>
using namespace std;
class String{
    struct Srep;           //��ʾ
    Srep *rep;
public:
    class Cref;           //����char
    class Range{};       //�����쳣
};
struct String::Srep{
    char* s;                //��Ԫ�ص�ָ��
    int sz;                 //�ַ�����
    int n;                  //���ü���
    Srep(int nsz, const char* p)
    {
        n = l;
        sz = nsz;
        s = new char[sz+l]; //Ϊ���������ӿռ�
        strcpy(s,p);
    }
    ~Srep(){delete[] s; }
    Srep* get_own_copy()    //��Ҫʱ��¡
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
private:                    //��ֹ����
    Srep(const Srep&);
    Srep& operator=(const Srep&);
};
int main()
{
    return 0;
}
