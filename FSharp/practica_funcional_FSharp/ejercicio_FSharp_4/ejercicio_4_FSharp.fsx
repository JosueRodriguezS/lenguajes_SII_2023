//Ejercicio 4 de la practica funcional de FSharp
//Autor: Josué Rodriguez S. Septiembre 2023

let element elem list =
    List.exists (fun x -> x = elem) list

//Semana2 Graph with weights
let weightGraph = [
            ("i", [("a", 9); ("b", 10)]);
            ("a", [("i", 4); ("c", 9); ("d", 4)]);
            ("b", [("i", 5); ("c", 5); ("d", 8)]);
            ("c", [("a", 4); ("b", 4); ("x", 1)]);
            ("d", [("a", 2); ("b", 3); ("f", 5)]);
            ("f", [("d", 8)]);
            ("x", [("c", 4)])
]

//Generate neightbors with weights
let rec weightedNeightbors node graph =
    match graph with
    | [] -> []
    | (head, neightbors)::rest -> 
        if head = node then
            neightbors
        else
            weightedNeightbors node rest

//Extend path considering weights
let extendPathUsingWeights(path, acumulativeWeight) graph = 
    List.filter
        (fun (r, p) -> r <> [])
        (List.map  (fun (node, weight) -> 
            if (element node (List.map fst path)) then ([], 0) 
            else ((node, weight)::path, acumulativeWeight + weight)) 
        (weightedNeightbors (fst (List.head path)) graph)) 

//Modified DFS using weights (uses extendPathUsingWeights function)
let rec prof2 ini fin grafo =
    let mutable camino_mas_corto = ([], System.Int32.MaxValue)  // ruta, peso_acumulado
    let rec prof_aux fin rutas grafo =
        if List.isEmpty rutas then
            let ruta, peso_total = camino_mas_corto
            (List.rev (List.map fst ruta), peso_total)
        else
            let ruta_actual, peso_actual = List.head rutas
            if (fst (List.head ruta_actual)) = fin && peso_actual < snd camino_mas_corto then
                camino_mas_corto <- (ruta_actual, peso_actual)
            prof_aux fin ((List.tail rutas) @ (extendPathUsingWeights (ruta_actual, peso_actual) grafo)) grafo
    prof_aux fin [([(ini, 0)], 0)] grafo

printf("Este es el ejemplo del grafo visto en clase con pesos al azar:\n")
//Call function for testing fuctionality
let path, totalWeight = prof2 "i" "x" weightGraph
//Print results of the path and total weight
printfn "Path: %A" path
printfn "Total Weight: %A" totalWeight
printfn ""

//Test with a graph with some minimun weights 1
printf
let WeightedGrapthTestMinimun = [
    ("i", [("a", 1); ("b", 8)]);
    ("a", [("i", 8); ("c", 1); ("d", 4)]);
    ("b", [("i", 5); ("c", 6); ("d", 1)]);
    ("c", [("a", 4); ("b", 4); ("x", 1)]);
    ("d", [("a", 4); ("b", 7); ("f", 1)]);
    ("f", [("d", 8)]);
    ("x", [("c", 4)])
]

printf("Este es el ejemplo del grafo visto en clase con algunos pesos minimos iguales a 1:\n")
//Call function for testing fuctionality
let pathTest, totalWeightTest = prof2 "i" "x" WeightedGrapthTestMinimun
//Print results of the path and total weight
printfn "Path: %A" pathTest
printfn "Total Weight: %A" totalWeightTest
printfn ""

//Test with a graph with some minimun weights of 10
let WeightedGrapthTestAll10 = [
    ("i", [("a", 10); ("b", 10)]);
    ("a", [("i", 10); ("c", 10); ("d", 10)]);
    ("b", [("i", 10); ("c", 10); ("d", 10)]);
    ("c", [("a", 10); ("b", 10); ("x", 10)]);
    ("d", [("a", 10); ("b", 10); ("f", 10)]);
    ("f", [("d", 10)]);
    ("x", [("c", 10)])
]

printf("Este es el ejemplo del grafo visto en clase con todos los pesos iguales a 10:\n")
//Call function for testing fuctionality
let pathTestAll10, totalWeightTestAll10 = prof2 "i" "x" WeightedGrapthTestAll10
//Print results of the path and total weight
printfn "Path: %A" pathTestAll10
printfn "Total Weight: %A" totalWeightTestAll10
printfn ""
