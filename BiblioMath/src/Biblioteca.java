import java.io.*;
import java.util.ArrayList;  //Paquete para manejo de archivos csv.

//Para Hashing (Clases incluidas en Java)
import java.security.GeneralSecurityException; //Para manejar errores al calcular hash.
import java.security.MessageDigest;
import java.security.SecureRandom; //Permite generar valores aleatorios (salt).
import java.util.Base64; //Permite la traducción bytes a texto para almacenar y recuperar las contraseñas.
import javax.crypto.SecretKeyFactory; //Permite el calucló del hash.
import javax.crypto.spec.PBEKeySpec; //Reune informacion que necesita PBKDF2 (algoritmo que permite calcular el hash).

public class Biblioteca { //Función: Lógica de usuarios/sesión

    private ArrayList<Usuario> baseUsuarios;
    private String aUsuarios;
    private Usuario usuarioActual;
    private static final int iteraciones = 600000; //Atributo entero no modificable, la cantidades de iteraciones que realizará el hashing. 

    public Biblioteca() {
        baseUsuarios = new ArrayList<Usuario>();
        aUsuarios = "BiblioMath/basesDatos/baseUsuarios.csv";
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
            e.printStackTrace();
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

        String hash = generar(contrasena.toCharArray()); //Genera el hash de la contraseña (almacena las iteraciones, el salt y el hash.)

        Usuario nuevoUsuario = new Usuario();

        nuevoUsuario.setNombre(nombre);
        nuevoUsuario.setContrasena(hash); //Almacena hash de la contraseña.
        nuevoUsuario.archivosBases();

        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(aUsuarios, true))) { //Abre el archivo en modo escritura y lo cierra el archivo automáticamente después de usarlo.
            escritor.write(nombre + "," + hash); //Escribe usuario y contraseña cifrada
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

            if (usuario.getNombre().equals(nombre) && verificar(contrasena.toCharArray(), usuario.getContrasena())) {
                
                setUsuarioActual(usuario);
                return "Inicio de sesión correcto";
            }
        }

        throw new RuntimeException();
    }

    //CALCULAR HASH
    private static byte[] calcularHash(char[] contrasena, byte[] salt){ //contrasena→arreglo de caracteres con contrasena, salt→arreglo de bytes con un valor aleatorio
        PBEKeySpec configuracion = new PBEKeySpec(contrasena, salt, iteraciones, 256);//Reune todos los datos necesarios. (256, tamano de resultado en biys.)

        try {
            SecretKeyFactory fabrica = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256"); //Obtiene la herramienta de Java que ejecuta PBKDF2 (algoritmo de calculo de hash).
            return fabrica.generateSecret(configuracion).getEncoded(); //Devuleve el resultado del calulo en bytes.

        }catch (GeneralSecurityException e){ //Maneja excepciones o errores
            throw new IllegalStateException("No se pudo calcular el hash de la contraseña.", e);
        } finally {
            configuracion.clearPassword();//Elimina la copia de la contraseña almacenada en la variable configuracion.
        }
    }

    //GENERAR HASH
    public static String generar(char[] contrasena) { //Recibe contraseñacomo arreglo de caracteres
        byte[] salt = new byte[16]; //Crea arreglo vacio de bytes.
        new SecureRandom().nextBytes(salt); //Llena el arreglo de nuevos valores aleatorios.
        byte[] hash = calcularHash(contrasena, salt); //Calcula el hash
        String saltTexto = Base64.getEncoder().encodeToString(salt); //Escribe el salt como String
        String hashTexto = Base64.getEncoder().encodeToString(hash); //Escribe el hash como String.

        //salt → clave de encriptado, hash → valor encriptado
        return iteraciones + ":" + saltTexto + ":" + hashTexto; //Devuelve los valores necesarios para decifrar la nueva contraseña encriptada.
    }

    //VERIFICACION DE CONTRASEÑA REPETIDA
    public static boolean verificar(char[] contrasena, String guardado){ //Recibe contrasena ingresada y el texto que produce el metodo generar.
        if (guardado == null) { //Si no se recibe la contraseña generada en hash, se retorna false.
            return false;
        } 
        String[] partes = guardado.split(":", -1); //Separa iteraciones, salt y hash. El -1 conserva partes vacias para validaciones de datos completos.

        if (partes.length != 3) { //Si no son 3 datos
            return false; //El formato esta mal y se retorna falso.
        }

        if (!partes[0].equals(String.valueOf(iteraciones))) { //Comprueba que el numero de iteraciones del hash sea el utilizado actualmente.
            return false;
        }

        try{
            byte[] salt = Base64.getDecoder().decode(partes[1]); //Vuelve el String que almacenaba el salt en bytes.
            byte[] hashGuardado = Base64.getDecoder().decode(partes[2]); //Vuelve el String que almacenaba el hash en bytes.

            if (salt.length != 16 || hashGuardado.length != 32) { //Validación de bytes esperados.
                return false;
            }

            byte[] hashIngresado = calcularHash(contrasena, salt); //Se calcula el hash de la contraseña ingresada.

            
            return MessageDigest.isEqual(hashGuardado, hashIngresado); //Compara los hash y devuelve el valor de verdad correspondiente.

        }catch (IllegalArgumentException e) { //Manejo de excepciones
            return false;
        }
    }
}
