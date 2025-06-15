% Binärbaum mit Cut-Fail
% Definition: nil = leerer Baum, tree(K,L,R) = Knoten mit Schlüssel K, linkem Teilbaum L, rechtem Teilbaum R

% 1. contains(tree(K,L,R),X) - prüft, ob sich der Wert X im Binärbaum tree befindet
% Verwendet Cut-Fail für effizienten Abbruch bei erstem Treffer

contains(tree(K,_,_), X) :-
    K = X,
    !.  % Cut: Wenn gefunden, keine weiteren Alternativen prüfen

contains(tree(K,L,_), X) :-
    X < K,
    !,  % Cut: Wenn X kleiner als K, nur im linken Teilbaum suchen
    contains(L, X).

contains(tree(K,_,R), X) :-
    X > K,
    !,  % Cut: Wenn X größer als K, nur im rechten Teilbaum suchen
    contains(R, X).

contains(tree(_,_,_), _) :-
    fail.  % Fail: Wenn keiner der obigen Fälle zutrifft

% Basis: leerer Baum enthält keinen Wert
contains(nil, _) :-
    fail.

% 2. isSearchTree(tree(K,L,R)) - prüft, ob der Baum ein Suchbaum ist
% Traversiert den Baum in Inorder und nutzt cut/fail für effiziente Prüfung

isSearchTree(nil) :-
    !.  % Cut: leerer Baum ist immer ein Suchbaum

isSearchTree(tree(K, L, R)) :-
    isSearchTree(L),
    !,  % Cut: Wenn linker Teilbaum kein Suchbaum ist, scheitern
    isSearchTree(R),
    !,  % Cut: Wenn rechter Teilbaum kein Suchbaum ist, scheitern
    checkOrder(L, K, R),
    !.  % Cut: Wenn Ordnung stimmt, erfolgreich

isSearchTree(_) :-
    fail.  % Fail: Wenn einer der Checks fehlschlägt

% Hilfsprädikat: prüft die Suchbaum-Eigenschaft (alle Werte im linken Teilbaum < K < alle Werte im rechten Teilbaum)
checkOrder(nil, _, nil) :-
    !.  % Cut: beide Teilbäume leer

checkOrder(nil, K, R) :-
    !,  % Cut: nur rechter Teilbaum vorhanden
    minValue(R, MinR),
    K < MinR.

checkOrder(L, K, nil) :-
    !,  % Cut: nur linker Teilbaum vorhanden
    maxValue(L, MaxL),
    MaxL < K.

checkOrder(L, K, R) :-
    !,  % Cut: beide Teilbäume vorhanden
    maxValue(L, MaxL),
    minValue(R, MinR),
    MaxL < K,
    K < MinR.

checkOrder(_, _, _) :-
    fail.  % Fail: wenn Ordnung nicht stimmt

% Hilfsprädikate für Min/Max-Werte im Baum
minValue(tree(K, nil, _), K) :-
    !.  % Cut: linkstes Element ist Minimum

minValue(tree(_, L, _), Min) :-
    !,  % Cut: gehe zum linken Teilbaum
    minValue(L, Min).

minValue(nil, _) :-
    fail.  % Fail: leerer Baum hat kein Minimum

maxValue(tree(K, _, nil), K) :-
    !.  % Cut: rechtstes Element ist Maximum

maxValue(tree(_, _, R), Max) :-
    !,  % Cut: gehe zum rechten Teilbaum
    maxValue(R, Max).

maxValue(nil, _) :-
    fail.  % Fail: leerer Baum hat kein Maximum

% Zusätzliche Hilfsprädikate für Tests

% Erstelle einen Beispielbaum
example_tree(tree(5, 
                  tree(3, 
                       tree(1, nil, nil), 
                       tree(4, nil, nil)), 
                  tree(8, 
                       tree(6, nil, nil), 
                       tree(9, nil, nil)))).

% Erstelle einen ungültigen Baum (nicht sortiert)
invalid_tree(tree(5, 
                  tree(7, nil, nil),  % 7 > 5, sollte rechts stehen
                  tree(8, nil, nil))).

% Test-Prädikat
% Test-Prädikat
test_trees :-
    write('=== Test der Binaerbaum-Implementierung ==='), nl,
    
    example_tree(Tree1),
    write('Beispielbaum: '), write(Tree1), nl,
    
    (isSearchTree(Tree1) ->
        write('[OK] Beispielbaum ist ein gueltiger Suchbaum') 
    ; 
        write('[FEHLER] Beispielbaum ist kein gueltiger Suchbaum')), nl,
    
    write('Teste contains(Tree, 4): '),
    (contains(Tree1, 4) ->
        write('[OK] 4 gefunden')
    ;
        write('[FEHLER] 4 nicht gefunden')), nl,
        
    write('Teste contains(Tree, 7): '),
    (contains(Tree1, 7) ->
        write('[OK] 7 gefunden')
    ;
        write('[FEHLER] 7 nicht gefunden')), nl,
    
    invalid_tree(Tree2),
    write('Ungueltiger Baum: '), write(Tree2), nl,
    
    (isSearchTree(Tree2) ->
        write('[FEHLER] Ungueltiger Baum wurde faelschlich als gueltig erkannt')
    ;
        write('[OK] Ungueltiger Baum wurde korrekt erkannt')), nl.

% Automatische Ausführung der Tests
:- initialization(test_trees).