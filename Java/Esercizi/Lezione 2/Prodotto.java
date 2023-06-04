class Prodotto{

	int prezzo;
	int sconto;
	String nome;
	
	Prodotto(int nuovoPrezzo, String nuovoNome){
		prezzo = nuovoPrezzo;
		nome = nuovoNome;
	}

	void impostaSconto(int nuovoSconto){
		if(nuovoSconto > 0 && nuovoSconto <= 100)
			sconto = nuovoSconto;
		else
			System.out.println("Errore input sconto");
	}

	void messaggioPromozionale(){
		if(sconto != 0){
			int prezzoFinale = prezzo - ((prezzo / 100) * sconto);
			System.out.println("Il prodotto " + nome + " da " + prezzo + " ora costa solo " + prezzoFinale);
		}
		else{
			System.out.println("Il prodotto " + nome + " ora costa solo " + prezzo);
		}
	}

	public static void main(String[] args){
		
		Prodotto prodotto = new Prodotto(Integer.parseInt(args[0]), args[1]);
		
		prodotto.impostaSconto(30);
		
		System.out.println("Nome: " + prodotto.nome + " | Prezzo: " + prodotto.prezzo + " | Sconto: " + prodotto.sconto);
		
		prodotto.messaggioPromozionale();
		
	}

}
