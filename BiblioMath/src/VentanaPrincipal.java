import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaPrincipal extends JFrame {

    private CardLayout cardLayout;
    private JPanel contenedor;

    //Contructor
    public VentanaPrincipal(Sistema sistema) {

        //Configurar la ventana / Métodos
        setTitle("BiblioMath");
        setSize(1000, 850);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Al cerrar la ventana se termina el programa
        setLocationRelativeTo(null);  // para que la ventana salga centrada se coloca null

        cardLayout = new CardLayout();
        contenedor = new JPanel(cardLayout);

        contenedor.add(new PanelLogin(sistema), "login");
        contenedor.add(new PanelInicio(sistema), "inicio");
        contenedor.add(new PanelAgregarConcepto(sistema), "agregar");
        contenedor.add(new PanelBiblioteca(sistema), "biblioteca");
        contenedor.add(new PanelKits(sistema), "kits");

        add(contenedor);
        setVisible(true);
    }
            
    public void mostrarPanel(String nombrePanel) {
        cardLayout.show(contenedor, nombrePanel);
}

}