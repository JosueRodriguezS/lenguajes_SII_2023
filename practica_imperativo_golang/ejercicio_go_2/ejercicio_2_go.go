package main

import (
	"fmt"
	"strings"
)

func printFigure(centerLine int) {
	if centerLine%2 == 0 || centerLine <= 0 {
		fmt.Println("Porfavor introduzca un numero impar y que sea positivo")
		return
	}

	var builder strings.Builder //Usamos el strings.Builder para contruir las lineas y luego imprimirlas de una sola vez
	spaces := centerLine / 2    //Es necesario calcular antes de los loop, para evitar gastar ciclos en recalcularlo en cada uno de los loops

	// Se procede a contruir la parte superior del romboide
	for i := 1; i <= centerLine; i += 2 {
		builder.Reset()
		builder.WriteString(strings.Repeat("  ", spaces)) //Se añade doble espaciado en las lineas de la parte superior para que la figura se parezca más al dibujo de las indicaciones
		spaces--

		for j := 0; j < i; j++ {
			if j > 0 {
				builder.WriteString(" ") //Se añade un espacio entre cada asterisco para que la figura se asemeje a la de las indicaciones
			}
			builder.WriteString("*")
		}
		fmt.Println(builder.String())
	}

	spaces = 1

	// Se construye la parte ingerior del romboide
	for i := centerLine - 2; i >= 1; i -= 2 {
		builder.Reset()
		builder.WriteString(strings.Repeat("  ", spaces)) //Se añaden dos espacios al inicio de las filas inferiores
		spaces++

		for j := 0; j < i; j++ {
			if j > 0 {
				builder.WriteString(" ") //Espacio entre cada asterisco
			}
			builder.WriteString("*")
		}
		fmt.Println(builder.String())
	}
}

func main() {
	var centerLine int
	fmt.Println("Introduzca el tamaño de la línea del centro: ")
	fmt.Scan(&centerLine)
	fmt.Println("Tu figura es:")
	printFigure(centerLine)
}
