#include <ncurses.h>
#include <unistd.h>

#define MAXX 80
#define MAXY 24
#define DELAY 1

int main(){

	int x = MAXX / 2, y = MAXY / 2; 
	initscr();
	noecho();
	keypad(stdscr, true);
	curs_set(false);

	while(true){
	
		clear();
		mvprintw(y, x, "+");
		refresh();
		sleep(DELAY);
		
		x++;
		y++;
		if(y >= MAXY || x >= MAXX) break;
	
	}

	endwin();

}
