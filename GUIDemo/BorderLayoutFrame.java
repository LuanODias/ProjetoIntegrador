import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;

public class BorderLayoutFrame extends MeuJFrame {
    public BorderLayoutFrame(String title) {
        super(title);

        BorderLayout layout = new BorderLayout(5, 5);
        setLayout(layout);

        preparar();
    }

    private void preparar() {
        JButton botao;
		
		botao = new JButton("Botão 1");
		add(botao, BorderLayout.NORTH);
		
		botao = new JButton("Botão 2");
		add(botao, BorderLayout.SOUTH);
		
		botao = new JButton("Botão 3");
		botao.setPreferredSize(new Dimension(200, 100));
		add(botao, BorderLayout.EAST);
		
		botao = new JButton("Botão 4");
		add(botao, BorderLayout.WEST);
		
		botao = new JButton("Botão 5");
		add(botao, BorderLayout.CENTER);
    }
} // fim da classe BorderLayoutFrame
