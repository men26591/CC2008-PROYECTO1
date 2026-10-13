import java.util.*;
import java.io.*;  //Paquete para manejo de archivos csv.

public class Usuario {
    private String nombre;
    private String contrasena;
    private ArrayList<Concepto> baseConceptos;
    private String aConceptos;
    private ArrayList<Kit> baseKits;
    private String aKits;
    private Object ultimaVisita;

    public Usuario() {
        this.nombre = "";
        this.contrasena = "";
        this.baseConceptos = new ArrayList<Concepto>();
        this.aConceptos = "";
        this.baseKits = new ArrayList<Kit>();
        this.aKits = "";
        this.ultimaVisita = null;
    }

    public <tipo> void BajarBaseDatos(String direccion, ArrayList<tipo> local)throws Exception {
        //Relacion con archivo .csv
        try(BufferedReader br = new BufferedReader(new FileReader(direccion))){ //Abre el archivo a manera de lector
        br.readLine(); // Saltar el encabezado

        String linea; //Para ir almacenando datos
        local.clear(); // Evitar duplicados al volver a cargar

        while ((linea = br.readLine()) != null) {
            if (linea.trim().isEmpty()) {
                continue; // Saltar filas vacías
            }

            String[] atributos = linea.split(",");
            
            //Creacion de objetos
            if (direccion.equals(aConceptos)){
                Concepto c = new Concepto();
                c.setId(Integer.parseInt(atributos[0]));
                c.setNombre(atributos[1]);
                c.setExplicacion(atributos[2]);
                c.setCategoria(atributos[3]);
                c.setCurso(atributos[4]);
                //c.setKitEstudio(atributos[5]);

                baseConceptos.add(c);//Agregar objeto a local
            }
            if (direccion.equals(aKits)) {
                Kit k = new Kit();
                k.setNombre(atributos[0]);
                //k.setConceptos(atributos[1]);
                baseKits.add(k); //Agregar objeto a local
                
            }
        }
        }

    }
    
    public <tipo> void GuardarBaseDatos(String direccion, ArrayList<tipo> local)throws Exception{
        //Relacion con archivo .csv
        if (!local.isEmpty()) { //Si no esta vacia
            ArrayList<String> datos = new ArrayList<>(); //Lista que almacena listas de datos.
            
            for (tipo e:local){
                if (e instanceof Concepto) {
                    Concepto c = (Concepto) e;
                    datos.add(c.toDatos());

                } else if (e instanceof Kit) {
                    Kit k = (Kit) e;
                    datos.add(k.toDatos());
                }

            new File(direccion).getParentFile().mkdirs(); //Se crea la carpeta del archivo si no existe

            try(BufferedWriter bw = new BufferedWriter(new FileWriter(direccion))){
                if(local.get(0) instanceof Concepto){ //Si se trata de la base de Conceptos
                    bw.write("id,nombre,explicacion,categoria,curso,kitEstudio");// encabezado
                }
                if(local.get(0) instanceof Kit){ //Si se trata de la base de Kits
                    bw.write("nombre,conceptos");// encabezado
                }

                bw.newLine(); //Cambio de fila

                for (String fila : datos) {
                    bw.write(fila); // Escribe la linea con los datos de un elemento
                    bw.newLine(); //Cambio de fila
                }
            }
            }
        }  
    }

    public void archivosBases(){
        String carpeta = "BiblioMath/basesDatos/" + nombre + "/";
        this.aConceptos = carpeta + "conceptos.csv"; //Archivo de conceptos dentro de la carpeta
        this.aKits = carpeta + "kits.csv"; //Archivo de kits dentro de la carpeta

        try {
            if (new File(aConceptos).isFile()) {
                BajarBaseDatos(aConceptos, baseConceptos); //Carga la base de datos
            }
            if (new File(aKits).isFile()) {
                BajarBaseDatos(aKits, baseKits); //Carga la base de datos
            }
        } catch (Exception e) { //Si ocurre un error
            throw new IllegalStateException("No se pudieron cargar los datos de " + nombre, e);
        }
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

   
    public void setUltimaVisita(Object ultimaVisita) {
        this.ultimaVisita = ultimaVisita;
    }


    public Object getUltimaVisita() {
        return this.ultimaVisita;
    }

 
    public String getAConceptos() {
        return this.aConceptos;
    }

    
    public String getAKit() {
        return this.aKits;
    }

    public void nuevoConcepto(int id,String nombre,String explicacion,String categoria,String curso,String kits) {
        boolean repetido = false;

        for(Concepto c:baseConceptos){
            if((c.getId()==id)||(c.getNombre().equalsIgnoreCase(nombre))){repetido=true;}
        }

        if(repetido){
            throw new RuntimeException("Ya existe un concepto con este nombre.");
        }else{
            Concepto c = new Concepto();
            c.setId(id);
            c.setNombre(nombre);
            c.setExplicacion(explicacion);
            c.setCategoria(categoria);
            c.setCurso(curso);

            String[] lkits = kits.split(","); //Separar kist ingresados 
            ArrayList<String> listaKits = new ArrayList<>();
            //Transformar la lista en un Arreglo dinámico
            for(String k:lkits){
                listaKits.add(k);
            }

            c.setKitEstudio(listaKits);

            this.baseConceptos.add(c);
            setUltimaVisita(c.getNombre());

            try{
                GuardarBaseDatos(aConceptos, baseConceptos); //Actualiza base datos
            }catch(Exception e){
                throw new RuntimeException("No se pudo guardar el concepto"+e);
            }
        }
    }
    
    public String motrarConceptos() {
        String cadena = "";
        for (Concepto c:baseConceptos){
            cadena += c.toString() + "\n";
        }
        
        return cadena;
    }

   
    public Concepto buscarConcepto(String nombre) {
        for (Concepto c:baseConceptos){
            if (c.getNombre().toLowerCase().equals(nombre.toLowerCase())){
                setUltimaVisita(c.getNombre());
                return c;
            }
        }

        //Si no se hizo ningun retorno
        return null;
                
    }

  
    public ArrayList<Concepto> filtrarCurso(String Curso) {
        ArrayList<Concepto> filtrado = new ArrayList<>();  

        for(Concepto c:baseConceptos){
            if(c.getCurso().equalsIgnoreCase(Curso)){
                filtrado.add(c);
            }
        }
       
        return filtrado;
    }

   
    public ArrayList<Concepto> filtrarCategoria(String Categoria) {
        ArrayList<Concepto> filtrado = new ArrayList<>();

        for(Concepto c:baseConceptos){
            if(c.getCategoria().equalsIgnoreCase(Categoria)){
                filtrado.add(c);
            }
        }
        
        return filtrado;
    }

    
    public void crearKitStudio(String nombre) {
        boolean repetido = false;
        
        for(Kit k:baseKits){
            if(k.getNombre().equalsIgnoreCase(nombre)){
                repetido = true;
            }
        }

        if(repetido){
            throw new RuntimeException();
        }else{
            Kit k = new Kit();
            k.setNombre(nombre);
            baseKits.add(k);
            setUltimaVisita(k.getNombre());
        }
    }

    public ArrayList <String> mostrarKits() {
        ArrayList <String> listaKits= new ArrayList<>();

        for (Kit k:baseKits){
            listaKits.add(k.toString());
        }

        return listaKits;
    }

    
    public Kit buscarKits(String nombre) {
        for (Kit k:baseKits){
            if(k.getNombre().toLowerCase().equals(nombre.toLowerCase())){
                setUltimaVisita(nombre);
                return k;
            }
        }
        return null;
    }

  
    public Object irUltimo() {
        if(ultimaVisita == null){ //Si no hay ultima visita registrada
            return "No se ha registrado última visita.";
        }else{
            if((ultimaVisita instanceof Concepto)||(ultimaVisita instanceof Kit)){ //Si es un Concepto o Kit
                return ultimaVisita;
            }
            return "No se encontro objeto."; //Si no es kit o concepto
            
        }
    }

    //Métodos dentro de Kit
    public String agregarCaKit(String kitN,String conceptoN){
        Kit kit = null;
        Concepto concepto = null;
        for (Kit k:baseKits){
            if(k.getNombre().toLowerCase().equals(kitN.toLowerCase())){
                kit = k;
            }
        }
        for (Concepto c:baseConceptos){
            if (c.getNombre().toLowerCase().equals(conceptoN.toLowerCase())){
                concepto = c;    
            }
        }

        if (kit == null) {
            return "No se encontró el kit.";
        }

        if (concepto == null) {
            return "No se encontró el concepto.";
        }

        for (Concepto c : kit.getConceptos()) {
            if (c.getId() == concepto.getId()) {
                return "El concepto ya pertenece a ese kit.";
            }
        }

        kit.agregarConcepto(concepto);
        return "Concepto agregado al kit correctamente.";
    }
    
    public String quitaEnKit(String kitN,int id){
        Kit kit = null;
        for (Kit k:baseKits){
            if(k.getNombre().toLowerCase().equals(kitN.toLowerCase())){
                kit = k;
            }
        }

        if (kit == null) {
            return "No se encontró el kit.";
        }

        boolean conceptoEncontrado = false;
        for (Concepto c : kit.getConceptos()) {
            if (c.getId() == id) {
                conceptoEncontrado = true;
            }
        }

        if (conceptoEncontrado == false) {
            return "No se encontró un concepto con ese ID dentro del kit.";
        }

        kit.quitarConcepto(id);
        return "Concepto eliminado del kit correctamente.";
    }

    public boolean estaLlenoKit(){

        if (baseKits.isEmpty()) {
                return false;
            }
        return true;
    }

    public boolean estaLlenoConcepto(){

        if (baseConceptos.isEmpty()) {
                return false;
            }
        return true;
    }
}
