/*
 * Make by Josué Rodríguez Solís
 * 
 * This file contains the class Cuadrado
 * This class is a representation of a square in a 2D space
 */
public class Cuadrado implements Representable{
    private final double lado;

    // Builder
    public Cuadrado(double lado) {
        this.lado = lado;
    }

    public double getLado() {
        return lado;
    }

    // Method to calculate the area of the square
    public double area() {
        return Math.pow(lado, 2);
    }

    // Method to calculate the perimeter of the square
    public double perimetro() {
        return 4 * lado;
    }

    // Override the method draw from the interface Representable
    @Override
    public void draw() {
        System.out.println("Soy un cuadrado de lado " + lado);
    }

}
