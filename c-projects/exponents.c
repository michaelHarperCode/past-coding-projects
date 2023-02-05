#include <stdio.h>

int main() {
    double x, n, z, ans; //x is the base, y is the power, z is how many times the value is being repeated, ans carries results and displays final answer
    ans = 0;
    z = 0;
    printf("Welcome to the exponent solver! Please write the base of the exponent.\n");
    scanf("%lf", &x);
    printf("Please write the power of the exponent.\n");
    scanf("%lf", &n);
// normal case: x and n are positives with no special cases
    if (n >= 1) {
        while (z < n) {
            if (ans == 0) {
                ans = ans + x;
                z = z + 1;
            }
            if (z < n) {
                ans = ans * x;
                z = z + 1;
            }
        }
    }
// special case 1: n is negative
    if (n < 1) {
        n = n * -1;
        while (z < n) {
            if (ans == 0) {
                ans = ans + x;
                z = z + 1;
            }
            if (z < n) {
                ans = ans * x;
                z = z + 1;
            }
        }
        ans = 1 / ans;
        n = n * -1;
    }
//special case 2: n is zero
    if (n == 0) {
        ans = 1;
    }
    if (x == 0 && n <= 0) { //special case 3: X is defined as zero to a non-positive or zero value N
        printf("Exponents with 0 as the base and a power less than or equal to zero are undefined.\n");
    } else {
        printf("The answer is %lf. Goodbye!\n", ans);
    }
}
