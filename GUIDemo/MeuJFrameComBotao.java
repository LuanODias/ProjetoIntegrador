import javax.swing.JButton;

public class MeuJFrameComBotao extends MeuJFrame {
    public MeuJFrameComBotao(String title) {
        super(title);

        preparar();
    }

    private void preparar() {
        JButton botao = new JButton("Botao 1");
        add(botao);
    }
} // fim da classe MeuJFrameComBotao 