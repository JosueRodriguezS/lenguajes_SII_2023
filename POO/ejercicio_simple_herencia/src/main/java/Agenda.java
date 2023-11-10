package POO.ejercicio_simple_herencia.src;

import java.util.ArrayList;
/*
 * Make by Josué Rodríguez Solís
 * 
 * This file contains the class "Agenda" 
 * It will contain the events and contacts in two different ArrayLists
 * It will also contain the methods to add and remove contacts and events
 */
public class Agenda {
    private ArrayList<Contacto> contactos;
    private ArrayList<Evento> eventos;

    // Builder
    public Agenda() {
        this.contactos = new ArrayList<Contacto>();
        this.eventos = new ArrayList<Evento>();
    }

    // Methods
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

    public void modificarEventoPersonal(EventoPersonal e, String nombre, String lugar, String fecha, String hora, String Tipo, String descripcion) {
        e.setNombre(nombre);
        e.setLugar(lugar);
        e.setFecha(fecha);
        e.setHora(hora);
        e.setTipo(Tipo);
        e.setDescripcion(descripcion);
    }

    public void modificarEventoProfesional(EventoProfesional e, String nombre, String lugar, String fecha, String hora, String Tipo, String importancia) {
        e.setNombre(nombre);
        e.setLugar(lugar);
        e.setFecha(fecha);
        e.setHora(hora);
        e.setTipo(Tipo);
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
