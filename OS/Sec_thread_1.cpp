#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>

int main(){
	pid_t myPid;
	pid_t myParentPid;
	gid_t myGid;
	uid_t myUid;
/*pid_t进程标识符*/
	myPid = getpid();/*得到进程ID*/
	myParentPid = getppid();/*得到父进程ID*/
	myGid = getgid();/*得到组ID*/
	myUid = getuid();/*得到用户ID*/
/*以上成功返回ID，失败返回-1*/
	printf("my process id is  %d\n", myPid);
	printf("my parent is process id is %d\n", myParentPid);
	printf("my group id is %d\n", myGid);
	printf("my user id is %d\n", myUid);
	return 0;
}
