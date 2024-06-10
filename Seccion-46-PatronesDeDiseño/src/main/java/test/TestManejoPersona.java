package test;

import datos.Conexion;
import datos.*;
import java.util.List;
import domain.*;
import java.sql.*;

public class TestManejoPersona {

    public static void main(String[] args) {

        //Conexion para la transaccion fuera del metodo
        Connection conexion = null;

        try {
            conexion = Conexion.getConnection();
//            comprobacion de autocommit
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }

            //Objeto que se comunica con la clase que tiene los metodos
            PersonaDao personaTransacccion = new PersonaDaoJDBC(conexion);

            List<PersonaDTO> personas = personaTransacccion.seleccionar();

            for (PersonaDTO persona : personas) {
                System.out.println("persona = " + persona);
            }

            conexion.commit();
            System.out.println("Se ha hecho commit de la transaccion... ");

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al Rollback");

            //Ejecucion del rolback si hay fallas en las ianmstrucciones
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }

        try {
            conexion = Conexion.getConnection();
//            comprobacion de autocommit
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }

            //Objeto que se comunica con la clase que tiene los metodos
            UsuarioDao personaTransacccion = new UsuarioDaoJDBC(conexion);

            List<UsuarioDTO> usuarios = personaTransacccion.seleccionar();

            for (UsuarioDTO usuario : usuarios) {
                System.out.println("usuario = " + usuario);
            }

            conexion.commit();
            System.out.println("Se ha hecho commit de la transaccion... ");

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al Rollback");

            //Ejecucion del rolback si hay fallas en las ianmstrucciones
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }

    }
}
