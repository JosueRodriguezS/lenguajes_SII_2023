import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 * Make by Josué Rodríguez Solís
 * 
 * This file contains the class Biblioteca
 * This is the class that represent a library
 * Attributes:
 * books: The books of the library
 * partners: The partners of the library
 * loans: The loans of the library
 */
public class Biblioteca {
    private List<Libro> books;
    private List<Socio> partners;
    private List<Prestamo> loans;

    // Builder
    public Biblioteca() {
        this.books = new ArrayList<Libro>();
        this.partners = new ArrayList<Socio>();
        this.loans = new ArrayList<Prestamo>();
    }

    // Methods for the books
    public void addBook(Libro book) {
        this.books.add(book);
    }

    public void removeBook(Libro book) {
        this.books.remove(book);
    }

    public void showBooks() {
        for (Libro book : this.books) {
            System.out.println(book.getBook_name());
        }
    }

    public void showBooksInfo() {
        System.out.println("----------Los libros de la biblioteca son:----------");
        for (Libro book : this.books) {
            System.out.println("Nombre: " + book.getBook_name() + " Autor: " + book.getBook_author() + " Editorial: " + book.getBook_editorial());
        }
        System.out.println("----------------------------------------------------");
    }

    //Method to get a book by name
    public Libro getBookByName(String book_name) {
        for (Libro book : this.books) {
            if (book.getBook_name().equals(book_name)) {
                return book;
            }
        }
        return null;
    }

    // Method to get all the books that are available
    public List<Libro> getAvailableBooks() {
        List<Libro> available_books = new ArrayList<Libro>();
        for (Libro book : this.books) {
            if (book.getDisponibility()) {
                available_books.add(book);
            }
        }
        return available_books;
    }

    // Methods for the partners
    public void addPartner(Socio partner) {
        this.partners.add(partner);
    }

    public void removePartner(Socio partner) {
        this.partners.remove(partner);
    }

    public void showPartners() {
        for (Socio partner : this.partners) {
            System.out.println("Nombre: " + partner.getPartner_name() + " ID: " + partner.getPartner_id());
        }
    }

    public void showPartnersInfo() {
        System.out.println("----------Los socios de la biblioteca son:----------");
        for (Socio partner : this.partners) {
            System.out.println("Nombre: " + partner.getPartner_name() + " ID: " + partner.getPartner_id() + " Dirección: " + partner.getPartner_direction());
        }
        System.out.println("----------------------------------------------------");
    }

    // Method to get a partner by id
    public Socio getPartnerById(int partner_id) {
        for (Socio partner : this.partners) {
            if (partner.getPartner_id() == partner_id) {
                return partner;
            }
        }
        return null;
    }

    // Methods for the loans
    public void makeLoan(String book_name, int partner_id, Date loan_date, Date return_date) {
        Socio partner = this.getPartnerById(partner_id);
        Libro book = this.getBookByName(book_name);
        if(book == null){
            System.out.println("El libro no existe");
            return;
        }
        if(partner == null){
            System.out.println("El socio no existe");
            return;
        }
        if(!book.getDisponibility()){
            System.out.println("El libro no está disponible");
            return;
        }
        partner.addLoan(book, loan_date, return_date);
        Prestamo loan = new Prestamo(loan_date, return_date, book, partner);
        this.loans.add(loan);
    }

    public void showLoansInfo () {
        System.out.println("----------Los préstamos de la biblioteca son:----------");
        for (Prestamo loan : this.loans) {
            System.out.println("Libro: " + loan.getBook().getBook_name() + " Prestado a: " + loan.getPartner().getPartner_name());
        }
        System.out.println("----------------------------------------------------");
    }

    // Relation Methods
    public List<Socio> filterPartnersWith3Loans() {
        List<Socio> partners_with_3_loans = new ArrayList<Socio>();
        for (Socio partner : this.partners) {
            if (partner.getLoansLength() >= 3) {
                partners_with_3_loans.add(partner);
            }
        }
        return partners_with_3_loans;
    }

    public void showPartnersInfoWith3Loans() {
        List<Socio> partners_with_3_loans = this.filterPartnersWith3Loans();
        System.out.println("Socios con 3 o más préstamos:");
        for (Socio partner : partners_with_3_loans) {
            System.out.println("Nombre: " + partner.getPartner_name() + " ID: " + partner.getPartner_id()); 
        }
         System.out.println("--------------------");
    }

}


