### Vereinfachung der Lambda-Terme gemäß dem Lambda-Kalkül

1. **λy. (λx. x) 2**

   - `(λx. x) 2` = `2` (β-Reduktion)  
   - ergebnis: `λy. 2`
---
2. **λy. (λx. y) 3**

   - `(λx. y) 3` = `y` (da `y` frei ist und nicht ersetzt wird)  
   - ergebnis: `λy. y`
---
3. **λx. (5 * y)(x + 2)**

 - kann nicht reduziert werden

---

4. **(λx. (λy. (y + 9))) 8**

   - erste Reduktion: `(λx. (λy. (y + 9))) 8`  
   - ergibt: `λy. (y + 9)`  
   - ergebnis: `λy. (y + 9)`

---

5. **((λx. (λy. (x + 3))) (λx. (λy. (z - 3))))**

   - β-Reduktion: `(λx. (λy. (x + 3)))` angewendet auf `λx. (λy. (z - 3))`  
   - ergebnis: `λy. ((λx. (λy. (z - 3))) + 3)`  ???(nicht sicher)


