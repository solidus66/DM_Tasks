package ru.vsu.cs.dm.qickAndMerge;

import java.util.Arrays;

public class QuickSort {
    private int countComparison = 0;
    private int swapCount = 0;

    public int[] sort(int[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            sort(arr, begin, partitionIndex - 1);
            sort(arr, partitionIndex + 1, end);
        }
        return arr;
    }

    private int partition(int arr[], int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            this.countComparison++;
            if (arr[j] <= pivot) {
                i++;
                this.swapCount++;
                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }
        int swapTemp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = swapTemp;

        return i + 1;
    }

    public int getCountComparison() {
        return countComparison;
    }

    public int getSwapCount() {
        return swapCount;
    }
}