/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package liberedujdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author USER
 */
public class OperacionesCRUD {
    public void insertarDatos(String Nombres, String Apellidos, String Email, String Telefono){
        try (Connection conexion = ConnexionDB.obtenerConexion();
                 PreparedStatement statement = conexion.prepareStatement("INSERT INTO RECTOR(Nombres, Apellidos, Email, Telefono) VALUES (?, ?, ?, ?)");){
                 statement.setString(1, Nombres);   
                 statement.setString(2, Apellidos);          
                 statement.setString(3, Email);       
                 statement.setString(4, Telefono);

                 statement.executeUpdate();
                 System.out.println("Los datos se insertaron correctamente.");
        } catch (SQLException ex) {
           System.out.print("Error al insertar datos" + ex.getMessage());
        }
    }
    
    public void consultarDatos(){
        try(Connection conexion = ConnexionDB.obtenerConexion();
                Statement statement = conexion.createStatement();
                ResultSet resulSet = statement.executeQuery("SELECT * FROM Rector")) {
            while(resulSet.next()){
                int Id = resulSet.getInt("id");          
                String Nombres = resulSet.getString("Nombres");
                String Apellidos = resulSet.getString("Apellidos");
                String Email = resulSet.getString("Email");
                String Telefono = resulSet.getString("Telefono");
                
                String mensaje = String.format("Usuario: %d,  Nombres: %s, Apellidos: %s, Correo: %s, Teléfono: %s", Id, Nombres, Apellidos, Email, Telefono);
                System.out.println(mensaje);
            }
        } catch (SQLException ex) {
            System.out.print("Error al listar los usuarios" + ex.getMessage());
        }
    }
    
    
    public void actulizarDatos(int Id,String Nombres, String Apellidos, String Email, String Telefono){
        try(Connection conexion = ConnexionDB.obtenerConexion();
                PreparedStatement statement = conexion.prepareStatement("UPDATE RECTOR SET Nombres = ?,Apellidos = ?,Email = ?,Telefono = ?WHERE Id = ?")) {
                 statement.setString(1, Nombres);   
                 statement.setString(2, Apellidos);          
                 statement.setString(3, Email);       
                 statement.setString(4, Telefono);
                 statement.setInt(5, Id);
                 
                 
                 statement.executeUpdate();
                 System.out.println("El usuario se a actualizado correctamente.");
                 
        } catch (SQLException ex) {
            System.out.print("Error al actualizar el usuario" + ex.getMessage());
        }
    }
    
    public void eliminarDatos(int Id){
        try(Connection conexion = ConnexionDB.obtenerConexion();
                PreparedStatement statement = conexion.prepareStatement("DELETE FROM Rector WHERE Id = ?")) {
            statement.setInt(1, Id);
            statement.executeUpdate();
            System.out.println("Usuario eliminado correctamente.");
            
            
        } catch (SQLException ex) {
            System.out.print("Error al eliminar el usuario.");
        }
    }
}
