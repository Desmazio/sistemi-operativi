public class TestAuto {

    public static void main(String[] args) {

        System.out.println("Creazione prima auto");
        Auto primaAuto = new Auto("AC123BA");
        primaAuto.stampaInfo();

        System.out.println("\nCreazione seconda auto");
        Auto secondaAuto = new Auto("AC666BCD");
        secondaAuto.stampaInfo();

        System.out.println("\nCreazione terza auto");
        Auto terzaAuto = new Auto("PA546CA");
        terzaAuto.stampaInfo();

        System.out.println("\nLe auto sono state create.\nStampiamo di nuovo le loro informazioni.");

        System.out.println("\nInfo prima auto:");
        primaAuto.stampaInfo();

        System.out.println("\nInfo seconda auto:");
        secondaAuto.stampaInfo();

        System.out.println("\nInfo terza auto");
        terzaAuto.stampaInfo();
    }

}

class Auto {

	String targa;
	static int numeroTelaio = 0;
	
	Auto(String targa){
		this.targa = targa;
		this.numeroTelaio += 1;
	}
	
	public void stampaInfo(){
		System.out.println("N° telaio: " +  + ", Targa: " + targa);
	}

}
