
import java.util.ArrayList;

/**
 * 
 */
public class Concepto {

    /**
     * Default constructor
     */
    public Concepto() {
    }

    /**
     * 
     */
    private int id;
    private String nombre;
    private String explicacion;
    private String categoria;
    private String curso;
    private ArrayList<KitEstudio> kitEstudio;

    /**
     * 
     */
    public Concepto() {
        id = "";
        nombre = "";
        categoria = "";
        curso = "";
        kitEstudio = new ArrayList<KitEstdio>();
    }

    /**
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param explicacion
     */
    public void setExplicacion(String explicacion) {
        this.explicacion = explicacion;
    }

    /**
     * @return
     */
    public String getExplicacion() {
        return explicacion;
    }

    /**
     * @param categoria
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * @return
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param curso
     */
    public void setCurso(String curso) {
        this.curso = curso;
    }

    /**
     * @return
     */
    public String getCurso() {
        return curso;
    }

    public ArrayList<KitEstudio> getKitEstudio() {
        return kitEstudio;
    }


    public void setKitEstudio(ArrayList<KitEstudio> kitEstudio) {
        this.kitEstudio = kitEstudio;
    }

    /**
     * @param nombreKit 
     * @return
     */
    public void agregarKit(String nombreKit) {
        return null;
    }

    /**
     * @return
     */
    public String toString() {
        return "";
    }

}