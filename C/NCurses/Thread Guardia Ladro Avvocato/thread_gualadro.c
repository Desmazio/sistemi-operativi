#include <stdio.h>
#include <ncurses.h>
#include <stdlib.h>
#include <time.h>
#include <signal.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <pthread.h>

#define PASSO 1  //Entità spostamento del ladro
#define SU KEY_UP  //Freccia su
#define GIU KEY_DOWN  //Freccia giù
#define SINISTRA KEY_LEFT  //Freccia sinistra
#define DESTRA KEY_RIGHT  //Freccia destra
#define MAXX 80  //Numero di colonne dello schermo
#define MAXY 24  //Numero di righe dello schermo

/* Struttura per la comunicazione tra figli e padre. */
struct pos{
    char c;  //Soggetto che invia il dato: ladro o guardia.
    int x;
    int y;
};

void* ladro(void* unused);
void* guardia();
void* avvocato();

pthread_mutex_t mutex = PTHREAD_MUTEX_INITIALIZER;

int main(){

	pthread_t thread_ladro;
	pthread_t thread_avvocato;
	pthread_t thread_guardia;

	initscr();
	noecho();
	curs_set(0);
	srand((int)time(NULL));

	pthread_create(&thread_ladro, NULL, &ladro, NULL);

	pthread_join(thread_ladro, NULL);

	endwin();
	return 0;
}

void* ladro(void* unused){
	struct pos pos_ladro;
	long int r;
     int dx, dy;
	
	pos_ladro.c = '$';
	pos_ladro.x = 1;
	pos_ladro.y = 1;
	
	while(1){
		
		// Generazione randomica della direzione del ladro
		r = random();
		if(r < RAND_MAX/2){
		  dx = PASSO;        
		}else{
		  dx = -PASSO;        
		}

		if(pos_ladro.x + dx < 1 || pos_ladro.x + dx > MAXX){
		  dx = -dx;        
		}

		//pos_ladro.x += dx;

		r = random();
		if(r < RAND_MAX/2){
		  dy = PASSO;        
		}else{
		  dy = -PASSO;    
		}

		if(pos_ladro.y + dy < 1 || pos_ladro.y + dy > MAXY){
		  dy = -dy;        
		}

		//pos_ladro.y += dy;
		
		// Blocco del mutex per muovoere il ladro
		pthread_mutex_lock(&mutex);
		
		// Cancello la sua ultima posizione
		mvaddch(pos_ladro.y, pos_ladro.x, ' ');
		
		// Assegno la nuova posizione e lo muovo
		pos_ladro.x += dx;
		pos_ladro.y += dy;
		mvaddch(pos_ladro.y, pos_ladro.x, pos_ladro.c);
		refresh();
		
		pthread_mutex_unlock(&mutex);

		usleep(1000000);
    }
}


















