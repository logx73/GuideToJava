package Multithreading;

import java.util.Arrays;


public class MultiSum {
    public static void main(String[] args) throws InterruptedException {
        int[] array = generateArray(500000000);
        long startTime = System.currentTimeMillis();
        Arrays.parallelSort(array);
        long endTime = System.currentTimeMillis();
        System.out.println("Multi-threaded Computation Time: " + (endTime - startTime) + " milliseconds");


    }

    private static int[] generateArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = size-1-i;
        }
        return array;
    }


}
