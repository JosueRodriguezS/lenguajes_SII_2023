package main

import (
	"fmt"
	"sort" //para ordenar, librería utilizada en el ejercicio de imperativo 2 go
)

type producto struct {
	nombre   string
	cantidad int
	precio   int
}
type listaProductos []producto

var lProductos listaProductos

const existenciaMinima int = 10 //la existencia mínima es el número mínimo debajo de el cual se deben tomar eventuales desiciones

func (l *listaProductos) agregarProducto(nombre string, cantidad int, precio int) {
	//Se busca si el producto ya existe dentro de la lista
	for i, prod := range *l {
		if prod.nombre == nombre {
			// Actualizar la cantidad y el precio si el producto ya existe
			(*l)[i].cantidad += cantidad
			if prod.precio != precio {
				(*l)[i].precio = precio
			}
			return
		}
	}

	*l = append(*l, producto{nombre: nombre, cantidad: cantidad, precio: precio})
}

// función adicional que reciba una cantidad potencialmente infinita de productos previamente creados y los agregue a la lista
func (l *listaProductos) agregarProductosVariados(productos ...producto) {
	for _, prod := range productos {
		l.agregarProducto(prod.nombre, prod.cantidad, prod.precio)
	}
}

func (l *listaProductos) buscarProducto(nombre string) (*producto, int) { //el retorno es el producto y un 1 si no existe
	var codigoErr = 0
	var resultado *producto
	var i int

	for i = 0; i < len(*l); i++ {
		if (*l)[i].nombre == nombre {
			resultado = &(*l)[i]
			break
		}
	}

	if i == len(*l) {
		codigoErr = 1 //No se encontra el producto
	}

	return resultado, codigoErr
}

func (l *listaProductos) venderProducto(nombre string, cantidad int) {
	prod, err := l.buscarProducto(nombre)
	if err != 1 {
		if prod.cantidad >= cantidad {
			prod.cantidad -= cantidad
			if prod.cantidad <= 0 {
				*l = append((*l)[:err], (*l)[err+1:]...)
				fmt.Println("Producto", nombre, "agotado y eliminado de la lista")
			}
		} else {
			fmt.Println("No hay suficiente cantidad de", nombre)
		}
	} else {
		fmt.Println("Producto no encontrado o error:", err)
	}
}

//haga una función para a partir del nombre del producto, se pueda modificar el precio del mismo Pero utilizando la función buscarProducto MODIFICADA PREVIAMENTE

func llenarDatos() {
	lProductos.agregarProducto("arroz", 15, 2500)
	lProductos.agregarProducto("frijoles", 4, 2000)
	lProductos.agregarProducto("leche", 8, 1200)
	lProductos.agregarProducto("café", 12, 4500)
	lProductos.agregarProducto("arroz", 2, 3500)

}

func (l *listaProductos) listarProductosMínimos(minExistencia int) listaProductos {
	newSlice := make(listaProductos, 0)

	for _, prod := range *l {
		if prod.cantidad <= minExistencia {
			newSlice = append(newSlice, prod)
		}
	}

	return newSlice
}

//Region practica_imperativo2_golang
//En esta region se encuentras las funciuones que se piden en el ejercicio, la funcion aumentarInvertarioDeMinimos(minExistencia) es la que se pide en el punto a
//y la funcion ordenarPorCampo(campo string) es la que se pide en el punto b

func (l *listaProductos) aumentarInvertarioDeMinimos(minExistencia int) {
	productosMinimos := l.listarProductosMínimos(minExistencia)
	for _, prod := range productosMinimos {
		cantidadAComprar := minExistencia - prod.cantidad
		l.agregarProducto(prod.nombre, cantidadAComprar, prod.precio)
	}
}

func (l *listaProductos) ordenarPorCampo(campo string) {
	switch campo {
	case "nombre":
		sort.Slice(*l, func(i, j int) bool { return (*l)[i].nombre < (*l)[j].nombre })
	case "cantidad":
		sort.Slice(*l, func(i, j int) bool { return (*l)[i].cantidad < (*l)[j].cantidad })
	case "precio":
		sort.Slice(*l, func(i, j int) bool { return (*l)[i].precio < (*l)[j].precio })
	default:
		fmt.Println("El campo", campo, "no es valido")
	}
}

//endRegion practica_imperativo2_golang

func main() {

	llenarDatos()
	fmt.Println(lProductos)
	producto1 := producto{"producto1", 5, 100}
	producto2 := producto{"producto2", 3, 150}
	producto3 := producto{"producto3", 2, 120}
	producto4 := producto{"zProducto", 30, 1500}
	producto5 := producto{"xProducto", 31, 1501}
	producto6 := producto{"yProducto", 32, 1502}
	lProductos.agregarProductosVariados(producto1, producto2, producto3, producto4, producto5, producto6)

	//venda productos
	lProductos.venderProducto("arroz", 2)
	lProductos.venderProducto("arroz", 3)
	lProductos.venderProducto("arroz", 12)
	lProductos.venderProducto("frijoles", 4)
	lProductos.venderProducto("frijoles", 4)
	fmt.Println(lProductos)

	//Cantidad minima de productos
	productosMinimos := lProductos.listarProductosMínimos(existenciaMinima)
	fmt.Println(productosMinimos)

	fmt.Println("¡		                                 ¡")
	fmt.Println("Punto a y b del ejercicio imperativo 2 go")
	fmt.Println("¡		                                 ¡")

	//Aumentar inventario de productos minimos
	lProductos.aumentarInvertarioDeMinimos(existenciaMinima)
	fmt.Println("Después de aumentar el inventario de los productos minimos:")
	fmt.Println(lProductos)

	//Orderar por nombre
	lProductos.ordenarPorCampo("nombre")
	fmt.Println("Ordenado por nombre:")
	fmt.Println(lProductos)

	//Orderar por cantidad
	lProductos.ordenarPorCampo("cantidad")
	fmt.Println("Ordenado por cantidad:")
	fmt.Println(lProductos)

	//Orderar por precio
	lProductos.ordenarPorCampo("precio")
	fmt.Println("Ordenado por precio:")
	fmt.Println(lProductos)
}
