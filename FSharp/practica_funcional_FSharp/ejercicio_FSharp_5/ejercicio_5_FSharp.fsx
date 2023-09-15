//Ejercicio 5 de la practica funcional de FSharp
//Autor: Josué Rodriguez S. Septiembre 2023

//Specify the maze as a list of tuples (x,y) where x is the case number and y is the list of cases that can be reached from x
//With a total of 36 cases, the maze is a 6x6 grid
type Maze = (int * int list) list
let graphMaze : Maze = [
                                    (1,[7]);          //Case 1 can reach case 7
                                    (2,[3;8]);        //Case 2 can reach cases 3 and 8          //also have access to the start
                                    (3,[2;4;9]);      //Case 3 can reach cases 2, 4 and 9
                                    (4,[3;10]);       //Case 4 can reach cases 3 and 10
                                    (5,[6;11]);       //Case 5 can reach cases 6 and 11
                                    (6,[5]);          //Case 6 can reach case 5
                                    (7,[1;13]);       //Case 7 can reach cases 1 and 13
                                    (8,[2;9]);        //Case 8 can reach cases 2 and 9
                                    (9,[3;8]);        //Case 9 can reach cases 3 and 8
                                    (10,[4;16]);      //Case 10 can reach cases 4 and 16
                                    (11,[5;17]);      //Case 11 can reach cases 5 and 17
                                    (12,[18]);        //Case 12 can reach case 18
                                    (13,[7;14]);      //Case 13 can reach cases 7 and 14
                                    (14,[13;15;20]);  //Case 14 can reach cases 13, 15 and 20
                                    (15,[14;21]);     //Case 15 can reach cases 14 and 21
                                    (16,[10;22]);     //Case 16 can reach cases 10 and 22
                                    (17,[11;23]);     //Case 17 can reach cases 11 and 23
                                    (18,[12;24]);     //Case 18 can reach cases 12 and 24
                                    (19,[25]);        //Case 19 can reach case 25
                                    (20,[14;26]);     //Case 20 can reach cases 14 and 26
                                    (21,[15;22]);     //Case 21 can reach cases 15 and 22
                                    (22,[16;21]);     //Case 22 can reach cases 16 and 21
                                    (23,[17;29]);     //Case 23 can reach cases 17 and 29  
                                    (24,[18;30]);     //Case 24 can reach cases 18 and 30
                                    (25,[19;31]);     //Case 25 can reach cases 19 and 31
                                    (26,[20;27]);     //Case 26 can reach cases 20 and 27
                                    (27,[26;28]);     //Case 27 can reach cases 26 and 28
                                    (28,[27;29;34]);  //Case 28 can reach cases 27, 29 and 34
                                    (29,[23;28]);     //Case 29 can reach cases 23 and 28
                                    (30,[24;36]);     //Case 30 can reach cases 24 and 36
                                    (31,[25;32]);     //Case 31 can reach cases 25 and 32
                                    (32,[31;33]);     //Case 32 can reach cases 31 and 33       //Also have access to the end
                                    (33,[32;34]);     //Case 33 can reach cases 32 and 34
                                    (34,[28;33;35]);  //Case 34 can reach cases 28, 33 and 35
                                    (35,[34;36]);     //Case 35 can reach cases 34 and 36
                                    (36,[35;30]);     //Case 36 can reach cases 35 and 30
                        ]
//The start and end cases are 2 and 32 respectively
//The Expected Path of the Labyrinth should be 2,3,4,10,16,22,21,15,14,20,26,27,28,34,33,32

//Function found all possible paths using DFS
let findAllPathsDFS (graph: Maze) start endCase =
    let rec dfs path currentCase =
        if currentCase = endCase then
            [List.rev (currentCase::path)]  // Return the path as a list
        else
            match List.tryFind (fun (case, neighbors) -> case = currentCase) graph with
            | Some (_, neighbors) ->
                let validNeighbors = List.filter (fun c -> not (List.contains c path)) neighbors
                List.collect (dfs (currentCase::path)) validNeighbors  // Collect the paths from valid neighbors
            | None -> []

    dfs [] start

//Function to print all the paths found
let printPaths paths =
    paths |> List.iter (fun path ->
        printfn "Path found: %A" path
    )

//Call the function with the start and end cases
let allPaths = findAllPathsDFS graphMaze 2 32

// Print the found paths
printPaths allPaths

//Function to find the shortest path using BFS
let findShortestPathBFS (graph: Maze) start endCase =
    let rec bfs queue visited =
        match queue with
        | [] -> None // No path found
        | (currentCase, path) :: rest when currentCase = endCase -> Some (List.rev (currentCase::path)) // Shortest path found
        | (currentCase, path) :: rest ->
            // Get neighbors of the current case that haven't been visited
            match List.tryFind (fun (case, _) -> case = currentCase) graph with
            | Some (_, neighbors) ->
                let unvisitedNeighbors =
                    neighbors
                    |> List.filter (fun c -> not (List.contains c visited))
                    |> List.map (fun c -> (c, currentCase::path))
                let newQueue = rest @ unvisitedNeighbors
                bfs newQueue (currentCase :: visited)
            | None -> None // Invalid case, return None

    bfs [(start, [])] []

// Call the function with the start and end cases
match findShortestPathBFS graphMaze 2 32 with
| Some shortestPath -> printfn "Shortest path: %A" shortestPath
| None -> printfn "No path found"

(*
//En esta parte del codigo se puede descomentar para ver todos los posibles caminos siempre y cuando no haya paredes
//Maze case with no walls
let noWall: Maze =[
                        (1,[2;7]);
                        (2,[1;3;8]);
                        (3,[2;4;9]);
                        (4,[3;5;10]);
                        (5,[4;6;11]);
                        (6,[5;12]);
                        (7,[1;8;13]);
                        (8,[2;7;9]);
                        (9,[3;8;10]);
                        (10,[4;9;11]);
                        (11,[5;10;12]);
                        (12,[6;11;18]);
                        (13,[7;14;19]);
                        (14,[13;15;20]);
                        (15,[14;16;21]);
                        (16,[15;17;22]);
                        (17,[16;18;23]);
                        (18,[12;17;24]);
                        (19,[13;20;25]);
                        (20,[14;19;21]);
                        (21,[15;20;22]);
                        (22,[16;21;23]);
                        (23,[17;22;24]);
                        (24,[18;23;30]);
                        (25,[19;26;31]);
                        (26,[25;27;32]);
                        (27,[26;28;33]);
                        (28,[27;29;34]);
                        (29,[28;30;35]);
                        (30,[24;29;36]);
                        (31,[25;32]);
                        (32,[26;31;33]);
                        (33,[27;32;34]);
                        (34,[28;33;35]);
                        (35,[29;34;36]);
                        (36,[30;35]);
]

//Found all path with no Walls
let allPathsNoWall = findAllPathsDFS noWall 2 32

// Print the found paths
printPaths allPathsNoWall

//Found shortest path with no Walls
match findShortestPathBFS noWall 2 32 with
| Some shortestPath -> printfn "Shortest path: %A" shortestPath
| None -> printfn "No path found"*)



