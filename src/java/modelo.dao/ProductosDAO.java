/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.dto.*;
import servicios.ConexionDB;

/**
 *
 * @author ander
 */
public class ProductosDAO {
    Connection conexion;
    ConexionDB cdb = new ConexionDB();
    PreparedStatement ps;
    ResultSet rs;

    public List listarPLM() {
        List<PlacasMadreDTO> plm = new ArrayList<>();
        String SQL = "SELECT * FROM placamadre";

        try {
            conexion = cdb.obtenerConexion();
            ps = conexion.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                PlacasMadreDTO ai = new PlacasMadreDTO();
                ai.setIdProducto(rs.getInt(1));
                ai.setMarca(rs.getString(2));
                ai.setChipset(rs.getString(3));
                ai.setSocket(rs.getString(4));
                ai.setProcesadoresCompatibles(rs.getString(5));
                ai.setTipoDeMemoria(rs.getString(6));
                ai.setRanurasDeMemoriaRAM(rs.getInt(7));
                ai.setNombre(rs.getString(8));
                ai.setPrecio(rs.getDouble(9));
                ai.setImagen(rs.getString(10));
                plm.add(ai);
            }
        } catch (SQLException e) {
        }
        return plm;
    }
}
