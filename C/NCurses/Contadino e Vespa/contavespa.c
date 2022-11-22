#include <stdio.h>
#include <ncurses.h>
#include <stdlib.h>
#include <time.h>
#include <signal.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

#define PASSO 1  //Entità spostamento del ladro
#define SU KEY_UP  //Freccia su
#define GIU KEY_DOWN  //Freccia giù
#define SINISTRA KEY_LEFT  //Freccia sinistra
#define DESTRA KEY_RIGHT  //Freccia destra
#define MAXX 80  //Numero di colonne dello schermo
#define MAXY 24  //Numero di righe dello schermo

struct pos{
	char c;	  // #: contadino, ^: Ape, X: trappola
	int x;
	int y;
};

void vespa(int pipeout);
void contadino(int pipeout);
void controllo(int pipein);

int main(){
	
	int filedes[2];
	int pid_vespa;
	int pid_contadino;
	
	initscr();
	noecho();
	keypad(stdscr, 1);		// Attiva la lettura dei tasti non-alfanumerici (tra cui le frecce)
	cbreak();			// Disattiva l'input stdin bufferizzato
	srand((int)time(NULL));
	curs_set(false);

	if(pipe(filedes) == -1){
		perror("\nErrore nella creazione della pipe\n");
		_exit(1);
	}
	
	pid_vespa = fork();
	switch(pid_vespa){
		case -1:
			perror("\nErrore nella creazione della fork Vespa\n");
			_exit(1);
		case 0:
			close(filedes[0]);
			vespa(filedes[1]);   // Il primo processo figlio invoca la funzione della vespa
		default:
			pid_contadino = fork();
			switch(pid_contadino){
				case -1:
					perror("\nErrore nella creazione della fork Contadino\n");
					_exit(1);
				case 0:
					close(filedes[0]);
					contadino(filedes[1]);   // Il secondo processo figlio invoca la funzione del contadino
				default:
					close(filedes[1]);
					controllo(filedes[0]);   // Il processo padre invoca la funzione di controllo
			}
	}
	
	kill(pid_vespa, 1);
        kill(pid_contadino, 1);
        endwin();
        return 0;
} 

void vespa(int pipeout){
	
	struct pos pos_vespa;
	long int r;
	int dx, dy;
	
	pos_vespa.c = '^';
	pos_vespa.x = 2;
	pos_vespa.y = 2;
	
	write(pipeout, &pos_vespa, sizeof(pos_vespa));
	
	while(1){
		r = random();
		if(r < RAND_MAX/2){
		    dx = PASSO;        
		}else{
		    dx = -PASSO;        
		}

		if(pos_vespa.x + dx < 1 || pos_vespa.x + dx > MAXX){
		    dx = -dx;        
		}
		
		pos_vespa.x += dx;
		
		r = random();
		if(r < RAND_MAX/2){
		    dy = PASSO;        
		}else{
		    dy = -PASSO;    
		}
		
		if(pos_vespa.y + dy < 1 || pos_vespa.y + dy > MAXY){
		    dy = -dy;        
		}

		pos_vespa.y += dy;

		write(pipeout, &pos_vespa, sizeof(pos_vespa));
		usleep(1000000);
	}
	
}

void contadino(int pipeout){
	struct pos pos_contadino;
     pos_contadino.c = '#';
     pos_contadino.x = MAXX-1;
     pos_contadino.y = MAXY-1;

     write(pipeout, &pos_contadino, sizeof(pos_contadino));
    
     while(1){
         switch(getch()){
             case SU:
                 if(pos_contadino.y > 0){
                     pos_contadino.y -= 1;                
                 }
                 break;
             case GIU:
                 if(pos_contadino.y < MAXY - 1){
                     pos_contadino.y += 1;                        
                 }    
                 break;
             case SINISTRA:
                 if(pos_contadino.x > 0){
                     pos_contadino.x -= 1;
                 }
                 break;
             case DESTRA:
                 if(pos_contadino.x < MAXX - 1){
                     pos_contadino.x += 1;                
                 }
                 break;
         }
         write(pipeout, &pos_contadino, sizeof(pos_contadino));    
     }
}

void controllo(int pipein){
	struct pos vespa, contadino, valore_letto;
	
	vespa.x = -1;
	
	do{
		read(pipein, &valore_letto, sizeof(valore_letto));
		
		if(valore_letto.c == '^'){   // Vespa
			if(vespa.x >= 0)
				mvaddch(vespa.y, vespa.x, ' ');
			vespa = valore_letto;
		}
		else if(valore_letto.c == '#'){   // Contadino
			if(contadino.x >= 0)
				mvaddch(contadino.y, contadino.x, ' ');
			contadino = valore_letto;
		}
		
		// Visualizzo l'oggetto nella posizione aggiornata 
        	mvaddch(valore_letto.y, valore_letto.x, valore_letto.c);
        	refresh();  
	}while(!(contadino.x == vespa.x && contadino.y == vespa.y));
}


























