import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Dimension; //Permite modificar los paneles

import java.awt.Image; // Agregar imageness

import java.awt.BorderLayout; // Importa un administrador de diseño que divide un contenedor en 5 regiones
import java.awt.Color; // Permite agregar colores
import java.awt.FlowLayout; // Alinial los elemento de forma especifica, los acomoda uno tras otro 
import java.awt.Font;
import java.awt.Graphics; //Permite agregar graficos (figuras)

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class PanelKits extends JPanel { //Función: Interfaz de kits

    private JTextField campoNombrar;
    private JTextField campoBuscarConcepto;
    private String nombreKit = "Nuevo Kit";

    public PanelKits(Sistema sistema) {
         //ENCABEZADO
         
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

            // Crear el campo para escribir
            campoNombrar = new JTextField();
            campoNombrar.setFont(new Font("Arial", Font.PLAIN, 15));

            campoNombrar.getDocument().addDocumentListener(
                new DocumentListener() {

                    private void actualizarNombre() {
                        String texto = campoNombrar.getText().trim();

                        if (texto.isEmpty()) {
                            nombreKit = "Nuevo Kit";
                        } else {
                            nombreKit = texto;
                        }

                        // Volver a dibujar el panel con el nuevo título
                        repaint();
                    }

                    @Override
                    public void insertUpdate(DocumentEvent e) {
                        actualizarNombre();
                    }

                    @Override
                    public void removeUpdate(DocumentEvent e) {
                        actualizarNombre();
                    }

                    @Override
                    public void changedUpdate(DocumentEvent e) {
                        actualizarNombre();
                    }
                }
            );

            // Agregarlo al panel
            this.add(campoNombrar, BorderLayout.CENTER);

            // Crear el campo para escribir
            campoBuscarConcepto = new JTextField();
            campoBuscarConcepto.setFont(new Font("Arial", Font.PLAIN, 15));

            // Agregarlo al panel
            this.add(campoBuscarConcepto, BorderLayout.CENTER);

    }

    @Override
    public void doLayout() {
        super.doLayout();
        int margen = 50;
        int separacion = 20;
        int altoCuadro = 300;
        if (campoNombrar != null) {
            // Las mismas medidas que utilizas al dibujar los cuadros

            int anchoCuadro =
                (getWidth() - margen * 2 - separacion) / 2;

            int posicionY = getHeight() - altoCuadro - 30;

            // Ubicar el campo debajo del texto
            campoNombrar.setBounds(
                margen + 20,                  // Posición horizontal
                posicionY + 75,               // Posición vertical
                Math.max(0, anchoCuadro - 40), // Ancho
                30                            // Alto
            );
        }
        if (campoBuscarConcepto != null) {
            // Las mismas medidas que utilizas al dibujar los cuadros

            int anchoCuadro =
                (getWidth() - margen * 2 - separacion) / 2;

            int posicionY = getHeight() - altoCuadro - 30;

            // Ubicar el campo debajo del texto
            campoBuscarConcepto.setBounds(
                margen + 20,                  // Posición horizontal
                posicionY + 150,               // Posición vertical
                Math.max(0, anchoCuadro - 40), // Ancho
                30                            // Alto
            );
        }
    }

    public void paintComponent(Graphics g) { // paint -> pintura y Component -> cuidad al escribir. Graphics -> g (el nombre de la cariables o algo así)
       
        super.paintComponent(g); // para que nos deje usar lo como un lienzo y que se vaya al FRAME completo, y todo hacer referencia a Graphics

        g.setColor(Color.BLACK); // aplica este color hasta que aparesca otro color. 
        g.drawRect(50, 20, 900,  60); // x,y, ancho y alto
        
        g.setColor(Color.WHITE);
        g.fillRect(50, 20, 900, 60); //figuara llena de color
        // Medidas y separación de los cuadros
        int margen = 50;
        int separacion = 20;
        int altoCuadro = 300;

        // Calcular el ancho para que ambos quepan en el panel
        int anchoCuadro = (getWidth() - (margen * 2) - separacion) / 2;

        // Posición vertical: dejar 30 píxeles debajo de los cuadros
        int posicionY = getHeight() - altoCuadro - 30;

        // Pintar ambos cuadros de blanco
        g.setColor(Color.WHITE);

        // Cuadro izquierdo
        g.fillRect(margen, posicionY, anchoCuadro, altoCuadro);

        // Cuadro derecho
        g.fillRect(
            margen + anchoCuadro + separacion,
            posicionY,
            anchoCuadro,
            altoCuadro
        );
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 18));
        g.drawString( nombreKit, margen + 20, posicionY + 30);

        g.setFont(new Font("Arial", Font.PLAIN, 15));
        g.drawString( "Cambiar nombre del kit", margen + 20, posicionY + 60);
        g.drawString( "Buscar concepto a agregar", margen + 20, posicionY + 135);

        g.setFont(new Font("Arial", Font.BOLD, 18));
        g.drawString("Detalles del kit", margen + anchoCuadro + separacion + 20, posicionY + 30);

    } 
}