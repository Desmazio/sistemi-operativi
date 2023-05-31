class Rettangolo{
	
	int base = 5, altezza = 10;
	
	void Stampa(){
		System.out.println("Base: " + base + " | Altezza: " + altezza);
	}
	
	void Scala(int valore){
		base += valore;
		altezza += valore;
	}
	
	public static void main(String[] args){
		
		Rettangolo rettangolo = new Rettangolo();
		rettangolo.Stampa();
		
		rettangolo.Scala(5);
		rettangolo.Stampa();
		
	}
	
}
