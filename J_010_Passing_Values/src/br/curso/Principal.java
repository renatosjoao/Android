package br.curso;

public class Principal {

	public Principal() {
	}

	
	public static void giveMEOBJ1(StringBuilder sh){
		sh = new StringBuilder();
		sh.append("Hugo");
		System.out.println(sh.toString());
		
	}
	
	public static void giveMEOBJ2(StringBuilder sh){
		//sh = new StringBuilder();
		sh.append("Hugo 2");
		System.out.println(sh.toString());
		
	}
	
	public static void main(String[] args) {
		StringBuilder st = null;
		StringBuilder st2 = new StringBuilder();
		
		giveMEOBJ1(st);
		giveMEOBJ2(st2);
		
		if ( st != null){
			System.out.println(st.toString());
		}else{
			System.out.println("st == null");
		}
		
		if ( st2 != null){
			System.out.println(st2.toString());
		}else{
			System.out.println("st2 == null");
		}
	}
}
