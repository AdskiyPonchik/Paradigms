mann(hans).
mann(karl).
mann(klaus).
mann(paul).
mann(otto).
mann(erich).

frau(anna).
frau(maria).
frau(ina).
frau(lisa).
frau(helga).
frau(berta).

% vater / mutter zusammenhängend
vater(hans, klaus).
vater(hans, maria).
vater(karl, paul).
vater(karl, lisa).
vater(otto, hans).
vater(erich, anna).

mutter(anna, klaus).
mutter(anna, maria).
mutter(ina, paul).
mutter(ina, lisa).
mutter(helga, hans).
mutter(berta, anna).

% geschwister 
geschwister(X, Y) :-
    vater(V, X), vater(V, Y),
    mutter(M, X), mutter(M, Y),
    X \= Y.

% großeltern 
grossvater(X, Y) :-
    vater(X, Z), (vater(Z, Y); mutter(Z, Y)).

grossmutter(X, Y) :-
    mutter(X, Z), (vater(Z, Y); mutter(Z, Y)).

% onkel / tante
onkel(X, Y) :-
    (vater(V, Y); mutter(V, Y)),
    geschwister(X, V),
    mann(X).

tante(X, Y) :-
    (vater(V, Y); mutter(V, Y)),
    geschwister(X, V),
    frau(X).

% cousin / cousine
cousin(X, Y) :-
    (vater(V, Y); mutter(V, Y)),
    geschwister(V, G),
    vater(G, X),
    mann(X).

cousine(X, Y) :-
    (vater(V, Y); mutter(V, Y)),
    geschwister(V, G),
    mutter(G, X),
    frau(X).

:- initialization(main).

main :-
    nl, write('1) Vater von Klaus: '),
    (vater(X1, klaus) -> write(X1), nl ; write('nichts'), nl),

    nl, write('2) Geschwister von Maria:'), nl,
    (geschwister(maria, X2), write('- '), write(X2), nl, fail ; true),

    nl, write('3) Ist Hans der Grossvater von Lisa? '),
    (grossvater(hans, lisa) -> write('JA') ; write('NEIN')), nl,

    nl, write('4) Onkel von Paul: '),
    (onkel(X4, paul) -> write(X4), nl ; write('Keine Antwort'), nl),

    nl, write('5) Cousins von Nina:'), nl,
    (cousin(nina, X5), write('- '), write(X5), nl, fail ; write('undefinierte Person'), nl).
