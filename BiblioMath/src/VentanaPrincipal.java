import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame {

    public VentanaPrincipal() {

        setTitle("BiblioMath");
        this.setSize(1800, 850);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);  // para que la ventana salga centrada se coloca null
        this.setVisible(true);
        
        
        //Llamamos a a la parte grafica gráfica
        //GraphicsWelcome graficosW = new GraphicsWelcome();
        //this.add(graficosW);
        //this.setVisible(true);
    }
}