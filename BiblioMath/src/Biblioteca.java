import java.io.*;
import java.util.ArrayList;  //Paquete para manejo de archivos csv.

public class Biblioteca { //Función: Lógica de usuarios/sesión

    private ArrayList<Usuario> baseUsuarios;
    private String aUsuarios;
    private Usuario usuarioActual;

    public Biblioteca() {
        baseUsuarios = new ArrayList<Usuario>();
        aUsuarios = "basesDatos/baseUsuarios.csv";
        usuarioActual = null;

        //Bajar los usuarios existententes en la base de datos a la lista local.
        try(BufferedReader br = new BufferedReader(new FileReader(aUsuarios))){ //Abre el archivo a manera de lector
            br.readLine(); // Saltar el encabezado

            String linea; //Para ir almacenando datos

            linea = br.readLine();//Lee la siguiente linea como un String
            while (linea != null) {
                if (linea.trim().isEmpty()) {
                    linea = br.readLine();
                    continue;
                }
                String[] atributos = linea.split(","); //Realiza una lista con los atributos.
                if(atributos.length == 2){
                    Usuario u = new Usuario(); //Crea usuario
                    u.setNombre(atributos[0]); //Primer atributo se asigna a usuario
                    u.setContrasena(atributos[1]); //Segundo atributo se asigna a contrasena
                    u.archivosBases();
                    baseUsuarios.add(u); //Se agrega usuario a la lista local
                    System.out.println("Usuario cargado: " + u.getNombre());
                }
                linea = br.readLine();//Lee la siguiente linea
            }

        }catch (IOException e) {//Si ocurre un error
            System.out.println("No se pudieron cargar los usuarios ya existentes ");
        }
    }

    public ArrayList<Usuario> getBaseUsuarios() {
        return baseUsuarios;
    }

    public void setUsuarioActual(Usuario u){
        this.usuarioActual = u;
    }

    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public String getAUsuarios(){
        return  aUsuarios;
    }

    public String crearUsuario(String nombre, String contrasena) {

        for (Usuario usuario : baseUsuarios) {

            if (usuario.getNombre().equals(nombre)) {
                return "Ya existe el usuario";
            }
        }

        Usuario nuevoUsuario = new Usuario();

        nuevoUsuario.setNombre(nombre);
        nuevoUsuario.setContrasena(contrasena);
        nuevoUsuario.archivosBases();

        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(aUsuarios, true))) { //Abre el archivo en modo escritura y lo cierra el archivo automáticamente después de usarlo.
            escritor.write(nombre + "," + contrasena); //Escribe usuario y contraseña
            escritor.newLine(); //Cambia de linea para no sobreescribir en la siguiente ocasion
            
        } catch (IOException e) { //En caso no se pueda abrir el archivo
            return "No se pudo guardar el usuario."; //Termina el método si hay error.
        }

        //Una vez ya guardado
        baseUsuarios.add(nuevoUsuario); //Agrega a la lista local
        setUsuarioActual(nuevoUsuario); //Declara que es el usuario con el que se esta trabajando.

        return "Se creó el usuario correctamente";
    }

    public String login(String nombre, String contrasena) {

        for (Usuario usuario : baseUsuarios) {

            if (usuario.getNombre().equals(nombre) &&
                usuario.getContrasena().equals(contrasena)) {
                
                setUsuarioActual(usuario);
                return "Inicio de sesión correcto";
            }
        }

        throw new RuntimeException();
    }
}
