#include <pthread.h>  
#include <stdio.h>

/* Struttura parametri per la print_function */ 
struct params{
	char character; /* The character to print. */  
	int count; /* The number of times to print it. */
};

/* Stampa un numero di caratteri prefissato su stderr, determinato dai parametri passati  Con un puntatore alla struttura params */
void* char_print (void* parameters){

	/* Casting del puntatore con il corretto tipo, cioè (struct char_print_parms*) */
	struct params* p;
	p = (struct params*) parameters;
	int i;
	for (i = 0; i < p-> count; ++i)
		printf("%c ", p->character);  
	return NULL;
}

int main(){
	/* Variabili per memorizzare i thread ID */
	pthread_t thread1_id;  
	pthread_t thread2_id;
	pthread_t thread3_id;
	pthread_t thread4_id;
	pthread_t thread5_id;



	/* Strutture per il passaggio dei dati ai thread */
	struct params thread1_args;  
	struct params thread2_args;
	struct params thread3_args;  
	struct params thread4_args;
	struct params thread5_args;

	/* Crea un nuovo thread che stampa 10.000 volte il carattere a */
	thread1_args.character = 'a';  
	thread1_args.count = 10000;
	pthread_create (&thread1_id, NULL, &char_print, &thread1_args);

	/* Crea un nuovo thread che stampa 10.000 volte il carattere e */
	thread2_args.character = 'e';  
	thread2_args.count = 10000;
	pthread_create (&thread2_id, NULL, &char_print, &thread2_args);


	/* Crea un nuovo thread che stampa 10.000 volte il carattere i */
	thread3_args.character = 'i';  
	thread3_args.count = 10000;
	pthread_create (&thread3_id, NULL, &char_print, &thread3_args);

	/* Crea un nuovo thread che stampa 10.000 volte il carattere o */
	thread4_args.character = 'o';  
	thread4_args.count = 10000;
	pthread_create (&thread4_id, NULL, &char_print, &thread4_args);


	/* Crea un nuovo thread che stampa 10.000 volte il carattere u */
	thread5_args.character = 'u';  
	thread5_args.count = 10000;
	pthread_create (&thread5_id, NULL, &char_print, &thread5_args);



	/* Attende la terminazione dei thread precedentemente creati, quindi termina il programma */
	pthread_join (thread1_id, NULL);  
	pthread_join (thread2_id, NULL);
	pthread_join (thread3_id, NULL);  
	pthread_join (thread4_id, NULL);	 
	pthread_join (thread5_id, NULL);
	return 0; 
}


