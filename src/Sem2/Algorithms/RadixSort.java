package Sem2.Algorithms;

import java.util.Arrays;

public class RadixSort {
    public void radixSort(int[] array) {
        int max = Arrays.stream(array).max().getAsInt();
        int exp = 1;
        while ((max/exp)>0) {
            CountingSortByLength(array, exp);
            exp *= 10;
        }
    }

    public void CountingSortByLength(int[] array, int exp) {
        int n = array.length;
        int[] output = new int[n];
        int[] count = new int[10];
        for (int i = 0; i < n; i++) {
            int digit = (array[i]/exp)%10;
            count[digit]++;
        }
        for (int i = 1; i <= 9; i++) {
            count[i] = count[i] + count[i-1];
        }
        for (int i = n-1; i >= 0; i--) {
            int digit = (array[i]/exp)%10;
            output[count[digit]-1] = array[i];
            count[digit]--;
        }
        System.arraycopy(output, 0, array, 0, n);
    }

    public static void main(String[] args) {
        RadixSort radixSort = new RadixSort();
        int[] randNums = {343, 829, 198, 553, 900, 322, 814, 615, 498, 704};

        radixSort.radixSort(randNums);
        for (int i = 0; i < randNums.length; i++) {
            System.out.println(randNums[i]);
        }
    }
}
