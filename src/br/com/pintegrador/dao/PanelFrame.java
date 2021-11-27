import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelFrame extends MeuJFrame {
    public PanelFrame(String title) {
        super(title);

        BorderLayout layout = new BorderLayout(2, 2);
        setLayout(layout);

        preparar();
    }

    private void preparar() {
        JPanel panel;
		JButton button;
		
		panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setPreferredSize(new Dimension(100, 80));
		add(panel, BorderLayout.NORTH);
		
		panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setPreferredSize(new Dimension(150, 100));
		panel.setLayout(new FlowLayout()); // default

		JButton botao_veiculo = new JButton("VEICULOS");
		panel.add(botao_veiculo);
		botao_veiculo.addActionListener(e->{
			TabelaVeiculos();
		});
		JButton botao_colaborabor = new JButton("COLABORADORES");
		panel.add(botao_colaborabor);
		JButton botao_chamados = new JButton("CHAMADOS");
		panel.add(botao_chamados);

		add(panel, BorderLayout.WEST);
		panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		add(panel, BorderLayout.CENTER);
    }
	public void TabelaVeiculos(){

		JOptionPane.showMessageDialog(null, 
                                                  "Tarefa incluída com sucesso", 
                                                  "Todo App", 
                                                  JOptionPane.INFORMATION_MESSAGE);
	}
} // fim da classe PanelFrame
