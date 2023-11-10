import java.util.Date;
import java.util.ArrayList;
import java.util.List;
/*
 * Make by Josué Rodríguez Solís
 * 
 * This file contains the class Socio
 * This is the class that represent a partner to a library
 * Attributes:
 * partner_id: The id of the partner
 * partner_name: The name of the partner
 * partnet_direction: The direction of the partner
 * loans: The loans of the partner
 */
public class Socio {
    private int partner_id;
    private String partner_name;
    private String partner_direction;
    private List<Prestamo> loans;

    // Builder
    public Socio(int partner_id, String partner_name, String partner_direction) {
        this.partner_id = partner_id;
        this.partner_name = partner_name;
        this.partner_direction = partner_direction;
        this.loans = new ArrayList<Prestamo>();
    }

    // Getters

    public int getPartner_id() {
        return this.partner_id;
    }

    public String getPartner_name() {
        return this.partner_name;
    }

    public String getPartner_direction() {
        return this.partner_direction;
    }

    public List<Prestamo> getLoans() {
        return this.loans;
    }

    // Methods for the loans

    public int getLoansLength() {
        return this.loans.size();
    }

    public void addLoan(Libro book, Date loan_date, Date return_date) {
        if (book.getDisponibility()) {
            Prestamo loan = new Prestamo(loan_date, return_date, book, this);
            this.loans.add(loan);
            
            book.loanBook();
        } else {
            System.out.println("El libro no está disponible");
        }
    }
}
