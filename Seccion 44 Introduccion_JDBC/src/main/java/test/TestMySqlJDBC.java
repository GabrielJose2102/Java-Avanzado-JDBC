package test;

import java.sql.*;

public class TestMySqlJDBC {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        try {
            //Usamos este codigo para conectar base de datos cuando es una aplicacion web
            //Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Como es una conexion local usamos este codigo sin problemas
            //Connection para ejecutar el metodo de conexion a la base de datos
            Connection conexion = DriverManager.getConnection(url, "root", "1234");
            /*Statement es un tipo interface que nos permite ejecutar sentencias sobre las tablas de la base de datos y
              createStatement() es la implementcion del metodo de esa interface*/
            Statement instruccion = conexion.createStatement();
            //Codigo de Sentencia SQL
            String sql = "SELECT id_persona, nombre, apellido, email, telefono FROM persona";
            
            //Interface ResultSet para que con la implementacion de metodod executeQuery(sql) ejecutamos la sentencia
            ResultSet resultado = instruccion.executeQuery(sql);
            //Ciclo para imprimir el contenido de la tabla el next() es para pasar al siguiente hasta que ya no halla nada en la tabla
            while (resultado.next()) {
                //Traemos los desde la tabla segun su tipo de dato el metodo a utilizar
                System.out.print("id_persona: " + resultado.getInt("id_persona"));
                System.out.print(" nombre: " + resultado.getString("nombre"));
                System.out.print(" apellido: " + resultado.getString("apellido"));
                System.out.print(" email: " + resultado.getString("email"));
                System.out.print("telefono: " + resultado.getString("telefono"));
                System.out.println("");
            }
                //Cerramos los 3 metodos en orden inverso de como se abrieron
                resultado.close();
                instruccion.close();
                conexion.close();
          
        //Excepcion        
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            
        }
    }
}
