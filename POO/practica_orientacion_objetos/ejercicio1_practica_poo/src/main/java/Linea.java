/*
 * Make by Josué Rodríguez Solís
 * 
 * This file contains the class Linea
 * This class is a representation of a line in a 2D space
 */
public class Linea implements Representable{
    private final double longitud;

    // Builder
    public Linea(double longitud) {
        this.longitud = longitud;
    }

    public double getLongitud() {
        return longitud;
    }

    // Override the method draw from the interface Representable
    @Override
    public void draw() {
        System.out.println("Soy una línea de longitud " + longitud);
    }
}
