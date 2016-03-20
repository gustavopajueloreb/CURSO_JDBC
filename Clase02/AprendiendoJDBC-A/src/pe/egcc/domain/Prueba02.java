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
public class Prueba02 {
    public static void main(String[] args) {
        Connection cn = null;
        try {
            //Leer el usuario
            String usuario;
            usuario = JOptionPane.showInputDialog("Ingrese usuario");
            //Proceso
            cn = AccesoDB.getConnection();
            String sql = "Select * from empleado "
                    + "where VCH_EMPLUSUARIO = '" + usuario + "'"; //aqui esta el error en statement "usuario"
            System.err.println("SQL: " + sql);
            Statement stm = cn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()) {
                String texto = rs.getString("CHR_EMPLCODIGO") +
                        " | " + rs.getString("VCH_EMPLPATERNO") +
                        " | " + rs.getString("VCH_EMPLMATERNO");
                System.out.println(texto);
            }
            rs.close();
            stm.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
