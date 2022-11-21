#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main(){

	pid_t pid1, pid2;

	pid1 = fork();

	if(pid1 == 0){
		printf("\nFiglio %d\n", pid1);
		execl("/bin/pwd", "pwd", (char *) 0);
	}
		

	wait((int *) 0);
	printf("\nPWD OK, Padre: %d\n", getpid());
	fflush(stdin);	

	pid2 = fork();

	if(pid2 == 0){
		printf("\nFiglio %d\n", pid2);
		execl("/bin/ls", "ls", "-l", (char *) 0);
	}

	wait((int *) 0);
	printf("\nLS OK, Padre: %d\n", getpid());
	fflush(stdin);	

}
