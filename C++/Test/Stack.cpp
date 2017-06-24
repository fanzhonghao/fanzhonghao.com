/* -----------------------------
 *  Author:fan
 *  Date:2017.6.25
 * -----------------------------
 *  Description:
 *    This instruction is used
 *  to implement a class Stack.
 * -----------------------------
 */
#include<iostream>
#include<stdlib.h>
using namespace std;
class Stack{
  int a[10];
  int top = 0,base = 0;
public:
  void push(const int& t);
  int pop();
  bool empty();
  bool full();
  int getNumbers();
};
void Stack::push(const int& t){
  if(top == 10){
    cout << "Overflow" <<endl;
    exit(-1);
  }
  a[top] = t;
  top++;
}
int Stack::pop(){
  if(top == base){
    cout << "None" <<endl;
    exit(-1);
  }
  top--;
  return a[top];
}
bool Stack::empty(){
  return base == top;
}
bool Stack::full(){
  return top == 10;
}
int Stack::getNumbers(){
  return top;
}
int main(int argc, char const *argv[]) {
  Stack a;
  for(int i = 0;i < 10;i++){
    a.push(i);
  }
  if(a.full()){
    cout << "full" <<endl;
  }else{
    cout << "not full" <<endl;
  }
  for(int i = 0;i < 10;i++)
  {
    cout << a.pop() <<endl;
  }
  cout << "num = " << a.getNumbers() <<endl;
  if(a.empty()){
    cout << "empty" <<endl;
  }else{
    cout << "not empty" <<endl;
  }
  return 0;
}
