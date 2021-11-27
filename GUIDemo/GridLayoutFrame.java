import java.awt.GridLayout;

import javax.swing.JButton;

public class GridLayoutFrame extends MeuJFrame {
    public GridLayoutFrame(String title) {
        super(title);

        GridLayout layout = new GridLayout(2, 3, 5, 5);
        setLayout(layout);

        preparar();
    }

    private void preparar() {
        final int NUM_BOTOES = 5;

		for (int i = 1; i <= NUM_BOTOES; i++) {
			add(new JButton("Botão " + i));
		}
    }
} // fim da classe GridLayoutFrame
