package ru.vsu.cs.dm.insertionSort.utils;

import java.util.Random;

public class RandomUtils {
    private static final Random random = new Random();

    public static int getRandomIntBetween(int min, int max) {
        return min + random.nextInt(max - min);
    }

    public static double getRandomDoubleBetween(double min, double max) {
        return min + random.nextDouble() * (max - min);
    }

    public static boolean getRandomBool() {
        return random.nextBoolean();
    }

    public static Integer[] getRandomArray(int size, Integer min, Integer max) {
        Integer[] array = new Integer[size];
        for (int n = 0; n < size; n++) {
            array[n] = getRandomIntBetween(min, max);
        }
        return array;
    }
}
