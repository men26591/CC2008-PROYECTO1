import java.util.*;
import java.io.*;  //Paquete para manejo de archivos csv.

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
        this.aConceptos = "baseConceptos1.csv";
        this.baseKits = new ArrayList<Kit>();
        this.aKits = "baseKits1.csv";
        this.ultimaVisita = "";
    }

   
    public <tipo> void BajarBaseDatos(String direccion, ArrayList<tipo> local)throws Exception {
        //Relacion con archivo .csv
        try(BufferedReader br = new BufferedReader(new FileReader(direccion))){ //Abre el archivo a manera de lector
        br.readLine(); // Saltar el encabezado

        String linea; //Para ir almacenando datos
        local.clear(); // Evitar duplicados al volver a cargar

        linea = br.readLine();
        while (linea != null) {
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

    
    public <tipo> void GuardarBaseDatos(String direccion, ArrayList<tipo> local) {
        //Relacion con archivo .csv
        if (!local.isEmpty()) { //Si no esta vacia
            ArrayList<String> datos = new ArrayList<>(); //Lista que almacena listas de datos.
            for (tipo e:local){
                datos.add(e.toDatos()); //Genera lista de Strings con los datos separados por comas
            }

            BufferedWriter bw = new BufferedWriter(new FileWriter(direccion));

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
            throw new RuntimeException();
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
        }
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
                setUltimaVisita(c.getNombre());
                return c.toString();
            }
        }

        //Si no se hizo ningun retorno
        return "No se encontró concepto.";
                
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

    
    public String buscarKits(String nombre) {
        for (Kit k:baseKits){
            if(k.getNombre().toLowerCase().equals(nombre.toLowerCase())){
                setUltimaVisita(nombre);
                return k.toString();
            }
        }
        return "No se encontró el Kit.";
    }

  
    public String irUltimo() {
        if(ultimaVisita.equals("")){
            return "No se ha registrado última visita. Es posible que no se hayan registrado conceptos o kits.";
        }else{
            String r = buscarKits(ultimaVisita);
            if(r.equals("No se encontró el Kit.")){
                return(buscarConcepto(ultimaVisita));
            }else{
                return "Kit:\n"+r;
            }
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
