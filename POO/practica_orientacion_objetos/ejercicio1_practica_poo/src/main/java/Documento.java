import java.util.ArrayList;
/*
 * Make by Josué Rodríguez Solís
 * 
 * This file contains the class Documento
 * This class is a representation of a document
 */
public class Documento {
    private final ArrayList<Hoja> hojas;

    // Builder
    public Documento() {
        this.hojas = new ArrayList<>();
    }

    // Method to add a sheet to the document
    public void add(Hoja hoja) {
        hojas.add(hoja);
    }

    // Method to print the document
    public void printDocument() {
        System.out.println("================================\nSoy un documento de" + " #" + hojas.size() + " hojas\n================================");
        for (Hoja hoja : hojas) {
            hoja.printSheet();
        }
    }
}   
