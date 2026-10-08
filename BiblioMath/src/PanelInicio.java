import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BorderFactory; //Aplicar bordes
import javax.swing.ImageIcon;

import java.awt.Image; // Agregar imageness
import java.awt.Color; // Permite agregar colores
import java.awt.Graphics; //Permite agregar graficos (figuras)
import java.awt.BorderLayout; // Importa un administrador de diseño que divide un contenedor en 5 regiones

public class PanelInicio extends JPanel { // Función: Interfaz de inicio

    public PanelInicio(Sistema sistema) {

        add(new JLabel("Inicio"));

        // ese this es tomar el JPanel y lo que hagas se modifica ahí
        this.setBackground(new Color(175, 199, 250));
        this.setLayout(new BorderLayout()); // Es para agregar eso de ubicaciones, si quere norte, este 
    
        JPanel encabezado = new JPanel(new BorderLayout());
        encabezado.setBorder(BorderFactory.createEmptyBorder(25, 55, 100, 55));
        encabezado.setOpaque(false);  // para que el panle que agregagamos no tenga color, osea que se transparente                 //Cargar imagen

        //Carga imagen del logo de biblioMath
        ImageIcon logoBiblioOriginal = new ImageIcon("BiblioMath/recursos/logoBiblio.png"); //Agregamos la imagen "carpeta/carpeta/archivo.loqueEs"
        //Cambiar el TAMAÑO de la imagen
        Image logoBiEscalada =  logoBiblioOriginal.getImage().getScaledInstance(230, 50, Image.SCALE_SMOOTH);
        //Convertir nuevamente a ImageIcon
        ImageIcon logoBiblioEscalado = new ImageIcon(logoBiEscalada);

        JLabel logoBiblio =new JLabel(logoBiblioEscalado); //Jlabel que mostrrá la imagen
        encabezado.add(logoBiblio,BorderLayout.WEST);


        //Cargar imagen LOGO MATE
        ImageIcon logoMateUVG = new ImageIcon("BiblioMath/recursos/logoMate.png");
        //Modifcar tamaño
        Image logoMaEscalada = logoMateUVG.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
        //Convetir nuevamente a ImageIcon
        ImageIcon logoMateUVGEscalonado = new ImageIcon(logoMaEscalada);
        //Agregar a Jlabel para mostrar
        JLabel logoMate = new JLabel(logoMateUVGEscalonado);
        encabezado.add(logoMate,BorderLayout.EAST);

          // Se añanden para que se muestre si no no se muestra!!!!
        this.add(encabezado, BorderLayout.NORTH); //Los agregamos y colcoamos donde queremos que aparezcan 
    }

    public void paintComponent(Graphics g) { // paint -> pintura y Component -> cuidad al escribir. Graphics -> g (el nombre de la cariables o algo así)
       
        super.paintComponent(g); // para que nos deje usar lo como un lienzo y que se vaya al FRAME completo, y todo hacer referencia a Graphics

        g.setColor(Color.BLACK); // aplica este color hasta que aparesca otro color. 
        g.drawRect(50, 20, 900,  60); // x,y, ancho y alto
        
        g.setColor(Color.WHITE);
        g.fillRect(50, 20, 900, 60); //figuara llena de color
    }
}

