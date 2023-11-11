import java.util.ArrayList;
/*
 * Make by Josué Rodríguez Solís
 * 
 * This file contains the class "Agenda" 
 * It will contain the events and contacts in two different ArrayLists
 * It will also contain the methods to add and remove contacts and events
 */

/*
* Esta clase va a implementa un Eager Singleton
* 
* Diferencias entre Eager y Lazy Singleton:
    Eager Singleton:
        Momento de Creación: La instancia se crea en el momento de la carga de la clase.
    Ventajas:
        Simplicidad: La implementación es sencilla y directa, ya que la instancia se crea de inmediato.
        Seguridad: La instancia está garantizada y disponible cuando se requiere, evitando problemas de concurrencia.
    Desventajas:
        Carga Inmediata: La instancia se crea incluso si no se utiliza, lo que puede generar una carga innecesaria al sistema.

    Lazy Singleton:
        Momento de Creación: La instancia se crea solo cuando se solicita por primera vez.
    Ventajas:
        Ahorro de Recursos: No se carga la instancia hasta que se necesita, ahorrando recursos si la instancia no se utiliza.
        Eficiencia: Útil en entornos donde la creación de la instancia es costosa y se desea retrasar hasta que sea absolutamente necesario.
    Desventajas:
        Posible Concurrencia: Debe gestionar concurrencia si se utiliza en un entorno multihilo.

* Elección de Eager Singleton para la Clase Agenda:

    En el contexto de la clase Agenda para la gestión de contactos y eventos, la elección de un Eager Singleton se justifica por varias razones:

        Simplicidad y Garantía de Disponibilidad: La creación de la instancia de la Agenda no es costosa, 
        y la simplicidad en la implementación es valiosa. Con un Eager Singleton, la instancia está garantizada 
        y disponible tan pronto como se carga la clase, asegurando que esté lista para su uso inmediato sin demoras.

        Baja Carga al Sistema: Dado que la creación de la instancia no implica una carga significativa al sistema 
        y no hay una necesidad explícita de retrasar la creación hasta que sea necesaria, 
        un Eager Singleton proporciona una solución directa y efectiva.

        Evitar Problemas de Concurrencia: En entornos de concurrencia moderada o baja, 
        donde la creación simultánea de múltiples instancias no es un problema, 
        un Eager Singleton ofrece una solución segura y libre de concurrencia.
*/
public class Agenda {
    private static final Agenda agenda = new Agenda();
    private ArrayList<Contacto> contactos;
    private ArrayList<Evento> eventos;

    // Builder
    private Agenda() {
        this.contactos = new ArrayList<Contacto>();
        this.eventos = new ArrayList<Evento>();
    }

    // Methods
    public static Agenda getAgenda() {
        return agenda;
    }

    public void addContacto(Contacto c) {
        this.contactos.add(c);
    }

    public void addEvento(Evento e) {
        this.eventos.add(e);
    }

    public void removeContacto(Contacto c) {
        this.contactos.remove(c);
    }

    public void removeEvento(Evento e) {
        this.eventos.remove(e);
    }

    public void modificarContactoPersonal(ContactoPersonal c, String nombre, String apellidos, String telefono, String email, String apodo, String redSocial) {
        c.setNombre(nombre);
        c.setApellidos(apellidos);
        c.setTelefono(telefono);
        c.setEmail(email);
        c.setApodo(apodo);
        c.setRedSocial(redSocial);
    }

    public void modificarContactoEmpresarial(ContactoEmpresarial c, String nombre, String apellidos, String telefono, String email, String empresa, String puesto) {
        c.setNombre(nombre);
        c.setApellidos(apellidos);
        c.setTelefono(telefono);
        c.setEmail(email);
        c.setEmpresa(empresa);
        c.setPuesto(puesto);
    }

    public void modificarEventoPersonal(EventoPersonal e, String nombre, String lugar, String fecha, String hora, String descripcion) {
        e.setNombre(nombre);
        e.setLugar(lugar);
        e.setFecha(fecha);
        e.setHora(hora);
        e.setDescripcion(descripcion);
    }

    public void modificarEventoProfesional(EventoProfesional e, String nombre, String lugar, String fecha, String hora, String importancia) {
        e.setNombre(nombre);
        e.setLugar(lugar);
        e.setFecha(fecha);
        e.setHora(hora);
        e.setImportancia(importancia);
    }

    public void mostrarContactos() {
        System.out.println("Estos son los contactos de la agenda:");
        for (Contacto c : contactos) {
            System.out.println(c.toString());
        }
    }

    public void mostrarEventos() {
        System.out.println("Estos son los eventos de la agenda:");
        for (Evento e : eventos) {
            System.out.println(e.toString());
        }
    }

    // ToString to show the information of the agenda (contacts and events)
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Agenda:\n");
        sb.append("Contactos:\n");
        for (Contacto c : contactos) {
            sb.append(c.toString()).append("\n");
        }
        sb.append("Eventos:\n");
        for (Evento e : eventos) {
            sb.append(e.toString()).append("\n");
        }
        return sb.toString();
    }
}
