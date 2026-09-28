import javax.swing.JFrame;
import javax.swing.JPanel; //donde colocamos los componentes
import javax.swing.JLabel; // texto
import javax.swing.JTextField; // entrada de texto
import javax.swing.JPasswordField; //


public class VentanaPrincipal extends JFrame {

    //Contructor
    public VentanaPrincipal() {

        //Configurar la ventana / Métodos
        setTitle("BiblioMath");
        this.setSize(1800, 850);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Al cerrar la ventana se termina el programa
        this.setLocationRelativeTo(null);  // para que la ventana salga centrada se coloca null


        JPanel panel = new JPanel(); // Los objetos se acomoda automáticamente
        
        //Comopenentes
        JLabel titulo = new JLabel("BiblioMath"); // objeto que representa un texto visible
        
        
        JLabel usuario = new JLabel("Usuario: ");
        JTextField campoUsuario = new JTextField(15); // cuadro donde el usuario puede escribir


        JLabel contrasena = new JLabel("Contraseña: ");
        JTextField campoContrasena = new JTextField(15);

        //Agregar componentes al panel

        panel.add(titulo);

        panel.add(usuario);
        panel.add(campoUsuario);

        panel.add(contrasena);
        panel.add(campoContrasena);

        //Agregar panel al Fram

        add(panel);

        //Mostrar ventana 
        this.setVisible(true);
    }
}