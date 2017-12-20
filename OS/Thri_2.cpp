#include <stdio.h>
#include <pthread.h>
#include <semaphore.h>
#include <stdlib.h>
#include <unistd.h>
#define NUM 5
int queue[NUM];
//blank代表有空位，product代表产品
sem_t blank_number,product_number;
//producer
void* producer(void* arg)   //生产者
{
int p=0;
while(1)
{//将空位信号量-1
sem_wait(&blank_number);
queue[p]=rand()%1000+1;
printf("product %d\n",queue[p]);
sem_post(&product_number);
//将产品信号量+1
p=(p+1)%NUM;    //一个小算法，以便控制睡眠时间
sleep(rand()%5);
}
return(void*)0;
}
//consumer
void* consumer(void* arg)    //消费者
{
int c=0;
while(1)
{   //等待有产品后消费，将产品信号量+1
sem_wait(&product_number);
printf("consume %d\n",queue[c]);
queue[c]=0;
sem_post(&blank_number);  //消费完毕后将空位信号量+1
c=(c+1)%NUM;
sleep(rand()%5);
}
return (void*)0;
}
int main(int argc,char* argv[])
{
pthread_t pid,cid;
sem_init(&blank_number,0,NUM);
sem_init(&product_number,0,0);

pthread_create(&pid,NULL,producer,NULL);
pthread_create(&cid,NULL,consumer,NULL);

pthread_join(pid,NULL);
pthread_join(cid,NULL);
return 0;
}
