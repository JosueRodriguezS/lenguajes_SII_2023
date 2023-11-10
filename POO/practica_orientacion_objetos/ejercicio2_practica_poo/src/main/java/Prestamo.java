import java.util.Date;
/*
 * Make by Josué Rodríguez Solís
 * 
 * This file contains the class Prestamo
 * This is the class that represent a loan to a library
 * Attributes:
 * loan_date: The date of the loan
 * return_date: The date of the return
 * book: The book that is loaned
 * partner: The partner that loaned the book
 */
public class Prestamo {
    private Date loan_date;
    private Date return_date;
    private Libro book;
    private Socio partner;

    // Builder
    public Prestamo( Date loan_date, Date return_date, Libro book, Socio partner) {
        this.loan_date = loan_date;
        this.return_date = return_date;
        this.book = book;
        this.partner = partner;
    }

    // Getters
    public Date getLoan_date() {
        return this.loan_date;
    }

    public Date getReturn_date() {
        return this.return_date;
    }

    public Libro getBook() {
        return this.book;
    }

    public Socio getPartner() {
        return this.partner;
    }
}
