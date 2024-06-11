
# Java Avanzado III

Se proporciona una introducción al JDBC, que es una API estándar de Java para interactuar con bases de datos. Se exploran los conceptos básicos de JDBC, como las clases y interfaces principales, la conexión a la base de datos y la ejecución de consultas SQL. Los estudiantes aprenderán cómo establecer una conexión con una base de datos y cómo ejecutar consultas para obtener y manipular datos.

El curso se enfoca en el manejo avanzado de JDBC. Se cubren temas como la creación de consultas preparadas para mejorar el rendimiento y prevenir ataques de inyección SQL. También se explora el uso de metadatos para obtener información sobre la base de datos y se enseña cómo administrar las excepciones que pueden ocurrir durante la interacción con la base de datos.

Se centra en los patrones de diseño utilizados en el desarrollo de aplicaciones JDBC. Se presentan patrones comunes, como Singleton, DAO (Data Access Object) y Factory. Estos patrones ayudan a organizar y estructurar el código de manera eficiente y modular, facilitando la interacción con la base de datos y mejorando la mantenibilidad del código.

Se explora el concepto de transacciones en JDBC. Los estudiantes aprenderán cómo realizar transacciones para garantizar la integridad y consistencia de los datos en la base de datos. Se discute el uso de puntos de guardado (Savepoints) y se aborda el manejo de transacciones distribuidas, lo que permite trabajar con múltiples bases de datos y garantizar la coherencia en las operaciones realizadas.

En resumen, este curso de Java abarca desde la introducción a JDBC hasta el manejo avanzado de esta tecnología, incluyendo el uso de patrones de diseño y transacciones. Los estudiantes aprenderán a interactuar con bases de datos, realizar consultas, mejorar el rendimiento, utilizar patrones de diseño para una arquitectura más robusta y aplicar transacciones para garantizar la integridad de los datos. Este conocimiento es fundamental para desarrolladores que trabajan con aplicaciones que requieren acceso a bases de datos y deseen utilizar las mejores prácticas en el manejo de la interacción con ellas.

## Contenido

- Sección 44 Introducción JDBC.

- Sección 45 Manejo JDBC.

- Sección 46 Patrones de diseño.

- Sección 47 Transacciones JDBC.

- Sección 48 Loboratorio Final.


## Instalacion y Ejecucion

- Instala el JDK (Java Development Kit): Descarga e instala la versión adecuada del JDK para tu sistema operativo desde el sitio web oficial de Oracle o de OpenJDK.

 [Descargar JDK 15](https://www.oracle.com/java/technologies/javase/javase8-archive-downloads.html)

- Configura las variables de entorno: Añade la variable de entorno JAVA_HOME que apunte al directorio de instalación del JDK. Añade también la variable de entorno PATH para incluir la ruta al directorio bin del JDK.

- Instala un IDE (Entorno de Desarrollo Integrado): Elige un IDE Java, como Eclipse, IntelliJ IDEA o NetBeans, e instálalo en tu sistema. Estos IDEs proporcionan herramientas y características adicionales para facilitar el desarrollo en Java.

- Configura el IDE: Abre tu IDE y configura la ubicación del JDK. En la configuración, selecciona el directorio de instalación del JDK que has establecido en la variable JAVA_HOME.


 [Descargar NetBeans 12](https://netbeans.apache.org/front/main/index.html)

- Crea un proyecto: Crea un nuevo proyecto en tu IDE o importa uno existente. Configura la configuración del proyecto, como el tipo de proyecto (aplicación de consola, aplicación web, etc.) y las dependencias necesarias.
- Escribe y ejecuta código: Escribe tu código fuente Java en los archivos del proyecto. Utiliza las herramientas y características del IDE para compilar y ejecutar tu código.
- Depuración y pruebas: Utiliza las capacidades de depuración del IDE para identificar y solucionar problemas en tu código. Ejecuta pruebas unitarias para verificar la funcionalidad de tu programa.


[Mysql Conector]()

- Abre el archivo pom.xml de tu proyecto Maven. Este archivo se encuentra en la raíz del proyecto y contiene la configuración y las dependencias del proyecto.

- Agrega la dependencia de MySQL en la sección <dependencies> del archivo pom.xml. Asegúrate de incluir la información correcta de la versión de MySQL que deseas utilizar. Aquí tienes un ejemplo de cómo se vería la dependencia:

```java
<dependencies>
    <!-- Otras dependencias del proyecto -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.26</version>
    </dependency>
</dependencies>

```

- Guarda el archivo pom.xml.

- Maven descargará automáticamente la librería de MySQL y la agregará al proyecto. Puedes verificar que la dependencia se haya descargado correctamente buscando la carpeta .m2/repository en tu directorio de usuario. Dentro de la carpeta, deberías encontrar la estructura de carpetas correspondiente a la dependencia de MySQL.

- Ahora puedes utilizar la librería de MySQL en tu proyecto. Asegúrate de importar las clases necesarias en tus archivos Java para poder utilizar las funcionalidades de la librería.
## Resumen y Analisis

**Sección 44:** Introducción JDBC
En esta sección se introduce JDBC (Java Database Connectivity), que es una API estándar de Java para interactuar con bases de datos. Se explican los conceptos básicos de JDBC, como las clases y interfaces principales, la conexión a la base de datos y la ejecución de consultas SQL.

**Sección 45:** Manejo JDBC
En esta sección se profundiza en el manejo de JDBC. Se cubren temas como la creación de consultas preparadas para mejorar el rendimiento y prevenir ataques de inyección SQL, el uso de metadatos para obtener información sobre la base de datos y la administración de excepciones en JDBC.

**Sección 46:** Patrones de diseño
En esta sección se exploran los patrones de diseño comunes utilizados en el desarrollo de aplicaciones con JDBC. Se presentan patrones como Singleton, DAO (Data Access Object) y Factory, que ayudan a organizar y estructurar el código de manera eficiente y modular.

**Sección 47:** Transacciones JDBC
En esta sección se aborda el tema de las transacciones en JDBC. Se explica cómo realizar transacciones para garantizar la integridad de los datos y la consistencia en la base de datos. También se discute el uso de puntos de guardado (Savepoints) y el manejo de transacciones distribuidas.
## Proyecto Final

Consiste en una implementación básica de manejo de base de datos y conexión utilizando JDBC (Java Database Connectivity).

**Clase Conexion:**
- Esta clase proporciona métodos estáticos para establecer una conexión con la base de datos y cerrar los recursos asociados.

- Utiliza la clase DriverManager de JDBC para obtener una conexión utilizando la URL de conexión, el nombre de usuario y la contraseña proporcionados.

- Los métodos closeRS, closeST, closePST y closeCNT se encargan de cerrar los ResultSet, Statements, PreparedStatements y Connections respectivamente.

**Clase Usuario:**
- Esta clase se encarga de realizar operaciones CRUD (Crear, Leer, Actualizar y Eliminar) en la tabla usuario de la base de datos.

- Utiliza los métodos estáticos de la clase Conexion para obtener y cerrar la conexión con la base de datos.

- Los métodos insert, select, update y delete realizan las operaciones correspondientes utilizando PreparedStatement.

- En cada método, se obtiene la conexión, se prepara y ejecuta la consulta, se procesa el resultado y se cierran los recursos.


En resumen, este proyecto muestra una implementación básica de manejo de base de datos utilizando JDBC. La clase Conexion proporciona métodos para establecer y cerrar la conexión, mientras que la clase UsuarioDAO realiza operaciones CRUD en la tabla usuario. Es importante destacar que este código se limita a la lógica básica de interacción con la base de datos y puede requerir mejoras en cuanto a la seguridad y el manejo de excepciones.
## Ejemplo de Codigo

- Clase Principal 

```java
package test;

import datos.UsuarioDAO;
import domain.Usuario;
import java.util.List;

public class TestLaboratorio {

    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();

    Usuario usuarioNuevo = new Usuario("Gabriel2021", "210208");
    usuarioDAO.insert(usuarioNuevo);


        Usuario usuarioActualizar = new Usuario(2, "Juan", "HolaMundo");
        usuarioDAO.update(usuarioActualizar);


        Usuario usuarioEliminar = new Usuario(2);
        usuarioDAO.delete(usuarioEliminar);
        
        

        List<Usuario> usuarios = usuarioDAO.select();
        usuarios.forEach(usuario -> {
            System.out.println("usuario = " + usuario);
        });

    }

}
```

- Clase Usuarios

```java
package domain;

public class Usuario {

    private int idUsuario;
    private String usuario;
    private String password;

    public Usuario() {
    }

    public Usuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    public Usuario(int idUsuario, String usuario, String password) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.password = password;
    }

    public int getIdusuario() {
        return this.idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", usuario=" + usuario + ", password=" + password + '}';
    }

    
}

```

- Clase UsuarioDAO

```java
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
```


- Clases Conexion

```java
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

```
## Autor

- [@GabrielTorrealba](https://github.com/GabrielJose2102)

