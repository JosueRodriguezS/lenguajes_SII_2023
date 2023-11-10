package POO.ejercicio_simple_herencia.src;

/* 
 * Make by Josué Rodríguez Solís
 * 
 * This file contains the class "ContactoPersonal" which is the son of "Contacto"
 * It contains the information of a personal contact
 * Nickname and social media
 */
public class ContactoPersonal extends Contacto{
    private String apodo;
    private String redSocial;

    // Builder
    public ContactoPersonal(String nombre, String apellidos, String telefono, String email, String apodo, String redSocial) {
        super(nombre, apellidos, telefono, email);
        this.apodo = apodo;
        this.redSocial = redSocial;
    }

    // Getters and setters
    public String getApodo() {
        return apodo;
    }

    public String getRedSocial() {
        return redSocial;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public void setRedSocial(String redSocial) {
        this.redSocial = redSocial;
    }

    // toString
    @Override
    public String toString() {
        return super.toString() + "\nContactoPersonal{" + "apodo=" + apodo + ", redSocial=" + redSocial + '}' + '\n';
    }
}
