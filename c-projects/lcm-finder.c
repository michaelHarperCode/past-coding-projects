#include <stdio.h>

int main()
{
double a, b, a1, b1, lcm;
printf("Welcome to the Least Common Multiple finder! Enter your first value.\n");
scanf("%lf", &a);
printf("Enter your second value. \n");
scanf("%lf", &b);
a1 = a;
b1 = b;
while(a1 != b1){
  if (a1 > b1){
    a1 = a1 - b1;
  }
  else {
    b1 = b1 - a1;
  }
}
lcm = a / a1;
lcm = lcm * b;
printf("The least common multiple for these numbers is %.0lf.\n", lcm);
}