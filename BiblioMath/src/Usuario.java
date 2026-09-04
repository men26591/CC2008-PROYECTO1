
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;


public class Usuario {
    private String nombre;
    private String contrasena;
    private ArrayList<Concepto> baseConceptos;
    private String aConceptos;
    private ArrayList<Kit> baseKits;
    private String aKits;
    private String ultimaVisita;

    
    public Usuario() {
        this.nombre = "";
        this.contrasena = "";
        this.baseConceptos = new ArrayList<Concepto>();
        this.aConceptos = "";
        this.baseKits = new ArrayList<Kit>();
        this.aKits = "";
        this.ultimaVisita = "";
    }

   
    public void BajarBaseDatos(String direccion, ArrayList local) {
        //Relacion con archivo .csv
    }

    
    public void GuardarBaseDatos(String direccion, ArrayList local) {
        //Relacion con archivo .csv
       
    }

   
    public void setNombre(String nombre) {
        this.nombre = nombre;       
    }

    
    public String getNombre() {
        return this.nombre;
    }

    
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setBaseConceptos(ArrayList<Concepto> baseConceptos) {
        this.baseConceptos = baseConceptos;
    }

  
    public ArrayList<Concepto> getBaseConceptos() {
        return this.baseConceptos;
    }


    public void setBaseKits(ArrayList<Kit> baseKits) {
        this.baseKits = baseKits;
    }

    
    public ArrayList<Kit> getBaseKits() {
        return this.baseKits;
    }

   
    public void setUltimaVisita(String ultimaVisita) {
        this.ultimaVisita = ultimaVisita;
    }


    public String getUltimaVisita() {
        return this.ultimaVisita;
    }

 
    public String getAConceptos() {
      
        return "";
    }

    
    public String getAKit() {
        
        return "";
    }

    public void nuevoConcepto(int id,String nombre,String explicacion,String categoria,String curso,String kits) {
        Concepto c = new Concepto();
        c.setId(id);
        c.setNombre(nombre);
        c.setExplicacion(explicacion);
        c.setCategoria(categoria);
        c.setCurso(curso);
        String[] listaKits = kits.split(",");
        c.setKitEstudio(listaKits);

        this.baseConceptos.add(c);
    }

    
    public String motrarConceptos() {
        String cadena = "";
        for (Concepto c:baseConceptos){
            cadena += c.toString() + "\n";
        }
        
        return cadena;
    }

   
    public String buscarConcepto(String nombre) {
        for (Concepto c:baseConceptos){
            if (c.getNombre().toLowerCase().equals(nombre.toLowerCase())){
                setUltimaVisita(Integer.toString(c.getId()));
                return c.toString();
            }
        }

        //Si no se hizo ningun retorno
        return "No se encontró concepto.";
                
    }

  
    public ArrayList<Concepto> filtrarCurso(String Curso) {
        ArrayList<Concepto> filtrado = new ArrayList<>();  

        for(Concepto c:baseConceptos){
            if(c.getCurso().equals(Curso)){
                filtrado.add(c);
            }
        }
       
        return filtrado;
    }

   
    public ArrayList<Concepto> filtrarCategoria(String Categoria) {
        ArrayList<Concepto> filtrado = new ArrayList<>();

        for(Concepto c:baseConceptos){
            if(c.getCategoria().equals(Categoria)){
                filtrado.add(c);
            }
        }
        
        return filtrado;
    }

    
    public void crearKitStudio(String nombre) {
        Kit k = new Kit();
        k.setNombre(nombre);
        baseKits.add(k);
    }

    public ArrayList <String> mostrarKits() {
        ArrayList <String> listaKits= new ArrayList<>();

        for (Kit k:baseKits){
            listaKits.add(k.toString());
        }

        return listaKits;
    }

    
    public String buscarKits(String nombre) {
        for (Kit k:baseKits){
            if(k.getNombre().toLowerCase().equals(nombre.toLowerCase())){
                setUltimaVisita(nombre);
                return k.toString();
            }
        }
        return "No se encontró el Kit.";
    }

  
    public void irUltimo() {
        
        return null;
    }

}
