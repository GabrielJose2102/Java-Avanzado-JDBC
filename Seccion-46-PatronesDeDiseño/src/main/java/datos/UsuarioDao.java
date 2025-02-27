package datos;

import domain.UsuarioDTO;
import java.sql.SQLException;
import java.util.List;

public interface UsuarioDao {

    public List<UsuarioDTO> seleccionar() throws SQLException;

    public int insertar(UsuarioDTO persona) throws SQLException;

    public int actualizar(UsuarioDTO persona) throws SQLException;

    public int eliminar(UsuarioDTO persona) throws SQLException;
}
