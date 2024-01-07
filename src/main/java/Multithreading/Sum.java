package Multithreading;

import java.util.Arrays;

public class Sum {
    public static void main(String[] args) {
        int[] array = generateArray(500000000);
        long startTime = System.currentTimeMillis();
        Arrays.sort(array);
        long endTime = System.currentTimeMillis();
        System.out.println("Single-threaded Computation Time: " + (endTime - startTime) + " milliseconds");
    }

    private static int[] generateArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = size-1-i;
        }
        return array;
    }
}
