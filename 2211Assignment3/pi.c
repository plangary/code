#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <math.h>
//C99
//Use command "gcc pi.c -lm -std=c99" to run 

int main(){
    srand(time(NULL)); //set seed
    int n, i,r; //declare variables
    double piTotal;
    double mean;
    double sum;
    double all_vals[10]; // declare array of size 10 to store values
    double estimate_pi(long long n); //function protoype

    printf("Enter number of iterations");
    r=scanf("%d",&n); // store number of arguments passed in r

    if(r!=1){ //check if proper arguments given
        printf("Invalid input!");
        return 1;
    }


    for(i = 0; i<10; i++) { // call estimate_pi function 10 times
        all_vals[i] = estimate_pi(n); //store pi value in array
        printf("%.10f\n",all_vals[i]); // print pi value
        piTotal = piTotal + all_vals[i]; //add pi value to total sum

    }
    mean = piTotal/10; //calculate mean value

    for (int j = 0; j < 10; j++){ //iterate array and calculate std variation
        sum = sum + ((all_vals[i] - mean)*(all_vals[i]-mean));
    }



    printf("The Mean Value is: %.10f\n",mean); //print values using 10 digits of precision
    printf("The STD VAR is: %.10f\n", sqrt(sum/(n-1)));



    return 0;
}


double estimate_pi (long long n){
    double x,y;
    int i, count = 0;
    double z;
    double pi;

    for (i = 0; i<n; i++){
        x = (double) rand()/RAND_MAX; // generate random variable between 0 and 1
        y = (double) rand()/RAND_MAX;
        z = x*x + y*y;
        if (z<=1){ //check if value lies within first quadrant
            count ++; // increase count if true
        }
    }
    pi = (double) count/n *4; // calculate pi value
    return pi;

}

