package local.com.agenda_contactos;

import java.io.Serializable;

/**
 * Created by user on 28/02/2018.
 */
//implementamos el uso de la interfaz Serializable
// para poder enviar los datos en forma de bytes...

    //Hemos creado una clase Contacto, donde almacenaremos los nombres, email y edad
    //que usaremos en toda la app, para poder crear un array en instancia a esta clase.

public class Contacto implements Serializable {
    private String nombre;
    private String email;
    private  int edad;
    public Contacto(String nombre, String email, int edad) {
        this.nombre = nombre;
        this.email = email;
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
