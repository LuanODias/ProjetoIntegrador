import java.awt.FlowLayout;

import javax.swing.JButton;

public class FlowLayoutFrame extends MeuJFrame {
    public FlowLayoutFrame(String title) {
        super(title);

        FlowLayout layout = new FlowLayout();
        setLayout(layout);

        preparar();
    }

    private void preparar() {
        final int NUM_BOTOES = 5;
		
		for (int i = 1; i <= NUM_BOTOES; i++) {
			add(new JButton("Botão " + i));
		}
    }
} // fim da classe FlowLayoutFrame 
