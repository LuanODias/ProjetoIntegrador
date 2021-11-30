package br.com.pintegrador.util;
import javax.swing.JFrame;

import br.com.pintegrador.interfaces.*;

public class Utilitarios {

	public void telas(String tela, JFrame menu) {
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
		}
		
		
	}
}
