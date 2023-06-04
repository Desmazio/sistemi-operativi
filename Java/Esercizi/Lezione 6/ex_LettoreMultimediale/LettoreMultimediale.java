import classi.*;
import eccezioni.*;

public class LettoreMultimediale {

    public static void main(String[] args) {

        // Test Prima Parte: implementazione dei metodi previsti

        // Test su canzone
        Canzone canzoneTest = new Canzone("Song", "MP3",3);

        assert canzoneTest.getTitolo().equals("Song") : ("La canzone dovrebbe avere titolo \"Song\", trovato: \"" + canzoneTest.getTitolo() + "\"");
        assert canzoneTest.getFormato().equals("MP3") : ("La canzone dovrebbe avere formato \"MP3\", trovato: \"" + canzoneTest.getFormato() + "\"");
        assert canzoneTest.getDurata() == 3 : ("La canzone dovrebbe avere durata 3, trovato: " + canzoneTest.getDurata());

        assert canzoneTest.getVolume() == 0 : ("La canzone dovrebbe avere volume 0, trovato: " + canzoneTest.getVolume());

        assert canzoneTest.esegui().equals("SongSongSong") : ("L'esecuzione dovrebbe rendere \"SongSongSong\", reso: \"" + canzoneTest.esegui() + "\"");

        canzoneTest.louder();
        assert canzoneTest.esegui().equals("SongSongSong!") : ("L'esecuzione dovrebbe rendere \"SongSongSong!\", reso: \"" + canzoneTest.esegui() + "\"");

        
        // Test su foto
        Foto fotoTest = new Foto("Sfondo", "JPG");

        assert fotoTest.esegui().equals("Sfondo") : ("L'esecuzione dovrebbe rendere \"Sfondo\", reso: \"" + fotoTest.esegui() + "\"");

        fotoTest.brighter();
        assert fotoTest.esegui().equals("Sfondo*") : ("L'esecuzione dovrebbe rendere \"Sfondo*\", reso: \"" + fotoTest.esegui() + "\"");


        // Test su film
        Filmato filmTest = new Filmato("Matrix", "MP4", 4);

        assert filmTest.esegui().equals("MatrixMatrixMatrixMatrix") : ("L'esecuzione dovrebbe rendere \"MatrixMatrixMatrixMatrix\", reso: \"" + filmTest.esegui() + "\"");

        filmTest.louder();
        filmTest.brighter();
        assert filmTest.esegui().equals("MatrixMatrixMatrixMatrix!*") : ("L'esecuzione dovrebbe rendere \"MatrixMatrixMatrixMatrix!*\", reso: \"" + filmTest.esegui() + "\"");



        // Test Seconda Parte: generazione delle eccezioni nel costruttore
        System.out.println("\nPrima parte conclusa, ora testiamo la generazione delle eccezioni...\n");

        try {

            new Canzone("Andrea","MP4",3);
            assert false : "Non è stata lanciata un'eccezione per Canzone con formato MP4.";

        } catch(FormatoNonSupportato e) {

            //System.out.println("Eccezione lanciata correttamente per Canzone con formato MP4.\n");
        }


        try {

            new Foto("Cielo","JPEGI");
            assert false : "Non è stata lanciata un'eccezione per Foto con formato JPEGI.";

        } catch(FormatoNonSupportato e) {

            //System.out.println("Eccezione lanciata correttamente per Foto con formato JPEGI.\n");
        }


        try {

            new Filmato("Avatar","MP3",5);
            assert false : "Non è stata lanciata un'eccezione per Filmato con formato MP3.";

        } catch(FormatoNonSupportato e) {

            //System.out.println("Eccezione lanciata correttamente per Filmato con formato MP3.\n");
        }



        System.out.println("\nSe stai leggendo questo messaggio, il tuo codice ha soddisfatto tutti gli assert.");
    
    }

}
