
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
    
}