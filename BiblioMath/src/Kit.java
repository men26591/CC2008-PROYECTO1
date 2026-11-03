
import java.util.*;


public class Kit {

//Atributos
    private String nombre;
    private ArrayList<Integer> conceptos; //Almacena ID de conceptos

    public Kit(){
        nombre = "";
        conceptos = new ArrayList<>();
    }
    
    public Kit(String nombre){
        this.nombre = nombre;
        conceptos = new ArrayList<Integer>();
        }
    
//Métodos SET & GET

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public void setConceptos(ArrayList<Integer>conceptos){
        this.conceptos = conceptos;
    }

    public ArrayList<Integer> getConceptos(){
        return conceptos;
    }

// Otros métodos

    public void agregarConcepto(Concepto concepto){
        if (concepto != null){
                conceptos.add(concepto.getId());
        }
    }

    public void quitarConcepto(int id){
        for(int i = 0; i < conceptos.size(); i++){
           if(conceptos.get(i) != null){
                if(id == conceptos.get(i)){
                    conceptos.remove(conceptos.get(i));
                }
            } 
        }
    }
    public String toString(){ 
        return nombre + ","+ conceptos;
    }

    public String toDatos(){ //Para el almacenamiento en csv
        String cadena="";
        cadena = nombre+","+conceptos; //Datos separados por comas
        
        return cadena;
    }
}
