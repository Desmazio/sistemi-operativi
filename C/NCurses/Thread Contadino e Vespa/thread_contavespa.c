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

void* vespa(void* params);
void* contadino(void* params);
void areaGioco(void* data_contadino, void* data_vespa);

pthread_mutex_t mutex = PTHREAD_MUTEX_INITIALIZER;

int main(){

	pthread_t thread_contadino;
	pthread_t thread_vespa;
	
	struct pos data_contadino;
	data_contadino.c = '#';
	data_contadino.x = MAXX / 2;
	data_contadino.y = MAXY / 2;
	struct pos data_vespa;
	data_vespa.c = '^';
	data_vespa.x = 4;
	data_vespa.y = 4;
	
	initscr();
	noecho();
	curs_set(0);
	keypad(stdscr, 1);
	cbreak();
	srand((int)time(NULL));
	
	pthread_create(&thread_contadino, NULL, &contadino, &data_contadino);
	pthread_create(&thread_vespa, NULL, &vespa, &data_vespa);
	
	areaGioco(&data_contadino, &data_vespa);
	
	pthread_cancel(thread_contadino);
	pthread_cancel(thread_vespa);
	pthread_mutex_destroy(&mutex);
	
	endwin();
	printf("\n\n");
	printf("GAME OVER\n\n\n");

}

void* vespa(void* params){
	struct pos* pos_vespa;
	pos_vespa = (struct pos*) params;
	
	int dx, dy, num_passi = 1, conta_passi = 0;
	
	while (1)
	{

		if(conta_passi == 0){
			if (random() < RAND_MAX / 2)
				dx = 1;
			else
				dx = -1;

			if (random() < RAND_MAX / 2)
				dy = 1;
			else
				dy = -1;
		}
		conta_passi++;
		if(conta_passi == num_passi)
			conta_passi = 0;

		// Se supero area X schermo inverte il movimento
		if (pos_vespa->x + dx < 1 || pos_vespa->x + dx > MAXX)
		{
			dx = -dx;
		}

		

		// Se supero area Y schermo inverto il movimento
		if (pos_vespa->y + dy < 1 || pos_vespa->y + dy > MAXY)
		{
			dy = -dy;
		}

		pthread_mutex_lock(&mutex);
		
		mvaddch(pos_vespa->y, pos_vespa->x, ' ');
		pos_vespa->x += dx;
		pos_vespa->y += dy;
		mvaddch(pos_vespa->y, pos_vespa->x, pos_vespa->c);
		
		refresh();
		
		pthread_mutex_unlock(&mutex);
		
		usleep(1000000);
	}
	
}

void* contadino(void* params){
	struct pos* pos_contadino;
	pos_contadino = (struct pos*) params;
	
	int oldX, oldY;
	
	while(1){
		oldX = pos_contadino->x;
		oldY = pos_contadino->y;
		
		switch(getch()){
			case SU:
				if(pos_contadino->y > 0){
					pos_contadino->y -= 1;                
				}
				break;
			case GIU:
				if(pos_contadino->y < MAXY - 1){
					pos_contadino->y += 1;                        
				}    
				break;
			case SINISTRA:
				if(pos_contadino->x > 0){
					pos_contadino->x -= 1;
				}
				break;
			case DESTRA:
				if(pos_contadino->x < MAXX - 1){
					pos_contadino->x += 1;                
				}		
				break;
		}
		
		// Blocco del mutex , cancello vecchia posizione e stampo quella nuova
		pthread_mutex_lock(&mutex);
		
		mvaddch(oldY, oldX, ' ');
		mvaddch(pos_contadino->y, pos_contadino->x, pos_contadino->c);
		
		refresh();
		
		pthread_mutex_unlock(&mutex);
	}
	
}

void areaGioco(void* data_contadino, void* data_vespa){
	struct pos* contadino;
	struct pos* vespa;
	
	contadino = (struct pos*) data_contadino;
	vespa = (struct pos*) data_vespa;
	
	int game_over = 0;
	
	while(!game_over){
		mvprintw(MAXY / 2, MAXX / 2, "conta x %d", contadino->x);
		mvprintw(MAXY / 2, MAXX / 2 + 1, "conta y %d", contadino->y);
		mvprintw(MAXY / 2, MAXX / 2 + 2, "vespa x %d", vespa->x);
		mvprintw(MAXY / 2, MAXX / 2 + 3, "vespa y %d", vespa->y);
	
		if(vespa->x == contadino->x && vespa->y == contadino->y)
			game_over = 1;
	}
}
































