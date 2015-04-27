/**
 *  
 * 06/05/2014
 * @author Renato Stoffalette Joao
 */
package br.curso;

public class ObjC extends ObjB{

	@Override
	public void enviarMSG(String msg){
		super.enviarMSG(msg);
		System.out.println("Definição na classeC " + msg);  
	}
	
	public static void main(String[] args) {
		ObjC objc = new ObjC();
		ObjA obja = new ObjA();
		
		objc.enviarMSG("Hello");
		

	}

}
