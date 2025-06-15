### Logische operatoren als Labmda(λx.λy. y = FALSE, λx.λy. x = TRUE:
**NAND**
```lambda
NOT: λa. a FALSE TRUE
AND:  λa.λb. a b FALSE
Dann: λa.λb. NOT (AND a b)
```    
**OR**
```lambda
λa.λb. a TRUE b
```
**NOR**
```lambda
λa.λb. NOT (OR a b) -> NOR definiert in NAND
(λa.λb. (a TRUE b) FALSE TRUE)a b 
```
**XOR**  
XOR takes two arguments and returns TRUE when one and only one argument is TRUE
```lambda
λa.λb. a (NOT b) b
λa.λb. a (b FALSE TRUE) b
```
**XNOR**
XNOR takes two arguments and returns TRUE when both of the arguments are the same
```lambda
λa.λb. a b (NOT B)
λa.λb. a b (b FALSE TRUE)
```