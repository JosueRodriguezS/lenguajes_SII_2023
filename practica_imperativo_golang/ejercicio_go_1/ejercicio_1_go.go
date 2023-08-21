package main

import (
	"bufio"   //Paquete incorporado que proporciona funcionalidades para la lectura y escritura eficiente de datos
	"fmt"     //Paquete incorporado que proporciona funcionalidad para formatear e imprimir valores
	"os"      //Paquete incorporado que proporciona funcionalidades para interactuar con el sistema operativo (terminal)
	"strings" //Paquete incorporado que proporciona funcionalidades para manipular y trabajar con cadenas de texto
)

// Funcion que permite leer múltiples lineas desde la terminal y las transforma en una única cadena de texto
func readMultiline() string {
	var lines []string
	myScanner := bufio.NewScanner(os.Stdin)
	for myScanner.Scan() {
		lines = append(lines, myScanner.Text())
	}
	return strings.Join(lines, "\n")
}

// Proceso único en el que se realiza el cálculo de las tres variables, cantidad de caracteres, cantidad de palabras y la cantidad de lineas
func analizeTextProcess(text string) (int, int, int) {
	charCount, wordCoutn, lineCount := 0, 0, 0

	myScanner := bufio.NewScanner(strings.NewReader(text))

	//Se recorre cada línea del texto
	for myScanner.Scan() {
		line := myScanner.Text()
		charCount += len(line)        //Se suma el número de caracteres de cada línea a la varaible charCount
		words := strings.Fields(line) //Utilizando los espacios en blanco se separan las palabras en cada línea
		wordCoutn += len(words)
		lineCount++
	}

	return charCount, wordCoutn, lineCount
}

func main() {
	fmt.Printf("===============================================\n")
	fmt.Printf("Instrucciones\n")
	fmt.Printf("1. Ingrese su texto en la terminal\n")
	fmt.Printf("2. PResione Ctrl+D si es usuario Unix o Ctrl+Z si es usuario Windows\n")
	fmt.Printf("3. PResione Enter y disfrute de las estadísticas de su texto\n")
	fmt.Printf("===============================================\n")
	fmt.Printf("Puede ingresar su texto aquí.\n")

	text := readMultiline()

	myNumChars, myNumWords, myNUmLines := analizeTextProcess(text)

	fmt.Printf("===============================================\n")
	fmt.Printf("El número de caracteres es: %d\n", myNumChars)
	fmt.Printf("El número de palabras es: %d\n", myNumWords)
	fmt.Printf("El número de lineas es: %d\n", myNUmLines)
	fmt.Printf("===============================================")
}
