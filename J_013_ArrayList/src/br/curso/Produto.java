package br.curso;

public class Produto  implements Comparable<Produto>{

	private long id;
	private String nome;
	
	public Produto() {
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public Produto(long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int compareTo(Produto p) {
		return this.nome.compareToIgnoreCase(p.getNome());
	}
	
}
