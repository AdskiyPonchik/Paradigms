### Beschreiben Sie, was man als Alpha- bzw. Beta-Äquivalenz bei Lambda-Termen versteht!
**α-Äquivalenz (Alpha-Äquivalenz):**  
Zwei Lambda-Terme sind α-äquivalent, wenn sie sich nur in den Namen gebundener Variablen unterscheiden.  
Beispiel: `λx. x` ≡α `λy. y`  
    - Beide repräsentieren dieselbe Funktion (Identitätsfunktion).

**β-Äquivalenz (Beta-Äquivalenz):**  
Zwei Terme sind β-äquivalent, wenn sie durch Anwendung von β-Reduktionen ineinander überführt werden können.  
Beispiel: `(λx. x + 1) 2` → β `2 + 1`  
    - Beide Terme sind β-äquivalent, da sie dasselbe Ergebnis liefern.

### Aufgabe 2

1. **λx. λy. x + y =α λy. λx. x + y**  
   `+` **Richtig**

---

2. **λx. λy. x + y =α λx. λy. y + x**  
   ❌ **Falsch**  
   Begründung: Funktionskörper wurde verändert (`x + y` ≠ `y + x`) → keine reine Umbenennung.  
   **Nicht α-äquivalent**.

---

3. **(λy. (λx. yx))(λz. z + 1) =α (λz. (λx. zx))(λx. x + 1)**  
   ❌ **Falsch**  
   Begründung: Umbenennung von gebundenen Variablen (`y → z`) (oder `x → z`) ist falsch.  
   Beide Terme bleiben strukturell nicht gleichwertig → **nicht α-äquivalent**.
---

4. **(λx. (λy. x + y)) 5 =β λy. 5 + y**  
   ✅ **Richtig**  
   Begründung: β-Reduktion:  
   `(λx. (λy. x + y)) 5` → `λy. 5 + y`  
   - korrekte Anwendung → **β-äquivalent**.

---

5. **(λx. λy. xyz)((λx. x)(λz. x))(λy. 2 * y) 3 =β 6**  
   ❌ **Falsch**  
   Begründung: In `(λx. x)(λz. x)` wird `x` als freie Variable verwendet → Fehler bei Substitution.  
   - Ausdruck nicht korrekt reduziert → **nicht β-äquivalent zu 6**

---

6. **(λx. λy. yx)(λx. x `?`1`?`)(λy. 3 * y) 3 =β 3**  
   ✅ **Richtig**  
   schritt-fur-schritt:
   - `(λx. λy. yx)(λx. x 1)` → `λy. y(λx. x 1)`
   - `λy. y(λx. x 1)(λy. 3 * y)` → `(λy. 3 * y)(λx. x 1)` → `3 * ((λx. x 1))`
   - `(λx. x 1)` → ergibt? `1`  
     → `3 * 1 = 3`

→ **β-Äquivalenz korrekt**

