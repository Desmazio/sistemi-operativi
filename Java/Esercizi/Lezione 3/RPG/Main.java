class Main{

	public static void main(String[] args){
		Mago mago = new Mago("Giovanni", 80, 15, 20);
		Fisico fisico = new Fisico("Maurizio", 100, 25);
		
		mago.stampaStato();
		fisico.stampaStato();
		
		mago.subisciDanno(fisico.carica());
		fisico.subisciDanno(mago.lanciaIncantesimo());
		
		mago.stampaStato();
		fisico.stampaStato();
	}

}

class Personaggio{
	String nome;
	int puntiVita, forza;
	
	Personaggio(String nome, int puntiVita, int forza){
		this.nome = nome;
		this.puntiVita = puntiVita;
		this.forza = forza;
	}
	
	public void stampaStato(){
		System.out.println(nome + ", " + puntiVita + ", " + forza);
	}

	public void subisciDanno(int danno){
		puntiVita -= danno;
		if(puntiVita < 0)
			puntiVita = 0;
	}

}

class Mago extends Personaggio{
	int mana;
	
	Mago(String nome, int puntiVita, int forza, int mana){
		super(nome, puntiVita, forza);
		this.mana = mana;
	}

	public int  lanciaIncantesimo(){
		return mana;
	}

}

class Fisico extends Personaggio{

	Fisico(String nome, int puntiVita, int forza){
		super(nome, puntiVita, forza);	
	}

	public int carica(){
		return forza;
	}

}







