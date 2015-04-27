package br.curso;

public class ClasseMae {

	
	public class ClasseFilha{
		
		public String mostrar(){
			return  "Classe Filha - mostrar";
		}
		
		
	}
	
	
	public static class ClasseFilha_static{
		
		public String mostrar_static(){
			return  "Classe Filha Static - mostrar";
		}
		
	}
	
	
	
	public void fazerTeste(){
		
		ClasseMae.ClasseFilha_static CF = new ClasseFilha_static();
		ClasseFilha cF = new ClasseFilha();
		ClasseFilha_static cFs = new ClasseFilha_static();
		
	}

}
