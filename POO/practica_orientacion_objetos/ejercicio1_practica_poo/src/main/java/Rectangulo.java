/*
 * Make by Josué Rodríguez Solís
 * 
 * This file contains the class Rectangulo
 * This class is a representation of a rectangle in a 2D space
 */
public class Rectangulo implements Representable{
    private final double base;
    private final double altura;

    // Builder
    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double getBase() {
        return base;
    }

    public double getAltura() {
        return altura;
    }

    // Method to calculate the area of the rectangle
    public double area() {
        return base * altura;
    }

    // Method to calculate the perimeter of the rectangle
    public double perimetro() {
        return 2 * (base + altura);
    }

    // Override the method draw from the interface Representable
    @Override
    public void draw() {
        System.out.println("Soy un rectángulo de base " + base + " y altura " + altura);
    }
}
