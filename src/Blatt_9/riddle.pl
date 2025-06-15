neben(A, B, [A, B | _]).
neben(A, B, [B, A | _]).
neben(A, B, [_ | Rest]) :- neben(A, B, Rest).

solve(HeinoOwner) :-
    Pos1 = auto(F1, M1, S1, B1, C1),
    Pos2 = auto(F2, M2, S2, B2, C2),
    Pos3 = auto(F3, M3, S3, B3, C3),
    Pos4 = auto(F4, M4, S4, B4, C4),
    Pos5 = auto(F5, M5, S5, B5, C5),
    Autos = [Pos1, Pos2, Pos3, Pos4, Pos5],
    member(auto(rot, ferrari, _, _, _), Autos),
    member(auto(_, vw, _, _, madonna), Autos),
    member(auto(blau, bmw, muenchen, _, _), Autos),
    member(auto(braun, _, hamburg, _, _), Autos),
    member(auto(_, _, _, metzger, abba), Autos),
    member(auto(_, _, _, lehrer, beatles), Autos),
    member(auto(_, _, koeln, notar, _), Autos),
    member(auto(_, ford, _, schreiner, _), Autos),
    member(auto(gruen, _, hamburg, _, _), Autos),
    member(auto(_, _, berlin, baecker, _), Autos),
    member(auto(_, _, _, HeinoOwner, heino), Autos),
    neben(auto(_, bmw, _, _, _), auto(_, _, stuttgart, _, _), Autos),
    neben(auto(_, _, hamburg, _, _), auto(braun, _, _, _, _), Autos),
    neben(auto(blau, _, _, _, _), auto(_, smart, _, _, _), Autos),
    neben(auto(_, _, berlin, _, _), auto(_, _, _, baecker, _), Autos),
    neben(auto(_, _, _, _, beatles), auto(_, _, _, lehrer, _), Autos),
    Pos4 = auto(_, _, _, _, eminem),
    check_unique(Autos).

check_unique(Autos) :-
    extract_all(Autos, Farben, Marken, Staedte, Berufe, CDs),
    is_set(Farben),
    is_set(Marken), 
    is_set(Staedte),
    is_set(Berufe),
    is_set(CDs).

extract_all([], [], [], [], [], []).
extract_all([auto(F,M,S,B,C)|Rest], [F|Fs], [M|Ms], [S|Ss], [B|Bs], [C|Cs]) :-
    extract_all(Rest, Fs, Ms, Ss, Bs, Cs).

is_set([]).
is_set([H|T]) :- \+ member(H, T), is_set(T).

test_solve :-
    write('Teste Basis-Constraints...'), nl,
    Autos = [auto(F1,M1,S1,B1,C1), auto(F2,M2,S2,B2,C2), 
             auto(F3,M3,S3,B3,C3), auto(F4,M4,S4,B4,C4), auto(F5,M5,S5,B5,C5)],
    member(auto(rot, ferrari, _, _, _), Autos),
    member(auto(blau, bmw, muenchen, _, _), Autos),
    member(auto(_, _, _, _, eminem), Autos),
    write('Basis-Constraints erfuellt!'), nl,
    write('Autos: '), write(Autos), nl.

main :-
    ( solve(Beruf) ->
        write(Beruf), nl
    ; 
        write('Keine Loesung gefunden.'), nl
    ).

:- initialization(main).
