/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.egcc.domain;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Alumno
 */
public class Prueba03 {
    public static void main(String[] args) {
        Connection cn = null;
        try {
            //Leer el usuario
            String usuario;
            usuario = JOptionPane.showInputDialog("Ingrese usuario");
            //Proceso
            cn = AccesoDB.getConnection();
            String sql = "Select * from empleado "
                    + "where VCH_EMPLUSUARIO = ? "; //la ? es un paràmetro
            System.err.println("SQL: " + sql);
            //cambiamos el Statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, usuario); //se compila en el servidor
            ResultSet rs = pstm.executeQuery(); //cambio pstm
            while(rs.next()) {
                String texto = rs.getString("CHR_EMPLCODIGO") +
                        " | " + rs.getString("VCH_EMPLPATERNO") +
                        " | " + rs.getString("VCH_EMPLMATERNO");
                System.out.println(texto);
            }
            rs.close();
            pstm.close(); //close el pstm
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
