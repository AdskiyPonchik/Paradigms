:- use_module(library(clpfd)).

n_queens(N, Qs) :-
    length(Qs, N),              % Erstelle Liste mit N Elementen
    Qs ins 1..N,                % Jede Dame muss in Reihe 1 bis N stehen
    safe_queens(Qs).            % Stelle sicher, dass keine Damen sich angreifen

% Stelle sicher, dass alle Damen sicher sind
safe_queens([]).
safe_queens([Q|Qs]) :-
    safe_queens(Qs),
    no_attack(Q, Qs, 1).

% Stelle sicher, dass Dame Q keine anderen Damen angreift
no_attack(_, [], _).
no_attack(Q, [Q1|Qs], Dist) :-
    Q #\= Q1,                   % Nicht in derselben Reihe
    Q #\= Q1 + Dist,            % Nicht auf derselben Diagonale (/)
    Q #\= Q1 - Dist,            % Nicht auf derselben Diagonale (\)
    Dist1 is Dist + 1,
    no_attack(Q, Qs, Dist1).
