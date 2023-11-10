/*
 * Make by Josué Rodríguez Solís
 * 
 * This file contains the class Libro
 * This is the class that represent a book to a library
 * Attributes:
 * book_id: The id of the book
 * book_name: The name of the book
 * book_author: The author of the book
 * book_editorial: The editorial of the book
 * disponibility: The disponibility of the book
 */
public class Libro {
    private int book_id;
    private String book_name;
    private String book_author;
    private String book_editorial;
    private boolean disponibility;

    // Builder
    public Libro(int book_id, String book_name, String book_author, String book_editorial) {
        this.book_id = book_id;
        this.book_name = book_name;
        this.book_author = book_author;
        this.book_editorial = book_editorial;
        this.disponibility = true;
    }

    // Getters
    public int getBook_id() {
        return this.book_id;
    }

    public String getBook_name() {
        return this.book_name;
    }

    public String getBook_author() {
        return this.book_author;
    }

    public String getBook_editorial() {
        return this.book_editorial;
    }

    public boolean getDisponibility() {
        return this.disponibility;
    }

    // Methods for the disponibility
    public void setDisponibility(boolean disponibility) {
        this.disponibility = disponibility;
    }

    public void loanBook() {
        this.disponibility = false;
    }

    public void returnBook() {
        this.disponibility = true;
    }
}
