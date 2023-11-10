package POO.ejercicio_simple_herencia.src;

/*
 * Make by Josué Rodríguez Solís
 * 
 * This file contains the class "EventoPersonal" which is the son of "Evento"
 * It contains the information of a personal event
 * Type of event and description. Also the type "Evento Personal"
 */
public class EventoPersonal extends Evento{
    private String tipo;
    private String descripcion;
    private String tipoEvento = "Evento Personal";

    // Builder
    public EventoPersonal(String nombre, String lugar, String fecha, String hora, String tipo, String descripcion) {
        super(nombre, lugar, fecha, hora);
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    // Getters and setters
    public String getTipo() {
        return tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // toString
    @Override
    public String toString() {
        return super.toString() + "EventoPersonal{" + "tipo=" + tipo + ", descripcion=" + descripcion + ", tipoEvento=" + tipoEvento + '}';
    }
}
