import java.util.Scanner;

public class Principal {

    public Principal() {
    }

    public static void main(String args) {
        Scanner teclado = new Scanner(System.in);

        Biblioteca biblio = new Biblioteca();

        System.out.println("********** BiblioMath **********");
//LONG IN/SING UP
        System.out.println("\n1. Log in\n2. Sign up");
        System.out.println("\n********* ¿Qué desea hacer? (Ingrese el número) **********");
        
        boolean error = true;
        int accion = 0;
        while (error == true){
                try{
                    accion = teclado.nextInt();
                    teclado.nextLine();
                    error = false;

                    if (accion > 2 || accion < 1) {
                        System.out.println("\n¡Intente de nuevo! Ingresa una opción válida: ");
                        error = true;
                    }

                }catch(Exception e){
                    System.out.println("\n¡Intente de nuevo! Ingresa una opción válida: ");
                    teclado.nextLine();
                    error = true;
                     
                }
            }

        String username = "";
        String password="";

        switch (accion){
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
        
        System.out.println("********** Menú **********");

        System.out.println("1.Agregar Concepto \n2. Mostrar Conceptos\n3. Buscar Concepto\n4. Agregar Kit\n5. Mostrar Kits\n6. Buscar Kit\n7. Agregar Concepto a Kit\n8. Quitar Concepto en Kit\n9. Filtrar Curso\n10. Filtrar Categoria\n11. Último visitado");
        System.out.println("¿Qué desea hacer? (Ingrese el número)");

        error = true;
        int accionB = 0;
         while (error){
                String entrada = teclado.nextLine();
                try{
                    accionB = Integer.parseInt(entrada);
                    if ((0 > accionB) & (accionB > 10)){
                        error = false;
                    }
                    else{
                        System.out.println("\n¡Intente de nuevo! Ingresa una opción válida: ");
                    }
                }catch(Exception e){
                    System.out.println("\n¡Intente de nuevo! Ingresa una opción válida: ");
                }
        }

        switch (accionB){
            case 1:
                System.out.println("********** Agregar Concepto **********");

                int id;
                String nombre, explicacion, categoria, curso, kits;

                System.out.println("ID: ");
                id = teclado.nextInt(); teclado.nextLine();

                System.out.println("Nombre: ");
                nombre = teclado.nextLine();

                System.out.println("Explicación: ");
                explicacion = teclado.nextLine();

                System.out.println("Categoría: ");
                categoria = teclado.nextLine();

                System.out.println("Curso");
                curso = teclado.nextLine();

                System.out.println("Kits (Codigo de kits separados por Coma)");
                kits = teclado.nextLine();

                biblio.getUsuarioActual().nuevoConcepto(id, nombre, explicacion, categoria, curso, kits);

                break;
            case 2:
                System.out.println("********** Mostrar Conceptos **********");
                System.out.println(biblio.getUsuarioActual().motrarConceptos());
                break;
            case 3:
                System.out.println("********** Buscar Concepto **********");
                System.out.println("Nombre: ");
                String nom = teclado.nextLine();
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
            case 6:
                System.out.println("********** Buscar Kit**********");
                System.out.println("Nombre: ");
                nombre = teclado.nextLine();
                System.out.println(biblio.getUsuarioActual().buscarKits(nombre));
                break;
            case 7:
                System.out.println("********** Agregar Concepto a Kit**********");
                System.out.println("Nombre Kit: ");
                String kit = teclado.nextLine();
                System.out.println("Nombre Concepto: ");
                String concepto = teclado.nextLine();
                biblio.getUsuarioActual().agregarCaKit(kit, concepto);
                break;
            case 8:
                System.out.println("********** Quitar Concepto en Kit**********");
                System.out.println("Nombre Kit: ");
                kit = teclado.nextLine();
                System.out.println("ID Concepto: ");
                id = teclado.nextInt(); teclado.nextLine();
                biblio.getUsuarioActual().quitaEnKit(kit, id);
                break;
            case 9:
                System.out.println("**********Filtrar Curso**********");
                System.out.println("Curso");
                curso = teclado.nextLine();
                System.out.println(biblio.getUsuarioActual().filtrarCurso(curso));
                break;
            case 10:
                System.out.println("**********Filtrar Categoría**********");
                System.out.println("Categoria");
                categoria = teclado.nextLine();
                System.out.println(biblio.getUsuarioActual().filtrarCategoria(categoria));
                break;
            case 11:
                System.out.println("**********Ir al último visitado**********");
                System.out.println(biblio.getUsuarioActual().irUltimo());
                break;
            default:
                System.out.println("Opción no válida.");
                break;

        }

    }

}