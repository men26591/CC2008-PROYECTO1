import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelKits extends JPanel { //Función: Interfaz de kits

    public PanelKits(Sistema sistema) {
        add(new JLabel("Kits de estudio"));
        setVisible(true);
        setSize(1000, 750);
    }
}