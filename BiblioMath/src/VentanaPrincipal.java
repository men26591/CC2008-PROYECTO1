import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaPrincipal extends JFrame {

    private CardLayout cardLayout;
    private JPanel contenedor;

    public VentanaPrincipal(Sistema sistema) {

        setTitle("BiblioMath");
        setSize(1000, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        contenedor = new JPanel(cardLayout);

        contenedor.add(new PanelLogin(sistema), "login");
        contenedor.add(new PanelRegistro(sistema), "registro");
        contenedor.add(new PanelInicio(sistema), "inicio");
        contenedor.add(new PanelBiblioteca(sistema), "biblioteca");
        contenedor.add(
            new PanelAgregarConcepto(sistema),
            "agregar"
        );
        contenedor.add(new PanelKits(sistema), "kits");

        add(contenedor);

        setVisible(true);
    }

    public void mostrarPanel(String nombrePanel) {
        cardLayout.show(contenedor, nombrePanel);
    }
}