import java.awt.BorderLayout; // Importa un administrador de diseño que divide un contenedor en 5 regiones
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Font; //Permite agregar fuentes
import java.awt.Dimension;
import javax.swing.JPanel; // Agrupar elementos visuales dentro de la ventana
import javax.swing.ImageIcon; //Agregar imagenes 
import javax.swing.JLabel;
import javax.swing.JTextField; //Recibe el texto normal
import javax.swing.JPasswordField; //Recibe contraseña y agrega los puntitos 
import javax.swing.JButton; //Permite ejetuar la acción
import javax.swing.BoxLayout; // Permite ordenar elementos, es algo gráfico
import javax.swing.BorderFactory;
import javax.swing.Box; // Acompañana al BoxLayout es como un contendor ligero y una herramienta para crear espacio en blanco 


public class PanelKits extends JPanel { //Función: Interfaz de kits

    public PanelKits(Sistema sistema) {
         //ENCABEZADO
        JPanel encabezado = new JPanel(new BorderLayout());  // Para agregar eso de ubicaciones, si queres al norte, este...

    
        encabezado.setBorder(BorderFactory.createEmptyBorder(15, 30, 15, 30)); //Los bordes (arriba, iz, abajo, de) sería un tipo de padding/margen

        //Cargar imagen
        ImageIcon logoBiblioOriginal = new ImageIcon("BiblioMath/recursos/logoBiblio.png"); //Agregamos la imagen "carpeta/carpeta/archivo.loqueEs"
        //Cambiar el TAMAÑO de la imagen
        Image logoBiEscalada =  logoBiblioOriginal.getImage().getScaledInstance(280, 70, Image.SCALE_SMOOTH);
        //Convertir nuevamente a ImageIcon
        ImageIcon logoBiblioEscalado = new ImageIcon(logoBiEscalada);

        JLabel logoBiblio =new JLabel(logoBiblioEscalado); //Jlabel que mostrrá la imagen
        encabezado.add(logoBiblio,BorderLayout.WEST);


        //Cargar imagen LOGO MATE
        ImageIcon logoMateUVG = new ImageIcon("BiblioMath/recursos/logoMate.png");
        //Modifcar tamaño
        Image logoMaEscalada = logoMateUVG.getImage().getScaledInstance(70,70,Image.SCALE_SMOOTH);
        //Convetir nuevamente a ImageIcon
        ImageIcon logoMateUVGEscalonado = new ImageIcon(logoMaEscalada);
        //Agregar a Jlabel para mostrar
        JLabel logoMate = new JLabel(logoMateUVGEscalonado);
        encabezado.add(logoMate,BorderLayout.EAST);

        //Panel de la izquierda

        JPanel panelIzquierdo = new JPanel(new BorderLayout());
        panelIzquierdo.setBorder(BorderFactory.createEmptyBorder(25, 45, 25, 45));
        // Mostrar texto
        JLabel textoLogin = new JLabel("Log in");
        textoLogin.setFont(new Font ("SansSerif", Font.PLAIN, 13)); //Poner una fuente al texto. 
        textoLogin.setAlignmentX(LEFT_ALIGNMENT); // Para que se posiciones a la derecha
    }
}