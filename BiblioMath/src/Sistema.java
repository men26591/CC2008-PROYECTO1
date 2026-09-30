public class Sistema {

    private Biblioteca biblioteca;
    private VentanaPrincipal ventana;

    public Sistema() {
        biblioteca = new Biblioteca();
    }

    public void iniciar() {
        // Aquí se cargarían los usuarios del archivo CSV.
        ventana = new VentanaPrincipal(this);
        ventana.mostrarPanel("login");
    }

    public boolean iniciarSesion(String nombre, String contrasena) {
        try {
            biblioteca.login(nombre, contrasena);
            ventana.mostrarPanel("inicio");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String registrarUsuario(String nombre, String contrasena) {
        String mensaje = biblioteca.crearUsuario(nombre, contrasena);

        if (mensaje.equals("Se creó el usuario correctamente")) {
            ventana.mostrarPanel("inicio");
        }

        return mensaje;
    }

    public Usuario getUsuarioActual() {
        return biblioteca.getUsuarioActual();
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void cerrarSesion() {
        biblioteca.setUsuarioActual(null);
        ventana.mostrarPanel("login");
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
}