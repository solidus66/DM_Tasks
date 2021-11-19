package ru.vsu.cs.dm.bubbleAndShell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) throws IOException {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        //int[] array = {10, 2, 6, 3, 1, 7, 5, 9, 4, 15, 11, 21, 8, 12, 13};
        //int[] array = {15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        System.out.println("The input array: " + Arrays.toString(array));
        bubbleSort(array);
        System.out.println("Sorted array: " + Arrays.toString(array));

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        in.readLine();
    }
    

    public static void bubbleSort(int[] array) {
        boolean swap = true;
        int temp;
        int comparisonsCount = 0;
        int exchangeCounter = 0;

        while (swap) {
            swap = false;
            for (int i = 0; i < array.length - 1; i++) {
                comparisonsCount++;
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swap = true;
                    exchangeCounter++;
                }
            }
        }
        System.out.println("The number of comparisons: " + comparisonsCount);
        System.out.println("The number of exchanges: " + exchangeCounter);
    }
}
