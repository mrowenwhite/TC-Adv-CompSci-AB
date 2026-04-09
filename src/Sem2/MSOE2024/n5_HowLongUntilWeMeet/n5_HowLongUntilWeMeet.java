package Sem2.MSOE2024.n5_HowLongUntilWeMeet;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class n5_HowLongUntilWeMeet {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("src/Sem2/MSOE2024/n5_HowLongUntilWeMeet/HowLong.txt"));
        int maxDistance = sc.nextInt(), rows = sc.nextInt(), cols = sc.nextInt(), smallestDist = Integer.MAX_VALUE;
        char[][] mat1 = new char[rows][cols], mat2  = new char[rows][cols];
        Map<Character, Integer> lettermap = IntStream.rangeClosed('a', 'z').boxed().collect(Collectors.toMap(i -> (char) i.intValue(), i -> i - 'a' + 1));
        sc.nextLine();for (int r = 0; r < rows; r++) mat1[r] = sc.nextLine().toCharArray();
        sc.nextLine();for (int r = 0; r < rows; r++) mat2[r] = sc.nextLine().toCharArray();


        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++) {
                int diff = Math.max(lettermap.get(mat1[r][c]),lettermap.get(mat2[r][c])) - Math.min(lettermap.get(mat1[r][c]), lettermap.get(mat2[r][c]));

                if (diff < smallestDist)
                    smallestDist = diff;
            }
        System.out.println(smallestDist*5000 + " years");

    }
}
