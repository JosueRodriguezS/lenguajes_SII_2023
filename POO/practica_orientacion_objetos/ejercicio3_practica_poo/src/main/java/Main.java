/*
 * Make by Josué Rodríguez Solís
 * 
 * This file contains the class "Main" which will be the main class of the program
 * It will contain the main method
 */
public class Main {
    public static void main(String[] args) {
        //Get Agenda
        Agenda agenda = Agenda.getAgenda();        

        // Factory to create contacts
        FactoryAgenda factoryContacto = new FactoryContacto();

        Contacto cp1 = factoryContacto.crearContacto("Josué", "Rodríguez Solís", "123456789", "jrs@emailnator.com", "Joshu", "X", 
                "NONE", "NONE", "PERSONAL");
        Contacto cp2 = factoryContacto.crearContacto("Juan", "Pérez", "987654321", "pere@email.com", "Juan","Facebook",
                "NONE", "NONE", "PERSONAL");
        Contacto cp3 = factoryContacto.crearContacto("Pedro", "García", "123456789", "fga@email.com", "Pedro", "Twitter",
                "NONE", "NONE", "PERSONAL");
        Contacto cp4 = factoryContacto.crearContacto("Luis", "González", "987654321", "luis@email.com","Luis", "Instagram", 
                "NONE", "NONE", "PERSONAL");
        Contacto cp5 = factoryContacto.crearContacto("Alberto", "Gómez", "123456789", "alver@gmail.com", "Alberto", "TikTok", 
                "NONE", "NONE", "PERSONAL");

        Contacto ce1 = factoryContacto.crearContacto("Amelie", "Poulain", "123456789", "gua@email.com", "NONE", "NONE", 
                "Cine", "Actriz", "EMPRESARIAL");
        Contacto ce2 = factoryContacto.crearContacto("Javier", "Bardem", "987654321", "maximo@email.com", "NONE", "NONE",
                "Cine", "Actor", "EMPRESARIAL");
        Contacto ce3 = factoryContacto.crearContacto("Joaquin", "Phoenix", "123456789", "feni@gmail.com", "NONE", "NONE",
                "Orquesta", "Director", "EMPRESARIAL");
        Contacto ce4 = factoryContacto.crearContacto("Javier", "Gutiérrez", "987654321", "javi@gmail.com", "NONE", "NONE",
                "E-Sports", "Jugador", "EMPRESARIAL");
        Contacto ce5 = factoryContacto.crearContacto("Jorge", "Lorenzo", "123456789", "Jorge@gmail.com", "NONE", "NONE",
                "MotoGP", "Piloto", "EMPRESARIAL");

        // Factory to create events
        FactoryAgenda factoryEvento = new FactoryEvento();

        Evento ep1 = factoryEvento.crearEvento("Cumpleaños", "Casa", "01/01/2021", "12:00", "PERSONAL", "Cumpleaños de Josué", "NONE");
        Evento ep2 = factoryEvento.crearEvento("Fiesta", "Casa", "01/01/2021", "12:00", "PERSONAL", "Fiesta de Josué", "NONE");
        Evento ep3 = factoryEvento.crearEvento("Boda", "Casa", "01/01/2021", "12:00", "PERSONAL", "Boda de Josué", "NONE");
        Evento ep4 = factoryEvento.crearEvento("Graduación", "Casa", "01/01/2021", "12:00", "PERSONAL", "Graduación de Josué", "NONE");
        Evento ep5 = factoryEvento.crearEvento("Fiesta", "Casa", "01/01/2021", "12:00", "PERSONAL", "Fiesta de Josué", "NONE");

        Evento ef1 = factoryEvento.crearEvento("Reunión", "Casa", "01/01/2021", "12:00", "PROFESIONAL", "NONE", "Reunión de Josué");
        Evento ef2 = factoryEvento.crearEvento("Venta de acciones", "Casa", "01/01/2021", "17:00", "PROFESIONAL", "NONE", "Venta de acciones de Josué");
        Evento ef3 = factoryEvento.crearEvento("Reunión con el jefe", "Oficina", "01/21/2021", "21:00", "PROFESIONAL", "NONE", "Reunión con el jefe de Josué");
        Evento ef4 = factoryEvento.crearEvento("Reunión con el cliente", "Casa", "02/31/2021", "07:00", "PROFESIONAL", "NONE", "Reunión con el cliente de Josué");
        Evento ef5 = factoryEvento.crearEvento("Reunión con el equipo", "Oficinas", "01/12/2021", "10:00", "PROFESIONAL", "NONE", "Reunión con el equipo de Josué");

        //Add contacts to agenda
        agenda.addContacto(cp1);
        agenda.addContacto(cp2);
        agenda.addContacto(cp3);
        agenda.addContacto(cp4);
        agenda.addContacto(cp5);
        agenda.addContacto(ce1);
        agenda.addContacto(ce2);
        agenda.addContacto(ce3);
        agenda.addContacto(ce4);
        agenda.addContacto(ce5);

        //Add events to agenda
        agenda.addEvento(ep1);
        agenda.addEvento(ep2);
        agenda.addEvento(ep3);
        agenda.addEvento(ep4);
        agenda.addEvento(ep5);
        agenda.addEvento(ef1);
        agenda.addEvento(ef2);
        agenda.addEvento(ef3);
        agenda.addEvento(ef4);
        agenda.addEvento(ef5);

        agenda.mostrarContactos();
        System.out.println("\n");
        agenda.mostrarContactos();

        System.out.println("\n");
        System.out.println("Esta es la info de la agenda 3:\n" + agenda.toString());
    }}