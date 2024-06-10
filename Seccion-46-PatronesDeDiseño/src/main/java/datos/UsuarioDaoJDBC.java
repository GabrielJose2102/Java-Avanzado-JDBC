package datos;

import domain.UsuarioDTO;
import java.sql.*;
import static datos.Conexion.*;
import java.util.*;

public class UsuarioDaoJDBC implements UsuarioDao {

    private Connection conexionTransaccional;

    public UsuarioDaoJDBC() {
    }

    public UsuarioDaoJDBC(Connection conexion) {
        this.conexionTransaccional = conexion;
    }

    private static final String INSERTAR = "INSERT INTO usuario(usuario, password) VALUES(?, ?)";
    private static final String SELECT = "SELECT id_usuario, usuario, password FROM usuario ";
    private static final String UPDATE = "UPDATE usuario SET usuario = ?, password = ? WHERE id_usuario = ?";
    private static final String DELETE = "DELETE FROM usuario WHERE id_usuario = ?";

    @Override
    public int insertar(UsuarioDTO usuario) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int registro = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
            pstmt = conn.prepareStatement(INSERTAR);
            pstmt.setString(1, usuario.getUsuario());
            pstmt.setString(2, usuario.getPassword());
            registro = pstmt.executeUpdate();
            System.out.println("Registro exitoso...");

        } finally {
            try {
                close(pstmt);
                if (this.conexionTransaccional == null) {
                    close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registro;
    }

    @Override
    public List<UsuarioDTO> seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        UsuarioDTO usuario = null;
        List<UsuarioDTO> usuarios = new ArrayList<>();

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
            pstmt = conn.prepareStatement(SELECT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int idUsuario = rs.getInt("id_usuario");
                String nombreUsuario = rs.getString("usuario");
                String password = rs.getString("password");

                usuario = new UsuarioDTO(idUsuario, nombreUsuario, password);
                usuarios.add(usuario);
            }

        } finally {
            try {
                close(rs);
                close(pstmt);
                if (this.conexionTransaccional == null) {
                    close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return usuarios;
    }

    @Override
    public int actualizar(UsuarioDTO usuario) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int actualizado = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setString(1, usuario.getUsuario());
            pstmt.setString(2, usuario.getPassword());
            pstmt.setInt(3, usuario.getIdusuario());
            actualizado = pstmt.executeUpdate();
            System.out.println("Actualizacion exitosa...");

        } finally {
            try {
                close(pstmt);
                if (this.conexionTransaccional == null) {
                    close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return actualizado;
    }

    @Override
    public int eliminar(UsuarioDTO usuario) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int eliminado = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
            pstmt = conn.prepareStatement(DELETE);
            pstmt.setInt(1, usuario.getIdusuario());
            eliminado = pstmt.executeUpdate();
            System.out.println("Registro elimenado...");

        } finally {
            try {
                close(pstmt);
                if (this.conexionTransaccional == null) {
                    close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return eliminado;
    }
}
