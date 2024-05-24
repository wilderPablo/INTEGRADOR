/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios.conexiones;

import java.sql.Statement;
import java.sql.Connection;
import servicios.conexiones.ConectaDB;
import java.sql.ResultSet;

/**
 *
 * @author user
 */
public class DaoUsuario extends ConectaDB{
    public usuario identificar(usuario user)throws Exception{
    usuario usu=null;
    ConectaDB con;
    Connection  cn=null;
        Statement st=null;
        ResultSet rs=null;
        String sql="SELECT U.IdCliente,C.NombreCargo FROM USUARIO U"+
                    "inner join cargo C on U.IDCargo=C.IDCargo"+
                    "Where U.estado =1 and U.NombreUsuario ="+""+user.getNombres()+ ""
                +"AND U.contraseña"+user.getContraseña();
    
    con = new ConectaDB();
    try{
    cn=con.getConexion();
    st=cn.createStatement();
    rs=st.executeQuery(sql);
    if(rs.next() == true){
    usu =new usuario();
    usu.setId(rs.getInt("IDUsuario"));
    usu.setNombres(user.getNombres());
    usu.setCargo(new cargo());
    usu.getCargo().setNombreCargo(rs.getString("NOMBRECARGO"));
    usu.setEstado(true);
    }
    }catch(Exception e) {
    System.out.println("Error"+e.getMessage());
    }finally{
     if(rs!=null && rs.isClosed()==false){
     rs.close();
     }
     rs=null;
     if(st!=null && st.isClosed()==false){
     st.close();
     }
     st=null;
     if(cn!=null && cn.isClosed()==false){
     cn.close();
     }
     cn=null;
    }
    return usu;
    }
   
}
