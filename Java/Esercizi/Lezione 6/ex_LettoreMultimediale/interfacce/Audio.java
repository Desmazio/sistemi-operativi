/*
  L'interfaccia Audio ci permette di definire
  i metodi per la regolazione del volume.
*/

package interfacce;

public interface Audio {

    int maxVolume = 10;

    void weaker();
    void louder();
}
