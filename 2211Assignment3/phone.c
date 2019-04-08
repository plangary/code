#include <stdio.h>
#include <string.h>

int main() {

    int x, y, z, r;
    char input;

    printf("Please input phone: ");

    r = scanf("%3d%3d%4d", &x, &y, &z);
    if (r != 3) {
        printf("Invalid phone number!");
        return 1;
    }

    printf("Format options\n A) Local \n B) Domestic \n C) International \n D) Odd\n");
    scanf(" %c", &input);


    if (input == 'A' || input == 'a') {
        //printf("%.*i",3, phone+0);
        printf("Phone number:  %d-%d", y, z);
        return 0;
    }

    if (input == 'B' || input == 'b') {
        printf("Phone Number:  (%d) %d-%d", x, y, z);
        return 0;
    }

    if (input == 'C' || input == 'c') {
        printf("Phone Number:  +1-%d-%d-%d", x, y, z);
        return 0;
    }


    if (input == 'D' || input == 'd') {
        printf("%5.4d %5.4d %5.4d", x, y, z);
        return 0;
    }


    return 0;
}