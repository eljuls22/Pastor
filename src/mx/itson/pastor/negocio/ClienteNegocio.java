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
          if(!ClienteDAO.verificarEmail(nombre, direccion, telefono, email)){
            resultado = ClienteDAO.guardar(nombre, direccion, telefono, email);
              System.out.println("1");
          }
        }catch(Exception ex){
            System.err.println(ex.getMessage());
        }
        return resultado;
    }
    
        
    
}
