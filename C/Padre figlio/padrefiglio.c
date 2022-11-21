#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main(){

	pid_t pid;

	pid = fork();

	if(pid == 0)
		printf("\nHello ");

	wait((int *) 0);
	
	if(pid)
		printf("\nGoodbye\n");

}
