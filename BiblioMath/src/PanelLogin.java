import java.awt.BorderLayout; // Importa un administrador de diseño que divide un contenedor en 5 regiones
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Font; //Permite agregar fuentes
import java.awt.Dimension;

import javax.swing.JPanel; // Agrupar elementos visuales dentro de la ventana
import javax.swing.ImageIcon; //Agregar imagenes 
import javax.swing.JLabel;
import javax.swing.JTextField; //Recibe el texto normal
import javax.swing.JPasswordField; //Recibe contraseña y agrega los puntitos 
import javax.swing.JButton; //Permite ejetuar la acción
import javax.swing.BoxLayout; // Permite ordenar elementos, es algo gráfico
import javax.swing.Box; // Acompañana al BoxLayout es como un contendor ligero y una herramienta para crear espacio en blanco 
import javax.swing.BorderFactory; //Aplicar bordes
import javax.swing.JOptionPane; //Para mostrar mensaje por medio de una ventanita emergente

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
        formulario.setLayout(new BoxLayout(formulario, BoxLayout.Y_AXIS)); // Las componente se apilan verticalmente 


        // Mostrar login 
        JLabel textoLogin = new JLabel("Log in");
        textoLogin.setFont(new Font ("SansSerif", Font.PLAIN, 32)); //Poner una fuente al texto. 
        textoLogin.setAlignmentX(CENTER_ALIGNMENT); // Para que se posiciones a la derecha
       
        //Ingresar usuario
        JLabel textUsuario = new JLabel ("Username");
        textUsuario.setAlignmentX(CENTER_ALIGNMENT);
        JTextField campoUsuario = new JTextField(); // Entrada de datos
        campoUsuario.setMaximumSize(new Dimension(300,35));  //Deteriminar tamaño dell campo
        campoUsuario.setAlignmentX(CENTER_ALIGNMENT);
        campoUsuario.setAlignmentY(CENTER_ALIGNMENT);//Alinear

        //Mostrar texto y campo especial para contraseñas
        JLabel textContrasena = new JLabel ("Password");
        textContrasena.setAlignmentX(CENTER_ALIGNMENT);
        JPasswordField campoContrena = new JPasswordField();
        campoContrena.setMaximumSize(new Dimension(300,35)); //Determinar una tamaño para el campo porque si no aparece super grande
        campoContrena.setAlignmentX(CENTER_ALIGNMENT);
       

        //Añadir BOTÓN
        JButton botonLogin = new JButton("Login in"); // Crea un boton que va a tener escerito log in
        botonLogin.setMaximumSize(new Dimension(300,40)); //Limitamos tamaño
        botonLogin.setAlignmentX(CENTER_ALIGNMENT); //Aliniamos al centro
        JButton botonRegistro = new JButton("Sing up");
        botonRegistro.setAlignmentX(CENTER_ALIGNMENT);
        
        JPanel ilustracion = new JPanel();


        botonLogin.addActionListener( e -> { // cuando ocurra la acción de este botón ejecuta lo que está dentro
            
            String userName = campoUsuario.getText(); // Pasar lo que recibe lo pasa a string ese metodo .getText lo traae JTextField        
            String contrasena = new String (campoContrena.getPassword()); // Para obtener la contraseña 
            
            if(userName.isBlank() || contrasena.isBlank()){ // verifica si el campo de usuario o contraseña están en blanco
                JOptionPane.showMessageDialog(this, "Usuario o contraseña está vacía.", "Campos Vacíos", JOptionPane.WARNING_MESSAGE);

                return ; // para que hasta ahi llegue y evitar que se ejecture el resto de programa
            }
            
            boolean ingresadoCorrecto = sistema.iniciarSesion(userName, contrasena);

            if(!ingresadoCorrecto){
                JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos.","Datos Incompletos", JOptionPane.WARNING_MESSAGE); // mostramos mensaje por medio de ventana y aparece como un mensaje de aviso va el mensaje, titulo y la config. de que es un aviso de error
            }
        });

        botonRegistro.addActionListener(e -> {
            sistema.mostrarRegistro();
        });


        // Se añanden para que se muestre si no no se muestra!!!!
        contenido.add(formulario);
        
        contenido.add(ilustracion);

        formulario.add(Box.createVerticalStrut(70));
        formulario.add(textoLogin);
        formulario.add(Box.createVerticalStrut(30)); //Funciona para dejar un espacio
        formulario.add(textUsuario);
        formulario.add(campoUsuario);
        formulario.add(Box.createVerticalStrut(15)); //Funciona para dejar un espacio
        formulario.add(textContrasena);
        formulario.add(campoContrena);
        formulario.add(Box.createVerticalStrut(30)); // Crea espacio
        formulario.add(botonLogin);
        formulario.add(Box.createVerticalStrut(15));
        formulario.add(botonRegistro);



        //Cargar imagen LOGO MATE
        ImageIcon imagenDecorativa = new ImageIcon("BiblioMath/recursos/imagenLogin.png");
        //Modifcar tamaño
        Image imagenDeEscalada = imagenDecorativa.getImage().getScaledInstance(450,450,Image.SCALE_SMOOTH);
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

       
