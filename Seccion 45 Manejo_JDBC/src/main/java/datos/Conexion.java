package datos;

import java.sql.*;

//Clase de conexion para MySQL
public class Conexion {

    //URL de la conexion, usuario y contraseña.
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "admin";

    //A cada metodo creado tiene la firma de su excepcion para propagarla hasta la clase en la que se usa.
    //Metodo para conectar
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    //Metodos para cerrar ResultSet, Statement, PreparedStatement y la Connection.
    public static void close(ResultSet rst) throws SQLException {
        rst.close();
    }

    public static void close(Statement smtm) throws SQLException {
        smtm.cancel();
    }

    public static void close(PreparedStatement smtm) throws SQLException {
        smtm.close();
    }

    public static void close(Connection cnn) throws SQLException {
        cnn.close();
    }
}
