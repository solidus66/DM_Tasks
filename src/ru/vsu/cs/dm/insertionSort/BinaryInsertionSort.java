package ru.vsu.cs.dm.insertionSort;

import ru.vsu.cs.dm.insertionSort.utils.RandomUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BinaryInsertionSort<T extends Comparable<T>> extends Sorter<T> {

    public static void main(String[] args) throws IOException {
        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        //Integer[] array = {10, 2, 6, 3, 1, 7, 5, 9, 4, 15, 11, 21, 8, 12, 13, 12, 31, 43, 21, 56};
        //Integer[] array = {20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        System.out.println("The input array: " + Arrays.toString(array));

        Integer[] arrayToSort2 = Arrays.copyOf(array, array.length);

        Sorter<Integer> insertionSorterBinary = new BinaryInsertionSort<>();
        insertionSorterBinary.sort(arrayToSort2);

        outputAllSortInfo(arrayToSort2, insertionSorterBinary);

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        in.readLine();
    }

    public static void outputAllSortInfo(Integer[] array, Sorter<Integer> sorter) {
        System.out.println();
        System.out.println("Sorted array: " + Arrays.toString(array));
        System.out.println("The number of comparisons: " + sorter.getComparisonsCounter());
    }

    @Override
    public void sort(T[] array) {
        for (int i = 0; i < array.length; i++) {
            T key = array[i];
            int leftBorder = 0;
            int rightBorder = i;
            while (leftBorder < rightBorder) {
                int mid = leftBorder + (rightBorder - leftBorder) / 2;
                comparisonsCounter++;
                if (key.compareTo(array[mid]) < 0) {
                    rightBorder = mid;
                    logCompare(key, array[mid], '<');
                } else {
                    leftBorder = mid + 1;
                    logCompare(key, array[mid], '>');
                }
            }
            for (int j = i; j > leftBorder; j--) {
                array[j] = array[j - 1];
                array[leftBorder] = key;
            }
        }

    }
}
