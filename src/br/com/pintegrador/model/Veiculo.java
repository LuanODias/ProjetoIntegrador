package br.com.pintegrador.model;

public class Veiculo {

	private int id_veiculo;
	private String ano;
	private String modelo;
	private double autonomia;
	
	public Veiculo(String ano, String modelo, double autonomia) {
		super();
		this.ano = ano;
		this.modelo = modelo;
		this.autonomia = autonomia;
	}

	public int getId() {
		return id_veiculo;
	}

	public void setId(int id) {
		this.id_veiculo = id;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public double getAutonomia() {
		return autonomia;
	}

	public void setAutonomia(double autonomia) {
		this.autonomia = autonomia;
	}
	
	
	
	
}
