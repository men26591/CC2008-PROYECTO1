import java.awt.BorderLayout; // Importa un administrador de diseño que divide un contenedor en 5 regiones
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JPanel; // Agrupar elementos visuales dentro de la ventana
import javax.swing.ImageIcon; //Agregar imagenes 
import javax.swing.JLabel;


import javax.swing.BorderFactory; //Aplicar bordes


public class PanelLogin extends JPanel { // Función: Interfaz de login

    public PanelLogin(Sistema sistema) { // Tiene Sistema sistema porque reciben referencia de Sistema, pues es ahí donde se "activa/muestra"

        this.setLayout(new BorderLayout()); // Layout principal   se divide en regiones 

        
        //ENCABEZASO
        JPanel encabezado = new JPanel(new BorderLayout());  // Para agregar eso de ubicaciones, si queres al norte, este...

    
        encabezado.setBorder(BorderFactory.createEmptyBorder(15, 30, 15, 30)); //Los bordes (arriba, iz, abajo, de) sería un tipo de padding/margen

        //Cargar imagen
        ImageIcon logoBiblio = new ImageIcon("BiblioMath/recursos/logoBiblio.png"); //Agregamos la imagen "carpeta/carpeta/archivo.loqueEs"
        

        JLabel logoBiblioIzquierda =new JLabel(logoBiblio);

        encabezado.add(logoBiblioIzquierda,BorderLayout.WEST);


        //Contenido Principal


        JPanel contenido = new JPanel(new GridLayout(1,2));

        JPanel formulario = new JPanel();
        JPanel ilustracion = new JPanel();

        formulario.add(new JLabel("FORMULARIO"));
        ilustracion.add(new JLabel("IMAGEN"));

        contenido.add(formulario);
        contenido.add(ilustracion);

        //Agregar todo al panel

        //Agregar los Jpanel y dalres una ubicacacion de referencia
        
        this.add(encabezado, BorderLayout.NORTH); //Los agregamos y colcoamos donde queremos que aparezcan 
        this.add(contenido, BorderLayout.CENTER); //Los agregamos y colcoamos donde queremos que aparezcan 
        
    }
}