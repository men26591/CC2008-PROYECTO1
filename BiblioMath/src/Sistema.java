public class Sistema {

    private Biblioteca biblioteca;
    private VentanaPrincipal ventana;

    public Sistema() {
        biblioteca = new Biblioteca();
    }

    public void iniciar() {
        ventana = new VentanaPrincipal(this);
        mostrarLogin();
    }

    public boolean iniciarSesion(String nombre, String contrasena) {

        try {
            biblioteca.login(nombre, contrasena);
            mostrarInicio();
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public String registrarUsuario(String nombre, String contrasena) {

        String mensaje = biblioteca.crearUsuario(nombre, contrasena);

        if (mensaje.equals("Se creó el usuario correctamente")) {
            mostrarInicio();
        }

        return mensaje;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public Usuario getUsuarioActual() {
        return biblioteca.getUsuarioActual();
    }

    public void mostrarLogin() {
        ventana.mostrarPanel("login");
    }

    public void mostrarRegistro() {
        ventana.mostrarPanel("registro");
    }

    public void mostrarInicio() {
        ventana.mostrarPanel("inicio");
    }

    public void mostrarBiblioteca() {
        ventana.mostrarPanel("biblioteca");
    }

    public void mostrarAgregarConcepto() {
        ventana.mostrarPanel("agregar");
    }

    public void mostrarKits() {
        ventana.mostrarPanel("kits");
    }

    public void cerrarSesion() {
        biblioteca.setUsuarioActual(null);
        mostrarLogin();
    }
}