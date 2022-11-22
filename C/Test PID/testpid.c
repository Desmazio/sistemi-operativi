#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>

int main(){

	pid_t pid;
	printf("\nUnico processo con PID: %d\n", (int)getpid());

	pid = fork();

	if(pid == 0)
		printf("\nSono il processo figlio (PID: %d)", (int)getpid());
	else
		if(pid > 0)
			printf("\nSono il genitore del processo con PID %d\n", pid);
		else
			printf("\nErrore\n");

}
