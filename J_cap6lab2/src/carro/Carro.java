/**
 *  
 * 07/05/2014
 * @author Renato Stoffalette Joao
 */
package carro;

public class Carro {

	
	private String modelo;
	private double potencia;
	private String cor;
	
	
	public Carro(String modelo, double potencia, String cor) {
		super();
		this.modelo = modelo;
		this.potencia = potencia;
		this.cor = cor;
	}

	public Carro() {
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public double getPotencia() {
		return potencia;
	}


	public void setPotencia(double potencia) {
		this.potencia = potencia;
	}


	public String getCor() {
		return cor;
	}


	public void setCor(String cor) {
		this.cor = cor;
	}

}
