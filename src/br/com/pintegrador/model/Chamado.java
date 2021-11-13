package br.com.pintegrador.model;

import java.util.Date;

public class Chamado {
	private int id_chamado;
	private String numero_chamado;
	private int km_rodado;
	private double CO2;
	private Date data;
	

	private int veiculo;
	private int colaborador;
	
	

	public Chamado(String numero_chamado, int km_rodado, double cO2, Date data, int veiculo, int colaborador) {
		super();
		this.numero_chamado = numero_chamado;
		this.km_rodado = km_rodado;
		CO2 = cO2;
		this.data = data;
		this.veiculo = veiculo;
		this.colaborador = colaborador;
	}

	public int getId() {
		return id_chamado;
	}

	public void setId(int id_chamado) {
		this.id_chamado = id_chamado;
	}

	public String getNumero_chamado() {
		return numero_chamado;
	}

	public void setNumero_chamado(String numero_chamado) {
		this.numero_chamado = numero_chamado;
	}
	
	public Date getData() {
		return data;
	}

	public void setData(Date date) {
		this.data = date;
	}

	public int getKm_rodado() {
		return km_rodado;
	}

	public void setKm_rodado(int km_rodado) {
		this.km_rodado = km_rodado;
	}

	public double getCO2() {
		return CO2;
	}

	public void setCO2(double cO2) {
		CO2 = cO2;
	}


	public int getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(int veiculo) {
		this.veiculo = veiculo;
	}

	public int getColaborador() {
		return colaborador;
	}

	public void setColaborador(int colaborador) {
		this.colaborador = colaborador;
	}	
	
}
