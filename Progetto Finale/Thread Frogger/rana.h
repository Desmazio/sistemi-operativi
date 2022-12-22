#define MAXVERT 46    // Questi due numeri servono per indicare la dimensione della mappa, non dell'intera finestra, che comprende anche l'HUD
#define MAXORIZZ 80
#define SU KEY_UP  //Freccia su
#define GIU KEY_DOWN  //Freccia giù
#define SINISTRA KEY_LEFT  //Freccia sinistra
#define DESTRA KEY_RIGHT  //Freccia destra
#define PASSO 3   // La rana si muove tanto quanto la sua dimensione

struct rana{
	int x;
	int y;
};

void* rana(void* params){
	struct rana* pos_rana;
	pos_rana = (struct rana*) params; 
	
	int oldX, oldY;
	
	while(1){
		oldX = pos_rana->x;
		oldY = pos_rana->y;
		
		switch(getch()){
			case SINISTRA:
				if(pos_rana->x - PASSO > 0)
					pos_rana->x -= PASSO;
				break;
			case DESTRA:
				if(pos_rana->x + PASSO < MAXORIZZ - 1)
					pos_rana->x += PASSO;
				break;
			case SU:
				pos_rana->y -= PASSO;
				break;
			case GIU:
				if(pos_rana->y + PASSO < MAXVERT - 1)
					pos_rana->y += PASSO;
				break;
		}
	}

}
