import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Dimension; //Permite modificar los paneles

import java.awt.Image; // Agregar imageness
import java.awt.Graphics; //Permite agregar graficos (figuras)
import java.awt.BorderLayout; // Importa un administrador de diseño que divide un contenedor en 5 regiones
import java.awt.Color; // Permite agregar colores
import java.awt.FlowLayout; // Alinial los elemento de forma especifica, los acomoda uno tras otro 

public class PanelBiblioteca extends JPanel { //Función: Interfaz de biblioteca

    public PanelBiblioteca(Sistema sistema) {
        add(new JLabel("Biblioteca"));

        //this es
        this.setBackground(new Color(210, 224, 255));
        this.setLayout(new BorderLayout()); // Es para agregar eso de ubicaciones, si quere norte, este 
//ENCABEZADO *******************************************
        JPanel encabezado = new JPanel(new BorderLayout());
        encabezado.setBorder(BorderFactory.createEmptyBorder(25, 55, 30, 55));
        encabezado.setOpaque(false);  // para que el panle que agregagamos no tenga color, osea que se transparente                 //Cargar imagen
    
    //BOTON LOGO
        //Carga imagen del logo de biblioMath
        ImageIcon logoBiblioOriginal = new ImageIcon("BiblioMath/recursos/logoBiblio.png"); //Agregamos la imagen "carpeta/carpeta/archivo.loqueEs"
        //Cambiar el TAMAÑO de la imagen
        Image logoBiEscalada =  logoBiblioOriginal.getImage().getScaledInstance(230, 50, Image.SCALE_SMOOTH);
        //Convertir nuevamente a ImageIcon
        ImageIcon logoBiblioEscalado = new ImageIcon(logoBiEscalada);


        JButton botonLogoBiblio = new JButton(logoBiblioEscalado); // Creamos boton dunde vamos a colocar la imagen
        //Preferencias para el botón
        botonLogoBiblio.setContentAreaFilled(false); //Quitar el color del fondo botón
        botonLogoBiblio.setFocusPainted(false); // Quitar la línea que aparece cuando le das click
        botonLogoBiblio.setBorderPainted(false); //Quitar el borte del botón
        botonLogoBiblio.setPreferredSize(new Dimension(230,50)); // determinar una dimension "forzada" para el boton
        
        encabezado.add(botonLogoBiblio,BorderLayout.WEST);

    //** 

        //Panel para meterlo en el panel y que se colocen los dos logos del lado derecho 
         JPanel panelLogosDerecho = new JPanel(new FlowLayout(FlowLayout.RIGHT,10,0)); // Alinial los elemento de forma especifica : alninacion, espacio horizontal(la separación horizontarl) espacio vertica(la distancia los pixeles de estacio entre arriba y abajo)
         panelLogosDerecho.setOpaque(false); //Mantiene l fondo delpanel trasparente o sin color

    //BOTON HERRAMIENTAS

         //Cargar imagen LOGO HERRAMINETAS
        ImageIcon logoHerramientas = new ImageIcon("BiblioMath/recursos/herramientas.png");
        //Modifcar tamaño
        Image logoHeEscalada= logoHerramientas.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
        //Convetir nuevamente a ImageIcon
        ImageIcon logoErramientasEscalada = new ImageIcon(logoHeEscalada);
        //Agregar a Jlabel para mostrar

        JButton botonHerramientas = new JButton(logoErramientasEscalada); // Agregamos la imagen que queremos que aparezca en el botón
        //Preferncias para el botón
        botonHerramientas.setContentAreaFilled(false); //Quitar el color del botón
        botonHerramientas.setFocusPainted(false); //Quitar la linea que aparece cuando le das click
        botonHerramientas.setBorderPainted(false); //Quitar el borde del botó
        botonHerramientas.setPreferredSize(new Dimension(50,50)); // Obligar a colocar el botón con estas medidas
        panelLogosDerecho.add(botonHerramientas); // Agregarlo al panel que lo va a mostrar

    //BOTON LOGO UVG
        //Cargar imagen LOGO MATE
        ImageIcon logoMateUVG = new ImageIcon("BiblioMath/recursos/logoMate.png");
        //Modifcar tamaño
        Image logoMaEscalada = logoMateUVG.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
        //Convetir nuevamente a ImageIcon
        ImageIcon logoMateUVGEscalonado = new ImageIcon(logoMaEscalada);
        //Agregar a Jlabel para mostrar
        
        JButton botonlogoMate = new JButton(logoMateUVGEscalonado); // Agregamos la imagen que queremos que muestre
        //Preferencias para el diseño del botón
        botonlogoMate.setContentAreaFilled(false); //Quitar el color del botón
        botonlogoMate.setFocusPainted(false); //Quitar la linea que aparece cuando le das click
        botonlogoMate.setBorderPainted(false); //Quitar el borde del botó
        botonlogoMate.setPreferredSize(new Dimension(50,50)); // Obligar a colocar el botón con estas medidas
        panelLogosDerecho.add(botonHerramientas); // Agregarlo al panel que lo va a mostrar
        
        panelLogosDerecho.add(botonlogoMate);  // Agregar al panel que lo va a mostrar

// ACTIONES "actionListeer"

    botonLogoBiblio.addActionListener(e ->{ // Cuando lo preciones sucedará:

        sistema.mostrarInicio(); // Llama el métod que se encuentra en la clase Sistema el cual abre el panel de Inicio, esto se puede porque al inicio esta clase es una parámetro

    });

    botonHerramientas.addActionListener(e -> {
        //Agregar que sucede cuando se presiona
        sistema.mostrarAgregarConcepto();
    });

    botonlogoMate.addActionListener(e -> {
        //Agregamos lo que secede cuando se presiona
        JOptionPane.showMessageDialog(this, " MATE UVG \n Instragram: @uvgmate \n🐲");

    });

//AGREGAR PARA MOSTRAR
        encabezado.add(panelLogosDerecho);
        this.add(encabezado, BorderLayout.NORTH); 
    }

public void paintComponent(Graphics g) { // paint -> pintura y Component -> cuidad al escribir. Graphics -> g (el nombre de la cariables o algo así)
       
        super.paintComponent(g); // para que nos deje usar lo como un lienzo y que se vaya al FRAME completo, y todo hacer referencia a Graphics

        g.setColor(Color.BLACK); // aplica este color hasta que aparesca otro color. 
        g.drawRect(50, 20, 900,  60); // x,y, ancho y alto
        
        g.setColor(Color.WHITE);
        g.fillRect(50, 20, 900, 60); //figuara llena de color
    
    }
}