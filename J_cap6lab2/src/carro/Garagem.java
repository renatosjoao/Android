package carro;

public class Garagem {

	private Carro carroPasseio;
	private Carro carroUtilitario;
	
	public Garagem() {
	}

	
	
	public static void main(String[] args) {

		Garagem g = new Garagem();
		g.carroPasseio =  new Carro("VW Jetta",2.3,"Vermelha");
		g.carroUtilitario = new Carro("Renault Boxer",3.8,"Branca");
				
		System.out.println("-----------------------");
		System.out.println("Carro de Passeio :");
		System.out.println("Cor : " +g.carroPasseio.getCor());
		System.out.println("Modelo : " +g.carroPasseio.getModelo());
		System.out.println("Potencia : " +g.carroPasseio.getPotencia());
		
		System.out.println("-----------------------");
		System.out.println("Carro Utilitario :");
		System.out.println("Cor : " +g.carroUtilitario.getCor());
		System.out.println("Modelo : " +g.carroUtilitario.getModelo());
		System.out.println("Potencia : " +g.carroUtilitario.getPotencia());
	}

	
}
