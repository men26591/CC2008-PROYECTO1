
import java.util.ArrayList;

public class Concepto {

    public Concepto() {
    }

    private int id;
    private String nombre;
    private String explicacion;
    private String categoria;
    private String curso;
   private List<String> kitEstudio;

    public Concepto() {
        id = 0;
        nombre = "";
        explicacion = "";
        categoria = "";
        curso = "";
        kitEstudio = new ArrayList<>(); 
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

    public void setKitEstudio (List<String> kitEstudio){
        this.kitEstudio = kitEstudio;
    }

    //Otros métodos
    
    public void agregarKit(String nombreKit) {
        //DEPEDNE DE KIT.
        return null;
    }

    public String toString() {
        return "";
    }

}