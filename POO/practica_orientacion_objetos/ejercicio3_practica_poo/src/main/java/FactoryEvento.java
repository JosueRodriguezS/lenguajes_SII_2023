public class FactoryEvento implements FactoryAgenda{
    @Override
    public Contacto crearContacto(String nombre, String apellidos, String telefono, String email, String apodo, String redSocial, String empresa, String puesto, String tipo){
        return null;
    }
    @Override
    public Evento crearEvento(String nombre, String lugar, String fecha, String hora, String tipo, String  descripcion, String importancia){
        if (importancia.equals("NONE")){
            return new EventoPersonal(nombre, lugar, fecha, hora, tipo, descripcion);	
        } else if (descripcion.equals("NONE")){
            return new EventoProfesional(nombre, lugar, fecha, hora, tipo, importancia);
        } else {
            return null;
        }
    }
}
