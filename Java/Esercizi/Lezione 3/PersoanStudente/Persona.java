class Persona{
	String nome, cognome;
	int eta;
	
	Persona(String nome, String cognome){
		this.nome = nome;
		this.cognome = cognome;
	}
	
	Persona(String nome, String cognome, int eta){
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
	}
	
	void stampaPersona(){
		System.out.println("PERSONA | Nome: " + nome + ", Cognome: " + cognome + ", Età: " + eta);
	}
	
	public static void main(String[] args){
		//Persona persona = new Persona(args[0], args[1], Integer.parseInt(args[2]));
		//persona.stampaPersona();
		
		Studente studente = new Studente(args[0], args[1], Integer.parseInt(args[2]), Integer.parseInt(args[3]));
		studente.stampaStudente();
		
	}
	
}

class Studente extends Persona{
	int matricola;

	Studente(String nome, String cognome, int eta, int matricola){
		super(nome, cognome, eta);
		this.matricola = matricola;
	}
	
	public void stampaStudente(){
		System.out.println("STUDENTE | Nome: " + nome + ", Cognome: " + cognome + ", Età: " + eta + ", Matricola: " + matricola);
	}

}
