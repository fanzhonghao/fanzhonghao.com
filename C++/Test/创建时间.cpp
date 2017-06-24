/* ---------------------------
 *  Author: fan
 *  Date: 2017.06.24
 * ---------------------------
 *  Description:
 *    This instruction is
 *  used to test the variate's
 *  created sequence.
 * ---------------------------
 */
 #include<iostream>
 using namespace std;
 class A{
   char a;
 public:
   A(char b){
     cout << "constructor " << b << endl;
     a = b;
   }
   ~A(){
     cout << "desconstructor " << a << endl;
   }
 };
 A a('a');
 static A b('b');
 int main(int argc, char const *argv[]) {
   static A g('g');
   A c('c');
   static A d('d');
   return 0;
 }
 A e('e');
 static A f('f');
