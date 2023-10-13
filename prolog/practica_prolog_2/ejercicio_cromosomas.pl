%**************************************************%
%Ejercicio de cromosomas de prolog
%Autor: Josué Rodriguez S. Octubre 2023
%**************************************************%

% Hechos de diez personas. Incluye nombres, apellidos y cromosomas ficticios(0, 1).
persona(jon, snow, [0, 0, 1, 1, 1, 1, 0, 0, 1, 1]).
persona(daenerys, targaryen, [1, 1, 1, 0, 0, 0, 1, 0, 0, 1]).
persona(harry, potter, [0, 1, 0, 1, 1, 1, 0, 1, 1, 0]).
persona(hermione, granger, [1, 0, 0, 1, 0, 0, 1, 0, 0, 1]).
persona(tony, stark, [0, 0, 1, 1, 0, 1, 0, 0, 0, 1]).
persona(bruce, wayne, [0, 1, 1, 0, 1, 0, 1, 1, 0, 0]).
persona(clark, kent, [1, 1, 0, 0, 1, 0, 0, 1, 1, 1]).
persona(peter, parker, [0, 1, 1, 0, 0, 1, 0, 1, 1, 1]).
persona(luke, skywalker, [1, 0, 1, 1, 0, 0, 1, 1, 0, 0]).
persona(leia, organa, [0, 1, 0, 0, 1, 1, 1, 0, 0, 1]).

%---Ejercicio 4 | Cromosomas---%

% Predicado para calcular el porcentaje de similitud entre una muestra y una persona
%
% Este predicado calcula el porcentaje de similitud entre una muestra de un cromosoma dado y el cromosoma de una persona.
% Toma tres argumentos:
% - Muestra: es el cromosoma (por ejemplo, [1, 0, 1, 0, 0, 1, 0, 1, 0, 0]).
% - Persona: el nombre de una persona.
% - Porcentaje: el porcentaje de similitud entre la muestra y el cromosoma de la persona.
calcular_porcentaje_similitud(Muestra, Persona, Porcentaje) :-
    persona(Persona, _, CromosomaPersona),
    calcula_distancia_hamming(Muestra, CromosomaPersona, Distancia),
    length(Muestra, Longitud),
    Porcentaje is 100 * (1 - (Distancia / Longitud)).

% Predicado para calcular la distancia de Hamming entre dos listas de bits
% 
% Este predicado calcula la distancia de Hamming entre dos listas de bits.
% Toma tres argumentos:
% - Lista1: una lista de bits (por ejemplo, [1, 0, 1, 0, 0, 1, 0, 1, 0, 0]).
% - Lista2: una lista de bits.
% - Distancia: la distancia de Hamming entre las dos listas.
calcula_distancia_hamming([], [], 0).
calcula_distancia_hamming([H1|T1], [H2|T2], Distancia) :-
    calcula_distancia_hamming(T1, T2, DistanciaRestante),
    (H1 = H2 -> Distancia is DistanciaRestante ; Distancia is DistanciaRestante + 1).

% Predicado para encontrar el máximo porcentaje de similitud entre una lista de porcentajes
% 
% Este predicado encuentra el máximo porcentaje de similitud entre una lista de porcentajes.
% Toma dos argumentos:
% - Lista: una lista de porcentajes (por ejemplo, [[jon, 40.0], [daenerys, 70.0], [harry, 20.0], [hermione, 80.0], [tony, 60.0], [bruce, 50.0], [clark, 20.0], [peter, 20.0], [luke, 90.0], [leia, 30.0]]).
% - Max: el máximo porcentaje de similitud entre la lista de porcentajes.
max_porcentaje([], [_, 0.0]). 
max_porcentaje([[Persona, Porcentaje]|T], Max) :-
    max_porcentaje(T, [OtraPersona, OtraPorcentaje]),
    (Porcentaje >= OtraPorcentaje -> Max = [Persona, Porcentaje] ; Max = [OtraPersona, OtraPorcentaje]).

% Predicado para encontrar la persona más similar a una muestra y retornar su nombre y porcentaje de similitud
%
% Este predicado encuentra la persona más similar a una muestra y retorna su nombre y porcentaje de similitud.
% Toma tres argumentos:
% - Muestra: es el cromosoma (por ejemplo, [1, 0, 1, 0, 0, 1, 0, 1, 0, 0]).
% - PersonaMasSimilar: el nombre de la persona más similar a la muestra.
% - PorcentajeMasAlto: el porcentaje de similitud entre la muestra y el cromosoma de la persona más similar.
%
% Este predicado es el corazón del ejercicio 4. Es el que se debe llamar para encontrar la persona más similar a una muestra.
%
% Un ejemplo de uso sería:
%           encontrar_persona_mas_similar([1, 0, 1, 1, 0, 0, 1, 0, 0, 0], PersonaMasSimilar, PorcentajeMasAlto).
%
% Que retornaría:
%           PersonaMasSimilar = luke
%           PorcentajeMasAlto = 90.0
encontrar_persona_mas_similar(Muestra, PersonaMasSimilar, PorcentajeMasAlto) :-
    findall([Persona, Porcentaje], calcular_porcentaje_similitud(Muestra, Persona, Porcentaje), Resultados),
    max_porcentaje(Resultados, [PersonaMasSimilar, PorcentajeMasAlto]).

%***************************************************************************************************************************************%
% Apartir de aquí se encuentra algunos predicados que permiten validar el correcto funcionamiento de encontrar_persona_mas_similar.
% Se puede describir como un pequeño ejercicio de prueba.
%
% Predicado para obtener todos los porcentajes de similitud para una muestra
%
% Este predicado toma una muestra (lista de cromosomas) y devuelve una lista de pares [Persona, Porcentaje] que representan la similitud entre la muestra y cada persona en la base de datos.
%
% Ejemplo de uso:
%           obtener_todos_porcentajes([1, 0, 1, 1, 0, 0, 1, 0, 0, 0], ListaDePorcentajes).
obtener_todos_porcentajes(Muestra, ListaDePorcentajes) :-
    findall([Persona, Porcentaje], calcular_porcentaje_similitud(Muestra, Persona, Porcentaje), ListaDePorcentajes).

% Basicamente para la comprobación se puede correr la siguiente consulta:
%            encontrar_persona_mas_similar([1, 0, 1, 1, 0, 0, 1, 0, 0, 0], PersonaMasSimilar, PorcentajeMasAlto), obtener_todos_porcentajes([1, 0, 1, 1, 0, 0, 1, 0, 0, 0], ListaDePorcentajes).
%
% Que retornaría:
%           ListaDePorcentajes = [[jon,40.0],[daenerys,70.0],[harry,19.999999999999996],[hermione,80.0],[tony,60.0],[bruce,50.0],[clark,19.999999999999996],[peter,19.999999999999996],[luke,90.0],[leia,30.000000000000004]]
%           PersonaMasSimilar = luke
%           PorcentajeMasAlto = 90.0

% Otras posibles consultas son:
%           encontrar_persona_mas_similar([0, 0, 1, 1, 1, 1, 0, 0, 1, 1], PersonaMasSimilar, PorcentajeMasAlto), obtener_todos_porcentajes([0, 0, 1, 1, 1, 1, 0, 0, 1, 1], ListaDePorcentajes).
%           encontrar_persona_mas_similar([0, 1, 0, 0, 1, 1, 1, 0, 0, 1], PersonaMasSimilar, PorcentajeMasAlto), obtener_todos_porcentajes([0, 1, 0, 0, 1, 1, 1, 0, 0, 1], ListaDePorcentajes).