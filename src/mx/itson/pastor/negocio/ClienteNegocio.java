/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.pastor.negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import mx.itson.pastor.persistencia.ClienteDAO;
import mx.itson.pastor.persistencia.Conexion;
import java.sql.ResultSet;

/**
 *
 * @author julio
 */
public class ClienteNegocio {
    
    public static boolean guardar(String nombre, String direccion, String telefono, String email){
        boolean resultado = false;
        try{
            resultado = ClienteDAO.guardar(nombre, direccion, telefono, email);
        }catch(Exception ex){
            System.err.println(ex.getMessage());
        }
        return resultado;
    }
    
    public static boolean verificarEmail(String nombre, String direccion, String telefono, String email){
        boolean resultado = false;
    try {
            Connection connection = Conexion.obtener();
            String consulta = "SELECT* FROM cliente WHERE email = '" + email + "'";
            System.out.println(consulta);
            PreparedStatement statement = connection.prepareStatement(consulta);
            ResultSet r = statement.executeQuery();
            
            if (r.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return false;
        } 

  
}
    
}
