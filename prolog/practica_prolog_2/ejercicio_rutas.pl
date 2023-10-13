%**************************************************%
%Ejercicio de rutas de prolog
%Autor: Josué Rodriguez S. Octubre 2023
%**************************************************%

%---Ejercicio 4 | Rutas---%

% Definir conexiones con pesos
conectado(a, d, 7).
conectado(d, e, 3).
conectado(e, f, 2).
conectado(i, c, 4).
conectado(d, f, 5).
conectado(a, e, 6).
conectado(c, e, 1).
conectado(i, d, 8).
conectado(b, e, 4).

% ruta(Inicio, Fin, Ruta, Peso)
%
% Toma cuatro argumentos: 
%   -Inicio: El punto de inicio de la ruta.
%   -Fin: El punto final de la ruta.
%   -Ruta: La ruta desde el punto de inicio hasta el punto final.
%   -Peso: El peso de la ruta desde el punto de inicio hasta el punto final.
%
% Este predicado es verdadero si hay una ruta desde el punto de inicio 'Inicio' hasta el punto final 'Fin' con un peso de 'Peso' y la ruta es 'Ruta'.
% Utiliza el predicado 'ruta2' para encontrar la ruta y el peso.
ruta(Inicio, Fin, Ruta, Peso) :-
    ruta2(Inicio, Fin, [Inicio], Ruta, Peso).

% ruta2(Fin, Fin, Ruta, Ruta, 0)
% Este predicado es verdadero si se alcanza el punto final 'Fin' y la ruta es 'Ruta' con un peso de 0.
% Basicamente, es el caso base de la recursion.
ruta2(Fin, Fin, Ruta, Ruta, 0).

% ruta2(Inicio, Fin, Visitados, Ruta, Peso)
%
% Toma cinco argumentos:
%   -Inicio: El punto de inicio de la ruta.
%   -Fin: El punto final de la ruta.
%   -Visitados: Los puntos visitados en la ruta.
%   -Ruta: La ruta desde el punto de inicio hasta el punto final.
%   -Peso: El peso de la ruta desde el punto de inicio hasta el punto final.
%
% Este predicado es verdadero si hay una ruta desde el punto de inicio 'Inicio' hasta el punto final 'Fin' con un peso de 'Peso' y la ruta es 'Ruta'.
% Utiliza el predicado 'conectado' para encontrar el siguiente punto en la ruta y comprueba si no ha sido visitado antes.
ruta2(Inicio, Fin, Visitados, Ruta, Peso) :-
    conectado(Inicio, Siguiente, PesoArista),
    \+ member(Siguiente, Visitados),
    append(Visitados, [Siguiente], NuevosVisitados),  
    ruta2(Siguiente, Fin, NuevosVisitados, Ruta, NuevaPeso),
    Peso is NuevaPeso + PesoArista.

% ruta_mas_corta(Inicio, Fin, Ruta, Peso)
%
% Toma cuatro argumentos:
%   -Inicio: El punto de inicio de la ruta.
%   -Fin: El punto final de la ruta.
%   -Ruta: La ruta desde el punto de inicio hasta el punto final.
%   -Peso: El peso de la ruta desde el punto de inicio hasta el punto final.
%
% Este predicado es verdadero si hay una ruta desde el punto de inicio 'Inicio' hasta el punto final 'Fin' con un peso de 'Peso' y la ruta es 'Ruta'.
% Utiliza el predicado 'findall' para encontrar todas las rutas posibles y sus pesos utilizando el predicado 'ruta'.
% Luego utiliza el predicado 'min_peso' para encontrar la ruta con el peso minimo.
ruta_mas_corta(Inicio, Fin, Ruta, Peso) :-
    findall([R, P], ruta(Inicio, Fin, R, P), Rutas),  
    min_peso(Rutas, Ruta, Peso).  

% min_peso([[Ruta, Peso]], Ruta, Peso)
% Este predicado es verdadero si solo hay una ruta con un peso de 'Peso' y la ruta es 'Ruta'.
% Basicamente, es el caso base de la recursion.
min_peso([[Ruta, Peso]], Ruta, Peso).

% min_peso([[R1, P1] | Resto], Ruta, Peso)
% 
% Toma tres argumentos:
%   -[[R1, P1] | Resto]: La lista de rutas y pesos.
%   -Ruta: La ruta con el peso minimo.
%   -Peso: El peso minimo.
%
%Este predicado sirve para encontrar la ruta con el peso minimo.
min_peso([[R1, P1] | Resto], Ruta, Peso) :-
    min_peso(Resto, R2, P2),    (P1 < P2 -> Ruta = R1, Peso = P1; Ruta = R2, Peso = P2).

% Para probar el programa, ejecuta el siguiente comando:
%       ruta(i, f, Ruta, Peso). a
%       ruta_mas_corta(i, f, Ruta, Peso). a
%       ruta(i, f, Ruta, Peso), ruta_mas_corta(i, f, Ruta, Peso). a
