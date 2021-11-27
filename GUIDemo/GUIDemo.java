import javax.swing.JFrame;

/**
 * Exemplos de componentes de interface gráfica de usuário da
 * biblioteca Java Swing.
 * 
 * Cada método exemplica a utilização de um ou mais componentes.
 * Descomente a chamada de método correspondente para visualizar
 * o resultado. Recomenda-se descomentar uma chamada de cada vez.
 */
public class GUIDemo {
    public static void main(String[] args) {
        GUIDemo demo = new GUIDemo();
        
        //demo.exibirJanelaSimples();
        //demo.exibirMeuJFrame();
        //demo.exibirMeuJFrameComBotao();

        //demo.exibirBorderLayoutFrame();
        //demo.exibirFlowLayoutFrame();
        //demo.exibirGridLayoutFrame();
        //demo.exibirGridBagLayoutFrame();
        //demo.exibirNullLayoutFrame();

       demo.exibirPanelFrame();

        // demo.exibirInputFieldsFrame();
        
       //  demo.exibirActionEventFrame();
         //demo.exibirItemEventFrame();
         //demo.exibirListSelectionEventFrame();
    }

    public void exibirJanelaSimples() {
        JFrame frame = new JFrame();
        frame.setTitle("Demo Componentes Swing");
        frame.setSize(640, 480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void exibirMeuJFrame() {
        JFrame frame = new MeuJFrame("Demo MeuJFrame");
        frame.setVisible(true);
    }

    public void exibirMeuJFrameComBotao() {
        JFrame frame = new MeuJFrameComBotao("Demo MeuJFrameComBotao");
        frame.setVisible(true);
    }

    public void exibirBorderLayoutFrame() {
        JFrame frame = new BorderLayoutFrame("Demo BorderLayoutFrame");
        frame.setVisible(true);
    }

    public void exibirFlowLayoutFrame() {
        JFrame frame = new FlowLayoutFrame("Demo FlowLayoutFrame");
        frame.setVisible(true);
    }

    public void exibirGridLayoutFrame() {
        JFrame frame = new GridLayoutFrame("Demo GridLayoutFrame");
        frame.setVisible(true);
    }

    public void exibirGridBagLayoutFrame() {
        JFrame frame = new GridBagLayoutFrame("Demo GridBagLayoutFrame");
        frame.setVisible(true);
    }

    public void exibirNullLayoutFrame() {
        JFrame frame = new NullLayoutFrame("Demo NullLayoutFrame");
        frame.setVisible(true);
    }

    public void exibirPanelFrame() {
        JFrame frame = new PanelFrame("Demo PanelFrame");
        frame.setVisible(true);
    }

    public void exibirInputFieldsFrame() {
        JFrame frame = new InputFieldsFrame();
        frame.setVisible(true);
    }

    public void exibirActionEventFrame() {
        JFrame frame = new ActionEventFrame();
        frame.setVisible(true);
    }

    public void exibirItemEventFrame() {
        JFrame frame = new ItemEventFrame();
        frame.setVisible(true);
    }

    public void exibirListSelectionEventFrame() {
        JFrame frame = new ListSelectionEventFrame();
        frame.setVisible(true);
    }
} // fim da classe GUIDemo
