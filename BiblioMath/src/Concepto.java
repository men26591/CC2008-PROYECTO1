
import java.util.ArrayList;

public class Concepto {

    public Concepto() {
    }

    private int id;
    private String nombre;
    private String explicacion;
    private String categoria;
    private String curso;
    private ArrayList<KitEstudio> kitEstudio;

    public Concepto() {
        id = "";
        nombre = "";
        categoria = "";
        curso = "";
        kitEstudio = new ArrayList<KitEstdio>();
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


    public ArrayList<KitEstudio> getKitEstudio() {
        return kitEstudio;
    }

    public void setKitEstudio(ArrayList<KitEstudio> kitEstudio) {
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