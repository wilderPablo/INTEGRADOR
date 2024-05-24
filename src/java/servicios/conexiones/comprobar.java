/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package servicios.conexiones;

import java.sql.SQLException;

/**
 *
 * @author user
 */
public class comprobar {

    public static void main(String[] args) throws SQLException {
      ConectaDB c= new ConectaDB(); 
      if(c.getConexion()!=null){
          System.out.println("conexion es correcta");
      }else{
          System.out.println("conexion es eronea");
      }
        
        
    }
    
}
