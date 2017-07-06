/* ----------------------------
 *  Author:fan
 *  Date:2017.07.06
 * ----------------------------
 *  Description:
 *    This instruction is used
 *  to explore the usage of
 *  namespace.
 * ----------------------------
 */
 #include<iostream>
 using namespace std;
 namespace a{
   void p();
 }
 namespace b{
   void p();
 }
 void a::p(){
   cout << "namespace-a" <<endl;
 }
 void b::p(){
   cout << "namespace-b" <<endl;
 }
 using namespace a;
 using b::p;//这里不能加括号
 int main(int argc, char const *argv[]) {
   //不能直接使用 p(),应该是因为二义性的原因
   a::p();
   b::p();
   return 0;
 }
