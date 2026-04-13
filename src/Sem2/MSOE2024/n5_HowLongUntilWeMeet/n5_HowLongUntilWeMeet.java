package Sem2.MSOE2024.n5_HowLongUntilWeMeet;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class n5_HowLongUntilWeMeet {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("src/Sem2/MSOE2024/n5_HowLongUntilWeMeet/HowLong.txt"));

        Map<Character, Integer> letterMap = new HashMap<>();
        for (int i = 0; i < 26; i++)letterMap.put((char) ('a' + i), i);

        int smallestDist = Integer.MAX_VALUE;
        int maxDistance = sc.nextInt();
        int rows        = sc.nextInt();
        int cols        = sc.nextInt();
        char[][] mat1 = new char[rows][cols];
        char[][] mat2 = new char[rows][cols];

        sc.nextLine();for (int r = 0; r < rows; r++)System.out.println(mat1[r] = sc.nextLine().toCharArray());
        System.out.println();
        sc.nextLine();for (int r = 0; r < rows; r++)System.out.println(mat2[r] = sc.nextLine().toCharArray());


        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                smallestDist = Math.min(maxDistance-(Math.abs(letterMap.get(mat1[r][c])+letterMap.get(mat2[r][c]))), smallestDist);

        System.out.println(smallestDist*50);

    }
}
