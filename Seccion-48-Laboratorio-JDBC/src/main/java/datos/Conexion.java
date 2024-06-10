package datos;

import java.sql.*;

public class Conexion {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "admin";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    public static void closeRS(ResultSet rs) throws SQLException {
        rs.close();
    }

    public static void closeST(Statement stmt) throws SQLException {
        stmt.close();
    }

    public static void closePST(PreparedStatement Pstmt) throws SQLException {
        Pstmt.close();
    }

    public static void closeCNT(Connection cnt) throws SQLException {
        cnt.close();
    }
}
