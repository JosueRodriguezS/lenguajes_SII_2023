import java.util.ArrayList;

/*
 * Make by Josué Rodríguez Solís
 * 
 * This file contains the class Hoja
 * This class is a representation of a sheet in a 2D space
 */
public class Hoja {
    private final ArrayList<Representable> representables;

    // Builder
    public Hoja() {
        this.representables = new ArrayList<>();
    }

    // Method to add a representable object to the sheet
    public void add(Representable representable) {
        representables.add(representable);
    }

    // Method to print the sheet
    public void printSheet() {
        System.out.println("===============================\nSoy una hoja de representables\n===============================");
        for (Representable  representable : representables) {
            representable.draw();
        }
    }
}
