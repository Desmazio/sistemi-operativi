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

struct pos{
    char c;
    int x;
    int y;
};

void* player(void* params);
void* madre(void* params);
void areaGioco();

pthread_mutex_t mutex = PTHREAD_MUTEX_INITIALIZER;

int main(){

	pthread_t thread_player;
	pthread_t thread_madre;
	pthread_t thread_im;
	
	struct pos data_player;
	data_player.c = '^';
	data_player.x = MAXX / 2;
	data_player.y = MAXY - 1;
	struct pos data_madre;
	data_madre.c = '=';
	data_madre.x = MAXX / 2;
	data_madre.y = 1;
	
	initscr();
	noecho();
	curs_set(0);
	keypad(stdscr, 1);
	cbreak();
	srand((int)time(NULL));
	
	pthread_create(&thread_player, NULL, &player, &data_player);
	pthread_create(&thread_madre, NULL, &madre, &data_madre);
	
	pthread_join(thread_player, NULL);
	pthread_join(thread_im, NULL);

}

void* player(void* params){
	struct pos* pos_player;
	pos_player = (struct pos*) params;
	
	int oldX, oldY;

	while(1){
		oldX = pos_player->x;
		oldY = pos_player->y;
		
		switch(getch()){
			case SINISTRA:
				if(pos_player->x > 0){
					pos_player->x -= 1;
				}
				break;
			case DESTRA:
				if(pos_player->x < MAXX - 1){
					pos_player->x += 1;                
				}		
				break;
		}
		
		// Blocco del mutex , cancello vecchia posizione e stampo quella nuova
		pthread_mutex_lock(&mutex);
		
		mvaddch(oldY, oldX, ' ');
		mvaddch(pos_player->y, pos_player->x, pos_player->c);
		
		refresh();
		
		pthread_mutex_unlock(&mutex);
		
	}
}

void* madre(void* params){
	struct pos* pos_madre;
	pos_madre = (struct pos*) params;
	
	int dir = 1;

	while(1){
	
		if(pos_madre->x + dir < 1 || pos_madre->x + dir > MAXX - 1){
		    dir *= -1;        
		}

		pthread_mutex_lock(&mutex);
		
		mvaddch(pos_madre->y, pos_madre->x, ' ');
		pos_madre->x += dir;
		mvaddch(pos_madre->y, pos_madre->x, pos_madre->c);
		
		refresh();
		
		pthread_mutex_unlock(&mutex);
		
		usleep(100000);
	}
}
























