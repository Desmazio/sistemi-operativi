import ex_convertitore.dataStructures.Contante;
import ex_abstract.convertitori.*;

public class TestAbstract {

    public static void main(String[] args) {

        ConvertitoreRusso bancaRussa = new ConvertitoreRusso(2);
        bancaRussa.aggiungiValuta("Euro", 2.0d);
        bancaRussa.aggiungiValuta("Yen", 0.9d);

        ConvertitoreEuropeo bancaEuropea = new ConvertitoreEuropeo(2);
        bancaEuropea.aggiungiValuta("Sterline", 1.2d);
        bancaEuropea.aggiungiValuta("Rubli", 0.5d);

        ConvertitoreGiapponese bancaGiapponese = new ConvertitoreGiapponese(2);
        bancaGiapponese.aggiungiValuta("Rubli", 1.1d);
        bancaGiapponese.aggiungiValuta("Dollari", 10.0d);


        // Due test generali

        // 1. Non possiamo aggiungere una terza valuta
        assert !bancaRussa.aggiungiValuta("Dollari", 1.0d) : "ERRORE: Il convertitore bancaRussa ha accettato più di 2 valute estere";

        // 2. Valuta inattesa
        Contante attesi0Rubli = bancaRussa.converti(new Contante("Yuan", 100.0d));
        assert attesi0Rubli.getValuta().equals("Rubli") : ("ERRORE: Attesi Rubli, ricevuti " + attesi0Rubli.getValuta());
        assert attesi0Rubli.getValore() == 0.0d : ("ERRORE: Attesi 0 Rubli, ricevuti " + attesi0Rubli.getValore());


        // Tre test sui Rubli

        // 1. Si possono ottenere Rubli solo se si paga più di 20 unità
        attesi0Rubli = bancaRussa.converti(new Contante("Euro", 20.0d));
        assert attesi0Rubli.getValuta().equals("Rubli") : ("ERRORE: Attesi Rubli, ricevuti " + attesi0Rubli.getValuta());
        assert attesi0Rubli.getValore() == 0.0d : ("ERRORE: Attesi 0 Rubli, ricevuti " + attesi0Rubli.getValore());

        // 2. Più di 20 unità sono accettate
        Contante attesi42Rubli = bancaRussa.converti(new Contante("Euro", 21.0d));
        assert attesi42Rubli.getValuta().equals("Rubli") : ("ERRORE: Attesi Rubli, ricevuti " + attesi42Rubli.getValuta());
        assert attesi42Rubli.getValore() == 42.0d : ("ERRORE: Attesi 42 Rubli, ricevuti " + attesi42Rubli.getValore());

        // 3. Cambio da Yen
        Contante attesi27Rubli = bancaRussa.converti(new Contante("Yen", 30.0d));
        assert attesi27Rubli.getValuta().equals("Rubli") : ("ERRORE: Attesi Rubli, ricevuti " + attesi27Rubli.getValuta());
        assert attesi27Rubli.getValore() == 27.0d : ("ERRORE: Attesi 27 Rubli, ricevuti " + attesi27Rubli.getValore());


        // Tre test sugli Euro

        // 1. Cambio da Sterline
        Contante attesi1_2Euro = bancaEuropea.converti(new Contante("Sterline", 1.0d));
        assert attesi1_2Euro.getValuta().equals("Euro") : ("ERRORE: Attesi Euro, ricevuti " + attesi1_2Euro.getValuta());
        assert attesi1_2Euro.getValore() == 1.2d : ("ERRORE: Attesi 1.2 Euro, ricevuti " + attesi1_2Euro.getValore());

        // 2. Cambio da Rubli in assenza di sanzioni
        Contante attesi0_5Euro = bancaEuropea.converti(new Contante("Rubli", 1.0d));
        assert attesi0_5Euro.getValuta().equals("Euro") : ("ERRORE: Attesi Euro, ricevuti " + attesi0_5Euro.getValuta());
        assert attesi0_5Euro.getValore() == 0.5d : ("ERRORE: Attesi 0.5 Euro, ricevuti " + attesi0_5Euro.getValore());

        // 3. Cambio da Rubli in presenza di sanzioni
        bancaEuropea.applicaSanzioni();
        Contante attesi0Euro = bancaEuropea.converti(new Contante("Rubli", 1.0d));
        assert attesi0Euro.getValuta().equals("Euro") : ("ERRORE: Attesi Euro, ricevuti " + attesi0Euro.getValuta());
        assert attesi0Euro.getValore() == 0.0d : ("ERRORE: Attesi 0 Euro, ricevuti " + attesi0Euro.getValore());


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


        // Test degli Override di Object.toString()
        System.out.println("\nOra testiamo i metodi toString()...");

        System.out.println("\ntoString() di ConvertitoreRusso:");
        System.out.println(bancaRussa.toString());

        System.out.println("\ntoString() di ConvertitoreEuropeo:");
        System.out.println(bancaEuropea.toString());

        System.out.println("\ntoString() di ConvertitoreGiapponese:");
        System.out.println(bancaGiapponese.toString());
    }

}

