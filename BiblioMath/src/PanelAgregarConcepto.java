import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.plaf.TreeUI;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea; // agregar un texto de varias lineas

import java.awt.Dimension; //Permite modificar los paneles
import java.awt.GridLayout; // para dividir el panel 

import java.awt.Image; // Agregar imageness
import java.awt.Font; //Permite agregar fuentes
import java.awt.BorderLayout; // Importa un administrador de diseño que divide un contenedor en 5 regiones
import java.awt.Color; // Permite agregar colores
import java.awt.FlowLayout; // Alinial los elemento de forma especifica, los acomoda uno tras otro 
import java.awt.Graphics; //Permite agregar graficos (figuras)




public class PanelAgregarConcepto extends JPanel { // Función: Formulario para conceptos

    public PanelAgregarConcepto(Sistema sistema) {
        add(new JLabel("Agregar concepto"));

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
        
        panelLogosDerecho.add(botonlogoMate);  // Agregar al panel que lo va a mostrar
    


    //AGREGAR IMAGEN DEL TEXTO
        ImageIcon textoAprender = new ImageIcon("BiblioMath/recursos/queAprenderemosHoy.png"); //Agregamos la imagen "carpeta/carpeta/archivo.loqueEs"
        //Cambiar el TAMAÑO de la imagen
        Image textoApEscalonada =  textoAprender.getImage().getScaledInstance(400, 100, Image.SCALE_SMOOTH);
        //Convertir nuevamente a ImageIcon
        ImageIcon textoAprenderEscalonado = new ImageIcon(textoApEscalonada);

        JLabel tectoAprenderHoy =new JLabel(textoAprenderEscalonado); //Jlabel que mostrrá la imagen
        encabezado.add(tectoAprenderHoy,BorderLayout.SOUTH);

//CONTENIDO 
        JPanel contenido = new JPanel(new GridLayout(1,2)); // Para dividir el area en dos columnas 
        contenido.setOpaque(false); //Para que el panel no tenga colores 

    //Formaulario 
        JPanel formulario = new JPanel();
        formulario.setLayout(new BoxLayout(formulario, BoxLayout.Y_AXIS)); //Perminte que se apilen una sobre otra (componente)
        formulario.setOpaque(false); //para que no se muestre con color 

        //Mostrar Categoria 
        JLabel textoCategoria = new JLabel("Categoría");
        textoCategoria.setFont(new Font ("SansSerif", Font.PLAIN, 20)); //Poner una fuente al texto. 
        textoCategoria.setForeground( Color.WHITE); // cambiar de color de letra 
        textoCategoria.setAlignmentX(CENTER_ALIGNMENT); // Para que se posiciones a la derecha
       
        //Mostrar ingreso y comboBox
        //Temporal textField
        JTextField campoCategoria = new JTextField();
        campoCategoria.setMaximumSize(new Dimension(350,35));  //Deteriminar tamaño dell campo
        campoCategoria.setAlignmentX(CENTER_ALIGNMENT);
        campoCategoria.setAlignmentY(CENTER_ALIGNMENT);//Alinear

        //Mostrar Nombre
        JLabel textoNombre = new JLabel("Nombre");
        textoNombre.setFont(new Font ("SansSerif", Font.PLAIN, 20)); //Poner una fuente al texto. 
        textoNombre.setForeground( Color.WHITE); // cambiar de color de letra 
        textoNombre.setAlignmentX(CENTER_ALIGNMENT); // Para que se posiciones a la derecha


        //Temporal textField
        JTextField campoNombre = new JTextField();
        campoNombre.setMaximumSize(new Dimension(350,35));  //Deteriminar tamaño dell campo
        campoNombre.setAlignmentX(CENTER_ALIGNMENT);
        campoCategoria.setAlignmentY(CENTER_ALIGNMENT);//Alinear

        //Mostrar Curso
        JLabel textoCurso = new JLabel("Curso");
        textoCurso.setFont(new Font ("SansSerif", Font.PLAIN, 20)); //Poner una fuente al texto. 
        textoCurso.setForeground( Color.WHITE); // cambiar de color de letra 
        textoCurso.setAlignmentX(CENTER_ALIGNMENT); // Para que se posiciones a la derecha


        //Temporal textField
        JTextField campoCurso = new JTextField();
        campoCurso.setMaximumSize(new Dimension(350,35));  //Deteriminar tamaño dell campo
        campoCurso.setAlignmentX(CENTER_ALIGNMENT);
        campoCurso.setAlignmentY(CENTER_ALIGNMENT);//Alinear

        JButton botonRegistar = new JButton("Registrar"); // Crea un boton que va a tener escerito log in
        botonRegistar.setMaximumSize(new Dimension(100,40)); //Limitamos tamaño
        botonRegistar.setAlignmentX(CENTER_ALIGNMENT); //Aliniamos al centro
        

        //Agregar al Panel formulario

        formulario.add(Box.createVerticalStrut(30)); //Funciona para dejar un espacio
        formulario.add(textoCategoria);
        formulario.add(Box.createVerticalStrut(15)); //Funciona para dejar un espacio
        formulario.add(campoCategoria);
        formulario.add(Box.createVerticalStrut(30)); //Funciona para dejar un espacio
        formulario.add(textoNombre);
        formulario.add(Box.createVerticalStrut(15)); //Funciona para dejar un espacio
        formulario.add(campoNombre);
        formulario.add(Box.createVerticalStrut(30)); //Funciona para dejar un espacio
        formulario.add(textoCurso);
        formulario.add(Box.createVerticalStrut(15)); //Funciona para dejar un espacio
        formulario.add(campoCurso);
        formulario.add(Box.createVerticalStrut(25)); //Funciona para dejar un espacio
        formulario.add(botonRegistar);
        
        contenido.add(formulario);

    //Entrada texto 
    
        JPanel informacion = new JPanel();
        informacion.setOpaque(false); //Para que no muestre color 

        //Mostrar instrucciones 
        JLabel textoInstrucciones = new JLabel("Explicación del Concepto");
        textoInstrucciones.setFont(new Font ("SansSerif", Font.PLAIN, 20)); //Poner una fuente al texto. 
        textoInstrucciones.setForeground( Color.WHITE); // cambiar de color de letra 
        textoInstrucciones.setAlignmentX(CENTER_ALIGNMENT); // Para que se posiciones a la derecha

        JTextArea informacionConcepto = new JTextArea();
        Dimension tamanoInformacionConcepto = new Dimension(350,340); //Le doy el ancho y alto que yo quiero 
        informacionConcepto.setPreferredSize(tamanoInformacionConcepto); // Obligamos aque coloque ese tamaño

        informacionConcepto.setBorder(new LineBorder(new Color(63, 123, 242)));
        informacionConcepto.setFont(new Font("Arial", Font.PLAIN,12)); // Cambiar el tipo y tamaño de letra

        informacion.add(Box.createVerticalStrut(55)); //Funciona para dejar un espacio
        informacion.add(textoInstrucciones);
        informacion.add(Box.createVerticalStrut(10)); //Funciona para dejar un espacio
        informacion.add(informacionConcepto);

        contenido.add(informacion);

        

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
            this.add(contenido, BorderLayout.CENTER);
//ActionListener

        botonRegistar.addActionListener(e->{
            //Colocamos lo que pasa 



        });
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
}