#include <stdio.h>

void print_tree(int height) {
    for(int i = 1; i <= height; i++){
        for(int j = 0; j<height-i; j++)
        {
            printf(" ");
        }
        for(int k = 0; k < 2*i-1; k++){
            printf("*");
        }
        printf("\n");
    }
    for(int i = 0; i<height-1; i++)
    {
        printf(" ");
    }
    printf("*\n");
}

void print_tree_char(int height, char symbol) {
    for(int i = 1; i <= height; i++){
        for(int j = 0; j<height-i; j++)
        {
            printf(" ");
        }
        for(int k = 0; k < 2*i-1; k++){
            printf("%c", symbol);
        }
        printf("\n");
    }
    for(int i = 0; i<height-1; i++)
    {
        printf(" ");
    }
    printf("*\n");
}

int main() {
    print_tree(5);
    print_tree_char(5, 'o');
}