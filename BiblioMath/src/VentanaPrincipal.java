import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame {

    //Contructor
    public VentanaPrincipal() {

        //Configurar la ventana / Métodos
        this.setTitle("BiblioMath");
        this.setSize(1000, 850);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Al cerrar la ventana se termina el programa
        this.setLocationRelativeTo(null);  // para que la ventana salga centrada se coloca null
        
        PanelLogin panelLogin = new PanelLogin();
        
        this.add(panelLogin);
        this.setVisible(true);
    }
}