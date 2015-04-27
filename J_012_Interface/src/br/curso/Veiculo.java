package br.curso;

public class Veiculo {

	
	private int ID;
	private String valor;
	
	public interfaceMetodos delegate;
	
	public interface interfaceMetodos{
		
		public void chamar(int codigo, String valor);
		
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	
	public void mostrarValores(){
		this.ID +=20;
		this.valor = "mudei o valor: " + this.valor;
		//
		if ( delegate != null){
			delegate.chamar(this.ID,this.valor);
		}
	}
}
