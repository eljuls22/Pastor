/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.pastor.persistencia;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mx.itson.pastor.entidades.Cliente;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

/**
 *
 * @author AbelEsquer
 */
public class ClienteDAO {

    public static List<Cliente> obtenerTodos() {

        List<Cliente> clientes = new ArrayList<>();
        try {
            Connection connection = Conexion.obtener();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select id, nombre, direccion, telefono, email from cliente");

            while (resultSet.next()) {

                Cliente c = new Cliente();
                c.setId(resultSet.getInt(1));
                c.setNombre(resultSet.getString(2));
                c.setDireccion(resultSet.getString(3));
                c.setTelefono(resultSet.getString(4));
                c.setEmail(resultSet.getString(5));
                clientes.add(c);

            }

        } catch (Exception e) {
            System.err.println("Ocurrio un error: " + e.getMessage());
        }
        return clientes;
    }

    public static boolean guardar(String nombre, String direccion, String telefono, String email) {
        boolean resultado = false;

        try {

            Connection connection = Conexion.obtener();
            String consulta = "insert into cliente (nombre, direccion, telefono, email) values (?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(consulta);
            statement.setString(1, nombre);
            statement.setString(2, direccion);
            statement.setString(3, telefono);
            statement.setString(4, email);

            resultado = statement.getUpdateCount() == 1;

        } catch (Exception e) {
            System.err.println("Ocurrio un error " + e);

        }
        return resultado;
    }

    public static boolean verificarEmail(String nombre, String direccion, String telefono, String email) {
        boolean existencia = false;
        try {
            Connection connection = Conexion.obtener();
            String consulta = "SELECT* FROM cliente WHERE email = '" + email + "'";
            PreparedStatement statement = connection.prepareStatement(consulta);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            
            existencia = resultSet.next();
        } catch (Exception ex) {
            System.err.println("Ocurrió un error: " +ex.getMessage());
            return false;
        }
        return existencia;
    }

}
