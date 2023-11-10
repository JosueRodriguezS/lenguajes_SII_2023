import java.util.Date;
import java.util.ArrayList;
import java.util.List;
/*
 * Make by Josué Rodríguez Solís
 * 
 * This file contains the class Main
 * This is the class that represent the main of the program
 */
public class Main {
    public static void main(String[] args){
        Biblioteca library = new Biblioteca();

        // Create the books
        Libro book1 = new Libro(1, "El señor de los anillos", "J.R.R. Tolkien", "Minotauro");
        Libro book2 = new Libro(2, "El hobbit", "J.R.R. Tolkien", "Minotauro");
        Libro book3 = new Libro(3, "El silmarillion", "J.R.R. Tolkien", "Minotauro");
        Libro book4 = new Libro(4, "El arte de la guerra", "Sun Tzu", "DeBolsillo");
        Libro book5 = new Libro(5, "El principito", "Antoine de Saint-Exupéry", "Salamandra");
        Libro book6 = new Libro(6, "El código Da Vinci", "Dan Brown", "Umbriel");
        Libro book7 = new Libro(7, "El perfume", "Patrick Süskind", "Seix Barral");
        Libro book8 = new Libro(8, "El nombre del viento", "Patrick Rothfuss", "Plaza & Janés");

        // Create the partners
        Socio partner1 = new Socio(1, "Josué", "Calle 1");
        Socio partner2 = new Socio(2, "Juan", "Calle 2");
        Socio partner3 = new Socio(3, "Pedro", "Calle 3");

        // Add the books to the library
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);
        library.addBook(book6);
        library.addBook(book7);
        library.addBook(book8);

        // Add the partners to the library
        library.addPartner(partner1);
        library.addPartner(partner2);
        library.addPartner(partner3);

        // Show the books
        library.showBooksInfo();

        // Show the partners
        library.showPartnersInfo();

        // Make some loans
        library.makeLoan("El señor de los anillos", 1, new Date(), new Date());
        library.makeLoan("El hobbit", 2, new Date(), new Date());
        library.makeLoan("El silmarillion", 3, new Date(), new Date());
        library.makeLoan("El arte de la guerra", 1, new Date(), new Date());
        library.makeLoan("El principito", 2, new Date(), new Date());
        library.makeLoan("El código Da Vinci", 3, new Date(), new Date());
        
        // Show the loans
        library.showLoansInfo();

        // Try to make a loan with a book that is not available
        System.out.println("Intentando hacer un préstamo con un libro no disponible");
        library.makeLoan("El señor de los anillos", 2, new Date(), new Date());
        System.out.println("----------------------------------------------------");

        // make some loans to allocate 3 to partner 1 and partner 2
        library.makeLoan("El perfume", 1, new Date(), new Date());
        library.makeLoan("El nombre del viento", 2, new Date(), new Date());

        // show info
        library.showPartnersInfoWith3Loans();
    }   
}

