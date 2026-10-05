import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelDetalleConcepto extends JPanel {

    public PanelDetalleConcepto(Sistema sistema) {
        add(new JLabel("Biblioteca"));
        JFrame a = new JFrame();
        a.setVisible(true);
        a.setSize(1000, 750);
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a.setLocationRelativeTo(null);
        Color celesteFondo = new Color(210, 224, 255);
        a.setBackground(celesteFondo);
    }
}