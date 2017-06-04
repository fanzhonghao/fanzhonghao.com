/* --------------------
 *  Author: fanzhonghao
 *  Date: 2017.06.03
 * --------------------
 *  Description:
 *    Define a template
 *  of Stack class
 * --------------------
 */
#include<iostream>
#include<stdlib.h>
using namespace std;
template <class T>//声明类模板
class Stack
{
  T data[100];
  int base;
  int front;
public:
  Stack<T>();
  ~Stack<T>(){};
  void push(T);
  T pop();
  T read();
  int getnum();//得到栈中，元素总个数
};
template <typename T>//构造函数
Stack<T>::Stack()
{
  base = 0;
  front = 0;
}
template <typename T>//每次定义函数都要写一下
void Stack<T>::push(T a)
{
  if(front > 99) {cout << "error" << endl;exit(-1);}
  data[front] = a;
  front++;
}
template <typename T>
T Stack<T>::pop()
{
  if(front == base) {cout << "error" << endl;exit(-1);}
  front--;
  return data[front];
}
template <typename T>
T Stack<T>::read()
{
  if(front == base) {cout << "error" << endl;exit(-1);}
  return data[front-1];
}
template <typename T>
int Stack<T>::getnum()
{
  return front - base;
}
int main(int argc, char const *argv[]) {
  Stack<int> a;//实例化int型
  a.push(10);
  cout << a.read() << endl;//读栈顶元素
  cout << a.getnum() << endl;//得到现在元素个素
  cout << a.pop() << endl;//弹出栈顶元素
  cout << a.getnum() << endl;//得到现在元素个素
  //a.pop();
  Stack<char> b;
  b.push('l');
  b.push('o');
  b.push('c');
  cout << b.pop();
  cout << b.read();
  cout << b.pop();
  cout << b.pop() << endl;//cout 执行时从后往前执行
  return 0;
}
