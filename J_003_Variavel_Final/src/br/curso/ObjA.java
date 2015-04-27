/**
 *  
 * 06/05/2014
 * @author Renato Stoffalette Joao
 */
package br.curso;

public class ObjA {
	
		public final String CONST_A = "Valor da constante A";
		public String const_Aux = "Valor Aux";
		
		
		public void enviarMSG(String msg){
			System.out.println(msg);
		}
		
		
		public final void enviarMSG_Aux(String msg){
			System.out.println(msg);
		}
		
}
