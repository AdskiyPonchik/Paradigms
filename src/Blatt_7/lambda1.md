### 1. Welche Arten von Termen kennt das Lambda Kalkül?

    - **Variable**: x

    - **Abstraktion**: λx. x — Funktion, die ihr Argument zurückgibt (Identität) | x => x

    
    - **Applikation**: (λx. x) y — Anwendung der Identitätsfunktion auf `y` | (x => x)(y)

### Welche Vereinfachungen sind möglich?

1. **α-Umwandlung**  
   Eine Variable umbenennen, ohne ihre Bedeutung zu ändern.
   Beispiel: `λx. x` → `λy. y`
   ```scala 
    x => x
    y => y
   ```

2. **β-Reduktion**  
   Anwenden einer Funktion auf ein Argument.
   Beispiel: `(λx. x) y` → `y`
   ```scala 
    (x=>x)("Hallo")
   ```

3. **η-Reduktion**
   Vereinfachen Sie den Ausdruck, wenn das Argument einfach weitergegeben wird. 
   Beispiel: `λx. f x` → `f`, если `x` nicht frei in `f` vorkommt
   ```scala 
    val f = (x: Int) => x + 1
   val g = (x: Int) => f(x) //kann vereinfacht werden zum:
   val g = f
   ```
### Wie kann man mit Hilfe des Lambda Kalküls Eigenschaften beweisen?


1. **Reduktionsreihen zeigen (β-Reduktion)**  
   Man beweist, dass zwei Terme zum selben Ergebnis reduziert werden.  
   Beispiel:  
   `(λx. x) (λy. y)` → `λy. y`  
   Beide Terme sind gleichwertig (Konfluenz).

2. **Äquivalenz durch Umformungen**  
   Man nutzt α-, β- und η-Reduktion, um Gleichheit zweier Ausdrücke zu zeigen.

3. **Normalformen nachweisen**  
   Zeigen, dass ein Term eine Normalform hat (nicht weiter reduzierbar) — wichtig für Terminierung.

4. **Kontextanalyse**  
   Beweis, dass ein Term in jedem Kontext gleich bleibt — z. B. durch Substitution unveränderlich ist.

Scala-Beispiel (Äquivalenz durch Reduktion):
```scala
val id = (x: Int) => x
id(5)       // ergibt 5

((x: Int) => x)(5) == id(5)  // true

