import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class EventFrame extends MeuJFrame {
    private static final Insets FIELD_INSETS = new Insets(5, 10, 0, 0);

	private GridBagLayout panelLayout;
	private GridBagConstraints constraints;

	private JPanel panel;
	private JTextArea output;

    public EventFrame(String title) {
        super(title);

        panelLayout = new GridBagLayout();
		constraints = new GridBagConstraints();
		panel = new JPanel();
		output = new JTextArea();

        GridLayout layout = new GridLayout(1, 2, 2, 2);
        setLayout(layout);

        preparar();
    }

    private void preparar() {
        panel.setLayout(panelLayout);
        add(panel);

        add(output);
    }

    public void adicionaComponente(JComponent componente, int linha, int coluna, int largura, int altura) {
        constraints.gridx = coluna;
		constraints.gridy = linha;
		constraints.gridwidth = largura;
		constraints.gridheight = altura;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = FIELD_INSETS;

		panelLayout.setConstraints(componente, constraints);
		panel.add(componente);
    }

    public void prefixaSaida(String mensagem) {
        output.setText(mensagem + "\n" + output.getText());
    }

} // fim da classe EventFrame
