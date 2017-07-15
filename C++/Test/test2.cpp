#include<iostream>
#include<string>
using namespace std;
class A{
  string a;
public:
  A(string b) : a(b) {}
  void print(){
    cout << a <<endl;
  }
};
int main(int argc, char const *argv[]) {
  A a("123");
  a.print();
  return 0;
}
