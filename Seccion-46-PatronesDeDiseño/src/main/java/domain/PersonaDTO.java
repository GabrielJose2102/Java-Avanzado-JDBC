package domain;

//Clase representativa de la tabla de la base de datos con la que se ejecutaran las instrucciones.
public class PersonaDTO {

    //Variables de cada uno de los elementos de la tabla
    private int idPersona;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;

    //Constructor vacio
    public PersonaDTO() {
    }

    //Constructor solo con el id para eliminar posiciones completas
    public PersonaDTO(int idPersona) {
        this.idPersona = idPersona;
    }

    //Constructor para insertar registros sin id porque se inicializa por su cuenta
    public PersonaDTO(String nombre, String apellido, String email, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
    }

    //Constructor para Modificar registros con todos los elementos 
    public PersonaDTO(int idPersona, String nombre, String apellido, String email, String telefono) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
    }

    //Metodos setter y getter de cada uno por si se necesita usa individualmente alguno.
    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", telefono=" + telefono + '}';
    }

}
