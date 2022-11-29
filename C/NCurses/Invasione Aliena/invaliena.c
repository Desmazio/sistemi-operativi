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
	char c;
	int x;
	int y;
	int num;   // Serve ad indicare quale proiettile è
};

void proiettile(int pipeout, int x);
void madre(int pipeout);
void player(int pipeout);
void controllo(int pipein, int pipeout);

int main(){
	
	int filedes[2];
	int pid_madre, pid_player;
	
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
	
	pid_madre = fork();
	switch(pid_madre){
		case -1:
			perror("\nErrore nella creazione della fork Madre\n");
			_exit(1);
		case 0:
			//close(filedes[0]);
			madre(filedes[1]);   // Il primo processo figlio invoca la funzione della Madre
		default:
			pid_player = fork();
			switch(pid_player){
				case -1:
					perror("\nErrore nella creazione della fork Player\n");
					_exit(1);
				case 0:
					//close(filedes[0]);
					player(filedes[1]);	// Il primo processo figlio invoca la funzione del player
				default:
					//close(filedes[1]);
					controllo(filedes[0], filedes[1]);   // Il processo padre invoca la funzione di controllo
			}
	}
	
	// Game Over
	kill(pid_madre, 1);
   	kill(pid_player, 1);
  
   	endwin();
   	
   	printf("\n\nGAME OVER\n\n\n");
   	
   	return 0;
} 

void proiettile(int pipeout, int x){

	struct pos pos_proiettile;
	int dir = 1;
	
	pos_proiettile.c = 'o';
	pos_proiettile.x = x;
	pos_proiettile.y = 2;
	
	write(pipeout, &pos_proiettile, sizeof(pos_proiettile));
	
	while(pos_proiettile.y < MAXY){
		pos_proiettile.y += 1;
		
		write(pipeout, &pos_proiettile, sizeof(pos_proiettile));
		usleep(100000);
		
		if(pos_proiettile.y == MAXY)
			exit(1);
		
	}

}

void madre(int pipeout){
	
	struct pos pos_madre;
	int dir = 1, yes = 1;
	
	pos_madre.c = '=';
	pos_madre.x = 2;
	pos_madre.y = 1;
	
	write(pipeout, &pos_madre, sizeof(pos_madre));
	
	while(1){
	
		if(pos_madre.x + dir < 1 || pos_madre.x + dir > MAXX - 1){
		    dir *= -1;        
		}
		
		pos_madre.x += dir;

		write(pipeout, &pos_madre, sizeof(pos_madre));
		usleep(100000);
	}
	
}

void player(int pipeout){

	struct pos pos_player;
	int player_speed = 1, scudo = 3;
	
	pos_player.c = '^';
	pos_player.x = MAXX / 2;
	pos_player.y = MAXY - 1;
	
	write(pipeout, &pos_player, sizeof(pos_player));
	
	while(1){
	
		switch(getch()){
			case SINISTRA:
				if(pos_player.x > 0)
					pos_player.x -= player_speed;
				break;
			case DESTRA:
				if(pos_player.x < MAXX - 1)
					pos_player.x += player_speed;
				break;
		}
	
		write(pipeout, &pos_player, sizeof(pos_player));
	}

}

void controllo(int pipein, int pipeout){
	int scudo = 3, invincibile = 0;
	int cicli = 0, i;   // i serve a contare i cicli
	int num_proiettili = 5, pid_proiettile[num_proiettili], conta;
	struct pos madre, player, bullet[num_proiettili], valore_letto;
	
	madre.x = -1;
	player.x = -1;
	
	for(i = 0; i < num_proiettili; i++)
		bullet[i].x = -1;
	
	do{
		read(pipein, &valore_letto, sizeof(valore_letto));
		
		if(valore_letto.c == '='){
			if(madre.x >= 0)
				mvaddch(madre.y, madre.x, ' ');
			madre = valore_letto;
		}
		else if(valore_letto.c == '^'){
			if(player.x >= 0)
				mvaddch(player.y, player.x, ' ');
			player = valore_letto;
		}
		else if(valore_letto.c == 'o'){
			if(bullet[valore_letto.num].x >= 0)
				mvaddch(bullet[valore_letto.num].y, bullet[valore_letto.num].x, ' ');
			bullet[valore_letto.num] = valore_letto;
		}
		
		cicli++;     // Contatore dei cicli
		
		// Ogni tot cicli spara un proiettile
		if(!(cicli % 100)){
			pid_proiettile[conta] = fork();
			if(pid_proiettile[conta] == 0){
				proiettile(pipeout, madre.x);
			}
			
			conta++;
			if(conta == num_proiettili)
				conta = 0;
			
		}
		
		// Se viene colpito, il player sarà invincibile per un piccolo lasso di tempo, per poi tornare vulnerabile
		if(invincibile && !(cicli % 30))
			invincibile = 0;
		
		// Visualizzo l'oggetto nella posizione aggiornata 
        	mvaddch(valore_letto.y, valore_letto.x, valore_letto.c);
        	
        	// Gestione scudo
        	mvprintw(0, 0, "Scudo: %d", scudo);
        	mvprintw(10, 10, "cicli: %d", cicli);
        	mvprintw(11, 10, "inv: %d", invincibile);
        	
        	if(!invincibile && (bullet[1].x == player.x && bullet[1].y == player.y)){
        		scudo--;
        		invincibile = 1;
        		flash();
        	}
        	
        	// Game Over
        	if(scudo == 0){
        		break;
        	}
        		
        	refresh();  
	}while(1);
}


























