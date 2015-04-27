/**
 *  
 * 07/05/2014
 * @author Renato Stoffalette Joao
 */
package cap6lab1;

public class Cap6_Lab1 {

	public Cap6_Lab1() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Funcionario f1 = new Funcionario("Joao", "Pedro", "Programador", 4000f);
		
		System.out.println("Nome : " +f1.getNome());
		System.out.println("Sobrenome : " +f1.getSobrenome());
		System.out.println("Cargo : " +f1.getCargo());
		System.out.println("Salario : " +f1.getSalario());
		
	}

}
