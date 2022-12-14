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
void* bullet(void* params);
void areaGioco(void* data_player, void* data_madre);

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
	
	areaGioco(&data_player, &data_madre);
	
	endwin();
	printf("\n\nGAME OVER\n\n\n");

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
		
		pthread_mutex_lock(&mutex);
		
		mvaddch(pos_player->y, pos_player->x, pos_player->c);
		
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

		pos_madre->x += dir;
		
		pthread_mutex_unlock(&mutex);
		
		usleep(100000);
	}
}

void* bullet(void* params){
	struct pos* pos_bullet;
	pos_bullet = (struct pos*) params;
	pos_bullet->c = 'o';
	pos_bullet->y = 2;
	
	while(pos_bullet->y < MAXY){
		pthread_mutex_lock(&mutex);
		
		pos_bullet->y += 1;
		
		pthread_mutex_unlock(&mutex);
		
		usleep(100000);
	}
	
	//pthread_cancel();
	
}

void areaGioco(void* data_player, void* data_madre){
	struct pos* player;
	struct pos* madre;
	player = (struct pos*) data_player;
	madre = (struct pos*) data_madre;
	
	int bullet_num = 5, conta_bullet = 0, scudo = 3;
	pthread_t thread_bullet;
	struct pos data_bullet[bullet_num];
	
	int spara = 1, cicli = 0, i, game_over = 0;
	
	while(!game_over){
	
		cicli++;
		if(!(cicli % 100)){
			cicli = 0;
		
			data_bullet[conta_bullet].x = madre->x;
			pthread_create(&thread_bullet, NULL, &bullet, &data_bullet[conta_bullet]);
			conta_bullet++;
			if(conta_bullet == bullet_num)
				conta_bullet = 0;
		}

		// Controllo collisione player-bullet
		for(i = 0; i < bullet_num; i++){
			if(data_bullet[i].x == player->x && data_bullet[i].y == player->y){
				flash();
				scudo--;
			}
		}

		// Controllo Game Over
		if(scudo == 0)
			game_over = 1;

		// Stampa 
		erase();
		mvprintw(0, 1, "Scudo: %d", scudo);
		
		mvaddch(madre->y, madre->x, madre->c);
		mvaddch(player->y, player->x, player->c);
		for(i = 0; i < bullet_num; i++)
			mvaddch(data_bullet[i].y, data_bullet[i].x, data_bullet[i].c);
		
		refresh();
		usleep(10000);
		
	}
	
}
































