/*
 * Make by Josué Rodríguez Solís
 * 
 * This file contains the class Circulo
 * This class is a representation of a circle in a 2D space
 */
public class Circulo implements Representable{
    private final double radio;
    
    // Builder
    public Circulo(double radio) {
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    // Method to calculate the area of the circle
    public double area() {
        return Math.PI * Math.pow(radio, 2);
    }

    // Method to calculate the perimeter of the circle
    public double perimetro() {
        return 2 * Math.PI * radio;
    }

    // Override the method draw from the interface Representable
    @Override
    public void draw() {
        System.out.println("Soy un círculo de radio " + radio);
    }


}
