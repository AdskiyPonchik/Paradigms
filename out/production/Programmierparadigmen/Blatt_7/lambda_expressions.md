### Fibonacci-Zahlen 
```java
public class Fibo {
    public static int fibo(int n){
        if(n<=1){return n;}
        return fibo(n-1) + fibo(n-2);
    }
    public static void main(String[]args){
        System.out.println(fibo(10));
    }
}

```
```lambda
fib = Y (λf. λn. if (n ≤ 1) then n else (f (n-1) + f (n-2)))
(benutzen wir Y-kombinator)
```
### Fakultätszahlen
```lambda
fac = Y (λf. λn. if (n ≤ 1) then 1 else (n × f (n-1)))
```
Y = λy. (λx. y(x x)) (λx. y(x x)) F - aus der Vorlesung