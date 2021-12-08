package br.com.pintegrador.util;
import javax.swing.JFrame;

import br.com.pintegrador.interfaces.TelaAtualizarChamado;
import br.com.pintegrador.interfaces.TelaAtualizarColaborador;
import br.com.pintegrador.interfaces.TelaAtualizarVeiculo;
import br.com.pintegrador.interfaces.TelaCadastroChamado;
import br.com.pintegrador.interfaces.TelaCadastroColaborador;
import br.com.pintegrador.interfaces.TelaCadastroVeiculo;
import br.com.pintegrador.interfaces.TelaListagem;
import br.com.pintegrador.interfaces.TelaListagemChamado;
import br.com.pintegrador.interfaces.TelaListagemColaborador;
import br.com.pintegrador.interfaces.TelaListagemVeiculo;

public class Utilitarios {
	
	public void telas(String tela, JFrame menu, int id) {
		switch(tela) {
		case "chamado":
				TelaListagemChamado telaChamado = new TelaListagemChamado();
				telaChamado.setVisible(true);
				menu.setVisible(false);
				break;
		case "veiculo":
				TelaListagemVeiculo telaVeiculo = new TelaListagemVeiculo();
				telaVeiculo.setVisible(true);
				menu.setVisible(false);
				break;
		case "colaborador":
				TelaListagemColaborador telaColaborador = new TelaListagemColaborador();
				telaColaborador.setVisible(true);
				menu.setVisible(false);
				break;
		case "criarVeiculo": 
				TelaCadastroVeiculo telaCriarVeiculo = new TelaCadastroVeiculo();
				telaCriarVeiculo.setVisible(true);
				menu.setVisible(false);
				break;
		case "criarChamado": 
				TelaCadastroChamado telaCriarChamado = new TelaCadastroChamado();
				telaCriarChamado.setVisible(true);
				menu.setVisible(false);
				break;
		case "criarColaborador":
				TelaCadastroColaborador telaCriarColaborador = new TelaCadastroColaborador();
				telaCriarColaborador.setVisible(true);
				menu.setVisible(false);
				break;
		case "editarVeiculo":
				TelaAtualizarVeiculo atualizarVeiculo = new TelaAtualizarVeiculo();
				atualizarVeiculo.setId(id);
				atualizarVeiculo.setVisible(true);
				menu.setVisible(false);
				break;
		case "editarColaborador":
				TelaAtualizarColaborador atualizarcolaborador = new TelaAtualizarColaborador();
				atualizarcolaborador.setId(id);
				atualizarcolaborador.setVisible(true);
				menu.setVisible(false);
				break;
		case "editarChamado":
			TelaAtualizarChamado atualizarchamado = new TelaAtualizarChamado();
			atualizarchamado.setId(id);
			atualizarchamado.setVisible(true);
			menu.setVisible(false);
			break;
		case "principal":
			TelaListagem principal = new TelaListagem();
			principal.setVisible(true);
			menu.setVisible(false);
			break;
		}
		
	}
	
	public double calularPegadaCarbono(int km_rodado, double autonomia){
		double consumogasolina = km_rodado / autonomia;
		double CO2 = consumogasolina * 0.73 * 0.75 * 3.7;
		return CO2;
	}
}
