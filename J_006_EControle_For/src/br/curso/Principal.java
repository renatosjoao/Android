/**
 *  
 * 07/05/2014
 * @author Renato Stoffalette Joao
 */
package br.curso;

public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int index[] = {1, 2, 3};
		for (int i = 0; i <25; i++){
			if (i==10){
				break;
			}
			System.out.println(i);
		}
		System.out.println("------------------------");
		//for (int i : index){
		//	System.out.println(i);
		//}
		for (int i = 0; i <25; i++){
			if (i==10){
				continue;
			}
			System.out.println(i);
		}
	}

}
