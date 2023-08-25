package main

import (
	"fmt"
)

// Struct para guardar los datos de los zapatos, modelo, precio, talla del 34 al 44 y el stock de cada talla
type calzado struct {
	modelo string
	precio float64
	talla  int
	stock  int
}

// Función venderCalzado, recibe un puntero a un modelo de calzado y la cantidad a vender, devuelve un mensaje indicando si se pudo vender o no
func venderCalzado(c *calzado, cantidad int) {
	if c.talla > 34 || c.talla < 44 {
		if c.stock < cantidad {
			fmt.Println("No se pudo vender, no hay suficiente stock del zapato: ", c.modelo, c.talla)
		} else {
			c.stock -= cantidad
			fmt.Println("Se vendieron ", cantidad, " pares del zapato: ", c.modelo, c.talla)
		}
	} else {
		fmt.Println("No se pudo vender, la talla del zapato: ", c.modelo, c.talla, " no es valida")
	}
}

func main() {
	inventario := []calzado{
		//Marca, Precio, Talla, Stock.
		{"Nike", 100.0, 34, 10},
		{"Nike", 100.0, 35, 10},
		{"Nike", 100.0, 36, 10},
		{"Adidas", 100.0, 37, 10},
		{"Adidas", 100.0, 38, 10},
		{"Adidas", 100.0, 39, 10},
		{"Puma", 100.0, 40, 10},
		{"Puma", 100.0, 41, 10},
		{"Puma", 100.0, 42, 10},
		{"Puma", 100.0, 43, 10},
		{"Jordan", 100.0, 44, 10},
		{"Jordan", 100.0, 35, 0},
		{"Jordan", 100.0, 36, 0},
		{"Test", 100.0, 45, 0},
	}

	//Realizar ventas de calzado
	venderCalzado(&inventario[0], 2)
	venderCalzado(&inventario[1], 4)
	venderCalzado(&inventario[2], 3)
	venderCalzado(&inventario[3], 5)
	venderCalzado(&inventario[4], 8)
	venderCalzado(&inventario[5], 1)
	venderCalzado(&inventario[6], 10)
	venderCalzado(&inventario[7], 11)
	venderCalzado(&inventario[8], 4)
	venderCalzado(&inventario[9], 5)
	venderCalzado(&inventario[10], 6)
	venderCalzado(&inventario[11], 20)
	venderCalzado(&inventario[12], 2)

	fmt.Println("Inventario actualizado: ")
	for _, z := range inventario {
		fmt.Println(z)
	}
}
