import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Desktop; // Permite que el programa solicite al sistema operativo que abra archivos o navegador web predetermiando
import java.net.URI; // URI (Identificador de Recursos Uniforme) lo que permite manerar o represntar direcciones o enlaces
 

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel; // agregar un texto de varias lineas
import javax.swing.JOptionPane; //Permite modificar los paneles
import javax.swing.JPanel; // para dividir el panel
import javax.swing.JScrollPane; // Agregar imageness
import javax.swing.JTextArea; //Permite agregar fuentes


public class PanelDetalleEjercicio extends JPanel { // Función: Formulario para conceptos

    private JButton botonLogoBiblio, botonHerramientas, botonlogoMate,botonBiblioConcepto,botonEjercicios,botonKits, botonMasEjercicios, botonVerRespuesta, botonRegresar;
    private JLabel  textoTituloEjercicio;
    private Sistema sistema;
    private JTextArea textoEjercicio; 
    private JScrollPane barra;


    private Concepto conceptoActual;

    public PanelDetalleEjercicio(Sistema sistema) {
        
        add(new JLabel("DetalleConcepto"));

        this.sistema = sistema; // Guarda la referncia global 
        Chismoso shute = new Chismoso();

        //this es
        this.setBackground(new Color(210, 224, 255));
        this.setLayout(new BorderLayout()); // Es para agregar eso de ubicaciones, si quere norte, este 
//ENCABEZADO *******************************************
        JPanel encabezado = new JPanel(new BorderLayout());
        encabezado.setBorder(BorderFactory.createEmptyBorder(25, 55, 30, 55));
        encabezado.setOpaque(false);  // para que el panle que agregagamos no tenga color, osea que se transparente                 
    
    //BOTON LOGO
        //Carga imagen del logo de biblioMath
        ImageIcon logoBiblioOriginal = new ImageIcon("BiblioMath/recursos/logoBiblio.png"); //Agregamos la imagen "carpeta/carpeta/archivo.loqueEs"
        //Cambiar el TAMAÑO de la imagen
        Image logoBiEscalada =  logoBiblioOriginal.getImage().getScaledInstance(230, 50, Image.SCALE_SMOOTH);
        //Convertir nuevamente a ImageIcon
        ImageIcon logoBiblioEscalado = new ImageIcon(logoBiEscalada);


        botonLogoBiblio = new JButton(logoBiblioEscalado); // Creamos boton dunde vamos a colocar la imagen
        //Preferencias para el botón
        botonLogoBiblio.setContentAreaFilled(false); //Quitar el color del fondo botón
        botonLogoBiblio.setFocusPainted(false); // Quitar la línea que aparece cuando le das click
        botonLogoBiblio.setBorderPainted(false); //Quitar el borte del botón
        botonLogoBiblio.setPreferredSize(new Dimension(230,50)); // determinar una dimension "forzada" para el boton
        botonLogoBiblio.setToolTipText("Ir a Pantalla de Inicio");//Texto al posicionarse sobre el botón.
        botonLogoBiblio.addActionListener(shute);
        encabezado.add(botonLogoBiblio,BorderLayout.WEST);

    //** 

        //Panel para meterlo en el panel y que se colocen los dos logos del lado derecho 
         JPanel panelLogosDerecho = new JPanel(new FlowLayout(FlowLayout.RIGHT,10,0)); // Alinial los elemento de forma especifica : alninacion, espacio horizontal(la separación horizontarl) espacio vertica(la distancia los pixeles de estacio entre arriba y abajo)
         panelLogosDerecho.setOpaque(false); //Mantiene l fondo delpanel trasparente o sin color

    //
      //BOTON LOGO
        //Carga imagen del logo de biblioMath

        botonLogoBiblio = new JButton(logoBiblioEscalado); // Creamos boton dunde vamos a colocar la imagen
        //Preferencias para el botón
        botonLogoBiblio.setContentAreaFilled(false); //Quitar el color del fondo botón
        botonLogoBiblio.setFocusPainted(false); // Quitar la línea que aparece cuando le das click
        botonLogoBiblio.setBorderPainted(false); //Quitar el borte del botón
        botonLogoBiblio.setPreferredSize(new Dimension(230,50)); // determinar una dimension "forzada" para el boton
        botonLogoBiblio.setToolTipText("Ir a Pantalla de Inicio");//Texto al posicionarse sobre el botón.
        
        botonLogoBiblio.addActionListener(shute);
        encabezado.add(botonLogoBiblio,BorderLayout.WEST);

    
    //BOTON HERRAMIENTAS
        //Cargar imagen LOGO HERRAMINETAS
        ImageIcon logoHerramientas = new ImageIcon("BiblioMath/recursos/herramientas.png");
        //Modifcar tamaño
        Image logoHeEscalada= logoHerramientas.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
        //Convetir nuevamente a ImageIcon
        ImageIcon logoErramientasEscalada = new ImageIcon(logoHeEscalada);
        //Agregar a Jlabel para mostrar

        botonHerramientas = new JButton(logoErramientasEscalada); // Agregamos la imagen que queremos que aparezca en el botón
        //Preferncias para el botón
        botonHerramientas.setContentAreaFilled(false); //Quitar el color del botón
        botonHerramientas.setFocusPainted(false); //Quitar la linea que aparece cuando le das click
        botonHerramientas.setBorderPainted(false); //Quitar el borde del botó
        botonHerramientas.setPreferredSize(new Dimension(50,50)); // Obligar a colocar el botón con estas medidas
        botonHerramientas.setToolTipText("Agregar Concepto");//Texto al posicionarse sobre el botón.
        botonHerramientas.addActionListener(shute);
        panelLogosDerecho.add(botonHerramientas); // Agregarlo al panel que lo va a mostrar
    
    //BOTON BIBLIOTECA CONCEPTOS

        //Cargar imagen LOGO BIBLIO CONCEPTOS
        ImageIcon logoBiblioConcepto = new ImageIcon("BiblioMath/recursos/logoBibliConcepto.png");
        //Modifcar tamaño
        Image logoBiCoEscalado = logoBiblioConcepto.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
        //Convetir nuevamente a ImageIcon
        ImageIcon logoBilbioConceptoEscalada = new ImageIcon(logoBiCoEscalado);
        //Agregar a Jlabel para mostrar

        botonBiblioConcepto = new JButton(logoBilbioConceptoEscalada); // Agregamos la imagen que queremos que aparezca en el botón
        // //Preferncias para el botón
        botonBiblioConcepto.setContentAreaFilled(false); //Quitar el color del botón
        botonBiblioConcepto.setFocusPainted(false); //Quitar la linea que aparece cuando le das click
        botonBiblioConcepto.setBorderPainted(false); //Quitar el borde del botó
        botonBiblioConcepto.setPreferredSize(new Dimension(60,40)); // Obligar a colocar el botón con estas medidas
        botonBiblioConcepto.setToolTipText("Ver todos los Conceptos");//Texto al posicionarse sobre el botón.
        botonBiblioConcepto.addActionListener(shute);
        panelLogosDerecho.add(botonBiblioConcepto); // Agregarlo al panel que lo va a mostrar
    

    //BOTON EJERCICIOS

        //Cargar imagen LOGO BIBLIO CONCEPTOS
        ImageIcon logoEjercicio = new ImageIcon("BiblioMath/recursos/logoEjercicios.png");
        //Modifcar tamaño
        Image logoEjEscalonado = logoEjercicio.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
        //Convetir nuevamente a ImageIcon
        ImageIcon logoEjercicioEscalonada = new ImageIcon(logoEjEscalonado);
        //Agregar a Jlabel para mostrar

        botonEjercicios = new JButton(logoEjercicioEscalonada); // Agregamos la imagen que queremos que aparezca en el botón
        // //Preferncias para el botón
        botonEjercicios.setContentAreaFilled(false); //Quitar el color del botón
        botonEjercicios.setFocusPainted(false); //Quitar la linea que aparece cuando le das click
        botonEjercicios.setBorderPainted(false); //Quitar el borde del botó
        botonEjercicios.setPreferredSize(new Dimension(60,40)); // Obligar a colocar el botón con estas medidas
        botonEjercicios.setToolTipText("Agregar Ejercicios a Concepto");//Texto al posicionarse sobre el botón.
        botonEjercicios.addActionListener(shute);
        panelLogosDerecho.add(botonEjercicios); // Agregarlo al panel que lo va a mostrar
    
    //BOTON KITS
        //Cargar imagen 
        ImageIcon logoKits = new ImageIcon("BiblioMath/recursos/logoKits.png");
        //Modifcar tamaño
        Image logoKiEscalada= logoKits.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
        //Convetir nuevamente a ImageIcon
        ImageIcon logoKitsEscalado = new ImageIcon(logoKiEscalada);
        //Agregar a Jlabel para mostrar

        botonKits = new JButton(logoKitsEscalado); // Agregamos la imagen que queremos que aparezca en el botón
        // //Preferncias para el botón
        botonKits.setContentAreaFilled(false); //Quitar el color del botón
        botonKits.setFocusPainted(false); //Quitar la linea que aparece cuando le das click
        botonKits.setBorderPainted(false); //Quitar el borde del botó
        botonKits.setPreferredSize(new Dimension(60,40)); // Obligar a colocar el botón con estas medidas
        botonKits.setToolTipText("Agregar Kit");//Texto al posicionarse sobre el botón.
        botonKits.addActionListener(shute);
        panelLogosDerecho.add(botonKits); // Agregarlo al panel que lo va a mostrar


    
    //BOTON LOGO UVG
        //Cargar imagen LOGO MATE
        ImageIcon logoMateUVG = new ImageIcon("BiblioMath/recursos/logoMate.png");
        //Modifcar tamaño
        Image logoMaEscalada = logoMateUVG.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
        //Convetir nuevamente a ImageIcon
        ImageIcon logoMateUVGEscalonado = new ImageIcon(logoMaEscalada);
        //Agregar a Jlabel para mostrar
        
        botonlogoMate = new JButton(logoMateUVGEscalonado); // Agregamos la imagen que queremos que muestre
        //Preferencias para el diseño del botón
        botonlogoMate.setContentAreaFilled(false); //Quitar el color del botón
        botonlogoMate.setFocusPainted(false); //Quitar la linea que aparece cuando le das click
        botonlogoMate.setBorderPainted(false); //Quitar el borde del botó
        botonlogoMate.setPreferredSize(new Dimension(50,50)); // Obligar a colocar el botón con estas medidas
        botonlogoMate.setToolTipText("Redes Sociales");//Texto al posicionarse sobre el botón.
        botonlogoMate.addActionListener(shute);
        panelLogosDerecho.add(botonHerramientas); // Agregarlo al panel que lo va a mostrar
        
        panelLogosDerecho.add(botonlogoMate);  // Agregar al panel que lo va a mostrar


//CONTENIDO 
        JPanel contenido = new JPanel();
        contenido.setLayout(new BoxLayout(contenido, BoxLayout.Y_AXIS)); //Permite aplicar una sobre otra
        contenido.setOpaque(false); //Para que el panel no tenga colores 

        textoTituloEjercicio = new JLabel ("Ejercicio");
        textoTituloEjercicio.setFont(new Font ("SansSerif", Font.BOLD, 40)); //Poner una fuente al texto. 
        textoTituloEjercicio.setForeground(Color.BLACK); 
        textoTituloEjercicio.setAlignmentX(CENTER_ALIGNMENT); // Para que se posiciones a la derecha


        textoEjercicio = new JTextArea("DIBUJAR.............. ................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................. ................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................. ................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................. ................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................. ..................................................................................................................................................................................................................................................................................................................................................................................................... ..................................................................................................................................................................................................................... ....................... ................................... ................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................. ................... ................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................. ................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................. ................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................ ..................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................");
        //Cualidades
        textoEjercicio.setEditable(false); //Bloquea edición
        textoEjercicio.setFocusable(false); //Quita el cursor
        textoEjercicio.setLineWrap(true); //El texto salta Automáticamente
        textoEjercicio.setWrapStyleWord(true); // Evita que las palabras se corten a la mitad

        //Diseño
        textoEjercicio.setBorder(BorderFactory.createEmptyBorder(10,10, 10,10)); // Margen Interno
        textoEjercicio.setBackground(new Color(175, 199, 250));
        textoEjercicio.setFont(new Font("Arial", Font.PLAIN, 16));
        
        barra = new JScrollPane(textoEjercicio); //Metemos el JTextArea dentro de un JScrollPan
        barra.setBorder(null); //Quita el marco negro exterior
        barra.setViewportBorder(null); //Quita el marco interno 
        barra.setBackground(new Color(175, 199, 250));

        //Forzamos el tamaño 
        Dimension tamanoFijo = new Dimension(800,400);
        barra.setPreferredSize(tamanoFijo);
        barra.setMaximumSize(tamanoFijo);
        barra.setMinimumSize(tamanoFijo);

        contenido.add(Box.createVerticalStrut(15));
        contenido.add(textoTituloEjercicio);
        contenido.add(Box.createVerticalStrut(30));
        contenido.add(barra);

        
//PIE 
        JPanel pie = new JPanel(new BorderLayout());
        pie.setBorder(BorderFactory.createEmptyBorder(15, 50, 25, 50));
        pie.setOpaque(false); 

        // Boton para ver más ejercicios
        botonMasEjercicios = new JButton("Ver Respuesta");
        botonMasEjercicios.setOpaque(true); // Fuerza a que respete el nuevo color
        botonMasEjercicios.setContentAreaFilled(true); //Permite rellenar, pues dice que si está lleno
        botonMasEjercicios.setPreferredSize(new Dimension(200,40)); //Limitamos tamaño
        botonMasEjercicios.setBackground(new Color(63, 123, 242)); // Cambiar el color del botón
        botonMasEjercicios.setForeground(Color.WHITE); // Cambiar el color de la letra
        botonMasEjercicios.setBorderPainted(false); // Quitar el borde del botón
        botonMasEjercicios.setAlignmentX(CENTER_ALIGNMENT);
        botonMasEjercicios.addActionListener(shute);

        JPanel centro = new JPanel(new FlowLayout(FlowLayout.CENTER,10,0)); //Colcar una a la part de otra del lado recheo 
        centro.setOpaque(false); 

        //Boton para ver respuesta
        botonVerRespuesta = new JButton("Ver Respuesta");
        botonVerRespuesta.setOpaque(true); // Fuerza a que respete el nuevo color
        botonVerRespuesta.setContentAreaFilled(true); //Permite rellenar, pues dice que si está lleno
        botonVerRespuesta.setPreferredSize(new Dimension(470,40)); //Limitamos tamaño
        botonVerRespuesta.setBackground(new Color(63, 123, 242)); // Cambiar el color del botón
        botonVerRespuesta.setForeground(Color.WHITE); // Cambiar el color de la letra
        botonVerRespuesta.setBorderPainted(false); // Quitar el borde del botón
        botonVerRespuesta.setAlignmentX(CENTER_ALIGNMENT);
        botonVerRespuesta.addActionListener(shute);

        //Boton para regresar
        botonRegresar = new JButton("Ver Respuesta");
        botonRegresar.setOpaque(true); // Fuerza a que respete el nuevo color
        botonRegresar.setContentAreaFilled(true); //Permite rellenar, pues dice que si está lleno
        botonRegresar.setPreferredSize(new Dimension(200,40)); //Limitamos tamaño
        botonRegresar.setBackground(new Color(63, 123, 242)); // Cambiar el color del botón
        botonRegresar.setForeground(Color.WHITE); // Cambiar el color de la letra
        botonRegresar.setBorderPainted(false); // Quitar el borde del botón
        botonRegresar.setAlignmentX(CENTER_ALIGNMENT);
        botonRegresar.addActionListener(shute);

        centro.add(botonMasEjercicios);
        centro.add(botonVerRespuesta);
        centro.add(botonRegresar);

        pie.add(centro, BorderLayout.CENTER);



    //AGREGAR PARA MOSTRAR
            encabezado.add(panelLogosDerecho);
            this.add(encabezado, BorderLayout.NORTH); 
            this.add(contenido, BorderLayout.CENTER);
            this.add(pie, BorderLayout.SOUTH);

        }

    public void paintComponent(Graphics g) { // paint -> pintura y Component -> cuidad al escribir. Graphics -> g (el nombre de la cariables o algo así)
        
            super.paintComponent(g); // para que nos deje usar lo como un lienzo y que se vaya al FRAME completo, y todo hacer referencia a Graphics

            g.setColor(Color.BLACK); // aplica este color hasta que aparesca otro color. 
            g.drawRect(50, 20, 900,  60); // x,y, ancho y alto
            
            g.setColor(Color.WHITE);
            g.fillRect(50, 20, 900, 60); //figuara llena de color

            //BLOQUE IZQUIERDA156, 180, 255
            g.setColor(new Color(175, 199, 250));
            g.fillRect(50, 105, 900, 525);

            //BLOQUE PIE
            g.setColor(new Color(175, 199, 250));
            g.fillRect(50, 185, 900, 420);
            
        }

    private class Chismoso implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()== botonlogoMate){ // Valida si viene de este botón

                    try{
                        //Verifica si el sistema operativo puedo abrir el navegador 
                                                                                            //Es una constante de tiempo enumerada que representa una acción específica del sistema operativo, la capacidad de abrir una direccion web 
                        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)){
                            //obtiene la instancia del entorno del escritorio del sistam y abre el URL en el navedaro predetermiando
                            Desktop.getDesktop().browse(new URI("https://www.instagram.com/uvgmate?utm_source=ig_web_button_share_sheet&exln=ZDNlZDc0MzIxNw=="));   // Se valida previamente que el entorno de escritorio del sistema operativo sea compatible y que sopote la acction de ACTION.BROWS         
                        }
                    } catch (Exception r){
                        JOptionPane.showMessageDialog(PanelDetalleEjercicio.this, "¡No se pudo abrir el enlce! \nMATE UVG \n Instragram: @uvgmate \n🐲");
                    }
            }

            if(e.getSource() == botonLogoBiblio){
                sistema.mostrarInicio(); // Llama el métod que se encuentra en la clase Sistema el cual abre el panel de Inicio, esto se puede porque al inicio esta clase es una parámetro
            }

            if(e.getSource() == botonHerramientas){
                        sistema.mostrarAgregarConcepto();
            }


        }

    }
}