package ru.vsu.cs.dm.qickAndMerge;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";

    public static void main(String[] args) {
        init();
    }

    private static void init() {
        MergeSort mergeSort = new MergeSort();
        QuickSort quickSort = new QuickSort();

        int size = 16;
        int[] array;
        printArrayStartInfo();
        int answer = readAnswer();

        switch (answer) {
            case 1 -> {
                array = sortedArray();
                printArray(array);
                printMergeSortResult(array, size, mergeSort);
                printQuickSortResult(array, size - 1, quickSort);
            }
            case 2 -> {
                array = unSortedArray();
                printArray(array);
                printMergeSortResult(array, size, mergeSort);
                printQuickSortResult(array, size - 1, quickSort);
            }
            case 3 -> {
                array = backSortedArray();
                printArray(array);
                printMergeSortResult(array, size, mergeSort);
                printQuickSortResult(array, size - 1, quickSort);
            }
        }
    }

    private static void printArrayStartInfo() {
        System.out.println();
        System.out.println("""
                Select '1' to pick sorted array\s
                Select '2' to pick unsorted array\s
                Select '3' to pick back sorted array""");
    }

    private static int readAnswer() {
        Scanner scan = new Scanner(System.in);
        System.out.println("I choose: ");
        return scan.nextInt();
    }

    private static int[] sortedArray() {
        return new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
    }

    private static int[] unSortedArray() {
        return new int[]{10, 2, 6, 3, 1, 7, 5, 9, 4, 15, 11, 21, 8, 12, 13, 16};
    }

    private static int[] backSortedArray() {
        return new int[]{16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    }

    private static void printArray(int[] array2Print) {
        System.out.println();
        System.out.println(ANSI_CYAN + "The input array: " + ANSI_RESET);
        System.out.println(Arrays.toString(array2Print));
    }

    private static void printMergeSortResult(int[] arr, int size, MergeSort mergeSort) {
        System.out.println("\n");
        System.out.println(ANSI_CYAN + "Array sorted with Merge Sort: " + ANSI_RESET);
        System.out.println(Arrays.toString(mergeSort.sort(arr, size)));

        System.out.println("The number of comparisons: " + mergeSort.getCountComparison());
        System.out.println("The number of swaps: " + mergeSort.getSwapCount());
    }

    private static void printQuickSortResult(int[] arr, int end, QuickSort quickSort) {
        System.out.println("\n");
        System.out.println(ANSI_CYAN + "Array sorted with Quick Sort: " + ANSI_RESET);
        System.out.println(Arrays.toString(quickSort.sort(arr, 0, end)));

        System.out.println("The number of comparisons: " + quickSort.getCountComparison());
        System.out.println("The number of swaps: " + quickSort.getSwapCount());
    }
}
