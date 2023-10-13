%**************************************************%
%Práctica Prolog
%Autor: Josué Rodriguez S. Octubre 2023
%**************************************************%


% -------------------------------------------------- %
% Ejercicio 1) Defina sumlist(L, S) que es verdadero si S es la suma de los elementos de L.

% Base:
% La suma de una lista vacía es 0.
sumlist([], 0).

% Recursión:
% La suma de una lista no vacía es la suma del primer elemento de la lista y la suma del Tail de la lista.
sumlist([X|Xs], S) :-
    sumlist(Xs, S1),
    S is X + S1.


% -------------------------------------------------- %
% Ejercicio 2) Defina la relación subconj(S, S1), donde S y S1 son listas representando conjuntos, que es verdadera si S1 es subconjunto de S.

% Base:
% Un conjunto vacío es subconjunto de cualquier conjunto.
subconj(_, []).

% Recursión:
% Un conjunto no vacío es subconjunto de otro conjunto si el primer elemento del conjunto está en el otro conjunto y el Tail del conjunto es subconjunto del otro conjunto.
subconj(S, [X|S1]) :-
    member(X, S),
    subconj(S, S1).


% -------------------------------------------------- %
% Ejercicio 3) Defina la función aplanar(L,L2). 
% Esta función recibe una lista con múltiples listas anidadas como elementos otra lista que contendría los mismos elementos de manera lineal (sin listas). 

% Base: 
% Si la lista original está vacía, la lista aplanada es también vacía.
aplanar([], []).

% Caso recursivo 1:
% Aplanar una lista que tiene una cabeza que es una lista.
aplanar([Heap|Tail], L2) :-
    is_list(Heap),
    aplanar(Heap, FlatHeap), 
    aplanar(Tail, FlatTail), 
    append(FlatHeap, FlatTail, L2). 

% Caso recursivo 2: 
% Aplanar una lista que tiene una cabeza que no es una lista.
aplanar([Heap|Tail], [Heap|FlatTail]) :-
    \+ is_list(Heap),
    aplanar(Tail, FlatTail). 


% -------------------------------------------------- %
% Ejercicio 4) Defina un predicado llamado partir(Lista, Umbral, Menores, Mayores) 
% para dividir una lista respecto un umbral dado, dejando los valores menores a la izquierda y los mayores a la derecha. 
% Por ejemplo, el resultado de partir la lista [2,7,4,8,9,1] respecto al umbral 6 serían las listas [2,4,1] y [7,8,9].

% Base:
% Partir una lista vacía respecto a un umbral da dos listas vacías.
partir([], _, [], []).

% Caso recursivo 1:
% La cabeza de la lista es menor o igual al umbral.
partir([Valor|Valores], Umbral, [Valor|Ms], Ls) :-
    Valor =< Umbral,
    partir(Valores, Umbral, Ms, Ls).

% Caso recursivo 2:
% La cabeza de la lista es mayor al umbral.
partir([Valor|Valores], Umbral, Ms, [Valor|Ls]) :-
    Valor > Umbral,
    partir(Valores, Umbral, Ms, Ls).

% -------------------------------------------------- %
% Ejercicio 5) Implemente un predicado que, a partir de una lista de cadenas string, 
% filtre aquellas que contengan una subcadena que el usuario indique en otro argumento.

% Base:
% Filtrar una lista vacía respecto a una subcadena da una lista vacía.
sub_cadenas(_, [], []).

% Caso recursivo 1:
% Comprobar si una cadena contiene la subcadena.
sub_cadenas(Subcadena, [Cadena|Tail], [Cadena|FiltradasTail]) :-
    sub_atom(Cadena, _, _, _, Subcadena),
    sub_cadenas(Subcadena, Tail, FiltradasTail).

% Caso recursivo 2:
% Filtrar cadenas que no contienen la subcadena.
sub_cadenas(Subcadena, [_|Tail], Filtradas) :-
    sub_cadenas(Subcadena, Tail, Filtradas).

% NOTA: Desde mi computador no pude correr sub_cadenas("la", ["la casa", "el perro", "pintado la cerca"], Filtradas). 
% Me daba el siguiente error: uncaught exception: error(type_error(atom,[108,97,32,99,97,115,97]),sub_atom/5)
% 
% Sin embargo, si corría la linea con comillas simples, 
% si funcionaba: sub_cadenas('la', ["la casa", "el perro", "pintado la cerca"], Filtradas).
% el resultado era: Filtradas = ["la casa", "pintado la cerca"]














