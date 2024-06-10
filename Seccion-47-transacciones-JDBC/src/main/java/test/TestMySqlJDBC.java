package test;

import java.sql.*;

public class TestMySqlJDBC {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        try {
            //Usamos este codigo para conectar base de datos cuando es una aplicacion web
            //Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Como es una conexion local usamos este codigo sin problemas
            Connection conexion = DriverManager.getConnection(url, "root", "admin");
            Statement instruccion = conexion.createStatement();
            String sql = "SELECT id_persona, nombre, apellido, email, telefono FROM persona";
            ResultSet resultado = instruccion.executeQuery(sql);
            while (resultado.next()) {                
                System.out.print("id_persona: " + resultado.getInt("id_persona"));
                System.out.print(" nombre: " + resultado.getString("nombre"));
                System.out.print(" apellido: " + resultado.getString("apellido"));
                System.out.print(" email: " + resultado.getString("email"));
                System.out.print("telefono: " + resultado.getString("telefono"));
                System.out.println("");
            }
                resultado.close();
                instruccion.close();
                conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            
        }
    }
}
