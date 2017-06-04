/* --------------------------------
 *  Author: fanzhonghao
 *  Date: 2017.06.03
 * --------------------------------
 *  Description:
 *    Define class Circle、Square
 *  and Triangle derived from class
 *  Shape. And define
 *  function intersect() to judge
 *  whether two shapes have overla-
 *  ps
 * --------------------------------
 */
 //There we define triangle is regular triangle
 #include<iostream>
 using namespace std;
 class Shape
 {
   int centerx,centery;//define the shape's center
   int type;//1 stand for Circle and 2 -> Square and 3-> Triangle
   int radius;//define the radius of the shape
   /*There we make distance from side to the center is the shape's radius*/
 public:
   int gettype(){return type;}
   int getx(){return centerx;}
   int gety(){return centery;}
   int getc(){return radius;}
   void setx(int a){ centerx = a;}
   void sety(int b){ centery = b;}
   void setr(int c){ radius = c;}
   void settype(int t){ type = t;}
   virtual int maxdis() = 0;//中心到点的最远距离
 };
 class Circle : public Shape
 {
 public:
   Circle(int,int,int);
   int maxdis();
   void print();
 };
 class Square : public Shape
 {
 public:
   Square(int,int,int);
   int maxdis();
 };
 class Triangle : public Shape
 {
 public:
   Triangle(int,int,int);
   int maxdis();
 };
 Circle::Circle(int x,int y,int c)
 {
   setx(x);
   sety(y);
   setr(c);
   settype(1);
 }
 Square::Square(int x,int y,int c)
 {
   setx(x);
   sety(y);
   setr(c);
   settype(2);
 }
 Triangle::Triangle(int x,int y,int c)
 {
   setx(x);
   sety(y);
   setr(c);
   settype(3);
 }

 int Circle::maxdis()
 {
   return getc();
 }
 int Square::maxdis()
 {
   return getc() * 1.414;
 }
 int Triangle::maxdis()
 {
   return getc() * 2;
 }

 bool intersect(Shape* a,Shape* b)
 {//judge whether two shape are overlapped,0 stand for no while 1 stand for yes
   if (a->gettype() == 1 && b->gettype() == 1)//two circlrs
   {
     int c = a->getx() - b->getx();
     int d = a->gety() - b->gety();
     int e = a->getc() + b->getc();
     //cout << c <<" " << d << " " << e <<endl;
     if((c*c + d*d) < e*e)
     return 1;
     else
     return 0;
   }
   if((a->gettype() == 1 && b->gettype() == 2) || ( a->gettype() == 2 && b->gettype() == 1 ))
   {//easy judge whether circle and square is overlapped,not think over some issue
     int c = a->getx() - b->getx();
     int d = a->gety() - b->gety();
     int e = a->gettype() == 1 ? a->getc() + b->getc() * 1.414 : a->getc() * 1.414 + b->getc();
     int f = a->getc() + b->getc();
     if((c*c + d*d) < f*f)
     return 1;
     if((c*c + d*d) > e*e) return 0;
   }
   return 0;
 }
 void judge(Shape* a,Shape* b)
 {//judge whether two shape is overlapped
   if (intersect(a,b))
   {
     cout << "overlapped" << endl;
   }
   else { cout << "nonoverlapped" << endl;}
 }
 int main(int argc, char const *argv[]) {
   Circle circle1(10,10,10);
   Square square1(40,60,10);
   Triangle triangle1(40,100,10);
   Shape* first = &circle1;
   cout << circle1.getc() << endl;
   Circle circle2(30,10,10);
   Shape* second = &circle2;
   judge(first,first);//one circle
   judge(first,second);//two circle
   Shape* third = &triangle1;
   Square square2(30,10,20);
   Shape* forth = &square2;
   judge(first,third);//one circle and one square
   judge(first,forth);//one circle and one square
   cout << "The circle's maxdis is " << circle1.maxdis() <<endl;
   cout << "The square's maxdis is " << square1.maxdis() <<endl;
   cout << "The triangle's maxdis is " << triangle1.maxdis() << endl;
   return 0;
 }
 //The judue isn't integrite
