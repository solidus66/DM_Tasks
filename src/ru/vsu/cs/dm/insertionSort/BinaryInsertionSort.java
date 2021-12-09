package ru.vsu.cs.dm.insertionSort;

import java.util.Arrays;

public final class BinaryInsertionSort {

    public static void main(String[] args) {
        //int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        //int[] array = {10, 2, 6, 3, 1, 7, 5, 9, 4, 15, 11, 21, 8, 12, 13};
        int[] array = {15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        System.out.println("The input array: " + Arrays.toString(array));

        binaryInsertSort(array);
        System.out.println("Sorted array: " + Arrays.toString(array));
    }

    static void binaryInsertSort(int[] array) {
        int comparisonCounter = 0;
        for (int i = 1; i < array.length; i++) {
            int low = 0;
            int high = i;
            int mid = 0;

            while (low < high) {
                mid = low + (high - low) / 2;
                comparisonCounter++;
                if (array[i] < array[mid])
                    high = mid;
                else
                    low = mid + 1;
            }

            if (array[i] < array[mid]) {
                int t = array[i];
                for (int k = i; k > mid; k--)
                    array[k] = array[k - 1];
                array[low] = t;
            }
        }
        System.out.println("The number of comparisons: " + comparisonCounter);
    }
}
