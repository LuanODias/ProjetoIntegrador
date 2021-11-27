import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JComponent;

public class GridBagLayoutFrame extends MeuJFrame {
    private GridBagLayout layout;
    private GridBagConstraints constraints;

    public GridBagLayoutFrame(String title) {
        super(title);

        layout = new GridBagLayout();
        setLayout(layout);

        constraints = new GridBagConstraints();

        preparar();
    }

    private void preparar() {
        JButton botao;

		botao = new JButton("Botão 1");
		adicionaComponente(botao, 0, 0, 1, 1);

		botao = new JButton("Botão 2");
		adicionaComponente(botao, 0, 1, 1, 1);

		botao = new JButton("Botão 3");
		constraints.weightx = 10;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		adicionaComponente(botao, 1, 0, 2, 1);

		botao = new JButton("Botão 4");
		constraints.fill = GridBagConstraints.HORIZONTAL;
		adicionaComponente(botao, 2, 0, 1, 1);

		botao = new JButton("Botão 5");
		constraints.fill = GridBagConstraints.HORIZONTAL;
		adicionaComponente(botao, 3, 0, 1, 1);
		
		botao = new JButton("Botão 6");
		constraints.fill = GridBagConstraints.BOTH;
		adicionaComponente(botao, 2, 1, 1, 2);
    }

    private void adicionaComponente(JComponent componente, int linha, int coluna, int largura, int altura) {
        constraints.gridx = coluna;
		constraints.gridy = linha;
		constraints.gridwidth = largura;
		constraints.gridheight = altura;

		layout.setConstraints(componente, constraints);
		add(componente);
    }
} // fim da classe GridBagLayoutFrame
