import java.util.ArrayList;

public class Biblioteca {

    private ArrayList<Usuario> baseUsuarios;
    private Usuario usuarioActual;

    public Biblioteca() {
        baseUsuarios = new ArrayList<Usuario>();
        usuarioActual = null;
    }

    public ArrayList<Usuario> getBaseUsuarios() {
        return baseUsuarios;
    }

    public Usuario getUsuarioActual() {
        return usuarioActual;
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

        baseUsuarios.add(nuevoUsuario);

        return "Se creó el usuario correctamente";
    }
}
