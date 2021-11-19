package ru.vsu.cs.dm.search;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {5, 10, 15, 20, 25, 30, 35, 40, 45};
        System.out.println("The input array: " + Arrays.toString(array));

        Scanner input = new Scanner(System.in);
        System.out.println("Enter desired value: ");
        int item = input.nextInt();
        System.out.println("Desired value = " + item);

        int first = 0;
        int last = array.length - 1;
        int mid = (first + last) / 2;
        int counter = 1;

        while ((array[mid] != item) && (first <= last)) {
            counter++;
            if (array[mid] > item) {
                last = mid - 1;
            } else {
                first = mid + 1;
            }
            mid = (first + last) / 2;
        }
        if (first <= last) {
            System.out.println(item + " is the " + ++mid + " element in array");
            System.out.println("The number of comparisons: " + counter);
        } else {
            System.out.println("Element is not found! The number of comparisons: " + counter);
        }
    }
}

