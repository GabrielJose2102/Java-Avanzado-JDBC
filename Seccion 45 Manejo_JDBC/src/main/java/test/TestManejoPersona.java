package test;

import datos.PersonaDAO;
import java.util.List;
import domain.Persona;

public class TestManejoPersona {

    public static void main(String[] args) {
        //creamos el objeto donde esta el metodo seleccionar
        PersonaDAO personaDao = new PersonaDAO();

        //Insertar
        //Creamos objeto que contiene los elementos a guardar en la bas de datos.
//        Persona personaNuevo = new Persona("Alvaro", "Gomez", "GomezA@mail.com", "04145624563");
//        
//        personaDao.insertar(personaNuevo);
//        System.out.println("personaNuevo = " + personaNuevo);


        //Actualizar
//       Persona personaActualizar = new Persona(6, "Samanta", "Torrealba", "SamTorrealba@gmail.com", "0425612534");
//       personaDao.actualizar(personaActualizar);
//        System.out.println("personaActualizar = " + personaActualizar);
       

        //Borrar 
            Persona personaEliminar = new Persona(5);
            personaDao.eliminar(personaEliminar);
            
            
        
        //Seleccionar para Mostrar
        //creamos una lista de tipo Persona para agregar lo que proviene del metodo seleccionar
        List<Persona> personas = personaDao.seleccionar();

        //Con un forEach imprimimos en pantalla el contenido, aqui estan las dos versiones del forEach
        //forEach normal
//        for(Persona persona: personas){
//            System.out.println("Persona: " + persona);    
//        }
        //Funcion landa
        personas.forEach(persona -> {
            System.out.println("Persona: " + persona);
        });
    }
}
