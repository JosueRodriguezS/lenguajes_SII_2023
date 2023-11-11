public class FactoryContacto implements FactoryAgenda{
    @Override
    public Contacto crearContacto(String nombre, String apellidos, String telefono, String email, String apodo, String redSocial, String empresa, String puesto, String tipo){
        if (tipo.equals("PERSONAL")){
            return new ContactoPersonal(nombre, apellidos, telefono, email, apodo, redSocial, tipo);
        } else if (tipo.equals("EMPRESARIAL")){
            return new ContactoEmpresarial(nombre, apellidos, telefono, email, empresa, puesto, tipo);
        } else {
            return null;
        }}
    @Override
    public Evento crearEvento(String nombre, String lugar, String fecha, String hora, String tipo, String  descripcion, String importancia){
        return null;
}}