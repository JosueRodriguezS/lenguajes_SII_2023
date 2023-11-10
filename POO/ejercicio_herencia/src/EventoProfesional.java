package POO.ejercicio_simple_herencia.src;

/*
 * Make by Josué Rodríguez Solís
 * 
 * This file contains the class "EventoProfesional" which is the son of "Evento"
 * It contains the information of a professional event
 * Type of event and importance. Also the type "Evento Profesional"
 */
public class EventoProfesional extends Evento {
    private String tipo;
    private String importancia;
    private String tipoEvento = "Evento Profesional";

    // Builder
    public EventoProfesional(String nombre, String lugar, String fecha, String hora, String tipo, String importancia) {
        super(nombre, lugar, fecha, hora);
        this.tipo = tipo;
        this.importancia = importancia;
    }

    // Getters and setters
    public String getTipo() {
        return tipo;
    }

    public String getImportancia() {
        return importancia;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setImportancia(String importancia) {
        this.importancia = importancia;
    }

    // toString
    @Override
    public String toString() {
        return super.toString() + "EventoProfesional{" + "tipo=" + tipo + ", importancia=" + importancia + ", tipoEvento=" + tipoEvento + '}';
    }
}
