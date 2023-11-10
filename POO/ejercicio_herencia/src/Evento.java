package POO.ejercicio_simple_herencia.src;

/* 
 * Make by Josué Rodríguez Solís
 * 
 * This file contains the class "Evento", this will be the father of "EventoPersonal" and "EventoProfesional"
 * It will contain the basic information of an event
 * Name, place, date and time
 */
public class Evento {
    private String nombre;
    private String lugar;
    private String fecha;
    private String hora;

    // Builder
    public Evento(String nombre, String lugar, String fecha, String hora) {
        this.nombre = nombre;
        this.lugar = lugar;
        this.fecha = fecha;
        this.hora = hora;
    }

    // Getters and setters
    public String getNombre() {
        return nombre;
    }

    public String getLugar() {
        return lugar;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    // toString
    @Override
    public String toString() {
        return "Evento{" + "nombre=" + nombre + ", lugar=" + lugar + ", fecha=" + fecha + ", hora=" + hora + '}';
    }
}
