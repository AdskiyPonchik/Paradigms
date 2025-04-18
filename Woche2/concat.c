#include <stdlib.h>
#include <stdio.h>
#include <string.h>

char* concat(char* string1, char* string2) {
    size_t size_string1 = strlen(string1);
    size_t size_string2 = strlen(string2);
    size_t size_together = size_string1+size_string2;

    char* str = malloc((size_together+1) * sizeof(char));
    if (str == NULL)return NULL;
    for (size_t i = 0; i < size_string1;i++)
    {
        str[i] = string1[i];
    }
    for (size_t i = 0;i < size_string2; i++)
    {
        str[i+size_string1] = string2[i];
    }
    str[size_together] = '\0';
    return str;
}

int main() {
    char* result = concat("Hello ", "World");
    printf("%s", result);
    free(result);
    return 0;
}