import java.awt.CardLayout; // Es como para poner varios componentes en un espacio
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaPrincipal extends JFrame {  // Función:. administrar la ventana y sus pantallas

    private CardLayout cardLayout;
    private JPanel contenedor;

    public VentanaPrincipal(Sistema sistema) {

        setTitle("BiblioMath");
        setSize(1000, 750);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout(); // Crea el CardLayout 
        contenedor = new JPanel(cardLayout);  //Se crea un panel (donde vamos a mostrar ) que se organizará con cardLayout

        contenedor.add(new PanelLogin(sistema), "login"); // Se meten todas las pantallas dentro de ese panel  y crea las pantallas
        contenedor.add(new PanelRegistro(sistema), "registro"); //Crea la pantalla, agrega el cardLayout y agrega el nombre
        contenedor.add(new PanelInicio(sistema), "inicio");
        contenedor.add(new PanelBiblioteca(sistema), "biblioteca");
        contenedor.add(new PanelAgregarConcepto(sistema), "agregar" );
        contenedor.add(new PanelKits(sistema), "kits");

        add(contenedor); // Se agrega el contendro a la ventana

        setVisible(true); // Para que se visible 
    }

    public void mostrarPanel(String nombrePanel) { //Método para cambiar de pantalla (panel) más no cambia de VENTANA, está siempre es la misma (Esta esctructura aparece en SISTEMA)
        cardLayout.show(contenedor, nombrePanel);
    }
}