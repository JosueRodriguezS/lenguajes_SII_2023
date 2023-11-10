/*
 * Make by Josué Rodríguez Solís
 * 
 * This file contains the class "Contacto" which is the father of "ContactoPersonal" and "ContactoProfesional"
 */

package POO.ejercicio_simple_herencia.src;

/*
 * Class "Contacto"
 * 
 * This class will contain the basic information of a contact
 * Name, surname, phone number and email
 */
public class Contacto {
    private String nombre;
    private String apellidos;
    private String telefono;
    private String email;

    // Builder
    public Contacto(String nombre, String apellidos, String telefono, String email) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.email = email;
    }

    // Getters and setters
    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // toString modified to show the information of the contact
    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nApellidos: " + apellidos + "\nTeléfono: " + telefono + "\nEmail: " + email;
    }
}