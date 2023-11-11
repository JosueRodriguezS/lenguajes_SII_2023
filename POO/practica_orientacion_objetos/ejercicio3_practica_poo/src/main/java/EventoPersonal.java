/*
 * Make by Josué Rodríguez Solís
 * 
 * This file contains the class "EventoPersonal" which is the son of "Evento"
 * It contains the information of a personal event
 * Type of event and description. Also the type "Evento Personal"
 */
public class EventoPersonal extends Evento{
    private String descripcion;

    // Builder
    public EventoPersonal(String nombre, String lugar, String fecha, String hora, String tipo, String descripcion) {
        super(nombre, lugar, fecha, hora, tipo);
        this.descripcion = descripcion;
    }

    // Getters and setters
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // toString
    @Override
    public String toString() {
        return super.toString() + "EventoPersonal{" + "tipo=" + this.getTipo() + ", descripcion=" + descripcion + '}';
    }
}
