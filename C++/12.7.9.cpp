#include<iostream>
using namespace std;
class Char_vec{
  int sz;
  char element[1];
public:
  static Char_vec* new_char_vec(int s);
  char& operator[] (int i){return element[i];}
};
Char_vec* Char_vec::new_char_vec(int s){
  char *raw =(char*) ::operator new (sizeof(Char_vec) + s - 1);
  Char_vec* vec = new(raw) Char_vec;
  vec->sz = s;
  return vec;
}
int main(int argc, char const *argv[]) {
  Char_vec a;
  a.new_char_vec(5);
  char m = 'a';
  a[0] = m;
  //a[1] = m;
  for (int i = 0;i < 5;i++)
  {
    cout << i << " "<< a[i] <<endl;
  }

  return 0;
}
