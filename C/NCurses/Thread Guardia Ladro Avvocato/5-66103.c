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

void* ladro(void* params);
void* guardia(void* params);
void* avvocato(void* params);
int areaGioco(void* data_guardia, void* data_ladro, void* data_avvocato);
void gameOver(int ris);

pthread_mutex_t mutex = PTHREAD_MUTEX_INITIALIZER;

int main(){

	pthread_t thread_ladro;
	pthread_t thread_avvocato;
	pthread_t thread_guardia;
	
	struct pos data_ladro; 
	data_ladro.c = '$';
	data_ladro.x = 1;
	data_ladro.y = 1;
	struct pos data_avvocato; 
	data_avvocato.c = 'A';
	data_avvocato.x = 9;
	data_avvocato.y = 9;
	struct pos data_guardia; 
	data_guardia.c = '#';
	data_guardia.x = MAXX-1;
	data_guardia.y = MAXY-1;

	initscr();
	noecho();
	curs_set(0);
	keypad(stdscr, 1);
	cbreak();
	srand((int)time(NULL));
	
	int risultato; // 0 = vittoria della guardia, 1 = vittoria del ladro

	pthread_create(&thread_ladro, NULL, &ladro, &data_ladro);
	pthread_create(&thread_guardia, NULL, &guardia, &data_guardia);
	pthread_create(&thread_avvocato, NULL, &avvocato, &data_avvocato);
	
	risultato = areaGioco(&data_guardia, &data_ladro, &data_avvocato);
	
	pthread_cancel(thread_ladro);
	pthread_cancel(thread_guardia);
	pthread_cancel(thread_avvocato);
	pthread_mutex_destroy(&mutex);
	
	gameOver(risultato);
	
	return 0;
}

void* ladro(void* params){
	struct pos* pos_ladro;
	pos_ladro = (struct pos*) params;
	
	long int r;
     int dx, dy;
	
	while(1){
		
		// Generazione randomica della direzione del ladro
		r = random();
		if(r < RAND_MAX/2){
		  dx = PASSO;        
		}else{
		  dx = -PASSO;        
		}

		if(pos_ladro->x + dx < 1 || pos_ladro->x + dx > MAXX){
		  dx = -dx;        
		}

		r = random();
		if(r < RAND_MAX/2){
		  dy = PASSO;        
		}else{
		  dy = -PASSO;    
		}

		if(pos_ladro->y + dy < 1 || pos_ladro->y + dy > MAXY){
		  dy = -dy;        
		}
		
		// Blocco del mutex per muovoere il ladro
		pthread_mutex_lock(&mutex);
		
		// Cancello la sua ultima posizione
		mvaddch(pos_ladro->y, pos_ladro->x, ' ');
		
		// Assegno la nuova posizione e lo muovo
		pos_ladro->x += dx;
		pos_ladro->y += dy;
		mvaddch(pos_ladro->y, pos_ladro->x, pos_ladro->c);
		
		refresh();
		
		pthread_mutex_unlock(&mutex);

		usleep(1000000);
    }
}

void* guardia(void* params){
	struct pos* pos_guardia;
	pos_guardia = (struct pos*) params; 
	
	int oldX, oldY;

	while(1){
		oldX = pos_guardia->x;
		oldY = pos_guardia->y;
		
		switch(getch()){
			case SU:
				if(pos_guardia->y > 0){
					pos_guardia->y -= 1;                
				}
				break;
			case GIU:
				if(pos_guardia->y < MAXY - 1){
					pos_guardia->y += 1;                        
				}    
				break;
			case SINISTRA:
				if(pos_guardia->x > 0){
					pos_guardia->x -= 1;
				}
				break;
			case DESTRA:
				if(pos_guardia->x < MAXX - 1){
					pos_guardia->x += 1;                
				}		
				break;
		}
		
		// Blocco del mutex , cancello vecchia posizione e stampo quella nuova
		pthread_mutex_lock(&mutex);
		
		mvaddch(oldY, oldX, ' ');
		mvaddch(pos_guardia->y, pos_guardia->x, pos_guardia->c);
		
		refresh();
		
		pthread_mutex_unlock(&mutex);
		
	}
}

void* avvocato(void* params){
	struct pos* pos_avv;
	pos_avv = (struct pos*) params;
	
	long int r;
     int dx, dy;
	
	while(1){
		
		// Generazione randomica della direzione dell'avvocato
		r = random();
		if(r < RAND_MAX/2){
		  dx = PASSO;        
		}else{
		  dx = -PASSO;        
		}

		if(pos_avv->x + dx < 1 || pos_avv->x + dx > MAXX){
		  dx = -dx;        
		}

		r = random();
		if(r < RAND_MAX/2){
		  dy = PASSO;        
		}else{
		  dy = -PASSO;    
		}

		if(pos_avv->y + dy < 1 || pos_avv->y + dy > MAXY){
		  dy = -dy;        
		}
		
		// Blocco del mutex per muovoere l'avvocato
		pthread_mutex_lock(&mutex);
		
		// Cancello la sua ultima posizione
		mvaddch(pos_avv->y, pos_avv->x, ' ');
		
		// Assegno la nuova posizione e lo muovo
		pos_avv->x += dx;
		pos_avv->y += dy;
		mvaddch(pos_avv->y, pos_avv->x, pos_avv->c);
		
		refresh();
		
		pthread_mutex_unlock(&mutex);

		usleep(1000000);
    }

}

int areaGioco(void* data_guardia, void* data_ladro, void* data_avvocato){
	struct pos* guardia;
	struct pos* ladro;
	struct pos* avvocato;
	guardia = (struct pos*) data_guardia;
	ladro = (struct pos*) data_ladro;
	avvocato = (struct pos*) data_avvocato;

	while(1){		// Return 0 se ha vinto il ladro, return 1 se ha vinto il ladro
		if(guardia->x == ladro->x && guardia->y == ladro->y)
			return 0;
		else if(ladro->x == avvocato->x && ladro->y == avvocato->y)
			return 1;
			
	}

}

void gameOver(int ris){
	sleep(1);
	endwin();
	printf("\n\n");

	if(ris == 0){
		printf("GAMER OVER");
		printf("\nLa guardia ha catturato il ladro");
	}
	else{
		printf("GAMER OVER");
		printf("\nL'avvocato' ha salvato il ladro");
	}
	
	printf("\n\n");
}


















