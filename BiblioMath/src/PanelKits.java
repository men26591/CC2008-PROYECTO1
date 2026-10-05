import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelKits extends JPanel {

    public PanelKits(Sistema sistema) {
        add(new JLabel("Kits de estudio"));
        JFrame a = new JFrame();
        a.setVisible(true);
        a.setSize(1000, 750);
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a.setLocationRelativeTo(null);
    }
}