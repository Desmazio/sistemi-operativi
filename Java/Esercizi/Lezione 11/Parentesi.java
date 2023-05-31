
public class Parentesi {

    public static void main(String[] args) {
        String valide1 = "()";
        String valide2 = "(())";
        String valide3 = "(()(()))";

        assert valutaEspressione(valide1);
        assert valutaEspressione(valide2);
        assert valutaEspressione(valide3);


        String nonValide1 = ")(";
        String nonValide2 = "())";
        String nonValide3 = "(";

        assert !valutaEspressione(nonValide1);
        assert !valutaEspressione(nonValide2);
        assert !valutaEspressione(nonValide3);
    }


    public static boolean valutaEspressione(String controlla) {

        Stack<Character> stackAperte = new Stack<>();

        // Scorriamo la stringa un carattere alla volta
        for (char c : controlla.toCharArray()) {

            // Parentesi aperte: push nello stack
            if (c == '(') stackAperte.push(c);

            // Parentesi chiuse: pop dallo stack
            if (c == ')')

                if (stackAperte.size() > 0)
                    // Lo stack non è vuoto, pop
                    stackAperte.pop();

                else
                    // Se lo stack è vuoto, c'è una chiusa di troppo
                    return false;
        }

        /*
           Se a fine stringa c'è qualcosa nello stack, almeno una
           parentesi aperta non è stata chiusa
        */
        return !(stackAperte.size() > 0);
    }

}
