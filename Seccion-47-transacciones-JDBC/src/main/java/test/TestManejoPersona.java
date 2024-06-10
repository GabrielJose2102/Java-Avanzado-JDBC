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
            PersonaDAO personaTransacccion = new PersonaDAO(conexion);

            //Actualizacion de elementos.
            Persona cambioPersona = new Persona();
            cambioPersona.setIdPersona(6);
            cambioPersona.setNombre("Samhanta");
            cambioPersona.setApellido("Colmenarez");
            cambioPersona.setEmail("SamCol@gmail.com");
            cambioPersona.setTelefono("042651236456");
            personaTransacccion.actualizar(cambioPersona);

            Persona cambioPersona2 = new Persona();
            cambioPersona2.setIdPersona(7);
            cambioPersona2.setNombre("Karlos");
            cambioPersona2.setApellido("Perez");
            cambioPersona2.setEmail("Perez@gmail.com");
            cambioPersona2.setTelefono("04265423131");
            personaTransacccion.actualizar(cambioPersona2);

            //Insercion a la tabla uno con falla y el otro no para probar el rollback.
//            Persona nuevaPersona = new Persona("Karlos111111111111111111111111111111111111111111111", "Perez", "Perez11@gmail.com", "042651236456");
//            Persona nuevaPersona = new Persona("Karlos", "Perez", "Perez11@gmail.com", "042651236456");
//            personaTransacccion.insertar(nuevaPersona);
            //Ejecucion del commit luego de ejecutarse las instrucciones
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

            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }

            UsuarioDAO userName = new UsuarioDAO();

//            Usuario user = new Usuario();
//            user.setUsuario("Hola_Mundo");
//            user.setPassword("123456");
//            userName.insert(user);

            Usuario updateUser = new Usuario();
            updateUser.setIdUsuario(6);
            updateUser.setUsuario("MoureDev");
            updateUser.setPassword("654321");
            userName.update(updateUser);
            
//            Usuario deleteUser = new Usuario();
//            deleteUser.setIdUsuario(6);
//            userName.delete(updateUser);
            
            

            conexion.commit();
            System.out.println("Se ha efectuado un commit de la transaccion");

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Error en la base de datos entramos en rolback");

            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
                System.out.println("se efectuo un rolback");
            }
        }
    }
}
