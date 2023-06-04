import ex_convertitore.dataStructures.Contante;
import ex_convertitore.Convertitore;

public class TestConvertitore {

    public static void main(String[] args) {

        //////// PRIMO STEP \\\\\\\\

        Convertitore bancaRussa = new Convertitore("Rubli", 2);
        bancaRussa.aggiungiValuta("Euro", 2.0d);
        bancaRussa.aggiungiValuta("Yen", 0.9d);

        Convertitore bancaEuropea = new Convertitore("Euro", 2);
        bancaEuropea.aggiungiValuta("Sterline", 1.2d);
        bancaEuropea.aggiungiValuta("Rubli", 0.5d);

        Convertitore bancaGiapponese = new Convertitore("Yen", 2);
        bancaGiapponese.aggiungiValuta("Rubli", 1.1d);
        bancaGiapponese.aggiungiValuta("Dollari", 10.0d);


        // Non possiamo aggiungere una terza valuta
        assert !bancaRussa.aggiungiValuta("Dollari", 1.0d) : "ERRORE: Il convertitore bancaRussa ha accettato più di 2 valute estere";


        //////// SECONDO STEP \\\\\\\\

        // Tre test sui Rubli

        // 1. Cambio da Euro
        Contante attesi2Rubli = bancaRussa.converti(new Contante("Euro", 1.0d));
        assert attesi2Rubli.getValuta().equals("Rubli") : ("ERRORE: Attesi Rubli, ricevuti " + attesi2Rubli.getValuta());
        assert attesi2Rubli.getValore() == 2.0d : ("ERRORE: Attesi 2 Rubli, ricevuti " + attesi2Rubli.getValore());

        // 2. Cambio da Yen
        Contante attesi0_9Rubli = bancaRussa.converti(new Contante("Yen", 1.0d));
        assert attesi0_9Rubli.getValuta().equals("Rubli") : ("ERRORE: Attesi Rubli, ricevuti " + attesi0_9Rubli.getValuta());
        assert attesi0_9Rubli.getValore() == 0.9d : ("ERRORE: Attesi 0.9 Rubli, ricevuti " + attesi0_9Rubli.getValore());

        // 3. Cambio da valuta inattesa
        Contante attesi0Rubli = bancaRussa.converti(new Contante("Yuan", 100.0d));
        assert attesi0Rubli.getValuta().equals("Rubli") : ("ERRORE: Attesi Rubli, ricevuti " + attesi0Rubli.getValuta());
        assert attesi0Rubli.getValore() == 0.0d : ("ERRORE: Attesi 0 Rubli, ricevuti " + attesi0Rubli.getValore());


        // Due test sugli Euro

        // 1. Cambio da Sterline
        Contante attesi1_2Euro = bancaEuropea.converti(new Contante("Sterline", 1.0d));
        assert attesi1_2Euro.getValuta().equals("Euro") : ("ERRORE: Attesi Euro, ricevuti " + attesi1_2Euro.getValuta());
        assert attesi1_2Euro.getValore() == 1.2d : ("ERRORE: Attesi 1.2 Euro, ricevuti " + attesi1_2Euro.getValore());

        // 2. Cambio da Rubli
        Contante attesi0_5Euro = bancaEuropea.converti(new Contante("Rubli", 1.0d));
        assert attesi0_5Euro.getValuta().equals("Euro") : ("ERRORE: Attesi Euro, ricevuti " + attesi0_5Euro.getValuta());
        assert attesi0_5Euro.getValore() == 0.5d : ("ERRORE: Attesi 0.5 Euro, ricevuti " + attesi0_5Euro.getValore());


        // Due test sugli Yen

        // 1. Cambio da Rubli
        Contante attesi1_1Yen = bancaGiapponese.converti(new Contante("Rubli", 1.0d));
        assert attesi1_1Yen.getValuta().equals("Yen") : ("ERRORE: Attesi Yen, ricevuti " + attesi1_1Yen.getValuta());
        assert attesi1_1Yen.getValore() == 1.1d : ("ERRORE: Attesi 1.1 Yen, ricevuti " + attesi1_1Yen.getValore());

        // 2. Cambio da Dollari
        Contante attesi10Yen = bancaGiapponese.converti(new Contante("Dollari", 1.0d));
        assert attesi10Yen.getValuta().equals("Yen") : ("ERRORE: Attesi Yen, ricevuti " + attesi10Yen.getValuta());
        assert attesi10Yen.getValore() == 10d : ("ERRORE: Attesi 10 Yen, ricevuti " + attesi10Yen.getValore());


        System.out.println("\nSe stai leggendo questo messaggio, il tuo codice ha soddisfatto tutti gli assert.");


        //////// TERZO STEP \\\\\\\\

        // Test degli Override di Object.toString()

        System.out.println("\nOra testiamo i metodi toString()...");

        System.out.println("\ntoString() del convertitore della banca russa:");
        System.out.println(bancaRussa.toString());

        System.out.println("\ntoString() del convertitore della banca europea:");
        System.out.println(bancaEuropea.toString());

        System.out.println("\ntoString() del convertitore della banca giapponese:");
        System.out.println(bancaGiapponese.toString());
    }

}

