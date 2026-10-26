import java.awt.BorderLayout; // Importa un administrador de diseño que divide un contenedor en 5 regiones
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font; //Permite agregar fuentes
import java.awt.Graphics;
import java.awt.Image; // Agrupar elementos visuales dentro de la ventana
import javax.swing.BorderFactory; //Agregar imagenes
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane; //Recibe el texto normal
import javax.swing.JPanel; //Recibe contraseña y agrega los puntitos 
import java.awt.Graphics2D;
import java.awt.RenderingHints;


public class PanelDetalleConcepto extends JPanel {
    
    private Concepto conceptoActual;
    public PanelDetalleConcepto(Sistema sistema) {


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
        botonLogoBiblio.setToolTipText("Ir a Pantalla de Inicio");//Texto al posicionarse sobre el botón.
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
        botonHerramientas.setToolTipText("Agregar Concepto");//Texto al posicionarse sobre el botón.
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
        botonlogoMate.setToolTipText("Redes Sociales");//Texto al posicionarse sobre el botón.
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

    // BOTONES INFERIORES
    JPanel panelInferior = new JPanel(new BorderLayout());
    panelInferior.setOpaque(false);
    panelInferior.setBorder(BorderFactory.createEmptyBorder(10, 55, 25, 55));

    JButton botonEjercicios = crearBotonAzul("Ejercicios");
    JButton botonKit = crearBotonAzul("Agregar en Kit");
    JButton botonRegresar   = crearBotonAzul("Regresar");

    panelInferior.add(botonEjercicios, BorderLayout.WEST);
    panelInferior.add(botonKit,        BorderLayout.CENTER);
    panelInferior.add(botonRegresar,   BorderLayout.EAST);

    botonEjercicios.addActionListener(e -> {
        //sistema.mostrarEjercicios(conceptoActual);
    });

    botonKit.addActionListener(e -> {
        if (conceptoActual != null) {
            String kit = JOptionPane.showInputDialog(this, "Escribe el nombre del kit:"); //Recibe el nombre del kit
            String m = sistema.agregarAKit(conceptoActual,kit); //Se llama el metodo en sistema
            JOptionPane.showMessageDialog(this,m); //Se muestra el mensaje recibido.
        }
    });

    botonRegresar.addActionListener(e -> {
        sistema.mostrarInicio(); // o el panel anterior, como la lista de conceptos
    });

    
    //AGREGAR PARA MOSTRAR
    encabezado.add(panelLogosDerecho);
    this.add(encabezado, BorderLayout.NORTH); 

    this.add(panelInferior, BorderLayout.SOUTH);


    }

private JButton crearBotonAzul(String texto) {
    JButton boton = new JButton(texto) {
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(new Color(63, 123, 242));
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 40, 40); // esquinas redondeadas
            g2.dispose();
            super.paintComponent(g); // dibuja el texto encima
        }
    };
    boton.setContentAreaFilled(false);
    boton.setFocusPainted(false);
    boton.setBorderPainted(false);
    boton.setForeground(Color.WHITE);
    boton.setFont(new Font("Arial", Font.BOLD, 16));
    boton.setPreferredSize(new Dimension(180, 40));
    return boton;
}

public void mostrarEjercicios(Concepto concepto) {
    // cambia al panel de ejercicios (CardLayout o como lo manejes)
}


public void paintComponent(Graphics g) { // paint -> pintura y Component -> cuidad al escribir. Graphics -> g (el nombre de la cariables o algo así)
    
    super.paintComponent(g); // para que nos deje usar lo como un lienzo y que se vaya al FRAME completo, y todo hacer referencia a Graphics

    g.setColor(Color.BLACK); // aplica este color hasta que aparesca otro color. 
    g.drawRect(50, 20, 900,  60); // x,y, ancho y alto
    
    g.setColor(new Color(63, 123, 242));
    g.fillRect(50, 20, 900, 60); //figuara llena de color

    // Posición del cuadro
    int margen = 50;
    int posicionY = 110;

    // Tamaño según el espacio disponible
    int anchoCuadro = getWidth() - (margen * 2);
    int altoCuadro = getHeight() - posicionY - 100;

    // Dibujar el cuadro azul claro
    g.setColor(new Color(175, 199, 250));
    g.fillRect(margen, posicionY, anchoCuadro, altoCuadro);

    g.setColor(Color.WHITE);
    g.setFont(new Font("Arial", Font.BOLD, 18));

    if (conceptoActual != null) {
       int textoX = margen + 50;

        // Nombre destacado
        g.setColor(new Color(25, 25, 25));
        g.setFont(new Font("Arial", Font.BOLD, 28));
        String titulo = conceptoActual.getNombre(); //Obtiene el texto
        int anchoTitulo = g.getFontMetrics().stringWidth(titulo); //Mide el ancho del titulo
        int tituloX = margen + (anchoCuadro - anchoTitulo) / 2; //Coordena en x de manera que el titulo quede en medio
        g.drawString(titulo, tituloX, posicionY + 75);

        // Datos secundarios
        g.setColor(new Color(123, 158, 235));
        g.setFont(new Font("Arial", Font.PLAIN, 16));
        g.drawString("Categoría: " + conceptoActual.getCategoria(),
                      textoX, posicionY + 115);
        g.drawString("Curso: " + conceptoActual.getCurso(),
                      textoX, posicionY + 145);

        // Línea divisoria
        g.setColor(new Color(220, 227, 240));
        g.drawLine(textoX, posicionY + 170, margen + anchoCuadro - 50, posicionY + 170);

        // Explicación
        g.setColor(new Color(63, 123, 242));
        g.setFont(new Font("Arial", Font.BOLD, 19));
        g.drawString("Explicación", textoX, posicionY + 205);

        g.setColor(new Color(55, 65, 80));
        g.setFont(new Font("Arial", Font.PLAIN, 16));
        g.drawString(conceptoActual.getExplicacion(),textoX, posicionY + 240);

    } else {
        g.drawString("Nombre Concepto",anchoCuadro / 2 - margen, posicionY + 30);
    }
}
        
public void mostrarConcepto(Concepto concepto) {
    this.conceptoActual = concepto;
    repaint();
}

}