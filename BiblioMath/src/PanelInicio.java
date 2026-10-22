import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BorderFactory; //Aplicar bordes
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField; //Recibe el texto normal
import javax.swing.JOptionPane; //Para mostrar mensaje por medio de una ventanita emergente


import java.awt.Image; // Agregar imageness
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color; // Permite agregar colores
import java.awt.Dimension;
import java.awt.FlowLayout; // Alinial los elemento de forma especifica, los acomoda uno tras otro 
import java.awt.Graphics; //Permite agregar graficos (figuras)
import java.awt.BorderLayout; // Importa un administrador de diseño que divide un contenedor en 5 regiones
import java.awt.Desktop; // Permite que el programa solicite al sistema operativo que abra archivos o navegador web predetermiando
import java.net.URI; // URI (Identificador de Recursos Uniforme) lo que permite manerar o represntar direcciones o enlaces
 

public class PanelInicio extends JPanel { // Función: Interfaz de inicio

    private JButton botonLogoBiblio, botonHerramientas, botonBiblioConcepto, botonKits, botonlogoMate, botonBuscar, botonCerrarSesion, botonVer;
    private JLabel textoBienvenidaInicio, textoBusquedasPopulares;
    private JTextField campoBuscar;
    private Sistema sistema; //Para que todos los que esten aquí adentro tengan acceso a sistema

    public PanelInicio(Sistema sistema) {

        add(new JLabel("Inicio"));

        this.sistema = sistema; // Guarda la referencia global
        Chismoso shute = new Chismoso();


        // ese this es tomar el JPanel y lo que hagas se modifica ahí
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


        botonLogoBiblio = new JButton(logoBiblioEscalado); // Creamos boton dunde vamos a colocar la imagen
        //Preferencias para el botón
        botonLogoBiblio.setContentAreaFilled(false); //Quitar el color del fondo botón
        botonLogoBiblio.setFocusPainted(false); // Quitar la línea que aparece cuando le das click
        botonLogoBiblio.setBorderPainted(false); //Quitar el borte del botón
        botonLogoBiblio.setPreferredSize(new Dimension(230,50)); // determinar una dimension "forzada" para el boton
        botonLogoBiblio.addActionListener(shute);
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

        botonHerramientas = new JButton(logoErramientasEscalada); // Agregamos la imagen que queremos que aparezca en el botón
        //Preferncias para el botón
        botonHerramientas.setContentAreaFilled(false); //Quitar el color del botón
        botonHerramientas.setFocusPainted(false); //Quitar la linea que aparece cuando le das click
        botonHerramientas.setBorderPainted(false); //Quitar el borde del botó
        botonHerramientas.setPreferredSize(new Dimension(50,50)); // Obligar a colocar el botón con estas medidas
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
        botonBiblioConcepto.addActionListener(shute);
        panelLogosDerecho.add(botonBiblioConcepto); // Agregarlo al panel que lo va a mostrar
    
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
        botonlogoMate.addActionListener(shute);
        panelLogosDerecho.add(botonHerramientas); // Agregarlo al panel que lo va a mostrar
        
        panelLogosDerecho.add(botonlogoMate);  // Agregar al panel que lo va a mostrar

    
   
//Contenido principal  *******************************************

        JPanel contenido = new JPanel();
        contenido.setLayout(new BoxLayout(contenido, BoxLayout.Y_AXIS)); // Permite apilar una sobre otra, una compoente sobre otra
        contenido.setOpaque(false); //Mantiene l fondo delpanel trasparente o sin color

    
        //Crear imanen
        ImageIcon textoBienvenida = new ImageIcon("BiblioMath/recursos/bienvenida.png");
        Image textoBiEscalada = textoBienvenida.getImage().getScaledInstance(800,200, Image.SCALE_SMOOTH); //Modificar la escala de la imagen 
        ImageIcon textoBienvenidaEscalado = new ImageIcon(textoBiEscalada); //Regresar a set tipo imageIcone
        textoBienvenidaInicio = new JLabel(textoBienvenidaEscalado);
        textoBienvenidaInicio.setAlignmentX(CENTER_ALIGNMENT); 


        //Panel que contiene el campo de texto y el boton de buscar
        JPanel campoContenido = new JPanel(new FlowLayout(FlowLayout.CENTER,15,0)); // Alinial los elemento de forma especifica : alninacion, espacio horizontal(la separación horizontarl) espacio vertica(la distancia los pixeles de estacio entre arriba y abajo)
        campoContenido.setOpaque(false);  // no tenga color

        campoBuscar = new JTextField(); //Para que el usuarioIngrese datos
        campoBuscar.setPreferredSize(new Dimension(700, 35));  // Se usa este para modificar y no el setMaximumSize porque al usar FlowLayout este ignora lo que le ponemos, pero con este nuevo le obligamos a tomar este tamaño
        campoContenido.add(campoBuscar);

        botonBuscar = new JButton("🔍");
        botonBuscar.setPreferredSize(new Dimension(100, 35)); 
        botonBuscar.addActionListener(shute);
        campoContenido.add(botonBuscar);

        campoContenido.setMaximumSize(new Dimension(850, 40));  //limitamos el estapacion de todo el panel


        ///Agregar titulo de Busquedas populares

        //Crear imanen de titulo
        ImageIcon textoBusquedas = new ImageIcon("BiblioMath/recursos/busquedasPopulares.png");
        Image textoBuEscalado = textoBusquedas.getImage().getScaledInstance(200,50, Image.SCALE_SMOOTH); //Modificar la escala de la imagen 
        ImageIcon textoBusquedaEscalada = new ImageIcon(textoBuEscalado); //Regresar a set tipo imageIcone
        textoBusquedasPopulares = new JLabel(textoBusquedaEscalada);
        textoBusquedasPopulares.setAlignmentX(CENTER_ALIGNMENT); 
        
          // Boton para ver el reciente 
        botonVer =  new JButton("Ver");
        botonVer.setOpaque(true); // Fuerza a que respete el nuevo color
        botonVer.setContentAreaFilled(true); //Permite rellenar, pues dice que si está lleno
        botonVer.setMaximumSize(new Dimension(100,35)); //Limitamos tamaño
        botonVer.setBackground(new Color(63, 123, 242)); // Cambiar el color del botón
        botonVer.setForeground(Color.WHITE); // Cambiar el color de la letra
        botonVer.setBorderPainted(false); // Quitar el borde del botón
        botonVer.setAlignmentX(CENTER_ALIGNMENT);
        botonVer.addActionListener(shute);

        botonCerrarSesion = new JButton("Cerrar Sesión");
        botonCerrarSesion.setPreferredSize(new Dimension(100,35)); //Limitamos tamaño

        

//AGREGAR PARA MOSTRAR
        encabezado.add(panelLogosDerecho);
        contenido.add(textoBienvenidaInicio);
        contenido.add(Box.createVerticalStrut(20));
        contenido.add(campoContenido);
        contenido.add(Box.createVerticalStrut(20));
        contenido.add(textoBusquedasPopulares);
        contenido.add(Box.createVerticalStrut(160));
        contenido.add(botonVer);
        contenido.add(Box.createVerticalGlue()); // Absorbe el espacio sobrante
        


        // Se añanden para que se muestre si no no se muestra!!!!
        //Los agregamos y colcoamos donde queremos que aparezcan 
        this.add(encabezado, BorderLayout.NORTH); 
        this.add(contenido, BorderLayout.CENTER);
        this.add(botonCerrarSesion, BorderLayout.SOUTH);



    }   

    public void paintComponent(Graphics g) { // paint -> pintura y Component -> cuidad al escribir. Graphics -> g (el nombre de la cariables o algo así)
       
        super.paintComponent(g); // para que nos deje usar lo como un lienzo y que se vaya al FRAME completo, y todo hacer referencia a Graphics

        g.setColor(Color.BLACK); // aplica este color hasta que aparesca otro color. 
        g.drawRect(50, 20, 900,  60); // x,y, ancho y alto
        
        g.setColor(Color.WHITE);
        g.fillRect(50, 20, 900, 60); //figuara llena de color
    
        g.setColor(Color.WHITE);
        g.fillRect(150, 430, 700, 200);
    }

    public class Chismoso implements ActionListener{

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
                        JOptionPane.showMessageDialog(PanelInicio.this, "¡No se pudo abrir el enlce! \nMATE UVG \n Instragram: @uvgmate \n🐲");
                    }
            }

            if(e.getSource() == botonCerrarSesion){
                sistema.mostrarLogin();
            }

            if(e.getSource() == botonLogoBiblio){
                sistema.mostrarInicio(); // Llama el métod que se encuentra en la clase Sistema el cual abre el panel de Inicio, esto se puede porque al inicio esta clase es una parámetro
            }

            if(e.getSource() == botonHerramientas){
                        sistema.mostrarAgregarConcepto();
            }
            
            if(e.getSource() == botonKits){
                // sistema.mostrarKits(); 
            }

            if(e.getSource() == botonBuscar){
                String nombre = campoBuscar.getText().trim();

                if (nombre.isEmpty()) { //Si no se ha completado el formulario se solicita que lo haga
                    JOptionPane.showMessageDialog(PanelInicio.this, "Ingresa el nombre del concepto que deseas buscar.");
                }else{ //Si todos los campos estan llenos, se llama al metdo de registrad concepto del sistema
                    Object m = sistema.buscar(nombre); //Se llama a método en sistema
                    if (m instanceof Concepto){ //Si es un concepto
                        sistema.mostrarDetalleConcpeto((Concepto)m);//Muestra el panel de Detalle de Concepto con los datos.
                    }
                    else{
                        JOptionPane.showMessageDialog(PanelInicio.this, m); //Se muestra notificacion con mensaje retornado.
                    }
                }
            }

            if(e.getSource() == botonVer){

                Object m = sistema.verUltimo();
                if (m instanceof Concepto){ //Si es un concepto
                        sistema.mostrarDetalleConcpeto((Concepto)m);//Muestra el panel de Detalle de Concepto con los datos.
                    }
                else{
                    JOptionPane.showMessageDialog(PanelInicio.this, m); //Se muestra notificacion con mensaje retornado.
                }
            }
        }

        
    }
}

