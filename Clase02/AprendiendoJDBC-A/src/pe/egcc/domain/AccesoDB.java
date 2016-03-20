/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.egcc.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Alumno
 */
public class AccesoDB {

    private AccesoDB() {
        
    } 
            
    public static Connection getConnection() throws SQLException {
        Connection on = null;
        try {
            //paràmetros
            String driver = "oracle.jdbc.OracleDriver";
            String urlDB = "jdbc:oracle:thin:@localhost:1521/XE.uni.org";
            String user = "eureka";
            String pass = "admin";
            //cargar el driver
            Class.forName(driver).newInstance();
            //establecer la conexiòn
            on = DriverManager.getConnection(urlDB, user, pass);
        } catch (SQLException e) {
            throw e;
        } catch (ClassNotFoundException e){
            throw new SQLException("No se ha encontrado el driver");
        } catch (Exception e) {
            String msg = "Error, no se puede estabvlecer la conexion";
            if(e.getMessage() != null && !e.getMessage().isEmpty()) {
                msg += " " + e.getMessage();
            }
            throw new SQLException(msg);
        }
        return on;
    }
    
}
