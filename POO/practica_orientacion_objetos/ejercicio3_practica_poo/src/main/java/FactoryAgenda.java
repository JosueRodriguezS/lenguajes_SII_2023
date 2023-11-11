/*
 * Make by Josué Rodríguez Solís
 * 
 * This file contains the interface "FactoryAgenda"
 * 
 */
public interface FactoryAgenda {
    Contacto crearContacto(String nombre, String apellidos, String telefono, String email, String apodo, String redSocial, String empresa, String puesto, String tipo);
    Evento crearEvento(String nombre, String lugar, String fecha, String hora, String tipo, String  descripcion, String importancia); 
} 
