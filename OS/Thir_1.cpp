#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

#define true 1
#define false 0
int flag[2];        //表示进程p0正在占用临界区及临界区的状态
int turn;          //表示能进入临界区的进程序号
void p0()        //进程P0
{
while(true)      //有权进入临界区
{
 flag[0]=true;   //标志状态
turn=1;
while(flag[1]&&turn==1)    //若进程p1抢夺{
//wait
printf("Thread p0 is waiting\n");   //忙等待
}
//critical area
printf("Thread p0 is in the critical area\n"); //进入临界区
flag[0]=false;                   //离开临界区，改变状态
}


void p1()      //进程P1
{
while(true)    //p1有权进入临界区
{
flag[1]=true;        //表示进程p1正在占用临界区及临界区的状态
turn=0;              //表示能进入临界区的进程序号
while(flag[0]&&turn==0)  //若进程p1抢夺
{
//wait
printf("pthread p1 is waiting\n");  //忙等待
}
//critical area
printf("pthread p1 is in the critical area\n"); //进入临界区
flag[1]=false;            //离开临界区，改变状态
}
}
int main()
{
flag[0]=flag[1]=false;    //初始化状态
turn=0;
pthread_t t1,t2;

if(pthread_create(&t1,NULL,(void*)p0,NULL)!=0)//进程创建
{
printf("pthread t1 creation fail\n");
exit(-1);
}
if(pthread_create(&t2,NULL,(void*)p1,NULL)!=0)
{
printf("pthread t2 creation fail");
exit(-1);
}
pthread_join(t1,NULL);   //进程同步
pthread_join(t2,NULL);
return 0;
}
