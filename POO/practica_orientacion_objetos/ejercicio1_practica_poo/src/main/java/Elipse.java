/*
 * Make by Josué Rodríguez Solís
 * 
 * This file contains the class Elipse
 * This class is a representation of a elipse in a 2D space
 */
public class Elipse implements Representable{
    private final double radio1;
    private final double radio2;

    // Builder
    public Elipse(double radio1, double radio2) {
        this.radio1 = radio1;
        this.radio2 = radio2;
    }

    public double getRadio1() {
        return radio1;
    }

    public double getRadio2() {
        return radio2;
    }

    // Method to calculate the area of the elipse
    public double area() {
        return Math.PI * radio1 * radio2;
    }

    // Method to calculate the perimeter of the elipse
    public double perimetro() {
        return 2 * Math.PI * Math.sqrt((Math.pow(radio1, 2) + Math.pow(radio2, 2)) / 2);
    }

    // Override the method draw from the interface Representable
    @Override
    public void draw() {
        System.out.println("Soy una elipse de radio " + radio1 + " y " + radio2);
    }
}
