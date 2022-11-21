#include <stdio.h>
#include <max.h>

int main(){

 int a, b, m;
 
 printf("Inserire due numeri: ");
 scanf("%d", &a);
 scanf("%d", &b);

 m = max(a, b);

 printf("Il numero piu' grande e': %d", m);

}
