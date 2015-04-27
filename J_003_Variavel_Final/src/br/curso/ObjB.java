/**
 *  
 * 06/05/2014
 * @author Renato Stoffalette Joao
 */
package br.curso;

public class ObjB extends ObjA{

	@Override
	public void enviarMSG(String msg) {
		System.out.println("Nova definição de enviar mensagem "+ msg);
	}

}
