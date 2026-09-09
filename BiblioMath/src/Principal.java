import java.util.Scanner;

public class Principal {

    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);

        Biblioteca biblio = new Biblioteca();

        System.out.println("********** BiblioMath **********");
//LONG IN/SING UP
        System.out.println("\n1. Log in\n2. Sign up");
        System.out.println("\n********* ¿Qué desea hacer? (Ingrese el número) **********");
        
        boolean error = true;
        int accion1 = 0;
        while (error){
                String entrada1 = teclado.nextLine();
                try{
                    accion1 = Integer.parseInt(entrada1);
                    if (accion1 > 2 || accion1 < 1) {
                        System.out.println("\n¡Intente de nuevo! Ingresa una opción válida: ");
                    }
                    else{
                        error = false;
                    }

                }catch(Exception e){
                    System.out.println("\n¡Intente de nuevo! Ingresa una opción válida: ");
                }
            }

        String username = "";
        String password ="";

        switch (accion1){
            case 1:
                System.out.println("\n********* Log in **********");

                System.out.println("\nUsername: ");
                error = true;

                while (error == true){
                        
                        try{
                            username = teclado.nextLine();
                            error = false;
                                
                            if (username.isBlank()) { 
                                System.out.println("\n¡Intenta de nuevo! No puedes dejar espacios vacíos.");
                                error = true;
                            }

                        }catch(Exception e){
                            System.out.println("\n¡Error inesperado, intenta de nuevo!");
                            teclado.nextLine();
                            error = true;
                        }
                    }


                System.out.println("Password: ");
                error = true;

                while (error == true){
                        
                        try{
                            password = teclado.nextLine();
                            error = false;
                                
                            if (password.isBlank()) { 
                                System.out.println("\n¡Intenta de nuevo! No puedes dejar espacios vacíos.");
                                error = true;
                            }

                        }catch(Exception e){
                            System.out.println("\n¡Error inesperado, intenta de nuevo!");
                            teclado.nextLine();
                            error = true;
                        }
                    }
                
                System.out.println(biblio.login(username, password));

            break;
                
            case 2:
                
                System.out.println("\n********* Sign up **********");

                System.out.println("\nUsername: ");
                error = true;
                String usernameN = null;
                while (error == true){
                        
                        try{
                            usernameN = teclado.nextLine();
                            error = false;
                                
                            if (usernameN.isBlank()) { 
                                System.out.println("\n¡Intenta de nuevo! No puedes dejar espacios vacíos.");
                                error = true;
                            }

                        }catch(Exception e){
                            System.out.println("\n¡Error inesperado, intenta de nuevo!");
                            teclado.nextLine();
                            error = true;
                        }
                    }


                System.out.println("Password: ");
                error = true;
                String passwordN = null;
                while (error){
                        
                        try{
                            passwordN = teclado.nextLine();

                            if (passwordN.isBlank()) { 
                                System.out.println("\n¡Intenta de nuevo! No puedes dejar espacios vacíos.");
                            }
                            else{
                                error = false;
                            }

                        }catch(Exception e){
                            System.out.println("\n¡Error inesperado, intenta de nuevo!");
                            teclado.nextLine();
                        }
                    }

                System.out.println(biblio.crearUsuario(usernameN,passwordN));
        
            break;

            default:
                System.out.println("Opción no válida.");
                break;
        }

//BIBLIO
        System.out.println("********** ¡Bienvenido! A BiblioMath **********");
        int accionB = 0;

        while(accionB!=12){
            System.out.println("********** Menú **********");

            System.out.println("1.Agregar Concepto \n2. Mostrar Conceptos\n3. Buscar Concepto\n4. Agregar Kit\n5. Mostrar Kits\n6. Buscar Kit\n7. Agregar Concepto a Kit\n8. Quitar Concepto en Kit\n9. Filtrar Curso\n10. Filtrar Categoria\n11. Ultimo visitado\n12. Salida");
            System.out.println("¿Qué desea hacer? (Ingrese el número)");

            error = true;
            while (error){
                    accionB = teclado.nextInt(); teclado.nextLine();
                    try{
                        if ((0 < accionB) && (accionB < 13)){
                            error = false;
                        }
                        else{
                            System.out.println("\n 1111 ¡Intente de nuevo! Ingresa una opción válida: ");
                        }
                    }catch(Exception e){
                        System.out.println("\n 2222 ¡Intente de nuevo! Ingresa una opción válida: ");
                    }
            }

            switch (accionB){
                case 1:
                    System.out.println("********** Agregar Concepto **********");

                    int id = 0;
                    String nombre = "";
                    String explicacion = "";
                    String categoria = "";
                    String curso = "";
                    String kits = "";

                    System.out.println("ID: ");
                    error = true;

                    while (error == true){
                        
                        try{

                            id = teclado.nextInt(); teclado.nextLine();
                            error = false;

                        }catch(Exception e){
                            System.out.println("\n¡Error inesperado, intenta de nuevo!");
                            teclado.nextLine();
                            error = true;
                        }
                    }

                    System.out.println("Nombre: ");

                    error = true;

                    while (error == true){
                        
                        try{
    
                            nombre = teclado.nextLine();
                            error = false;
                                
                            if (nombre.isBlank()) { 
                                System.out.println("\n¡Intenta de nuevo! No puedes dejar espacios vacíos.");
                                error = true;
                            }

                        }catch(Exception e){
                            System.out.println("\n¡Error inesperado, intenta de nuevo!");
                            teclado.nextLine();
                            error = true;
                        }
                    }

                    System.out.println("Explicación: ");
                    error = true;

                    while (error == true){
                        
                        try{
                            
                            explicacion = teclado.nextLine();
                            error = false;
                                
                            if (explicacion.isBlank()) { 
                                System.out.println("\n¡Intenta de nuevo! No puedes dejar espacios vacíos.");
                                error = true;
                            }

                        }catch(Exception e){
                            System.out.println("\n¡Error inesperado, intenta de nuevo!");
                            teclado.nextLine();
                            error = true;
                        }
                    }

                    System.out.println("Categoría: ");
                    error = true;

                    while (error == true){
                        
                        try{
                            
                            categoria = teclado.nextLine();
                            error = false;
                                
                            if (categoria.isBlank()) { 
                                System.out.println("\n¡Intenta de nuevo! No puedes dejar espacios vacíos.");
                                error = true;
                            }

                        }catch(Exception e){
                            System.out.println("\n¡Error inesperado, intenta de nuevo!");
                            teclado.nextLine();
                            error = true;
                        }
                    }

                    System.out.println("Curso");
                    error = true;

                    while (error == true){
                        
                        try{
                            
                            curso = teclado.nextLine();
                            error = false;
                                
                            if (curso.isBlank()) { 
                                System.out.println("\n¡Intenta de nuevo! No puedes dejar espacios vacíos.");
                                error = true;
                            }

                        }catch(Exception e){
                            System.out.println("\n¡Error inesperado, intenta de nuevo!");
                            teclado.nextLine();
                            error = true;
                        }
                    }

                    System.out.println("Kits (Codigo de kits separados por Coma)");
                    error = true;

                    while (error == true){
                        
                        try{
                            kits = teclado.nextLine();
                            error = false;
                                
                            if (kits.isBlank()) { 
                                System.out.println("\n¡Intenta de nuevo! No puedes dejar espacios vacíos.");
                                error = true;
                            }

                        }catch(Exception e){
                            System.out.println("\n¡Error inesperado, intenta de nuevo!");
                            teclado.nextLine();
                            error = true;
                        }
                    }

                    biblio.getUsuarioActual().nuevoConcepto(id, nombre, explicacion, categoria, curso, kits);
                    break;

                case 2:
                    System.out.println("********** Mostrar Conceptos **********");
                    if(biblio.getUsuarioActual().estaLlenoConcepto() == true){
                    System.out.println(biblio.getUsuarioActual().motrarConceptos());
                    }else{
                    System.out.println("No se han ingresado conceptos al sistema.");
                    }
                    break;

                case 3:
                    
                    System.out.println("********** Buscar Concepto **********");

                    System.out.println("Nombre: ");
                    String nom = "";
                    error = true;

                    while (error == true){
                        
                        try{
                            nom = teclado.nextLine();
                            error = false;
                                
                            if (nom.isBlank()) { 
                                System.out.println("\n¡Intenta de nuevo! No puedes dejar espacios vacíos.");
                                error = true;
                            }

                        }catch(Exception e){
                            System.out.println("\n¡Error inesperado, intenta de nuevo!");
                            teclado.nextLine();
                            error = true;
                        }
                    }
                    
                    System.out.println(biblio.getUsuarioActual().buscarConcepto(nom));
                    
                    break;

                case 4:
                    System.out.println("********** Crear Kit **********");
                    String n = teclado.nextLine();

                    biblio.getUsuarioActual().crearKitStudio(n);
                    break;
                case 5:
                    System.out.println("********** Mostrar Kits **********");
                    System.out.println(biblio.getUsuarioActual().mostrarKits());
                    break;
                case 6:
                    System.out.println("********** Buscar Kit**********");
                    System.out.println("Nombre: ");
                    nombre = "";
                    error = true;

                    while (error == true){
                        
                        try{
                            nombre = teclado.nextLine();
                            error = false;
                                
                            if (nombre.isBlank()) { 
                                System.out.println("\n¡Intenta de nuevo! No puedes dejar espacios vacíos.");
                                error = true;
                            }

                        }catch(Exception e){
                            System.out.println("\n¡Error inesperado, intenta de nuevo!");
                            teclado.nextLine();
                            error = true;
                        }
                    }
                    System.out.println(biblio.getUsuarioActual().buscarKits(nombre));

                    break;
                case 7:
                    System.out.println("********** Agregar Concepto a Kit**********");
                    
                    String kit = " "; 
                    String concepto = " ";

                    if(biblio.getUsuarioActual().estaLlenoKit() == true && biblio.getUsuarioActual().estaLlenoConcepto() == true) {
                        System.out.println("Nombre Kit: ");
                        error = true;
                        while (error == true) {
                            kit = teclado.nextLine();
                            if (kit.isBlank()) {
                                System.out.println("¡Intenta de nuevo! El nombre del kit no puede estar vacío.");
                            } else {
                                error = false;
                            }
                        }

                        System.out.println("Nombre Concepto: ");
                        error = true;
                        while (error == true) {
                            concepto = teclado.nextLine();
                            if (concepto.isBlank()) {
                                System.out.println("¡Intenta de nuevo! El nombre del concepto no puede estar vacío.");
                            } else {
                                error = false;
                            }
                        }

                        System.out.println(biblio.getUsuarioActual().agregarCaKit(kit, concepto));
                    }else{
                        System.out.println("No se han registrado datos");
                    }
                    
                    
                    break;
                case 8:
                    System.out.println("********** Quitar Concepto en Kit**********");
                    if(biblio.getUsuarioActual().estaLlenoKit() == true && biblio.getUsuarioActual().estaLlenoConcepto() == true) {
                        System.out.println("Nombre Kit: ");
                        error = true;
                        while (error == true) {
                            kit = teclado.nextLine();
                            if (kit.isBlank()) {
                                System.out.println("¡Intenta de nuevo! El nombre del kit no puede estar vacío.");
                            } else {
                                error = false;
                            }
                        }

                        System.out.println("ID Concepto: ");
                        error = true;
                        while (error == true) {
                            try {
                                id = Integer.parseInt(teclado.nextLine());
                                if (id <= 0) {
                                    System.out.println("¡Intenta de nuevo! El ID debe ser mayor que cero.");
                                } else {
                                    error = false;
                                }
                            } catch (Exception e) {
                                System.out.println("¡Intenta de nuevo! Debes ingresar un número entero.");
                            }
                        }

                        System.out.println(biblio.getUsuarioActual().quitaEnKit(kit, id));
                    }else{
                        System.out.println("No se han registrado datos");
                    }
                    
                    break;
                case 9:
                    System.out.println("**********Filtrar Curso**********");
                    System.out.println("Curso");
                    error = true;
                    while (error == true) {
                        curso = teclado.nextLine();
                        if (curso.isBlank()) {
                            System.out.println("¡Intenta de nuevo! El curso no puede estar vacío.");
                        } else {
                            error = false;
                        }
                    }

                    if (biblio.getUsuarioActual().filtrarCurso(curso).isEmpty()) {
                        System.out.println("No se encontraron conceptos de ese curso.");
                    } else {
                        System.out.println(biblio.getUsuarioActual().filtrarCurso(curso));
                    }
                    break;
                case 10:
                    System.out.println("**********Filtrar Categoría**********");
                    System.out.println("Categoria");
                    error = true;
                    while (error == true) {
                        categoria = teclado.nextLine();
                        if (categoria.isBlank()) {
                            System.out.println("¡Intenta de nuevo! La categoría no puede estar vacía.");
                        } else {
                            error = false;
                        }
                    }
            
                case 11:
                    System.out.println("**********Ir al último visitado**********");
                    System.out.println(biblio.getUsuarioActual().irUltimo());
                    break;
                
                case 12:
                    System.out.println("¡Adios! Gracias por usar BiblioMath");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;

            }

        }
    }

}


                    


                    
