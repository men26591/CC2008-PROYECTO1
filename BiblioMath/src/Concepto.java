
import java.util.ArrayList;
import java.util.List;
import java.util.Base64;
import java.nio.charset.StandardCharsets;

public class Concepto {

    private int id;
    private String nombre;
    private String explicacion;
    private String categoria;
    private String curso;
    private List<String> kitEstudio;
    private ArrayList<String[]> ejercicios;   

    public Concepto() {
        id = 0;
        nombre = "";
        explicacion = "";
        categoria = "";
        curso = "";
        kitEstudio = new ArrayList<>();
        ejercicios = new ArrayList<>();
    }

    // Get & Set

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }


    public void setExplicacion(String explicacion) {
        this.explicacion = explicacion;
    }

    public String getExplicacion() {
        return explicacion;
    }


    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }


    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getCurso() {
        return curso;
    }

    public List<String> getKitEstudio(){
        return kitEstudio;
    }

    public void setKitEstudio (ArrayList<String> kitEstudio){
        this.kitEstudio = kitEstudio;
    }

    public ArrayList<String[]> getEjercicios(){
        return this.ejercicios;
    }

    public void setEjercicios(ArrayList<String[]> e){
        this.ejercicios = e;
    }

    //Otros métodos
    
    public void agregarKit(Kit kit) {

            kit.agregarConcepto(this);
            this.kitEstudio.add(kit.getNombre());
            
    }

    public void agregarEjercicio(String ejercicio, String r){
        String[] e = new String[2]; 
        e[0] = ejercicio;
        e[1] = r;

        ejercicios.add(e);
    }

    public String toString() {

        String nombresKit = "";
        String nombreKit = "";

        if (this.kitEstudio == null || this.kitEstudio.isEmpty()){
            nombresKit = "Ninguno"; 
        }else{
            for (int i= 0; i< this.kitEstudio.size(); i++){
                nombreKit = this.kitEstudio.get(i);

                if (i == 0){
                    nombresKit = nombreKit;
                }else {
                    nombresKit = nombresKit  + ", " + nombreKit;
                }
            }
        }
         
        return "\nConcepto \nID: " + id + "\nNombre: " + nombre + "\nCategoría: " + categoria + "\nCurso: " + curso +"\nKit de Estudio: "+ nombresKit + "\n";
    }

    public String toDatos(){ //Para el almacenamiento en csv
        //Manejo de ejercicios
        String datosEjercicios = "";

        for (String[] ejercicio : ejercicios) { //Permite almacenear preguntas y respuestas sin saltos de lineas
            String pregunta = Base64.getEncoder().encodeToString(ejercicio[0].getBytes(StandardCharsets.UTF_8));
            String respuesta = Base64.getEncoder().encodeToString(ejercicio[1].getBytes(StandardCharsets.UTF_8));

            if (!datosEjercicios.isEmpty()) {
                datosEjercicios += ";";
            }

            datosEjercicios += pregunta + ":" + respuesta;
        }

        //Cadena para archivo csv
        String cadena = "";
        cadena = id + "," + nombre + "," + explicacion + ","+ categoria + "," + curso + "," + kitEstudio+ ",ejercicios:" + datosEjercicios;

        return cadena;

    }
}