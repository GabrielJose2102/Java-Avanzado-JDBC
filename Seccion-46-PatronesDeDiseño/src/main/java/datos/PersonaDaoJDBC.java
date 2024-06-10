package datos;

import static datos.Conexion.*;
import domain.PersonaDTO;
import java.sql.*;
import java.util.*;

//Clase con instruccion select para la base de datos
public class PersonaDaoJDBC implements PersonaDao{

    //Creacion de variable para hacer la conexion fuera de los metodos.
    private Connection conexionTransaccional;

    //Constructor vacio
    public PersonaDaoJDBC() {
    }

    //Constructor para inicializar la variable
    public PersonaDaoJDBC(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }

    //variable con el codigo de la instruccion para SQL.
    private static final String SQL_SELECT = "SELECT id_persona, nombre, apellido, email, telefono FROM persona";
    private static final String SQL_INSERT = "INSERT INTO persona(nombre, apellido, email, telefono) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE persona SET nombre = ?, apellido = ?, email = ?, telefono = ? WHERE id_persona = ?";
    private static final String SQL_DELETE = "DELETE FROM persona WHERE id_persona = ?";

    //Metodo para seleccionar de tipo lista retornara una lista.
    @Override
    public List<PersonaDTO> seleccionar() throws SQLException {
        //Objetos de tipo Connection, PreparedStatement, ResultSet, PersonaDTO para instanciar con los metodos de la clase Conexion.
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        PersonaDTO persona = null;

        //Inicializacion de la lista con la clase PersonaDTO y de tipo ArrayList
        List<PersonaDTO> personas = new ArrayList<>();

        try {
            //Conexion, instrucciones y consulta a la base de datos.
            //Pero se hace de forma condicional para saber de donde proviene la conexion.
            //si es de fuera y dentro del metodo para saber si se debe cerrar al finalizar la ejecucion del metodo o seguir hasta hacer commit.
            //Esta accion se realizo en cada metodo.
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            //Ciclo para seleccionar los elementos de la base de datos (Todos hasta que sea null)
            while (rs.next()) {

                //Variables de tipo local donde se guardaran los elementos que vienen  de la base de datos
                int idPersona = rs.getInt("id_persona");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");

                //Uso del constructor de la clase persona se uso el que tiene todos los argumentos para seleccionar todos.
                persona = new PersonaDTO(idPersona, nombre, apellido, email, telefono);

                //Aqui se añade los elementos a la lista.
                personas.add(persona);
            }

        } finally {
            try {
                //Cierre de la consulta, instruccion y la conexion a la base de datos.
                close(rs);
                close(stmt);
                if (this.conexionTransaccional == null) {
                    close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        //Retorno de la lista con los elementos en ellas. 
        return personas;
    }

    @Override
    public int insertar(PersonaDTO persona) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registro = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setString(3, persona.getEmail());
            stmt.setString(4, persona.getTelefono());
            registro = stmt.executeUpdate();

        } finally {
            try {
                close(stmt);
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
    public int actualizar(PersonaDTO persona) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registroActualizado = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setString(3, persona.getEmail());
            stmt.setString(4, persona.getTelefono());
            stmt.setInt(5, persona.getIdPersona());
            registroActualizado = stmt.executeUpdate();

        } finally {
            try {
                close(stmt);
                if (this.conexionTransaccional == null) {
                    close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }
        return registroActualizado;
    }

    @Override
    public int eliminar(PersonaDTO persona) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registroEliminados = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, persona.getIdPersona());
            registroEliminados = stmt.executeUpdate();

        } finally {
            try {
                close(stmt);
                if (this.conexionTransaccional == null) {
                    close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }
        return registroEliminados;
    }
}
