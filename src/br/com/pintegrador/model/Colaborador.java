package br.com.pintegrador.model;

public class Colaborador {
	
	private int id_colaborador;
	private String nome;
	private String matricula;
	
	
	
	
	public Colaborador(String nome, String matricula) {
		super();
		this.nome = nome;
		this.matricula = matricula;
	}
	
	
	public int getId() {
		return id_colaborador;
	}
	public void setId(int id) {
		this.id_colaborador = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	
	
}
