
#include "simulate.h"

#include "job.h"

/**
 * run() handles the memory management
 */
int memory, max_memory;
FILE *fp;
linked_stack_t *jobs;
job_t *tempJob;
int create;



void run() {

    create = 0;
    int currMem = max_memory - (tempJob->required_memory*tempJob->required_time); //Misunderstood the wording of the assignment. Assumed the memory was for the individual time 
                                                                        
    


    if (max_memory < (tempJob->required_memory*tempJob->required_time)) { // check if the total available memory is less than the memory required to run the current job. Check this first and if it failed, then we do not need to process the job.
        print_exceed_memory(fp, tempJob->number);
    }
    else {



        if (currMem<tempJob->required_memory && max_memory>tempJob->required_memory){ // If the job that is trying to run requires less memory than the total available memory but the current available memory was less due to other jobs running, then push the job back onto the stack so when memory is deallocated, it would be able to run. 
            print_insufficient_memory(fp,tempJob->required_memory);
            push(jobs,tempJob);

        }

        print_starting(fp, tempJob->number); //now that we have reached this point, it means that the current job is able to be processed since we have checked for both cases with memory (current memory available and max memory available).
        print_allocate_memory(fp, currMem, tempJob->required_memory*tempJob->required_time); //allocate the memory by giving it the current memory and the memory required to run the job. 



        if (create == 0) {             //check here to see if the create variable is equal to 0. check this because when using pthread_create to create a thread, an int 0 is returned if successful. Once the thread is completed and 0 is returned meaning it was successful, reset the memory variables and print job completed.
            max_memory = currMem;
            print_completed(fp, tempJob->number);
            currMem = max_memory + tempJob->required_memory;
            print_deallocate_memory(fp, currMem, tempJob->required_memory);

        }
    }

}

