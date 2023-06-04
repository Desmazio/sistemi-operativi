class Quaderno{

	int numeroPagine;
	
	Quaderno(){
		numeroPagine = 0;
	}
	
	Quaderno(int numPagine){
		numeroPagine = numPagine;
	}
	
	void AggiungiPagine(int numeroPagineDaAggiungere){
		if(numeroPagineDaAggiungere > 0)
			numeroPagine += numeroPagineDaAggiungere;
		else
			System.out.println("AGGIUNGI | Hai inserito un numero errato");
	}

	void RimuoviPagine(int numeroPagineDaRimuovere){
		if(numeroPagineDaRimuovere > 0 && !(numeroPagine - numeroPagineDaRimuovere < 0))
			numeroPagine -= numeroPagineDaRimuovere;
		else
			System.out.println("RIMUOVI | Hai inserito un numero errato");
	}

}

class UsaQuaderno{

	public static void main(String[] args){
	
		Quaderno quaderno = new Quaderno(Integer.parseInt(args[0]));
		System.out.println("Pagine: " + quaderno.numeroPagine);
	
		quaderno.AggiungiPagine(35);
		quaderno.RimuoviPagine(25);
		
		System.out.println("Pagine: " + quaderno.numeroPagine);
	
	}

}
