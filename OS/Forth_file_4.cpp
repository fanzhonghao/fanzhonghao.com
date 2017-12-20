#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
char buf1[]="abcdefghij";
char buf2[]="ABCDEFGHIJ";
int main(){
	int fd;
	if((fd = creat("file.hole",S_IRWXU)) < 0){
		printf("create error\n");
		exit(EXIT_FAILURE);
	}
	if(write(fd,buf1,10) != 10){
		printf("buf1 write error\n");
		exit(EXIT_FAILURE);
	}
	if(lseek(fd,100,SEEK_SET) == -1){
		printf("lseek error\n");
		exit(EXIT_FAILURE);
	}
  if(write(fd,buf2,10) != 10)
	{
		printf("buf2 write error\n");
		exit(EXIT_FAILURE);
	}
	exit(0);
}
