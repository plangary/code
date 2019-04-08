
#include <stdio.h>
#include <mem.h>
#include <string.h>
//Compiled with C99
int main() {
    int cMonth, cDay, cYear, r; // Declare current values for Month, Day, and Year
    int mMonth = 0, mDay = 0, mYear = 0; // Declare and Initialize values for max Month,Day, and Year.

    printf("Enter a date (mm/dd/yy):");

    r = scanf("%d/%d/%d", &cMonth, &cDay, &cYear); // store number of arguments read by scanf fn in variable r
    if (cMonth == 0 && cDay == 0 && cYear == 0) { //check if initial value given for date is 0
        printf("Must enter at least 1 date ");
        return 1; // return 1 if initial date is 0/0/0
    }
    while (cMonth != 0 || cDay != 0 || cYear != 0) { // continue loop while 0/0/0 has not been inputted
        if (r != 3) { //check if proper argument passed to scanf
            printf("Error: Invalid date format!!\n");
            fflush(stdin); //clear stdin buffer
        }
        if (r == 3 && (cYear > 99 || cYear <= 0)) { //check if year value is between 0-99
            printf("Invalid Year number!\n");
        }
        if (r == 3 && (cMonth >= 13 || cMonth <= 0)) { // check if month value is between 0-12
            printf("Invalid Month number!\n");
        }
        if (r == 3 && (cDay > 31 || cDay <= 0)) { // check if day value is between 0-31
            printf("Invalid Day number!\n");
        }
        if (((cDay <= 31) && cMonth <= 12 && cYear <= 99)) {
            if (cYear > mYear && cYear > 0) { // initial check is year. If current year is greater than max year, set current date as max date
                if (cDay > 0 && cMonth > 0) {
                    mMonth = cMonth;
                    mDay = cDay;
                    mYear = cYear;
                }
            }
            if (cYear == mYear) { // if year is equal, compare months. If current month is greater than max month, set current max date as max date.
                if (cMonth > mMonth && cMonth > 0) {
                    mMonth = cMonth;
                    mDay = cDay;
                    mYear = cYear;

                }
                if (cMonth == mMonth) { // if  months are equal, compare days. If current day is greater than max day, set current date ad max date.
                    if (cDay > mDay && cDay > 0) {
                        mMonth = cMonth;
                        mDay = cDay;
                        mYear = cYear;

                    }
                }

            }

        }
        printf("Enter a date (mm/dd/yy):");
        r = scanf("%d/%d/%d", &cMonth, &cDay, &cYear);

    }
    if (mMonth != 0 && mDay != 0 && mYear != 0) {  // if max date is not 0/0/0
        printf("%.2d/%.2d/%.2d  is the latest date", mMonth, mDay, mYear);
        return 0;
    }
    printf("Error: At least one date must be input!");// if max date is still 0/0/0, give error.
    return 1;
}