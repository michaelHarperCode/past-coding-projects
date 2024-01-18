/**
Number of Steps to Reduce A Number to Zero

Given an integer, num, find how many steps it would take to reduce it to zero.
At a step, if the number is even, divide by 2. Otherwise, subtract 1.
*/

public int numberOfSteps(int num) {
  int stepCount = 0;
    while(num != 0){
      if(num % 2 == 0){
        num = num/2;
        }
      else{
        num = num - 1;
        }
      stepCount++;
      }
    return stepCount;
}
