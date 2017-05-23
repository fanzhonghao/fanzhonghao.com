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
 *  Description：
 *      生成类的对象时，按顺序调用构造
 *  函数，析构时，按照构造是的逆序析构
 * ---------------------------------------
 */

#include<iostream>
using namespace std;
class global{
public:
    global()
    {//构造函数
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
