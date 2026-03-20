package Sem2.Algorithms;

import java.util.Arrays;

public class RadixSort {
    public void intRadixSort(int[] array) {
        int max = Arrays.stream(array).max().isPresent() ? Arrays.stream(array).max().getAsInt() : 0;
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



    public void stringRadixSort(String[] array) {
        if  (array == null || array.length == 0)return;
        int stringLen = array[0].length();
        for  (int index = stringLen-1; index > 0; index--) {
            StableSortByCharacter(array, index);
        }
    }

    public void StableSortByCharacter(String[] array, int index) {
        int n  = array.length;
        String[] output = new String[n];
        int[] count = new int[256];
        for (String s : array)        count[s.charAt(index)]++;
        for (int i = 1; i <= 255; i++)count[i] += count[i-1];

        for (int i = n-1; i >= 0; i--) {
            int asciiVal = array[i].charAt(index);
            output[count[asciiVal]-1] = array[i];
            count[asciiVal]--;
        }
        for (int i = 0; i < n; i++) {
            array[i] = output[i];
        }
    }
    public static void main(String[] args) {
        RadixSort radixSort = new RadixSort();
        String[] randNums = {"a343", "c829", "b198", "d553", "b900", "c322", "a814", "f615", "e498", "j704"};

        radixSort.stringRadixSort(randNums);

        for (String randNum : randNums) {
            System.out.println(randNum);
        }
    }
}

