/*
 * Make by Josué Rodríguez Solís
 * 
 * This file contains the class Texto
 * This class is a representation of a text in a 2D space
 */
public class Texto implements Representable{
    private final String texto;

    // Builder
    public Texto(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    // Override the method draw from the interface Representable
    @Override
    public void draw() {
        System.out.println("Soy un texto que dice " + texto);
    }
}
