/* ---------------------
 *  Author: fanzhonghao
 *  Date: 2017.06.03
 * ---------------------
 *  Description:
 *    calculate
 * ---------------------
 */
#include<iostream>
#include<stdio.h>
#include<stdlib.h>
using namespace std;
int calculate(string a);
int panduan(string a);
int chuli(string a,int b[],char c[]);
int jisuan(int a[], char b[], int n, int m);
class Expr{
    string expr;
public:
    Expr(const string a){expr = a;};
    int eval();//count
    void print(){cout << eval() << endl;};//print
};
int Expr::eval()
{
    return calculate(Expr::expr);
}
int calculate(string a)
{
    int biaoji = 0;//when biaoji = 1, the express is error
    biaoji = panduan(a);
    if(biaoji == 1) exit(1);

    int b[100];
    char c[100];
    int p = chuli(a,b,c);//divide a into num and cauculate char

    return jisuan(b,c,p+1,p);//cauculate
}
int jisuan(int a[], char b[], int n, int m)
{
	int i, j, p, q;
	for (i = 0; i < m; i++)
	{
		if (b[i] == '*' || b[i] == '/') {
			if (b[i] == '*'){
                    a[i+1] = a[i] * a[i + 1];
                    a[i] = 0;
                    if(i == 0) b[i] = '+';
                    else b[i] = b[i-1];
            }
			else {
                    if(a[i+1] == 0) {cout<<"����Ϊ"; return 0;}
                    a[i+1] = a[i] / a[i + 1];
                    a[i] = 0;
                    if(i == 0) b[i] = '+';
                    else b[i] = b[i-1];
            }

		}
	}
	for (i = 0; i < m; i++)
	{
		if (b[i] == '+') {
			a[i + 1] += a[i];
		}
		else a[i + 1] = a[i] - a[i+1];
	}

	return a[n - 1];
}
int chuli(string a,int b[],char c[])
{
    int d = 0,p = 0,q = 0;
    for(int i = 0;a[i] != '\0' && a[i] != ';';i++)
    {
        if(a[i] >= '0' && a[i] <= '9')
        {
            d = d*10 + a[i] - '0';
        }
        else {
            b[p++] = d;
            d = 0;
            c[q++] = a[i];
        }
    }
    b[p++] = d;
    return q;
}
int panduan(string a)
{
    int i = 0,j = 0;
    for(;a[i] != '\0' && a[i] != ';';i++)
    {
        if( !(a[i] >= '0' && a[i] <= '9')) j++;
        else j = 0;
        if(j == 2) return 1;
    }
    return 0;
}
int main()
{
    string a;
    cin >>  a;
    Expr x(a);
    x.print();
    return 0;
}
