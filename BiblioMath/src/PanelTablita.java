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

    private static final Color AZUL = new Color(63, 123, 242);
    private static final Color AZUL_CLARO = new Color(116, 157, 247);
    private static final Color FONDO = new Color(193, 211, 253);

    private JTextField campoBuscar;
    private JComboBox<String> comboCurso;
    private JComboBox<String> comboKit;
    private JPanel filas;          // aquí van las filas de la tabla
    private JButton botonAgregar;
    private JButton botonNombre, botonExpresion, botonDemostracion, botonCurso; // títulos de la tabla

    public PanelTablita(Sistema sistema) {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.WHITE);

        // ZONA SUPERIOR: encabezado + filtros
        JPanel superior = new JPanel(new BorderLayout());
        superior.setBackground(FONDO);
        superior.add(crearEncabezado(sistema), BorderLayout.NORTH);
        superior.add(crearFiltros(), BorderLayout.CENTER);
        this.add(superior, BorderLayout.NORTH);

        // TABLA
        JPanel tabla = new JPanel(new BorderLayout());
        tabla.setBorder(BorderFactory.createEmptyBorder(25, 55, 25, 55));
        tabla.setOpaque(false);
        tabla.add(crearFilaTitulos(), BorderLayout.NORTH);

        filas = new JPanel();
        filas.setLayout(new BoxLayout(filas, BoxLayout.Y_AXIS));
        filas.setBackground(Color.WHITE);

        JScrollPane scroll = new JScrollPane(filas);
        scroll.setBorder(BorderFactory.createLineBorder(AZUL));
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        tabla.add(scroll, BorderLayout.CENTER);
        this.add(tabla, BorderLayout.CENTER);

        // Última fila fija con el botón Agregar
        filas.add(crearFilaAgregar(sistema));

        // Filas de diseño: solo el botón "Explicación", el texto lo pone la lógica
        for (int i = 0; i < 3; i++) {
            agregarFila("", "", "");
        }

    }

    // ---------------- ENCABEZADO ----------------
    private JPanel crearEncabezado(Sistema sistema) {
        JPanel encabezado = new JPanel(new BorderLayout());
        encabezado.setBorder(BorderFactory.createEmptyBorder(25, 55, 10, 55));
        encabezado.setOpaque(false);

        JButton botonLogo = crearBotonImagen("BiblioMath/recursos/logoBiblio.png", 230, 50, "Ir a Pantalla de Inicio");
        botonLogo.addActionListener(e -> sistema.mostrarInicio());
        encabezado.add(botonLogo, BorderLayout.WEST);

        JButton botonMate = crearBotonImagen("BiblioMath/recursos/logoMate.png", 50, 50, "Redes Sociales");
        botonMate.addActionListener(e ->
            JOptionPane.showMessageDialog(this, " MATE UVG \n Instragram: @uvgmate \n🐲"));
        encabezado.add(botonMate, BorderLayout.EAST);

        return encabezado;
    }

    private JButton crearBotonImagen(String ruta, int ancho, int alto, String tooltip) {
        Image img = new ImageIcon(ruta).getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        JButton b = new JButton(new ImageIcon(img));
        b.setContentAreaFilled(false);
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

        filtros.add(conTitulo("Teorema/definición/fórmula", campoBuscar));
        filtros.add(conTitulo("Curso", comboCurso));
        filtros.add(conTitulo("Kit de estudio", comboKit));
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
        fila.setBorder(BorderFactory.createLineBorder(AZUL));

        botonNombre = crearBotonTitulo("Nombre");
        botonExpresion = crearBotonTitulo("Expresión");
        botonDemostracion = crearBotonTitulo("Demostración");
        botonCurso = crearBotonTitulo("Curso");

        fila.add(envolverTitulo(botonNombre));
        fila.add(envolverTitulo(botonExpresion));
        fila.add(envolverTitulo(botonDemostracion));
        fila.add(envolverTitulo(botonCurso));
        return fila;
    }

    // Botón azul que ocupa toda la celda del título (cambia de color al pasar el mouse)
    private JButton crearBotonTitulo(String texto) {
        BotonAzul b = new BotonAzul(texto, AZUL_CLARO, new Color(138, 175, 250), new Color(92, 138, 240), 0);
        b.setForeground(Color.BLACK);
        b.setFont(new Font("Arial", Font.BOLD, 18));
        return b;
    }

    // Envuelve el botón en un panel para dibujar la línea vertical entre columnas
    private JPanel envolverTitulo(JButton boton) {
        JPanel p = new JPanel(new BorderLayout());
        p.setBackground(AZUL_CLARO);
        p.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, AZUL));
        p.add(boton, BorderLayout.CENTER);
        return p;
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
        filas.revalidate();
        filas.repaint();
        return f;
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

    // Celda que ocupa todo el espacio para que se pueda hacer clic y escribir
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

    // ---------------- GETTERS para quien conecte la lógica ----------------
    public JTextField getCampoBuscar() { return campoBuscar; }
    public JComboBox<String> getComboCurso() { return comboCurso; }
    public JComboBox<String> getComboKit() { return comboKit; }
    public JButton getBotonAgregar() { return botonAgregar; }
    public JButton getBotonNombre() { return botonNombre; }
    public JButton getBotonExpresion() { return botonExpresion; }
    public JButton getBotonDemostracion() { return botonDemostracion; }
    public JButton getBotonCurso() { return botonCurso; }

    // Borra las filas de datos y deja solo la fila "Agregar"
    public void limpiarFilas() {
        while (filas.getComponentCount() > 1) {
            filas.remove(0);
        }
        filas.revalidate();
        filas.repaint();
    }
}