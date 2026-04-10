package Sem2.MSOE2024.n5_HowLongUntilWeMeet;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class n5_HowLongUntilWeMeet {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("src/Sem2/MSOE2024/n5_HowLongUntilWeMeet/HowLong.txt"));
        Character[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        int[]     nums = {1,    2,   3,   4,   5,   6,   7,   8,   9,   10,  11,  12,  13,  14,  15,  16,  17,  18,  19,  20,  21,  22,  23,  24,  25};

        int smallestDist = Integer.MAX_VALUE;
        int maxDistance = sc.nextInt();
        int rows        = sc.nextInt();
        int cols        = sc.nextInt();

        char[][] mat1 = new char[rows][cols];
        char[][] mat2 = new char[rows][cols];
        int[][]  difs = new int[rows][cols];

        sc.nextLine();for (int r = 0; r < rows; r++)System.out.println(mat1[r] = sc.nextLine().toCharArray());
        System.out.println();
        sc.nextLine();for (int r = 0; r < rows; r++)System.out.println(mat2[r] = sc.nextLine().toCharArray());


        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int finalR = r;
                int finalC = c;
                int n1 = IntStream.rangeClosed(0, letters.length).filter(i -> String.valueOf(i).equals(mat1[finalR][finalC])).findFirst().orElse(-1);
                int n2 = IntStream.rangeClosed(0, letters.length).filter(i -> String.valueOf(i).equals(mat2[finalR][finalC])).findFirst().orElse(-1);
                difs[r][c] = (nums[n1] - nums[26-n2]);
                // dif substration mess, n1, n2, getting -1 return from orElse
                System.out.print(difs[r][c] + " ");
            }
            System.out.println();
        }
        smallestDist = Arrays.stream(difs).flatMapToInt(Arrays::stream).max().getAsInt();

        System.out.println(smallestDist*5000 + " years");

    }
}
