slice(L, I, J, R) :-
    length(Prefix, I),         % Generiere eine Präfixliste der Länge I
    append(Prefix, Rest, L),   % L = Prefix + Rest
    K is J - I + 1,            % Länge der gesuchten Teilliste
    length(R, K),              % R soll genau K Elemente haben
    append(R, _, Rest).        % Rest = R + Suffix (Suffix ignoriert)

range(I, J,[I]) :- 
    I =:= J.  % Wenn I gleich J ist, dann besteht die Liste nur aus einer Zahl I.

range(I, J, [I|L]) :- 
    I < J,  % Wenn I kleiner als J ist, wird die Rekursion fortgesetzt;
    I1 is I + 1,  % Erhöhen I um 1.
    range(I1, J, L).  % Rekursiver Aufruf des Bereichs von I1.
