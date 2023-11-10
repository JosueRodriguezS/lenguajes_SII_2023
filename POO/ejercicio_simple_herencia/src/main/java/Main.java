package POO.ejercicio_simple_herencia.src;

/*
 * Make by Josué Rodríguez Solís
 * 
 * This file contains the class "Main" which will be the main class of the program
 * It will contain the main method
 */
public class Main {
    public static void main(String[] args) {
     
        //Create 5 personal contacts
        //name, surname, phone, email, nickname, social media
        ContactoPersonal cp1 = new ContactoPersonal("Josué", "Rodríguez Solís", "123456789", "jrs@emailnator.com", 
                "Joshu", "X");
        ContactoPersonal cp2 = new ContactoPersonal("Juan", "Pérez", "987654321", "pere@email.com",
                "Juan","Facebook");
        ContactoPersonal cp3 = new ContactoPersonal("Pedro", "García", "123456789", "fga@email.com",
                "Pedro", "Twitter");   
        ContactoPersonal cp4 = new ContactoPersonal("Luis", "González", "987654321", "luis@email.com",
                "Luis", "Instagram");
        ContactoPersonal cp5 = new ContactoPersonal("Alberto", "Gómez", "123456789", "alver@gmail.com",
                "Alberto", "TikTok");

        //Create 5 business contacts
        //name, surname, phone, email, company, position
        ContactoEmpresarial ce1 = new ContactoEmpresarial("Amelie", "Poulain", "123456789", "gua@email.com",
                "Cine", "Actriz");
        ContactoEmpresarial ce2 = new ContactoEmpresarial("Javier", "Bardem", "987654321", "maximo@email.com",
                "Cine", "Actor");
        ContactoEmpresarial ce3 = new ContactoEmpresarial("Joaquin", "Phoenix", "123456789", "feni@gmail.com",
                "Orquesta", "Director");
        ContactoEmpresarial ce4 = new ContactoEmpresarial("Javier", "Gutiérrez", "987654321", "javi@gmail.com",
                "E-Sports", "Jugador");
        ContactoEmpresarial ce5 = new ContactoEmpresarial("Jorge", "Lorenzo", "123456789", "Jorge@gmail.com",
                "MotoGP", "Piloto");

        //Create 5 personal events
        //name, place, date, time, type, description
        EventoPersonal ep1 = new EventoPersonal("Cumpleaños", "Casa", "01/01/2021", "12:00", "Cumpleaños", "Cumpleaños de Josué");
        EventoPersonal ep2 = new EventoPersonal("Fiesta", "Casa", "01/01/2021", "12:00", "Fiesta", "Fiesta de Josué");
        EventoPersonal ep3 = new EventoPersonal("Boda", "Casa", "01/01/2021", "12:00", "Boda", "Boda de Josué");
        EventoPersonal ep4 = new EventoPersonal("Graduación", "Casa", "01/01/2021", "12:00", "Graduación", "Graduación de Josué");
        EventoPersonal ep5 = new EventoPersonal("Fiesta", "Casa", "01/01/2021", "12:00", "Fiesta", "Fiesta de Josué");
        
        //Create 5 business events
        //name, place, date, time, type, description
        EventoProfesional ef1 = new EventoProfesional("Reunión", "Casa", "01/01/2021", "12:00", "Reunión", "Reunión de Josué");
        EventoProfesional ef2 = new EventoProfesional("Venta de acciones", "Casa", "01/01/2021", "17:00", "Venta de acciones", "Venta de acciones de Josué");
        EventoProfesional ef3 = new EventoProfesional("Reunión con el jefe", "Oficina", "01/21/2021", "21:00", "Reunión con el jefe", "Reunión con el jefe de Josué");
        EventoProfesional ef4 = new EventoProfesional("Reunión con el cliente", "Casa", "02/31/2021", "07:00", "Reunión con el cliente", "Reunión con el cliente de Josué");
        EventoProfesional ef5 = new EventoProfesional("Reunión con el equipo", "Oficinas", "01/12/2021", "10:00", "Reunión con el equipo", "Reunión con el equipo de Josué");

        //Agenda1, only personal contacts
        Agenda agenda1 = new Agenda();
        agenda1.addContacto(cp1);
        agenda1.addContacto(cp2);
        agenda1.addContacto(cp3);
        agenda1.addContacto(cp4);
        agenda1.addContacto(cp5);

        //Agenda2, only business contacts
        Agenda agenda2 = new Agenda();
        agenda2.addContacto(ce1);
        agenda2.addContacto(ce2);
        agenda2.addContacto(ce3);
        agenda2.addContacto(ce4);
        agenda2.addContacto(ce5);

        //Agenda3, mix of all events and some contacts
        Agenda agenda3 = new Agenda();
        agenda3.addContacto(cp1);
        agenda3.addContacto(cp2);
        agenda3.addContacto(cp3);
        agenda3.addContacto(cp4);
        agenda3.addContacto(cp5);
        agenda3.addEvento(ep1);
        agenda3.addEvento(ep2);
        agenda3.addEvento(ep3);
        agenda3.addEvento(ep4);
        agenda3.addEvento(ep5);
        agenda3.addEvento(ef1);
        agenda3.addEvento(ef2);
        agenda3.addEvento(ef3);
        agenda3.addEvento(ef4);
        agenda3.addEvento(ef5);

        agenda1.mostrarContactos();
        System.out.println("\n");
        agenda2.mostrarContactos();

        System.out.println("\n");
        System.out.println("Esta es la info de la agenda 3:\n" + agenda3.toString());
    }}