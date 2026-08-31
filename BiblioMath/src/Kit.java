
import java.io.*;
import java.util.*;


public class Kit {
    //Atributos
    private String nombre;
    private ArrayList<Concepto> conceptos;

    public Kit(){
        nombre = "";
        this.conceptos = new ArrayList<>();
    }

    //Métodos

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
        if (concepto != null){
                conceptos.add(concepto);
        }
    }

    public void mostrarKit(){
        System.out.println("Kit: " + nombre);
        for(int i = 0; i < conceptos.size(); i++){
            System.out.println(conceptos.get(i));
        }
    }
    public Concepto buscarenkit(int id){
        for(int i = 0; i < conceptos.size(); i++){
            if(id == conceptos.get(i).getId()){
                return conceptos.get(i);
            }
        }
        return null;
    }
}