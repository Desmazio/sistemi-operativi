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

/* Struttura per la comunicazione tra figli e padre. */
struct pos{
    char c;  //Soggetto che invia il dato: ladro o guardia.
    int x;
    int y;
};

void ladro(int pipeout);
void guardia(int pipeout);
void controllo(int pipein);

int main(){
    int filedes[2];
    int pid_ladro;
    int pid_guardia;

    initscr();
    noecho();
    keypad(stdscr, 1);		// Attiva la lettura dei tasti non-alfanumerici (tra cui le frecce)
    cbreak();			// Disattiva l'input stdin bufferizzato
    srand((int)time(NULL));
    curs_set(false);
    
    if(pipe(filedes) == -1){
        perror("Errore nella creazione della pipe!\n");
        _exit(1);
    }
    
    pid_ladro = fork();
    switch(pid_ladro){
        case -1:
            perror("Errore nell\'esecuzione della fork!\n");
            exit(1);
        case 0:
            close(filedes[0]);  //Chiusura del descrittore in lettura
            ladro(filedes[1]);  //Il primo processo figlio invoca la funzione ladro
        default:
            pid_guardia = fork();
            switch(pid_guardia){
                case -1:
                    perror("Errore nell\'esecuzione della pipe!\n");
                    _exit(1);
                case 0:
                    close(filedes[0]);  //Chiusura descrittore di lettura 
                    guardia(filedes[1]);  //Il secondo processo figlio invoca la funzione guardia
                default:
                    close(filedes[1]);  //Chiusura del descrittore di scrittura
                    controllo(filedes[0]);  //Il processo padre invoca la funzione di controllo
            }
    }
    /* Siamo usciti dalla funzione di controllo e vengono terminati i due processi figli e ripristinato il normale modo operativo dello schermo. */
    kill(pid_ladro, 1);
    kill(pid_guardia, 1);
    endwin();
    return 0;
}

void ladro(int pipeout){
    struct pos pos_ladro;
    long int r;
    int dx, dy;
    pos_ladro.x = 1;
    pos_ladro.y = 1;
    pos_ladro.c = '$';
    
    write(pipeout, &pos_ladro, sizeof(pos_ladro));
    
    while(1){
        r = random();
        if(r < RAND_MAX/2){
            dx = PASSO;        
        }else{
            dx = -PASSO;        
        }

        if(pos_ladro.x + dx < 1 || pos_ladro.x + dx > MAXX){
            dx = -dx;        
        }
        
        pos_ladro.x += dx;
        
        r = random();
        if(r < RAND_MAX/2){
            dy = PASSO;        
        }else{
            dy = -PASSO;    
        }
        
        if(pos_ladro.y + dy < 1 || pos_ladro.y + dy > MAXY){
            dy = -dy;        
        }

        pos_ladro.y += dy;

        write(pipeout, &pos_ladro, sizeof(pos_ladro));
        usleep(1000000);
    }
}

void guardia(int pipeout){
    struct pos pos_guardia;
    pos_guardia.c = '#';
    pos_guardia.x = MAXX-1;
    pos_guardia.y = MAXY-1;

    write(pipeout, &pos_guardia, sizeof(pos_guardia));
    
    while(1){
        switch(getch()){
            case SU:
                if(pos_guardia.y > 0){
                    pos_guardia.y -= 1;                
                }
                break;
            case GIU:
                if(pos_guardia.y < MAXY - 1){
                    pos_guardia.y += 1;                        
                }    
                break;
            case SINISTRA:
                if(pos_guardia.x > 0){
                    pos_guardia.x -= 1;
                }
                break;
            case DESTRA:
                if(pos_guardia.x < MAXX - 1){
                    pos_guardia.x += 1;                
                }
                break;
        }
        write(pipeout, &pos_guardia, sizeof(pos_guardia));    
    }
}

void controllo(int pipein){
    struct pos ladro, guardia, valore_letto;
    ladro.x = -1;
    guardia.x = -1;
    
    do{
        read(pipein, &valore_letto, sizeof(valore_letto));  //Leggo dalla pipe 
        if(valore_letto.c == '$'){
            if(ladro.x >= 0){  //Cancello la vecchia posizione del ladro
                mvaddch(ladro.y, ladro.x, ' ');
            }        
            ladro = valore_letto;
        }else{
	    if(valore_letto.c == '#'){
            	if(guardia.x >= 0){  //Cancello la vecchia posizione della guardia
               	 mvaddch(guardia.y, guardia.x, ' ');             
            }
            guardia = valore_letto;
       	    }
	}
        /* Visualizzo l'oggetto nella posizione aggiornata. */
        mvaddch(valore_letto.y, valore_letto.x, valore_letto.c);
        refresh();    
    }while(!(guardia.x == ladro.x && guardia.y == ladro.y));
}

