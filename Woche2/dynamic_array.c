#include <stdlib.h>
#include <stdio.h>

typedef struct {
    char* array;
    int numElems;
    int size;
} Dyn_array_t;

void initArray(Dyn_array_t* array, int desSize) {
    array->numElems = 0;
    array->size = desSize;
    array->array = malloc(array->size * sizeof(char));
}

void destroyArray(Dyn_array_t* array) {
    free(array->array);
    array->numElems=0;
    array->size=0;
}

void insert(Dyn_array_t* array, char elem) {
    array->numElems+=1;
    if(array->numElems>=array->size){
        array->size*=2;
        array->array = realloc(array->array, array->size*sizeof(char));
    }
    array->array[array->numElems-1] = elem;
}


int main() {
    return EXIT_SUCCESS;
}