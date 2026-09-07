import java.util.Scanner;

public class Principal {

    public Principal() {
    }

    public static void main(String args) {
        Scanner teclado = new Scanner(System.in);

        Biblioteca biblio = new Biblioteca();

        System.out.println("********** BiblioMath **********");
//LONG IN/SING UP
        System.out.println("\n1. Lon in\n2. Sign up");
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

        String username, password;

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

        System.out.println("\n1. Ver Racha \n2.Agregar Concepto \n3. Buscar \n4. Ver Busquedas Populares ");
        System.out.println("¿Qué desea hacer? (Ingrese el número)");

        error = true;
        int accionB = 0;
         while (error){
                String entrada = teclado.nextLine();
                try{
                    accionB = Integer.parseInt(entrada);
                    if ((0 > accionB) & (accionB > 4)){
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
                System.out.println("********** Racha **********");

                break;
            case 2:
                System.out.println("********** Agregar Concepto **********");

                int id;
                String nombre, explicacion, categoria, curso;

                System.out.println("Nombre: ");
                nombre = teclado.nextLine();

                System.out.println("Explicación: ");
                explicacion = teclado.nextLine();

                System.out.println("Categoría: ");
                categoria = teclado.nextLine();

                System.out.println("Curso");
                curso = teclado.nextLine();


                break;
            case 3:
                System.out.println("********** Buscar **********");

                break;
            case 4:
                System.out.println("********** Busquedas Populares **********");

                break;
            default:
                System.out.println("Opción no válida.");
                break;

        }

    }

}