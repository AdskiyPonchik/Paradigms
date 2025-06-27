% 1. filter(Liste, Element, Ausgabe)
filter([], _, []).
filter([H|T], Element, [H|FilteredTail]) :-
    H = Element,
    filter(T, Element, FilteredTail).

filter([H|T], Element, FilteredTail) :-
    H \= Element,
    filter(T, Element, FilteredTail).

% 2. rotate_left(Liste, Ergebnis)
rotate_left([], []).
rotate_left([H|T], Result) :-
    append(T, [H], Result).

% 3. isNearlyEqual(List1, List2)
isNearlyEqual(List1, List2) :-
    remove_first_last(List1, Middle1),
    remove_first_last(List2, Middle2),
    Middle1 = Middle2.

remove_first_last([], []).
remove_first_last([_], []).
remove_first_last([_|T], Middle) :-
    reverse(T, [_|Rev]),
    reverse(Rev, Middle).
