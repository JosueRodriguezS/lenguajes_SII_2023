

/*
 * Make by Josué Rodríguez Solís
 * 
 * This file contains the class "ContactoEmpresarial" which is the son of "Contacto"
 * It contains the information of a business contact
 * Company and position
 */
public class ContactoEmpresarial extends Contacto{
    private String empresa;
    private String puesto;

    // Builder
    public ContactoEmpresarial(String nombre, String apellidos, String telefono, String email, String empresa, String puesto, String tipo) {
        super(nombre, apellidos, telefono, email, tipo);
        this.empresa = empresa;
        this.puesto = puesto;
    }

    // Getters and setters
    public String getEmpresa() {
        return empresa;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    // toString
    @Override
    public String toString() {
        return super.toString() + "\nContactoEmpresarial{" + "empresa=" + empresa + ", puesto=" + puesto + '}' + '\n';
    }
}
