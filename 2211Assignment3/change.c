
#include <stdio.h>
//C99
void amount();

int main(){
    int dollars, twenties, tens, fives, toonies, lonnies,r; // declare variables
    void pay_amount(int dollars, int *twenties, int *tens, int *fives, int *toonies, //function prototype
    int *lonnies);

    printf("Enter ammount: ");
    r=scanf("%d", &dollars); //assign number of arguments read

    if(r!=1 ){ // check if proper arguments given and exit if not
        printf("INVALID INPUT");
        return 1;
    }
    if (dollars<0){ // check if positive dollar amount is given and exit if not
        printf("Please Enter Positive Amount");
        return 1;
    }
        pay_amount(dollars, &twenties, &tens, &fives, &toonies, &lonnies); // call function
        printf("total bills ");

        printf("total $20 bills: %d\n", twenties); //print values
        printf("total $10 bills: %d\n", tens);
        printf("total $5 bills: %d\n", fives);
        printf("total toonies: %d\n", toonies);
        printf("total lonnies: %d\n", lonnies);



    return 0;
 }
void pay_amount ( int dollars, int *twenties, int *tens, int *fives, int *toonies, int *lonnies){ //function parameters.
    *twenties = (dollars/20); //calculate divisibility by 20. assign new value to twenties variable
    *tens = ((dollars%20)/10); // calculate remainder divisibility by 10. Assign new value to tens variable
    *fives = (((dollars %20)%10)/5); // calculate remainder divisibiliy by 5. Assign new value to fives variable
    *toonies = ((((dollars%20)%10)%5)/2); // calculate remainder divisibily by 2. Assign new value to toonies variable
    *lonnies = ((((dollars%20)%10)%5)%2); // calculate remainder mod 2. Assign new value to lonnies variable.
}



