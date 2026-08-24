
import java.io.*;
import java.util.*;


public class Usuario {
    private String nombre;
    private String contrasena;
    private ArrayList<Concepto> baseConceptos;
    private String aConceptos;
    private ArrayListe<KitEstudio> baseKits;
    private String aKits;
    private String ultimaVisita;

    
    public Usuario() {
        this.nombre = "";
        this.contrasena = "";
        this.baseConceptos = new ArrayList<Concepto>();
        this.aConceptos = "";
        this.baseKits = new ArrayList<KitEstudio>();
        this.aKits = "";
        this.ultimaVisita = "";
    }

   
    public void BajarBaseDatos(String direccion, ArrayList local) {
    
    }

    
    public void GuardarBaseDatos(String direccion, ArrayList local) {
       
    }

   
    public void setNombre(String nombre) {
       
    }

    
    public String getNombre() {
        return "";
    }

    
    public void setContrasena(String contrasena) {
        
    }

    public String getContrasena() {
        return "";
    }

    public void setBaseConceptos(Set<Concepto> baseConceptos) {
        
    }

  
    public Set<Concepto> getBaseConceptos() {
        return null;
    }


    public void setBaseKits(Set<KitEstudio> baseKits) {

    }

    
    public Set<KitEstudio> getBaseKits() {
        return null;
    }

   
    public void setUltimaVisita(String ultimaVisita) {
        
    }


    public String getUltimaVisita() {
       
        return "";
    }

 
    public String getAConceptos() {
      
        return "";
    }

    
    public String getAKit() {
        
        return "";
    }

    public void nuevoConcepto() {
        
        return null;
    }

    
    public String motrarConceptos() {
        
        return "";
    }

   
    public String buscarConcepto() {
        
        return "";
    }

  
    public void filtrarCurso(String Curso) {
       
        return null;
    }

   
    public void filtrarCategoria(String Categoria) {
        
        return null;
    }

    
    public void creatKitStudio() {
        
        return null;
    }

    public List <String> mostrarKits() {
        return null;
    }

    
    public void buscarKits(String nombre) {
        
    }

  
    public void irUltimo() {
        
        return null;
    }

}
