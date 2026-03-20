package Sem2.Practice_Problems;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class InventoryHeatMap {
    public static void main(String[] args) {
        Random rand = new Random();
        int[][] mat = IntStream.range(0, 5).mapToObj(i -> rand.ints(5, 0, 11).toArray()).toArray(int[][]::new);
        boolean[][] mat2 = new boolean[5][5];
        IntStream.range(0, 5).forEach(i -> {double average = Arrays.stream(mat[i]).average().orElse(0.0);IntStream.range(0, 5).forEach(j -> mat2[i][j] = mat[i][j] > average);System.out.printf(Arrays.toString(mat[i]) + "\tAverage: %d\n", (int)average);});
        System.out.println("\n\n");
        final int[] MINMAX = {Integer.MAX_VALUE, Integer.MIN_VALUE};
        IntStream.range(0, 5).forEach(i -> {System.out.println("Above Avg: " + Arrays.toString(mat2[i]));Arrays.stream(mat[i]).forEach(val -> {MINMAX[0] = Math.min(MINMAX[0], val);MINMAX[1] = Math.max(MINMAX[1], val);});});

        System.out.printf("\nGlobal MAX: %d\nGlobal MIN: %d\n", MINMAX[0], MINMAX[1]);
    }

}

