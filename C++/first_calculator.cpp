#include<stdio.h>
#include<iostream>
using namespace std;
bool Zui_Qian(char a[],int n);
bool Kuo_Hao(char a[],int n);
int Chu_Li2(char a[],int n,int m);
int jisuan(int a[],char b[],int n,int m);
bool Biao_Da_Shi(char a[],int n)
{//�жϱ��ʽ�Ƿ���ȷ
    if(Zui_Qian(a,n) == 0) throw 1;//��ȷ
    try{
        Kuo_Hao(a,n);
    }
    catch (int b){
        cout<<"���Ų�ƥ��";
    }
    return 0;

}
bool Zui_Qian(char a[],int n)
{//�ж��Ƿ���ǰ׺�����͵Ⱥ�ǰ���ʽ�Ƿ���ȷ
    char b[100];
    int i,j,no = 0,no2 = 0;
    for (i = 0; i < n;i++)
        if(a[i] == '=') break;
    if(i == n-1) return 1; //��ǰ׺��
    //������ǰ׺��
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
//n��ʾ���鿪ʼ,m��ʾ�������,m��������������
//�������ڵĽ��д��룬������Ľ��д���
    if(n >= m || n < 0) return 0;//�����ж�
    static int count = 0,num = 0;//count�������������м�����num�����ַ������м���
    int i,j,b[100]; //�洢ÿһ�εļ�����
    char c[100];   //�洢����ǰ��ļ������

    for(int p = n;p < m;)
    {
        for(i = p;a[i] != '(' && i < m;i++);
        if(a[i] == '(' && i != p) {//���Ų��ǵ�һ���ַ�
            b[count++] = Chu_Li2(a,p,i-1);  //����ǰ�Ľ��д���
            c[num++] = a[i-1];

            for(j = i+1;a[j] != ')' && j < m;j++);//�ҵ������ڽ�ֹ�ط�
            if(a[j] == ')')
            {
                b[count++] = Chu_Li2(a,i+1,j); //�����ڵĽ��д���
                if(j < m-1) c[num++] = a[j+1]; //�������ź�ļ����
            }
            else {
                cout<<"�������"<<"\n";
                return 0;
            }
            //ע��
          //  c[num++] = a[j+1];
            b[count++] = Chu_Li2(a,j+2,m); //�������ź��
            break;
        }
        else b[count++] = Chu_Li2(a,p,i);
        if(i == m) break;
    }
    //����
   /* for(i = 0;i < count;i++)
        cout<<"b["<<i<<"] ="<<b[i]<<"\t";
    cout<<"\t";
    for(i = 0;i < num;i++)
        cout<<"c["<<i<<"] ="<<c[i]<<"\t";*/

    cout<<jisuan(b,c,count,num); //count��num����ֵ
    return 0;
}

int Chu_Li2(char a[], int n, int m) //��ȷ
{//����������飬char ת��Ϊ���֣�һ��charһ��int,Ȼ����jisuan()����
 //�������������������ŵ�
	char c[100];  //�洢�����ַ�
	int b[100][100], i, j, num = 0, no = 0, d[100],f, e;//num��¼�������飬no��¼�ַ�������

	for (f= 0,i = n; i < m; i++)
	{
		if (a[i] == '+' || a[i] == '-' || a[i] == '*' || a[i] == '/') { c[no++] = a[i]; b[num][f] = 10; num++; f = 0; continue; }
		b[num][f++] = a[i] - '0';
	}
	b[num][f] = 10;

	//a���������һ��ӦΪ����

	//cout << "\n";
	for (i = 0; i <= num; i++)
	{
		d[i] = 0;
		for (e = 0; b[i][e] != 10; e++)
			d[i] = d[i] * 10 + b[i][e];
	}

	return jisuan(d, c, num + 1, no);
}
int jisuan(int a[], char b[], int n, int m) //��ȷ
{//���ʽ����,n,m���洢
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
    char a[100]; //���ʽ�洢
    int i,j,len = 0;
    gets(a);
    for (; a[len] != '\0';len++);
    for(;;)
    {//�ѱ��ʽ���Ŀո�ȥ��
        len--;
        if(a[len] != ' ' || a[len] != ';') break;
    }
    len++;

    //cout<<"begin len = "<<len<<"\n";
    try{
        Biao_Da_Shi(a,len);
    }
    catch (int b){
        cout<<"�������";
    }
//������ʽ�����ִ���
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
