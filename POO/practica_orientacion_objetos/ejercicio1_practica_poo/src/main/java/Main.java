
/*
 * Make by Josué Rodríguez Solís
 * 
 * This file contains the class Main
 * This class is the main class of the project
 */

public class Main {
    public static void main(String[] args) {

        // Create a dummy document
        Documento documentoDummy = new Documento();

        // Create 3 dummy sheets
        Hoja hojaDummy = new Hoja();
        Hoja hojaDummy2 = new Hoja();
        Hoja hojaDummy3 = new Hoja();

        // Create 3 dummy texts
        Texto textoDummy = new Texto("Hola buenas tardes");
        Texto textoDummy2 = new Texto("Boujour bonsoir");
        Texto textoDummy3 = new Texto("Hello good evening");

        // Create 3 dummy circles
        Circulo circuloDummy = new Circulo(5);
        Circulo circuloDummy2 = new Circulo(10);
        Circulo circuloDummy3 = new Circulo(15);

        // Create 3 dummy squares
        Cuadrado cuadradoDummy = new Cuadrado(5);
        Cuadrado cuadradoDummy2 = new Cuadrado(10);
        Cuadrado cuadradoDummy3 = new Cuadrado(15);

        // Create 3 dummy rectangles
        Rectangulo rectanguloDummy = new Rectangulo(5, 10);
        Rectangulo rectanguloDummy2 = new Rectangulo(10, 15);
        Rectangulo rectanguloDummy3 = new Rectangulo(15, 20);

        // Create 3 dummy Elipses
        Elipse elipseDummy = new Elipse(5, 10);
        Elipse elipseDummy2 = new Elipse(10, 15);
        Elipse elipseDummy3 = new Elipse(15, 20);

        // Create 3 dummy lines
        Linea lineaDummy = new Linea(5);
        Linea lineaDummy2 = new Linea(10);  
        Linea lineaDummy3 = new Linea(15);

        // Add some elements to a group
        Grupo grupoDummy = new Grupo();
        grupoDummy.add(textoDummy);
        grupoDummy.add(circuloDummy);
        grupoDummy.add(cuadradoDummy);
        grupoDummy.add(rectanguloDummy);
        grupoDummy.add(elipseDummy);
        grupoDummy.add(lineaDummy);

        // Add elements to the sheets
        hojaDummy.add(textoDummy);
        hojaDummy.add(circuloDummy);
        hojaDummy.add(cuadradoDummy);
        hojaDummy.add(rectanguloDummy);
        hojaDummy.add(elipseDummy);
        hojaDummy.add(lineaDummy);
        
        hojaDummy2.add(textoDummy2);
        hojaDummy2.add(circuloDummy2);
        hojaDummy2.add(cuadradoDummy2);
        hojaDummy2.add(rectanguloDummy2);
        hojaDummy2.add(elipseDummy2);

        hojaDummy3.add(textoDummy3);
        hojaDummy3.add(circuloDummy3);
        hojaDummy3.add(cuadradoDummy3);
        hojaDummy3.add(rectanguloDummy3);
        hojaDummy3.add(elipseDummy3);
        hojaDummy3.add(grupoDummy);
        
        // Add the sheets to the document
        documentoDummy.add(hojaDummy);
        documentoDummy.add(hojaDummy2);
        documentoDummy.add(hojaDummy3);

        // Print the document
        documentoDummy.printDocument();
    }
}
