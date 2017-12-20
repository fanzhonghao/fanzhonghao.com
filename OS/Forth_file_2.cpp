/**权限不足*/
#include <sys/types.h>
#include <unistd.h>
#include <stdlib.h>
#include <fcntl.h>
#include <stdio.h>
int main()
{
	int  fd1,fd2;
	char buf[]="abcdefgh";
	char temp[4];
	fd1 = open("tempfile",O_RDWR|O_CREAT|O_TRUNC);
	if(fd1 < 0)
	{
		printf("can not open file\n");
		exit(EXIT_FAILURE);
	}
	if(write(fd1,buf,8) != 8)
	{
		printf("can not write to file\n");
		exit(EXIT_FAILURE);
	}
	else
		printf("write : %s\n",buf);
    fd2 = open("tempfile",O_RDWR);
	if(fd2< 0)
	{
		printf("can not open tempfile\n");
		exit(EXIT_FAILURE);
	}
	lseek(fd1,0,SEEK_SET);
	if(read(fd1,temp,4) != 4)
	{
		printf("can not read from fd1\n");
		exit(EXIT_FAILURE);
	}
	else
		printf("fd1: %s",temp);
	if(read(fd2,temp,4) != 4)
	{
		printf("can not read from fd2\n");
		exit(EXIT_FAILURE);
	}
	else
		printf("fd2: %s",temp);
	close(fd1); 	close(fd2);
	printf("\n");
return 0;
}
