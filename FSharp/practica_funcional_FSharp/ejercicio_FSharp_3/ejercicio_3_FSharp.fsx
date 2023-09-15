//Ejercicio 3 de la practica funcional de FSharp
//Autor: Josué Rodriguez S. Septiembre 2023

//Function to obtain the n-th element of a list 
let nthElement (n: int) (list: int list) =
    let index = [0..(n)] //Build a list with the indexes of the list, this is necessary because F# does not have a function to obtain the index of a list
    let result = List.map (fun i ->
    //If the index is out of range, return 0
        match List.tryItem i list with
        | Some(x) -> x
        | None -> 0) index
    if n < List.length list then result.[n].ToString()
    else "false"

//Test cases based on the examples
let result1 = nthElement 2 [1; 2; 3; 4; 5] // [3]
let result2 = nthElement 3 [1; 2; 3; 4; 5] // [4]
let result3 = nthElement 6 [1; 2; 3; 4; 5] // [false]

printf("Ejemplos de las indicaciones\n")
printfn "Resultado 1: %A" result1
printfn "Resultado 2: %A" result2
printfn "Resultado 3: %A" result3

//Additional test cases
printf("\n")
printf("Ejemplos adicionales\n")
let result4 = nthElement 0 [1; 2; 3; 4; 5] // [1]
let result5 = nthElement 1 [1; 2; 3; 4; 5] // [2]
let result6 = nthElement 4 [1; 2; 3; 4; 5] // [5]
let result7 = nthElement 5 [1; 2; 3; 4; 5] // [false]

printfn "Resultado 4: %A" result4
printfn "Resultado 5: %A" result5
printfn "Resultado 6: %A" result6
printfn "Resultado 7: %A" result7