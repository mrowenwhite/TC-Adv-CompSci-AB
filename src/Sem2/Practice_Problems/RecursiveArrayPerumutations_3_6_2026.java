package Sem2.Practice_Problems;

import java.util.Arrays;

public class RecursiveArrayPerumutations_3_6_2026 {
    static int validCount = 0;
    public static void main(String[] args) {
        String[] colors = {"blue", "red", "white", "black"};
        generatePermutations(colors, 0);
        System.out.println("Number of permutations: " + validCount);

    }
    public static void generatePermutations(String[] arr, int index) {
        if (index == arr.length-1) {
            if (isValid(arr)) {
                System.out.println(Arrays.toString(arr));
                validCount++;
            }
        }
        for (int i = index; i < arr.length-1; i++) {
            swap(arr, index, i);
            generatePermutations(arr, index+1);
            swap(arr, index, i);
        }
    }

    public static boolean isValid(String[] arr) {
        for (int i = 0; i < 2; i++) {
            if ((arr[i].equals("white")&&arr[i+1].equals("black"))||(arr[i].equals("black")&&arr[i+1].equals("white"))) {
                return false;
            }
        }
        return true;
    }

    public static void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
