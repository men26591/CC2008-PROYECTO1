import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PanelTablita extends JPanel { // Función: Interfaz de la tabla de conceptos (solo diseño)

    private Sistema sistema;//Para facilitar su uso en la clase

    private static final Color AZUL = new Color(63, 123, 242);
    private static final Color AZUL_CLARO = new Color(116, 157, 247);
    private static final Color FONDO = new Color(193, 211, 253);

    private JTextField campoBuscar; // se crea el campo buscar pero no se usa aún porque no tenemos la opcion de filtros 
    private JComboBox<String> comboCurso;
    private JComboBox<String> comboKit;
    private JPanel filas;          // aquí van las filas de la tabla
    private JScrollPane scrollTabla;
    private JButton botonAgregar;

    public PanelTablita(Sistema sistema) {
        this.sistema = sistema;

        this.setLayout(new BorderLayout());
        this.setBackground(Color.WHITE);

        // ZONA SUPERIOR: encabezado + filtros
        JPanel superior = new JPanel(new BorderLayout());
        superior.setBackground(FONDO);
        superior.add(crearEncabezado(sistema), BorderLayout.NORTH);
        superior.add(crearFiltros(), BorderLayout.CENTER);
        this.add(superior, BorderLayout.NORTH);

        // TABLA
        JPanel tabla = new JPanel();
        tabla.setLayout(new BoxLayout(tabla, BoxLayout.Y_AXIS));
        tabla.setBorder(BorderFactory.createEmptyBorder(25, 55, 25, 55));
        tabla.setOpaque(false);
        JPanel titulos = crearFilaTitulos();
        titulos.setMaximumSize(new Dimension(Integer.MAX_VALUE, 55));

        filas = new JPanel();
        filas.setLayout(new BoxLayout(filas, BoxLayout.Y_AXIS));
        filas.setBackground(Color.WHITE);
        filas.add(titulos);

        scrollTabla = new JScrollPane(filas);
        scrollTabla.setBorder(BorderFactory.createLineBorder(AZUL));
        scrollTabla.getVerticalScrollBar().setUnitIncrement(16);
        tabla.add(scrollTabla);
        this.add(tabla, BorderLayout.CENTER);

        // La tabla termina con la fila del botón Agregar.
        filas.add(crearFilaAgregar(sistema));
        ajustarAlturaTabla();

    }

    // ---------------- ENCABEZADO ----------------
    private JPanel crearEncabezado(Sistema sistema) {
        JPanel encabezado = new JPanel(new BorderLayout());
        encabezado.setBorder(BorderFactory.createEmptyBorder(25, 55, 10, 55));
        encabezado.setOpaque(false);

        JButton botonLogo = crearBotonImagen("BiblioMath/recursos/logoBiblio.png", 230, 50, "Ir a Pantalla de Inicio");
        botonLogo.addActionListener(e -> sistema.mostrarInicio()); // pide al sistema mostrar la pantalla de inicio
        encabezado.add(botonLogo, BorderLayout.WEST);

        JButton botonMate = crearBotonImagen("BiblioMath/recursos/logoMate.png", 50, 50, "Redes Sociales");
        botonMate.addActionListener(e ->
            JOptionPane.showMessageDialog(this, " MATE UVG \n Instragram: @uvgmate \n🐲")); // pide a Joptionpane mostrar un mensaje
        encabezado.add(botonMate, BorderLayout.EAST);

        return encabezado;
    }

    private JButton crearBotonImagen(String ruta, int ancho, int alto, String tooltip) {
        Image img = new ImageIcon(ruta).getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH); //edita como se ve el botón
        JButton b = new JButton(new ImageIcon(img));
        b.setContentAreaFilled(false); // con esto, los botones no se ven con el diseño predeterminado
        b.setFocusPainted(false);
        b.setBorderPainted(false);
        b.setPreferredSize(new Dimension(ancho, alto));
        b.setToolTipText(tooltip);
        return b;
    }

    // ---------------- FILTROS ----------------
    private JPanel crearFiltros() {
        JPanel filtros = new JPanel(new FlowLayout(FlowLayout.LEFT, 40, 10));
        filtros.setBorder(BorderFactory.createEmptyBorder(10, 40, 15, 40));
        filtros.setOpaque(false);

        campoBuscar = new JTextField();
        campoBuscar.setPreferredSize(new Dimension(280, 35));

        comboCurso = new JComboBox<>();
        comboCurso.setPreferredSize(new Dimension(220, 35));

        comboKit = new JComboBox<>();
        comboKit.setPreferredSize(new Dimension(220, 35));

        filtros.add(conTitulo("Teorema/definición/fórmula", campoBuscar)); // si se pueden buscar pero no se filtran 
        filtros.add(conTitulo("Curso", comboCurso));
        filtros.add(conTitulo("Kit de estudio", comboKit));
        
        //Chismoso
        comboCurso.addActionListener(e -> aplicarFiltros());
        comboKit.addActionListener(e -> aplicarFiltros());
        return filtros;
    }

    private JPanel conTitulo(String titulo, JComponent componente) {
        JPanel p = new JPanel(new BorderLayout(0, 6));
        p.setOpaque(false);
        JLabel l = new JLabel(titulo);
        l.setFont(new Font("Arial", Font.PLAIN, 15));
        p.add(l, BorderLayout.NORTH);
        p.add(componente, BorderLayout.CENTER);
        return p;
    }

    // ---------------- TABLA ----------------
    private JPanel crearFilaTitulos() {
        JPanel fila = new JPanel(new GridLayout(1, 4));
        fila.setPreferredSize(new Dimension(0, 55));
        fila.setBackground(AZUL_CLARO);
        fila.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, AZUL));

        String[] titulos = {"Nombre", "Expresión", "Demostración", "Curso"};
        for (String t : titulos) {
            JLabel l = new JLabel(t, SwingConstants.CENTER);
            l.setFont(new Font("Arial", Font.BOLD, 18));
            l.setForeground(Color.BLACK);
            l.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, AZUL));
            fila.add(l);
        }
        return fila;
    }

    // Los componentes de una fila, para que quien conecte la lógica los use
    public static class FilaTabla {
        public JTextField campoNombre;
        public JTextField campoExpresion;
        public JButton botonExplicacion;
        public JTextField campoCurso;
    }

    // Agrega una fila antes de la fila "Agregar". Nombre, expresión y curso son
    // campos de texto que el usuario puede escribir (se pueden dejar en "").
    public FilaTabla agregarFila(String nombre, String expresion, String curso) {
        JPanel fila = new JPanel(new GridLayout(1, 4));
        fila.setBackground(Color.WHITE);
        fila.setPreferredSize(new Dimension(0, 80));
        fila.setMaximumSize(new Dimension(Integer.MAX_VALUE, 80));
        fila.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, AZUL));

        FilaTabla f = new FilaTabla();
        f.campoNombre = crearCampoCelda(nombre);
        f.campoExpresion = crearCampoCelda(expresion);
        f.botonExplicacion = crearBotonRedondo("Explicación →");
        f.campoCurso = crearCampoCelda(curso);

        fila.add(crearCeldaCampo(f.campoNombre));
        fila.add(crearCeldaCampo(f.campoExpresion));
        fila.add(crearCelda(f.botonExplicacion));
        fila.add(crearCeldaCampo(f.campoCurso));

        filas.add(fila, filas.getComponentCount() - 1); // antes de la fila "Agregar"
        ajustarAlturaTabla();
        filas.revalidate();
        filas.repaint();
        return f;
    }

    // Ajusta el borde a las filas visibles y deja scroll si hay muchas.
    private void ajustarAlturaTabla() {
        if (scrollTabla == null || filas == null) {
            return;
        }

        int altoContenido = filas.getPreferredSize().height;
        int altoVisible = Math.min(altoContenido, 360);
        scrollTabla.setPreferredSize(new Dimension(0, altoVisible));
        scrollTabla.setMaximumSize(new Dimension(Integer.MAX_VALUE, altoVisible));
    }

    // Campo de texto sin borde, centrado, para escribir dentro de la celda
    private JTextField crearCampoCelda(String texto) {
        JTextField c = new JTextField(texto);
        c.setHorizontalAlignment(SwingConstants.CENTER);
        c.setFont(new Font("Arial", Font.PLAIN, 14));
        c.setBorder(BorderFactory.createEmptyBorder());
        c.setOpaque(false);
        return c;
    }

    // Celda que ocupa todo el espacio para que se pueda hacer clic y escribir, donde esta e boton de agregar
    private JPanel crearCeldaCampo(JTextField campo) {
        JPanel celda = new JPanel(new BorderLayout());
        celda.setOpaque(false);
        celda.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(0, 0, 0, 1, AZUL),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        celda.add(campo, BorderLayout.CENTER);
        return celda;
    }

    private JPanel crearFilaAgregar(Sistema sistema) {
        JPanel fila = new JPanel(new GridLayout(1, 4));
        fila.setBackground(Color.WHITE);
        fila.setPreferredSize(new Dimension(0, 70));
        fila.setMaximumSize(new Dimension(Integer.MAX_VALUE, 70));

        botonAgregar = crearBotonRedondo("Agregar ✎");
        botonAgregar.addActionListener(e -> sistema.mostrarAgregarConcepto());

        fila.add(crearCelda(botonAgregar));
        fila.add(crearCelda(new JLabel("")));
        fila.add(crearCelda(new JLabel("")));
        fila.add(crearCelda(new JLabel("")));
        return fila;
    }

    // Celda: centra el contenido y dibuja la línea vertical
    private JPanel crearCelda(JComponent contenido) {
        JPanel celda = new JPanel(new GridBagLayout());
        celda.setOpaque(false);
        celda.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, AZUL));
        if (contenido instanceof JLabel) {
            contenido.setFont(new Font("Arial", Font.PLAIN, 14));
        }
        celda.add(contenido);
        return celda;
    }

    // Botón azul redondeado (Explicación, Agregar)
    private JButton crearBotonRedondo(String texto) {
        BotonAzul b = new BotonAzul(texto, AZUL, new Color(92, 146, 250), new Color(40, 95, 210), 30);
        b.setForeground(Color.WHITE);
        b.setFont(new Font("Arial", Font.BOLD, 14));
        b.setPreferredSize(new Dimension(160, 34));
        return b;
    }

    // Botón que dibuja su propio fondo, así se ve igual en Mac, Windows y Linux:
    // cambia de color al pasar el mouse y al presionarlo, y muestra la manito.
    private static class BotonAzul extends JButton {
        private final Color normal, hover, presionado;
        private final int arco;

        BotonAzul(String texto, Color normal, Color hover, Color presionado, int arco) {
            super(texto);
            this.normal = normal;
            this.hover = hover;
            this.presionado = presionado;
            this.arco = arco;
            setContentAreaFilled(false);
            setBorderPainted(false);
            setFocusPainted(false);
            setOpaque(false);
            setRolloverEnabled(true);
            setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

            Color fondo = normal;
            if (getModel().isPressed()) {
                fondo = presionado;
            } else if (getModel().isRollover()) {
                fondo = hover;
            }
            g2.setColor(fondo);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), arco, arco);

            g2.setColor(getForeground());
            g2.setFont(getFont());
            FontMetrics fm = g2.getFontMetrics();
            int x = (getWidth() - fm.stringWidth(getText())) / 2;
            int y = (getHeight() - fm.getHeight()) / 2 + fm.getAscent();
            g2.drawString(getText(), x, y);
            g2.dispose();
        }
    }

    // ---------------- GETTERS para conectar la lógica ----------------
    public JTextField getCampoBuscar() { return campoBuscar; }
    public JComboBox<String> getComboCurso() { return comboCurso; }
    public JComboBox<String> getComboKit() { return comboKit; }
    public JButton getBotonAgregar() { return botonAgregar; }

    // Borra las filas de datos y deja solo la fila "Agregar"
    public void limpiarFilas() {
        while (filas.getComponentCount() > 2) {
            filas.remove(1);
        }
        ajustarAlturaTabla();
        filas.revalidate();
        filas.repaint();
    }

    public void llenarTablita(ArrayList<Concepto> conceptos){
        limpiarFilas(); // Le limpian las filas para evitar repeticiones

        for(Concepto c:conceptos){//Para cada concepto 
            FilaTabla f = agregarFila(c.getNombre(), c.getExplicacion().substring(0, Math.min(15, c.getExplicacion().length())),c.getCurso());//Se crea fila, descripcion = máx. los primeros 15 caracteres de la explicacion

            //Se bloquea la edicion de la fila
            f.campoNombre.setEditable(false);
            f.campoCurso.setEditable(false);
            f.campoExpresion.setEditable(false);

            //Boton
            f.botonExplicacion.addActionListener(e -> {
               sistema.mostrarDetalleConcepto(c);
            });
        }
    }

    public void cargarFiltros(ArrayList<Concepto> conceptos){
        //Limpia opciones pasadas
        comboCurso.removeAllItems();
        comboKit.removeAllItems();

        //Se agrega la opcion de todos
        comboCurso.addItem("Todos");
        comboKit.addItem("Todos");

        ArrayList<String> cursos = new ArrayList<>(); //Lista para almacenar Cursos

        for (Concepto c : conceptos) { //Por cada concepto
            String curso = c.getCurso(); //Se obtiene su curso

            if (!cursos.contains(curso)) { //Si no se ha agregado
                cursos.add(curso); //Se agrega a la lista
                comboCurso.addItem(curso); //Se agrega a las opciones del combobox
            }
        }

        for (Kit k : sistema.getUsuarioActual().getBaseKits()) { //Por cada kit del Usuarui
            comboKit.addItem(k.getNombre()); //Se agrega su nombre como opcion para el combobox
        }

        llenarTablita(conceptos); //Se llenan los conceptos en la tabla
    }

    public void aplicarFiltros(){
        //Se obtienen los filtros seleccionados
        String curso = (String) comboCurso.getSelectedItem();
        String nombreKit = (String) comboKit.getSelectedItem();

    
        ArrayList<Concepto> mostrar = new ArrayList<>(); //Lista para almacenar todos los conceptos a mostrar
        
        for (Concepto c : sistema.getUsuarioActual().getBaseConceptos()) {//Para cada concepto
            
            //Los Requisitos se cumplen si no hay, se selcciono Todos o si es igual al filtro
            boolean cumpleCurso = (curso == null) || "Todos".equals(curso) || curso.equals(c.getCurso()); 

            boolean cumpleKit = (nombreKit == null) || "Todos".equals(nombreKit) || (c.getKitEstudio().contains(nombreKit));

            if (cumpleCurso && cumpleKit) { //Si cumple con ambos filtros
                mostrar.add(c); //Se agrega a la lista de mostrar
            }
        }

        llenarTablita(mostrar); //Se llena la tablita con lista filtrada de objetos

    }
}