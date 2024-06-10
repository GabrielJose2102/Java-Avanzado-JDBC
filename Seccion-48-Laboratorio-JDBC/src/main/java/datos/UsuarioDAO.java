package datos;

import domain.Usuario;
import java.sql.*;
import static datos.Conexion.*;
import java.util.*;

public class UsuarioDAO {

    private static final String INSERTAR = "INSERT INTO usuario(usuario, password) VALUES(?, ?)";
    private static final String SELECT = "SELECT id_usuario, usuario, password FROM usuario ";
    private static final String UPDATE = "UPDATE usuario SET usuario = ?, password = ? WHERE id_usuario = ?";
    private static final String DELETE = "DELETE FROM usuario WHERE id_usuario = ?"; 

    public void insert(Usuario usuario) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(INSERTAR);
            pstmt.setString(1, usuario.getUsuario());
            pstmt.setString(2, usuario.getPassword());
            pstmt.executeUpdate();
            System.out.println("Registro exitoso...");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                closePST(pstmt);
                closeCNT(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }

    public List<Usuario> select() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Usuario usuario = null;
        List<Usuario> usuarios = new ArrayList<>();

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(SELECT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int idUsuario = rs.getInt("id_usuario");
                String nombreUsuario = rs.getString("usuario");
                String password = rs.getString("password");

                usuario = new Usuario(idUsuario, nombreUsuario, password);
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                closeRS(rs);
                closePST(pstmt);
                closeCNT(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return usuarios;
    }

    public void update(Usuario usuario) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setString(1, usuario.getUsuario());
            pstmt.setString(2, usuario.getPassword());
            pstmt.setInt(3, usuario.getIdusuario());
            pstmt.executeUpdate();
            System.out.println("Actualizacion exitosa...");

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                closePST(pstmt);
                closeCNT(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }

    
    public void delete(Usuario usuario) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(DELETE);
            pstmt.setInt(1, usuario.getIdusuario());
            pstmt.executeUpdate();
            System.out.println("Registro elimenado...");

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                closePST(pstmt);
                closeCNT(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }
}
