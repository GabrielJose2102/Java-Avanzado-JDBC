package test;

import datos.UsuarioDAO;
import domain.Usuario;
import java.util.List;

public class TestLaboratorio {

    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();

//    Usuario usuarioNuevo = new Usuario("Gabriel2021", "210208");
//    usuarioDAO.insert(usuarioNuevo);


//        Usuario usuarioActualizar = new Usuario(2, "Juan", "HolaMundo");
//        usuarioDAO.update(usuarioActualizar);


        Usuario usuarioEliminar = new Usuario(2);
        usuarioDAO.delete(usuarioEliminar);
        
        

        List<Usuario> usuarios = usuarioDAO.select();
        usuarios.forEach(usuario -> {
            System.out.println("usuario = " + usuario);
        });

    }

}
