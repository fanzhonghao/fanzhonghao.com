#include <stdio.h>/*printf函数*/
#include <sys/wait.h>/*wait函数*/
#include <unistd.h>/*fork,sleep*/
#include <errno.h>/*error*/
int main(){
	pid_t ret;
	int status , i;
	int role = -1;
	ret = fork();
	if(ret > 0){
		printf("Parent: This the parent process (pid %d)\n", getpid());
		for(i=0;i<6;i++){
			printf("Parent: At count %d\n", i);
			sleep(1);      }/*休眠1ms，输出时有输出延迟*/
		ret = wait(&status);//防止僵尸进程的产生
		role=0;
  }
	else
		if(ret ==0){
			printf("Child: This the child process (pid %d)\n", getpid());
			for(i=0;i<6;i++){
				printf("Chile: At count %d\n",i);
				sleep(1);
			}
			role = 1;
		}
		else{
			printf("Parent: Error trying to fork() (%d)\n", errno);
		}
		printf("%s: Exiting...\n", ((role ==0)?"Parent":"Child"));
		return 0;
}
/*wait函数用来将进程挂起*/
/*当父进程休眠时，子进程运行，*/
/*fork函数没有参数，如果返回值是0，则表示当前进程是新创建的子进程，大于0表示父进程，小于0表示发生错误*/
