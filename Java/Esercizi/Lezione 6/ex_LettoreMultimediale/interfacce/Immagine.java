/*
  L'interfaccia Immagine ci permette di definire
  i metodi per la regolazione della luminosità.
*/

package interfacce;

public interface Immagine {

    int maxLuminosita = 10;

    void brighter();
    void darker();
}
