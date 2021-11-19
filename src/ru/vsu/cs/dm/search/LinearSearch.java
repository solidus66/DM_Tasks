package ru.vsu.cs.dm.search;

import java.util.Arrays;
import java.util.Scanner;

class LinearSearch {
    public static void main(String[] args) {
        int[] array = {5, 10, 15, 20, 25, 30, 35, 40, 45};
        System.out.println("The input array: " + Arrays.toString(array));

        Scanner input = new Scanner(System.in);
        System.out.println("Enter desired value: ");
        int item = input.nextInt();
        System.out.println("Desired value = " + item);

        int comparisonCounter;

        for (comparisonCounter = 0; comparisonCounter < array.length; comparisonCounter++) {
            if (array[comparisonCounter] == item) {
                System.out.println("The number of comparisons = " + (comparisonCounter + 1));
                break;
            }
        }
        if (comparisonCounter == array.length) {
            System.out.println("The number of comparisons = " + (comparisonCounter));
            System.out.println("Element is not found!");
        }
    }
}