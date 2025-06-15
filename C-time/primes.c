#include <stdio.h>
#include <math.h>

int is_prime(int num) {
    if(num > 1){
        for(int i = 2; i < num; i++){
            if(num%i == 0){return 0;}
        }
        return 1;
    }
    return 0;
}
int calculate_nth_prime_number(int n){
    int counter = 0;
    int current_number = 2;
    while (counter < n) {
        int prime = 1;
        for (int i = 2; i * i <= current_number; i++) {
            if (current_number % i == 0) {
                prime = 0;
                break;
            }
        }
        if (prime) {
            counter++;
            if (counter == n) {
                return current_number;
            }
        }
        current_number++;
    }
    return 0;
}
int main() {
    is_prime(1); // 0
    is_prime(2); // 1
    is_prime(3); // 1
    calculate_nth_prime_number(1); // 11
}