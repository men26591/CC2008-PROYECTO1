import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
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

        // Filas de ejemplo (borrar cuando se conecte la lógica)
        agregarFila("Teorema de Pitágoras", "c² = a² + b²", "Precálculo, Cálculo, ...");
        agregarFila("Ley de De Morgan", "¬(p ∧ q) ≡ ¬p ∨ ¬q", "Lógica proposicional, Discreta 1, ...");
        agregarFila("Triángulo rectángulo", "(imagen)", "Precálculo, Cálculo, ...");
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

        comboCurso = new JComboBox<>(new String[]{"Cálculo 1...", "Precálculo", "Discreta 1"});
        comboCurso.setPreferredSize(new Dimension(220, 35));

        comboKit = new JComboBox<>(new String[]{"Parcial 1...", "Parcial 2", "Final"});
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

        String[] titulos = {"Nombre", "Expresión", "Demostración", "Curso"};
        for (String t : titulos) {
            JLabel l = new JLabel(t, SwingConstants.CENTER);
            l.setFont(new Font("Arial", Font.BOLD, 18));
            l.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, AZUL));
            fila.add(l);
        }
        return fila;
    }

    // Agrega una fila antes de la fila "Agregar". Devuelve el botón "Explicación"
    // para que quien conecte la lógica le asigne su acción.
    public JButton agregarFila(String nombre, String expresion, String curso) {
        JPanel fila = new JPanel(new GridLayout(1, 4));
        fila.setBackground(Color.WHITE);
        fila.setPreferredSize(new Dimension(0, 80));
        fila.setMaximumSize(new Dimension(Integer.MAX_VALUE, 80));
        fila.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, AZUL));

        JButton boton = crearBotonRedondo("Explicación →");

        fila.add(crearCelda(new JLabel("<html><center>" + nombre + "</center></html>")));
        fila.add(crearCelda(new JLabel("<html><center>" + expresion + "</center></html>")));
        fila.add(crearCelda(boton));
        fila.add(crearCelda(new JLabel("<html><center>" + curso + "</center></html>")));

        filas.add(fila, filas.getComponentCount() - 1); // antes de la fila "Agregar"
        filas.revalidate();
        filas.repaint();
        return boton;
    }

    private JPanel crearFilaAgregar(Sistema sistema) {
        JPanel fila = new JPanel(new GridLayout(1, 4));
        fila.setBackground(Color.WHITE);
        fila.setPreferredSize(new Dimension(0, 70));
        fila.setMaximumSize(new Dimension(Integer.MAX_VALUE, 70));

        botonAgregar = crearBotonRedondo("Agregar ✎");
        botonAgregar.addActionListener(e -> sistema.mostrarAgregarConcepto());

        fila.add(crearCelda(botonAgregar));
        fila.add(crearCelda(new JLabel("...")));
        fila.add(crearCelda(new JLabel("...")));
        fila.add(crearCelda(new JLabel("...")));
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

    private JButton crearBotonRedondo(String texto) {
        JButton b = new JButton(texto);
        b.setBackground(AZUL);
        b.setForeground(Color.WHITE);
        b.setFont(new Font("Arial", Font.BOLD, 14));
        b.setFocusPainted(false);
        b.setBorderPainted(false);
        b.setOpaque(true);
        b.setPreferredSize(new Dimension(160, 34));
        return b;
    }

    // ---------------- GETTERS para quien conecte la lógica ----------------
    public JTextField getCampoBuscar() { return campoBuscar; }
    public JComboBox<String> getComboCurso() { return comboCurso; }
    public JComboBox<String> getComboKit() { return comboKit; }
    public JButton getBotonAgregar() { return botonAgregar; }

    // Borra las filas de datos y deja solo la fila "Agregar"
    public void limpiarFilas() {
        while (filas.getComponentCount() > 1) {
            filas.remove(0);
        }
        filas.revalidate();
        filas.repaint();
    }
}