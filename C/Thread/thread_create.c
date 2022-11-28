#include <pthread.h>
#include <stdio.h>

void* char_print(void* unused){
	while(1){
		printf("%c ", 'x');
	}
}

int main(){
	pthread_t thread_id;
	
	// Crea un thread che esegue la funzione char_print()
	pthread_create(&thread_id, NULL, &char_print, NULL);
	
	// Il thread principale stampa continuamente delle 'o'
	while(1)
		printf("%c ", 'o');
		
	return 0;
}
