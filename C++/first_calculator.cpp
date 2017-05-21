#include<stdio.h>
#include<iostream>
using namespace std;
bool Zui_Qian(char a[],int n);
bool Kuo_Hao(char a[],int n);
int Chu_Li2(char a[],int n,int m);
int jisuan(int a[],char b[],int n,int m);
bool Biao_Da_Shi(char a[],int n)
{//判断表达式是否正确
    if(Zui_Qian(a,n) == 0) throw 1;//正确
    try{
        Kuo_Hao(a,n);
    }
    catch (int b){
        cout<<"括号不匹配";
    }
    return 0;

}
bool Zui_Qian(char a[],int n)
{//判断是否有前缀名，和等号前表达式是否正确
    char b[100];
    int i,j,no = 0,no2 = 0;
    for (i = 0; i < n;i++)
        if(a[i] == '=') break;
    if(i == n-1) return 1; //无前缀名
    //以下有前缀名
    for(j = 0;j < i;j++)
        if(a[j] == ' ') no++;
        i--;
    for(;i >= 0;i--)
    {
        if(a[i] == ' ') no2++;
        else break;
    }
    if(no2 != no) return 0;
    return 1;
}
bool Kuo_Hao(char a[],int n){
    int b[6]={0,0,0,0,0,0},i;
    for(i = 0;i < n;i++)
    {
        switch (a[i]){
            case '(': b[0]++; break;
            case '[': b[1]++; break;
            case '{': b[2]++; break;
            case ')': b[3]++; break;
            case ']': b[4]++; break;
            case '}': b[5]++; break;
        }
    }
    if(b[0] != b[3] || b[1] != b[4] || b[2] != b[5]) throw 0;
    return 1;
}
int Chu_Li(char a[],int n,int m){
//n表示数组开始,m表示数组结束,m不包括数组内容
//将括号内的进行传入，括号外的进行传入
    if(n >= m || n < 0) return 0;//错误判断
    static int count = 0,num = 0;//count最终数字数组中计数，num最终字符数组中计数
    int i,j,b[100]; //存储每一段的计算结果
    char c[100];   //存储括号前后的计算符号

    for(int p = n;p < m;)
    {
        for(i = p;a[i] != '(' && i < m;i++);
        if(a[i] == '(' && i != p) {//括号不是第一个字符
            b[count++] = Chu_Li2(a,p,i-1);  //括号前的进行处理
            c[num++] = a[i-1];

            for(j = i+1;a[j] != ')' && j < m;j++);//找到括号内截止地方
            if(a[j] == ')')
            {
                b[count++] = Chu_Li2(a,i+1,j); //括号内的进行处理
                if(j < m-1) c[num++] = a[j+1]; //保留括号后的计算符
            }
            else {
                cout<<"输入错误"<<"\n";
                return 0;
            }
            //注意
          //  c[num++] = a[j+1];
            b[count++] = Chu_Li2(a,j+2,m); //计算括号后的
            break;
        }
        else b[count++] = Chu_Li2(a,p,i);
        if(i == m) break;
    }
    //测试
   /* for(i = 0;i < count;i++)
        cout<<"b["<<i<<"] ="<<b[i]<<"\t";
    cout<<"\t";
    for(i = 0;i < num;i++)
        cout<<"c["<<i<<"] ="<<c[i]<<"\t";*/

    cout<<jisuan(b,c,count,num); //count、num中无值
    return 0;
}

int Chu_Li2(char a[], int n, int m) //正确
{//将传入的数组，char 转换为两种，一种char一种int,然后传入jisuan()处理
 //不包含括号中仍有括号的
	char c[100];  //存储计算字符
	int b[100][100], i, j, num = 0, no = 0, d[100],f, e;//num记录数字数组，no记录字符串数组

	for (f= 0,i = n; i < m; i++)
	{
		if (a[i] == '+' || a[i] == '-' || a[i] == '*' || a[i] == '/') { c[no++] = a[i]; b[num][f] = 10; num++; f = 0; continue; }
		b[num][f++] = a[i] - '0';
	}
	b[num][f] = 10;

	//a数组中最后一个应为数字

	//cout << "\n";
	for (i = 0; i <= num; i++)
	{
		d[i] = 0;
		for (e = 0; b[i][e] != 10; e++)
			d[i] = d[i] * 10 + b[i][e];
	}

	return jisuan(d, c, num + 1, no);
}
int jisuan(int a[], char b[], int n, int m) //正确
{//表达式处理,n,m不存储
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
                    if(a[i+1] == 0) {cout<<"除数为"; return 0;}
                    a[i+1] = a[i] / a[i + 1];
                    a[i] = 0;
                    if(i == 0) b[i] = '+';
                    else b[i] = b[i-1];
            }

		}
	}
/*
	for(i = 0;i < n;i++)
    {
        cout<<a[i];
        if(i < n-1) cout<<b[i];
    }
    cout<<endl;
*/
	for (i = 0; i < m; i++)
	{
		if (b[i] == '+') {
			a[i + 1] += a[i];
		}
		else a[i + 1] = a[i] - a[i+1];
	}

	return a[n - 1];
}

int main(){
    char a[100]; //表达式存储
    int i,j,len = 0;
    gets(a);
    for (; a[len] != '\0';len++);
    for(;;)
    {//把表达式最后的空格去掉
        len--;
        if(a[len] != ' ' || a[len] != ';') break;
    }
    len++;

    //cout<<"begin len = "<<len<<"\n";
    try{
        Biao_Da_Shi(a,len);
    }
    catch (int b){
        cout<<"输入错误";
    }
//如果表达式有名字处理
    for (i = 0; i < len;i++)
        if(a[i] == '=') break;
    if(a[i] == '=' && i != len-1)
    {
        for(j = 0;j < i; j++)
        {
            cout<<a[j];
        }
        cout<<" "<<a[j]<<" ";
        len = len - i - 1;
        i++;
        for(j = 0;a[i] != '\0';j++)
            a[j] = a[i++];
        a[j] = '\0';
        //cout<<len;
    }

    Chu_Li(a,0,len);
    return 0;
}
