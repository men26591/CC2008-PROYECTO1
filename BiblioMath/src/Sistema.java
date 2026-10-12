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

    public String registrarConcepto(String nombre, String explicacion,String categoria, String curso) {
        Usuario u = getUsuarioActual();

        int siguienteId = 0; //Variable para signar ID
        for (Concepto concepto : u.getBaseConceptos()) { //Para cada concepto
            if (concepto.getId() >= siguienteId) { //Si tiene un ID mayor o igual al de la variable
                siguienteId = concepto.getId() + 1; //La variableaumenta en 1 su ID
            }
        }

        String mensaje;
        try {
            u.nuevoConcepto(siguienteId, nombre,explicacion, categoria,curso, "");
            mensaje = "Concepto registrado correctamente.";
        } catch (Exception e) {
            mensaje = "No se pudo agregar concepto.";
        }

        return mensaje;    
    }

    public String buscar(String nombre) {
        Usuario u = getUsuarioActual(); //Se obtiene el usuario

        String m = u.buscarKits(nombre); //Se busca Kit
        if(m.equals("No se encontró el Kit.")){ //Si no se encuentra Kit
            m = u.buscarConcepto(nombre); //Se busca concepto
            if(m.equals("No se encontró concepto.")){ //Si no e encuentra Concepto
                m = "No se encontro ningun concepto o kit con este nombre."; //Se modifica mensaje para que indicar que no se encontro concepto ni kit.
            }
        }

        return m;  //Se retorna el   
    }

    public String verUltimo() {
        Usuario u = getUsuarioActual(); //Se obtiene el usuario
        String m =  u.irUltimo(); //Se llama al método ir último de usuario
        return m;  //Se retorna lo retornado por el método
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