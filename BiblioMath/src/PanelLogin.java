import javax.swing.JPanel; //Espacio para agregar las cosas en la ventana
import javax.swing.JLabel; 

public class PanelLogin extends JPanel {
    
    private JTextField txtUsuario; // asi el usuario ingresa el texto y la contraseña
    private JPasswordField txtContrasena;

     public PanelLogin(Sistema sistema) {

        setLayout(new BorderLayout());
        setBackground(new Color(220, 230, 255));

        JLabel encabezado = new JLabel("BiblioMath");
        encabezado.setFont(new Font("Arial", Font.BOLD, 20));
        encabezado.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        add(encabezado, BorderLayout.NORTH);

        JPanel formulario = new JPanel();
        formulario.setLayout(new GridLayout(7, 1, 10, 10));
        formulario.setBackground(Color.WHITE);
        formulario.setBorder(
            BorderFactory.createEmptyBorder(50, 70, 50, 70)
        );

        JLabel titulo = new JLabel("Log in");
        titulo.setFont(new Font("Arial", Font.BOLD, 32));

        txtUsuario = new JTextField();
        txtContrasena = new JPasswordField();

        JButton btnLogin = new JButton("Log in");
        JButton btnRegistro = new JButton("Sign up");

        btnLogin.setBackground(new Color(63, 123, 242));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFocusPainted(false);

        formulario.add(titulo);
        formulario.add(new JLabel("Username"));
        formulario.add(txtUsuario);
        formulario.add(new JLabel("Password"));
        formulario.add(txtContrasena);
        formulario.add(btnLogin);
        formulario.add(btnRegistro);

        add(formulario, BorderLayout.CENTER);

        btnLogin.addActionListener(e -> {

            String usuario = txtUsuario.getText();
            String contrasena =
                new String(txtContrasena.getPassword());

            if (usuario.isBlank() || contrasena.isBlank()) {
                JOptionPane.showMessageDialog(
                    this,
                    "Debe completar todos los campos."
                );
            } else if (!sistema.iniciarSesion(usuario, contrasena)) {
                JOptionPane.showMessageDialog(
                    this,
                    "Usuario o contraseña incorrectos."
                );
            }
        });
    }
}


