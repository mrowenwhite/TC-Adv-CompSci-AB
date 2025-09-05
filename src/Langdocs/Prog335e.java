package Langdocs;
import java.util.Random;
import java.util.Scanner;


public class Prog335e {
    static int[] arr = new int[100];
    static int[] choiceNums  = new int[40];

    public static void main(String[] args) {
        Scanner sc   = new Scanner(System.in);
        Random  rand = new Random();

        for (int lcv = 0; lcv < 100; ++lcv)
            arr[lcv] = (int) (Math.random() * 1000 - 1) + 1;

        for (int lcv = 0; lcv < 40; ++lcv)
            choiceNums[lcv] = (int)(Math.random() * 1000 - 1) + 1;

        for (int choiceNum : choiceNums) {
            for (int i = 0; i < choiceNums.length; ++i) {
                if (arr[i] == choiceNum) {
                    System.out.println(choiceNum + " is located at " + Location(i));
                }
            }
        }
    }

    public static int Location(int n) {
        for (int num : arr) {
            if (num == n) return n; else continue;
        }
        return -1;
    }
}
