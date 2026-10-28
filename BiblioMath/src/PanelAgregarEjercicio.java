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
import javax.swing.JTextField; // Importa un administrador de diseño que divide un contenedor en 5 regiones
import javax.swing.border.LineBorder; // Permite agregar colores




public class PanelAgregarEjercicio extends JPanel { // Función: Formulario para conceptos

    private JButton botonLogoBiblio, botonHerramientas, botonlogoMate, botonRegistar,botonBiblioConcepto,botonEjercicios,botonKits;
    private JLabel tectoAprenderHoy, textoNombreConcepto,textoInstrucciones, textoInstruccionesRespuesta;
    private JTextField campoNombreConcepto;
    private JTextArea informacionEjercicio, informacionRespuesta;
    private Sistema sistema;

    public PanelAgregarEjercicio(Sistema sistema) {
        
        add(new JLabel("agregarEjercicio"));

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


    //AGREGAR IMAGEN DEL TEXTO
        ImageIcon textoAprender = new ImageIcon("BiblioMath/recursos/anadirEjercicio.png"); //Agregamos la imagen "carpeta/carpeta/archivo.loqueEs"
        //Cambiar el TAMAÑO de la imagen
        Image textoApEscalonada =  textoAprender.getImage().getScaledInstance(400, 100, Image.SCALE_SMOOTH);
        //Convertir nuevamente a ImageIcon
        ImageIcon textoAprenderEscalonado = new ImageIcon(textoApEscalonada);

        tectoAprenderHoy =new JLabel(textoAprenderEscalonado); //Jlabel que mostrrá la imagen
        encabezado.add(tectoAprenderHoy,BorderLayout.SOUTH);

//CONTENIDO 
        JPanel contenido = new JPanel(new GridLayout(1,2)); // Para dividir el area en dos columnas 
        contenido.setOpaque(false); //Para que el panel no tenga colores 


    //Lado Izquierdo
    
        JPanel ladoIzquiero = new JPanel();
        ladoIzquiero.setLayout(new BoxLayout(ladoIzquiero, BoxLayout.Y_AXIS)); //Perminte que se apilen una sobre otra (componente)
        ladoIzquiero.setOpaque(false); //Para que no muestre color 

        //Mostrar Ingrese el nombre del concepto 
        textoNombreConcepto = new JLabel("Nombre del Concepto");
        textoNombreConcepto.setFont(new Font ("SansSerif", Font.PLAIN, 20)); //Poner una fuente al texto. 
        textoNombreConcepto.setForeground( Color.WHITE); // cambiar de color de letra 
        textoNombreConcepto.setAlignmentX(CENTER_ALIGNMENT); // Para que se posiciones a la derecha

        //Mostrar intrucciones
        campoNombreConcepto = new JTextField();
        campoNombreConcepto.setMaximumSize(new Dimension(350,35));  //Deteriminar tamaño dell campo
        campoNombreConcepto.setAlignmentX(CENTER_ALIGNMENT);
        campoNombreConcepto.setAlignmentY(CENTER_ALIGNMENT);//Alinear

         //Mostrar instrucciones 
        textoInstrucciones = new JLabel("Ingresa el ejercicio");
        textoInstrucciones.setFont(new Font ("SansSerif", Font.PLAIN, 20)); //Poner una fuente al texto. 
        textoInstrucciones.setForeground( Color.WHITE); // cambiar de color de letra 
        textoInstrucciones.setAlignmentX(CENTER_ALIGNMENT); // Para que se posiciones a la derecha

        //JtextArea
        informacionEjercicio = new JTextArea();
        informacionEjercicio.setLineWrap(true); // para un salto de linea
        informacionEjercicio.setWrapStyleWord(false); //para romper palabras si es necesario
        informacionEjercicio.setFont(new Font("Arial", Font.PLAIN,12)); // Cambiar el tipo y tamaño de letra

        JScrollPane barra = new JScrollPane(informacionEjercicio); // Crar un Jscrollpanel y se agrega a al cuadro de texto
        
        barra.setMaximumSize(new Dimension(350,230)); // Obligamos aque coloque ese tamaño
        barra.setBorder(new LineBorder(new Color(63, 123, 242)));

        ladoIzquiero.add(Box.createVerticalStrut(30));
        ladoIzquiero.add(textoNombreConcepto);
        ladoIzquiero.add(Box.createVerticalStrut(15));
        ladoIzquiero.add(campoNombreConcepto);
        ladoIzquiero.add(Box.createVerticalStrut(30));
        ladoIzquiero.add(textoInstrucciones);
        ladoIzquiero.add(Box.createVerticalStrut(15));
        ladoIzquiero.add(barra);
        ladoIzquiero.add(Box.createVerticalStrut(5));

        contenido.add(ladoIzquiero);


    //Lado Derecho
        JPanel ladoDerecho = new JPanel();
        ladoDerecho.setLayout(new BoxLayout(ladoDerecho, BoxLayout.Y_AXIS)); //Perminte que se apilen una sobre otra (componente)
        ladoDerecho.setOpaque(false); //Para que no muestre color 

        //Mostrar instrucciones 
        textoInstruccionesRespuesta = new JLabel("Ingresa la respuesta del ejercicio");
        textoInstruccionesRespuesta.setFont(new Font ("SansSerif", Font.PLAIN, 20)); //Poner una fuente al texto. 
        textoInstruccionesRespuesta.setForeground( Color.WHITE); // cambiar de color de letra 
        textoInstruccionesRespuesta.setAlignmentX(CENTER_ALIGNMENT); // Para que se posiciones a la derecha

        //JtextArea
        informacionRespuesta = new JTextArea();
        informacionRespuesta.setLineWrap(true); // para un salto de linea
        informacionRespuesta.setWrapStyleWord(false); //para romper palabras si es necesario
        informacionRespuesta.setFont(new Font("Arial", Font.PLAIN,12)); // Cambiar el tipo y tamaño de letra

        JScrollPane barraRespuesta = new JScrollPane(informacionRespuesta); // Crar un Jscrollpanel y se agrega a al cuadro de texto
        
        barraRespuesta.setMaximumSize(new Dimension(350,230)); // Obligamos aque coloque ese tamaño
        barraRespuesta.setBorder(new LineBorder(new Color(63, 123, 242)));

        botonRegistar = new JButton("Registrar"); // Crea un boton que va a tener escerito log in
        botonRegistar.setMaximumSize(new Dimension(100,40)); //Limitamos tamaño
        botonRegistar.setAlignmentX(CENTER_ALIGNMENT); //Aliniamos al centro
        botonRegistar.addActionListener(shute);

        ladoDerecho.add(Box.createVerticalStrut(30));
        ladoDerecho.add(textoInstruccionesRespuesta);
        ladoDerecho.add(Box.createVerticalStrut(15));
        ladoDerecho.add(barraRespuesta);
        ladoDerecho.add(Box.createVerticalStrut(30));
        ladoDerecho.add(botonRegistar);

        contenido.add(ladoDerecho);

    

    //AGREGAR PARA MOSTRAR
            encabezado.add(panelLogosDerecho);
            this.add(encabezado, BorderLayout.NORTH); 
            this.add(contenido, BorderLayout.CENTER);

        }

    public void paintComponent(Graphics g) { // paint -> pintura y Component -> cuidad al escribir. Graphics -> g (el nombre de la cariables o algo así)
        
            super.paintComponent(g); // para que nos deje usar lo como un lienzo y que se vaya al FRAME completo, y todo hacer referencia a Graphics

            g.setColor(Color.BLACK); // aplica este color hasta que aparesca otro color. 
            g.drawRect(50, 20, 900,  60); // x,y, ancho y alto
            
            g.setColor(Color.WHITE);
            g.fillRect(50, 20, 900, 60); //figuara llena de color
        
            //BLOQUE SEPARADOR DE CONTENIDO 

            //BLOQUE IZQUIERDA
            g.setColor(new Color(63, 123, 242));
            g.fillRect(50, 220, 410, 410);

            //BLOQUE DERECHA
            //BLOQUE IZQUIERDA
            g.setColor(new Color(123, 158, 235));
            g.fillRect(545, 220, 410, 410);
            
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
                        JOptionPane.showMessageDialog(PanelAgregarEjercicio.this, "¡No se pudo abrir el enlce! \nMATE UVG \n Instragram: @uvgmate \n🐲");
                    }
            }

            if(e.getSource() == botonLogoBiblio){
                sistema.mostrarInicio(); // Llama el métod que se encuentra en la clase Sistema el cual abre el panel de Inicio, esto se puede porque al inicio esta clase es una parámetro
            }

            if(e.getSource() == botonHerramientas){
                        sistema.mostrarAgregarConcepto();
            }

            if(e.getSource() == botonRegistar){
                String nombre = campoNombreConcepto.getText().trim();
                String ejercicio = informacionEjercicio.getText().trim();
                String respuesta = informacionRespuesta.getText().trim();

                if (nombre.isEmpty() || ejercicio.isEmpty() || respuesta.isEmpty()) { //Si no se ha completado el formulario se solicita que lo haga
                    JOptionPane.showMessageDialog(PanelAgregarEjercicio.this, "Completa todos los campos para poder registrar el nuevo concepto.");
                }else{ //Si todos los campos estan llenos, se llama al metdo de registrad concepto del sistema
                    JOptionPane.showMessageDialog(PanelAgregarEjercicio.this, "EN PROCESO"); //Lo muestra como notificacion

                    campoNombreConcepto.setText(""); //Para que la entra de texto se vacié le ponemos "", que es para definir lo que muesta
                    informacionEjercicio.setText("");
                    informacionRespuesta.setText("");
                }
            }

        }

    }
}