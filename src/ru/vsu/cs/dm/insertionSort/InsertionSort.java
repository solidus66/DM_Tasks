package ru.vsu.cs.dm.insertionSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) throws IOException {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        //int[] array = {10, 2, 6, 3, 1, 7, 5, 9, 4, 15, 11, 21, 8, 12, 13};
        //int[] array = {15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        System.out.println("The input array: " + Arrays.toString(array));
        System.out.println();

        int comparisonsCount = 0;

        for (int left = 0; left < array.length; left++) {
            int value = array[left];
            int i = left - 1;
            for (; i >= 0; i--) {
                if (value < array[i]) {
                    array[i + 1] = array[i];
                    comparisonsCount++;
                } else {
                    break;
                }
            }
            array[i + 1] = value;
        }
        System.out.println("Sorted array: " + Arrays.toString(array));
        System.out.println("The number of comparisons: " + comparisonsCount);

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        in.readLine();
    }
}