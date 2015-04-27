package br.curso;

public class Principal implements Veiculo.interfaceMetodos {

	public static void main(String[] args) {
		Veiculo ve = new Veiculo();
		ve.setID(10);
		ve.setValor("Camaro");
		ve.delegate = new Principal();
		
		ve.mostrarValores();
		
		//System.out.println(ve.getID());
		//System.out.println(ve.getValor());
	}

	@Override
	public void chamar(int codigo, String valor) {
		System.out.format("Valores corrigidos: id = %d - Valor = %s ",codigo,valor);
	}
	

}
