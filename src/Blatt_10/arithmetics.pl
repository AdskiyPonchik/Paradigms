% Euklid
ggt(X, 0, X) :- 
    X > 0.  % basis: НОД(X, 0) = X, если X > 0

ggt(X, Y, G) :- 
    Y > 0,  
    R is X mod Y, 
    ggt(Y, R, G).

% soll sein?
gcd(X, Y, G) :-
    AbsX is abs(X),
    AbsY is abs(Y),
    ggt(AbsX, AbsY, G).

% ?- ggt(48, 18, G).
% G = 6.
%
% ?- ggt(56, 42, G).
% G = 14.
%
% ?- gcd(-48, 18, G).
% G = 6.



% Primitest
is_prime(P) :-
    P > 1,  % Zahl muss größer als 1 sein
    not(has_divisor(P, 2)).

% Funktion, die prüft, ob P einen Teiler im Bereich von 2 bis sqrt(P) hat
has_divisor(P, D) :-
    D * D =< P,  
    P mod D =:= 0.  

has_divisor(P, D) :-
    D * D =< P,
    D1 is D + 1,  % Nächsten Wert prüfen
    has_divisor(P, D1).
