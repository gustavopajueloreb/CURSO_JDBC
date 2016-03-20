/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.egcc.domain;

import java.sql.Connection;

/**
 *
 * @author Alumno
 */
public class Prueba01 {
    public static void main(String[] args) {
        try {
            Connection cn = AccesoDB.getConnection();
            System.out.println("Conecciòn iniciada");
            cn.close();
        } catch (Exception e) {
            System.err.println("No se estableció la conexión");
        }
    }
}
