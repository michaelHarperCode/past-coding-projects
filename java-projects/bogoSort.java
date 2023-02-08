/**
Implements the most inefficient method of sorting, Bogo Sort.
This uses the Stopwatch and StandardOut [stdout] libraries from Algorithms, found here: https://algs4.cs.princeton.edu/code/algs4.jar
*/

import edu.princeton.cs.algs4.*;
import java.util.Scanner;

public class bogoSort {

    /**
     * Creates an array of unsorted numbers of the given length.
     * @param size The size of the array, including the first position '0'.
     * @return an array of random numbers of length size.
     */
    public static double[] set(int size) {
        double[] intArray = new double[size];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = Math.round(Math.random() * 100);
        }
        return intArray;
    }

    /**
     * Checks to see if the array is sorted in order of the smallest value to greatest.
     * @param array The array being checked
     * @return Boolean of whether the array is sorted.
     */
    public static boolean check(double[] array){
        for (int i = 0; i < array.length - 1; i++){
            if(array[i] > array[i+1]) return false;
        }
        return true;
    }

    /**
     * Shuffles the values within the array.
     * @param array The array being shuffled.
     */
    public static void shuffle(double[] array){
        int currentIndex = array.length;
        int randomIndex;
        double tempValue;
        while(currentIndex != 0){
            randomIndex = (int) Math.floor(Math.random() * currentIndex);
            currentIndex--;
            tempValue = array[currentIndex];
            array[currentIndex] = array[randomIndex];
            array[randomIndex] = tempValue;
        }
    }

    public static void main(String[] args) {
        Scanner readUser = new Scanner(System.in);
        StdOut.printf("Welcome. This program uses the Bogo Sort method on lists from length 1 to length n. Enter the length of the longest list you wish to sort.\n");
        int longestListLength = readUser.nextInt();
        for (int i = 1; i <= longestListLength; i++) {
            Stopwatch timer = new Stopwatch();
            double[] array = set(i);
            double lengthOfArray = array.length; //for printing purposes
            boolean sorted = false;
            long numberOfAttempts = 1;
            while (!sorted) {
                if (!check(array)) {
                    numberOfAttempts++;
                    shuffle(array);
                } else {
                    sorted = true;
                }
            }
            StdOut.printf("It took %.2f seconds and " + numberOfAttempts + " attempts to randomly shuffle the %.0f item long list correctly.\n", timer.elapsedTime(), lengthOfArray);
        }
    }
}
