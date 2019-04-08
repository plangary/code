/******************************************************************************
* Name: Pouya Langary
 Student ID : 250798366
******************************************************************************/

#include "simulate.h"
#include "myOS.h"
#include "job.h"
#include "linked_stack.h"


int memory, max_memory;
FILE *fp;
linked_stack_t *jobs;
job_t *tempJob;
int create;


void simulate(int memory_value, linked_stack_t *stack) {
    int i;
    int *p;
    jobs = stack;
    fp = fopen(SYSTEM_OUTPUT, "a"); //open file

    pthread_t threads[NUMBER_OF_THREADS]; //create thread array of size 4
    max_memory = memory_value;

    do {

        tempJob = pop(jobs);
        create = pthread_create(&threads[0], NULL, run2, (void* ) p );



    } while(jobs->head != NULL); //keep popping off stack until no available jobs


    for (i = 0; i < NUMBER_OF_THREADS; i++) { //wait until all threads have completed
        pthread_join(threads[i], NULL);
    }
    fclose(fp);

}
/**
 * Function to recieve threads and execute them in run function
 * @param x
 * @return
 */
void *run2 (void * arg){
    run();

}




