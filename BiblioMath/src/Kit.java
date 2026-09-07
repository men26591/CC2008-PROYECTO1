
import java.io.*;
import java.util.*;


public class Kit {

//Atributos
    private String nombre;
    private ArrayList<Concepto> conceptos;

    public Kit(){
        nombre = "";
        conceptos = new ArrayList<>();
    }
    
    public Kit(String nombre){
        this.nombre = nombre;
        conceptos = new ArrayList<Concepto>();
        }
    
//Métodos SET & GET

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public void setConceptos(ArrayList<Concepto>conceptos){
        this.conceptos = conceptos;
    }

    public ArrayList<Concepto> getConceptos(){
        return conceptos;
    }

// Otros métodos

    public void agregarConcepto(Concepto concepto){
        if (concepto != null){
                conceptos.add(concepto);
        }
    }
    
    public Concepto buscarenkit(int id){
        for(int i = 0; i < conceptos.size(); i++){
            if(conceptos.get(i) != null){
                if(id == conceptos.get(i).getId()){
                    return conceptos.get(i);
                }
            }          
        }
        return null;
    }
    public void quitarConcepto(int id){
        for(int i = 0; i < conceptos.size(); i++){
           if(conceptos.get(i) != null){
                if(id == conceptos.get(i).getId()){
                    conceptos.remove(conceptos.get(i));
                }
            } 
        }
    }  
    public String toString(){ 
        return nombre + ","+ conceptos;
    }
}
