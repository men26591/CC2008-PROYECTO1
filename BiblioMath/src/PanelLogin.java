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


        //Contenido Principal


        JPanel contenido = new JPanel(new GridLayout(1,2));

        JPanel formulario = new JPanel();
        JPanel ilustracion = new JPanel();

        formulario.add(new JLabel("FORMULARIO"));
        contenido.add(formulario);
        contenido.add(ilustracion);

        //Cargar imagen LOGO MATE
        ImageIcon imagenDecorativa = new ImageIcon("BiblioMath/recursos/imagenLogin.png");
        //Modifcar tamaño
        Image imagenDeEscalada = imagenDecorativa.getImage().getScaledInstance(400,400,Image.SCALE_SMOOTH);
        //Convetir nuevamente a ImageIcon
        ImageIcon imagenDeEscaladaEscalado = new ImageIcon(imagenDeEscalada);
        //Agregar a Jlabel para mostrar
        JLabel imagenDecorativaEscalonado = new JLabel(imagenDeEscaladaEscalado);
        encabezado.add(imagenDecorativaEscalonado,BorderLayout.CENTER);
        ilustracion.add(imagenDecorativaEscalonado);

        

        //Agregar todo al panel

        //Agregar los Jpanel y dalres una ubicacacion de referencia
        
        this.add(encabezado, BorderLayout.NORTH); //Los agregamos y colcoamos donde queremos que aparezcan 
        this.add(contenido, BorderLayout.CENTER); //Los agregamos y colcoamos donde queremos que aparezcan 
        
    }
}