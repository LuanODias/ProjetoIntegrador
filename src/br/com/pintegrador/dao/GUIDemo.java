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
        

       demo.exibirPanelFrame();

      
    }

    public void exibirJanelaSimples() {
        JFrame frame = new JFrame();
        frame.setTitle("Demo Componentes Swing");
        frame.setSize(640, 480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void exibirPanelFrame() {
        JFrame frame = new PanelFrame("Demo PanelFrame");
        frame.setVisible(true);
    }
} // fim da classe GUIDemo
