#include <stdlib.h>
#include <stdio.h>
#include <string.h>

int is_anagram(char* word, char* compared) {
    if(strlen(word) != strlen(compared)) {
        return 0;
    }
    int letters[256] = {0};
    for(size_t i = 0; i < strlen(word); i++){
        letters[(unsigned char)word[i]]++;
    }
    for(size_t i = 0; i < strlen(compared); i++){
        letters[(unsigned char)compared[i]]--;
        if(letters[(unsigned char)compared[i]] < 0)return 0;
    }
    return 1;
}


int main() {
    // test your code
    printf("%d\n", is_anagram("mehl", "helm"));
    printf("%d\n", is_anagram("boeing", "airbus"));
    return EXIT_SUCCESS;
}