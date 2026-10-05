public class Sistema {

    private Biblioteca biblioteca;
    private VentanaPrincipal ventana;

    public Sistema() { // Función: Coordinar aplicación, lógica y navegación
        biblioteca = new Biblioteca(); //Crea una única biblioteca
    }

    public void iniciar() {
        ventana = new VentanaPrincipal(this); //Crea la ventan y pasa el Sistema 

        mostrarLogin();
    }

    public boolean iniciarSesion(String nombre, String contrasena) { //

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

    public Biblioteca getBiblioteca() { //Le da acceso a otros paneles para obtener la informacion
        return biblioteca;
    }

    public Usuario getUsuarioActual() { //Le da acceso a otros paneles para obtener la informacion
        return biblioteca.getUsuarioActual();
    }

    //Se crea una capa de abstracción, donde dice que es lo que se quiere hacer 
    public void mostrarLogin() {  
        ventana.mostrarPanel("login"); // Este metodo se encuentra en VentanaPrincipal y es el que sirve para mostrar las pantallas en la ventana
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