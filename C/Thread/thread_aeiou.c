#include <pthread.h>
#include <stdio.h>

struct params {
	char c;
	int count; // numero delle volte che il parametro dev'essere stampato
};

void* char_print(void* parametro){
	printf("AAAA");
	struct params* p;
	int i;
	
	p = (struct params*) parametro;
	
	printf("AAAA");
	printf("%c", p->c);
	
	for(i = 0; i < p->count; i++){
		printf("%c ", p->c);
	}
	
	return NULL;
}

int main(){
	pthread_t id1, id2, id3, id4, id5;
	
	struct params p1, p2, p3, p4, p5;
	p1.c = 'a';
	p1.count = 10000;
	p2.c = 'e';
	p2.count = 10000;
	p3.c = 'i';
	p3.count = 10000;
	p4.c = 'o';
	p4.count = 10000;
	p5.c = 'u';
	p5.count = 10000;
	
	
	
	pthread_create(&id1, NULL, &char_print, &p1);
	 
}
