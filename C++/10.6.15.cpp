/* ---------------------------------------
 *  Programmer: Fan
 *  Data: 2017/5/15
 * ---------------------------------------
 *  Given this program:
 *
 *  	#include <iostream>
 *
 *  	int main()
 *  	{
 *  	    std::cout << "Hello world!\n";
 *  	}
 *
 *  modify it to produce this output:
 *
 *  	Initialize
 *  	Hello world!
 *  	Clean up
 * ---------------------------------------
 *  Description��
 *      ������Ķ���ʱ����˳����ù���
 *  ����������ʱ�����չ����ǵ���������
 * ---------------------------------------
 */

#include<iostream>
using namespace std;
class global{
public:
    global()
    {//���캯��
        cout<<"Initialize\n";
    }
    ~global()
    {
        cout<<"Clean up\n";
    }
};
global a;
int main()
{
    std::cout<<"Hello,world!\n";
}
/*http://blog.csdn.net/kevinlynx/article/details/642116*/
