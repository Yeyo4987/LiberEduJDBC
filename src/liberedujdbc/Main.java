/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package liberedujdbc;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OperacionesCRUD operaciones = new OperacionesCRUD();
        while (true) {
            System.out.println("Selecciona una opción: ");   
            System.out.println("1.  Insertar usuario");
            System.out.println("2.  Consultar usuarios");
            System.out.println("3.  Actualizar usuario");
            System.out.println("4.  Eliminar usuario");
            System.out.println("0.  Salir");
            
           
            int option = scanner.nextInt();
            scanner.nextLine();
            
            switch (option) {
                case 1 -> {
                    System.out.println("Nombres del usuario: ");
                    String Nombre = scanner.nextLine();
                    System.out.println("Apellidos del usuario: ");
                    String Apellidos = scanner.nextLine();
                    System.out.println("Email del usuario: ");
                    String Email = scanner.nextLine();
                    System.out.println("Telefono del usuario: ");
                    String Telefono = scanner.nextLine();
                    
                    operaciones.insertarDatos(Nombre, Apellidos, Email, Telefono);
                }
                    
                case 2 -> {
                    System.out.println("Lista de usuarios");
                    operaciones.consultarDatos();
                }
                
                case 3 -> {
                    System.out.println("Ingrese el Id del usuario a actualizar");
                    int idActualizar = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Nuevos nombres: ");
                    String Nombre = scanner.nextLine();
                    System.out.println("Nuevos apellidos: ");
                    String Apellidos = scanner.nextLine();
                    System.out.println("Nuevo email: ");
                    String Email = scanner.nextLine();
                    System.out.println("Nuevo telefono: ");
                    String Telefono = scanner.nextLine();
                    
                    operaciones.actulizarDatos(idActualizar,Nombre, Apellidos, Email, Telefono);
                    
                }
                
                case 4 -> {
                    System.out.println("Ingrese el id del usuario a eliminar");
                    int idEliminar = scanner.nextInt();
                    operaciones.eliminarDatos(idEliminar);
                }
                    
                case 0 -> {
                    System.out.println("Saliendo...");
                    System.exit(0);
                }
                default -> System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }
}    
