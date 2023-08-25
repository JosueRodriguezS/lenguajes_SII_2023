package main

import (
	"fmt"
)

// Funcion rorateRight para rotar los valores del array hacia la derecha, recibe el puntero del array de tamaño no definido y el numero de posiciones a rotar
func rotateRight(array *[]int, num int) {
	//Recorremos el array tantas veces como posiciones a rotar
	for i := 0; i < num; i++ {
		//guardamos el ultimo valor del array
		last := (*array)[len(*array)-1]
		//Recorremos el array de derecha a izquierda
		for j := len(*array) - 1; j > 0; j-- {
			//Guardamos el valor de la posicion anterior en la posicion actual
			(*array)[j] = (*array)[j-1]
		}
		//Guardamos el ultimo valor en la primera posicion
		(*array)[0] = last
	}
}

// Funcion rorateLeft para rotar los valores del array hacia la izquierda, recibe el puntero del array de tamaño no definido y el numero de posiciones a rotar
func rorateLeft(array *[]int, num int) {
	//Recorremos el array tantas veces como posiciones a rotar
	for i := 0; i < num; i++ {
		//Guardamos el primer valor del array
		first := (*array)[0]
		//Recorremos el array de izquierda a derecha
		for j := 0; j < len(*array)-1; j++ {
			//guardamos el valor de la posicion siguiente en la posicion actual
			(*array)[j] = (*array)[j+1]
		}
		//Guardamos el primer valor en la ultima posicion
		(*array)[len(*array)-1] = first
	}
}

func rotateArray(array *[]int, direction int, num int) {
	//Si la direccion es 0 llamamos a la funcion rotateLeft
	if direction == 0 {
		rorateLeft(array, num)
	} else {
		//Si la direccion es 1 llamamos a la funcion rotateRight
		rotateRight(array, num)
	}
}

func main() {

	var array []int
	//Rellenamos el array con los valores del 1 al 10
	for i := 1; i <= 10; i++ {
		array = append(array, i)
	}

	fmt.Println("Array original: ", array)
	//rotamos el array 3 posiciones a la izquierda
	rotateArray(&array, 0, 3)
	//imprimimos el array por pantalla
	fmt.Println("Array rotado 3 posiciones a la izquierda: ", array)
	//rotamos el array 3 posiciones a la derecha
	rotateArray(&array, 1, 3)
	fmt.Println("Array rotado 3 posiciones a la derecha: ", array)
}
