#include <stdio.h>
#include <curses.h>
#include <pthread.h>
#include <unistd.h>
#include <stdlib.h>

#define MAXX 80
#define MAXY 20

struct params{
	char character;
	int count;
};

pthread_mutex_t mutex = PTHREAD_MUTEX_INITIALIZER;

// Stampa un numero random di caratteri in base ai caratteri passati
void* char_print(void* parameters){
	
	struct params* p;
	p = (struct params*) parameters;
	int i, x, y;
	
	// Stampa a video in posizione random
	for(i = 0; i < p->count; i++){
		pthread_mutex_lock(&mutex);  // Inizio sezione critica
		x = rand() % MAXX;
		y = rand() % MAXY;
		mvaddch(y, x, p->character);
		refresh();
		usleep(1);
		pthread_mutex_unlock(&mutex); // Fine sezione critica
	}	
		
}

int main(){
	
	// Variabili thread ID
	pthread_t thread1_id;
	pthread_t thread2_id;
	
	// Strutture per passaggio dati ai thread
	struct params thread1_args;
	struct params thread2_args;
	
	// Inizializzzazione Ncurses
	initscr();
	noecho();
	curs_set(0);
	
	// Crea un nuovo thread che stampa 30.000 volte il carattere X
	thread1_args.character = 'x';
	thread1_args.count = 30000;
	pthread_create(&thread1_id, NULL, &char_print, &thread1_args);
	
	// Crea un nuovo thread che stampa 20.000 volte il carattere Y
	thread2_args.character = 'y';
	thread1_args.count = 20000;
	pthread_create(&thread2_id, NULL, &char_print, &thread2_args);
	
	// Attende la terminazione dei due thread e poi esce dal programma
	pthread_join(thread1_id, NULL);
	pthread_join(thread2_id, NULL);
	
	// Elimino il mutex
	pthread_mutex_destroy(&mutex);
	
	// Chiudo la finestra
	endwin();
	
}








