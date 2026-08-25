
import java.io.*;
import java.util.*;


public class Kit {
    //Atributos
    private String nombre;
    private ArrayList<Concepto> conceptos;
    //Métodos
    public Kit(){}
    public void setNombre(Scanner teclado){
        System.out.println("Ingrese el nombre del nuevo kit: ");
        nombre = teclado.nextLine();
        conceptos = new ArrayList<Concepto>(1);
    }
    public String getNombre(){
        return nombre;
    }

    public void setConceptos(){
        conceptos = new ArrayList<Concepto>(1);
    }
    public ArrayList<Concepto> getConceptos(){
        return conceptos;
    }
    public void agregarConcepto(Concepto concepto){
        conceptos.add(concepto);
    }
    
}