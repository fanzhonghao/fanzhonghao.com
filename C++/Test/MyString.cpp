/* ----------------------------
 *  Author:fan
 *  Date:2017.7.10
 * ----------------------------
 *  Description:
 *    This instruction is used
 *  to implement a class
 *  "MyString" which use + to
 *  realize the operator like
 *  popup.
 * ----------------------------
 */
#include<iostream>
using namespace std;
class MyString {
  string a;
  int b;
  int begin;
public:
  MyString(string S): a(S){b = a.length();begin = 0;}
  MyString(int c) {
    b = c;
    for(int i = 0;i < c;i++){
      a += ' ';
    }
    begin = 0;
  }
  MyString() {b = 0;begin = 0;}
  ~MyString() {}
  int get_len() {return b;}
  void display(){
    cout << "[" ;
    for(int i = begin;i < a.length();i++){
      cout << a[i];
    }
    cout << "]" <<endl;
  }
  MyString& operator+(int x){
    int y;
    static MyString s7;
    s7 = *this;
    s7.begin += x;
    return s7;
  }
  MyString& operator++(){
    begin++;
    return *this;
  }
};
int main(int argc, char const *argv[]) {
  MyString s1("0123456789"),s2(5),s3;
  s1.display();
  s2.display();
  s3.display();
  s3 = s1;
  s1.display();
  s3.display();
  s2 = s1 + 3;
  s1.display();
  s2.display();
  s3 = ++++s2;
  s2.display();
  s3.display();
  return 0;
}
