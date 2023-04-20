#include <stdio.h>
#include <ncurses.h>
#include <curses.h>
#include <stdlib.h>
#include <time.h>
#include <signal.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <pthread.h>
#include "rana.h"

#define MAXX 80  //Numero di colonne dello schermo
#define MAXY 48  //Numero di righe dello schermo
#define HCORSIA 3 // Altezza di ogni corsia, marciapiede, prato, fiume

struct mappa{
	int num_corsie;
	int num_fiumi;
};

void gameLoop(void* data_rana);
void stampaMappa();
void stampaRana(struct rana* rana);

pthread_mutex_t mutex = PTHREAD_MUTEX_INITIALIZER;

int main(){

	init_pair(1, COLOR_WHITE, COLOR_GREEN);
	init_pair(2, COLOR_WHITE, COLOR_CYAN);
	init_pair(3, COLOR_WHITE, COLOR_BLACK);
	init_pair(4, COLOR_BLACK, COLOR_GREEN);

	pthread_t thread_rana;
	
	struct rana data_rana;
	data_rana.x = MAXX / 2;
	data_rana.y = MAXY - 4;

	initscr();
	start_color();
	noecho();
	curs_set(0);
	keypad(stdscr, 1);
	cbreak();
	srand((int)time(NULL));
	
	pthread_create(&thread_rana, NULL, &rana, &data_rana);

	gameLoop(&data_rana);

}

void gameLoop(void* data_rana){
	struct rana* rana;
	rana = (struct rana*) data_rana;

	while(1){
	
		stampaMappa();
		stampaRana(rana);
		refresh();
	
	}
}
	
void stampaRana(struct rana* rana){
	init_pair(4, COLOR_BLACK, COLOR_GREEN);
	attron(COLOR_PAIR(4));
	
	mvaddch(rana->y, rana->x, '#');
	mvaddch(rana->y, rana->x + 2, '#');
	mvaddch(rana->y + 1, rana->x + 1, '#');
	mvaddch(rana->y + 2, rana->x, '#');
	mvaddch(rana->y + 2, rana->x + 2, '#');
}
	
void stampaMappa(){

	init_pair(1, COLOR_WHITE, COLOR_GREEN);
	init_pair(2, COLOR_WHITE, COLOR_CYAN);
	init_pair(3, COLOR_WHITE, COLOR_BLACK);
	init_pair(4, COLOR_BLACK, COLOR_GREEN);

	int r, c, riga = 2;
	int num_corsie = 5;
	
	// STAMPA MARCIAPIEDE
	attron(COLOR_PAIR(1));
	for(r = 0; r < HCORSIA; r++){
		for(c = 0; c < MAXX; c++){
			mvaddch(MAXY - (r + riga), c, ' ');
		}
	}
	riga += r;
	
	// STAMPA STRADA
	attron(COLOR_PAIR(3));
	for(r = 0; r < HCORSIA * num_corsie; r++){
		for(c = 0; c < MAXX; c++){
			mvaddch(MAXY - (r + riga), c, ' ');
		}
	}
	riga += r;
	
	// STAMPA PRATO
	attron(COLOR_PAIR(1));
	for(r = 0; r < HCORSIA; r++){
		for(c = 0; c < MAXX; c++){
			mvaddch(MAXY - (r + riga), c, ' ');
		}
	}
	riga += r;
	
	// STAMPA FIUME
	attron(COLOR_PAIR(2));
	for(r = 0; r < HCORSIA * num_corsie; r++){
		for(c = 0; c < MAXX; c++){
			mvaddch(MAXY - (r + riga), c, ' ');
		}
	}
	riga += r;
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


