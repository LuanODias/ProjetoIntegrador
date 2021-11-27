import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ActionEventFrame extends EventFrame {
    private JTextField text1;
	private JTextField text2;
	private JPasswordField passwd;
	private JButton btn;

	public ActionEventFrame() {
		super("Demo ActionEvent");

		preparar();
	}

	private void preparar() {
		ActionEventHandler handler = new ActionEventHandler();

		text1 = new JTextField(50);
		text1.addActionListener(handler);
		adicionaComponente(text1, 0, 0, 1, 1);

		text2 = new JTextField(50);
		text2.addActionListener(handler);
		adicionaComponente(text2, 1, 0, 1, 1);

		passwd = new JPasswordField(50);
		passwd.addActionListener(handler);
		adicionaComponente(passwd, 2, 0, 1, 1);

		btn = new JButton("Clique aqui");
		btn.addActionListener(handler);
		adicionaComponente(btn, 3, 0, 1, 1);
	}

	private class ActionEventHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String msg = "";

			if (e.getSource() == text1) {
				msg = String.format("Pressionou Enter no text1: %s", e.getActionCommand());
			} else if (e.getSource() == text2) {
				msg = String.format("Pressionou Enter no text2: %s", e.getActionCommand());
			} else if (e.getSource() == passwd) {
				msg = String.format("Pressionou Enter na passwd: %s", e.getActionCommand());
			} else { // botao
				msg = String.format("Clicou no btn:\n\ttext1 = %s,\n\ttext2 = %s,\n\tpasswd = %s", text1.getText(),
						text2.getText(), new String(passwd.getPassword()));
			}

			prefixaSaida(msg);
		}
	}
} // fim da classe ActionEventFrame
