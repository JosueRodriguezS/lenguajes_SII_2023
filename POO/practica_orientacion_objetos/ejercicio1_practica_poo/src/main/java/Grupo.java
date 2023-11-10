import java.util.ArrayList;
/*
 * Make by Josué Rodríguez Solís
 * 
 * This file contains the class Grupo
 * This class is a representation of a group of representable objects or other groups
 */
public class Grupo implements Representable{
    private final ArrayList<Representable> representables;

    // Builder
    public Grupo() {
        this.representables = new ArrayList<>();
    }

    // Method to add a representable object to the group
    public void add(Representable representable) {
        representables.add(representable);
    }

    // Override the method draw from the interface Representable
    @Override
    public void draw() {
        System.out.println("___________________Soy un grupo de representables__________________");
        for (Representable representable : representables) {
            representable.draw();
        }
        System.out.println("___________________________________________________________________");
    }
}