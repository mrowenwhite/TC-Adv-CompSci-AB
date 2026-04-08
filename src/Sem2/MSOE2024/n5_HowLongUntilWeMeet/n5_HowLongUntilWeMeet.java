package Sem2.MSOE2024.n5_HowLongUntilWeMeet;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class n5_HowLongUntilWeMeet {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("src/Sem2/MSOE2024/n5_HowLongUntilWeMeet/HowLong.txt"));
        int maxDistance =  sc.nextInt(), rows =  sc.nextInt(), cols =  sc.nextInt();
        char[][] mat1 = new char[rows][cols];
        char[][] mat2 = new char[rows][cols];

        String alph = "abcdefghijklmnopqrstuvwxyz";
        HashMap<Character, Integer> alphabet = new HashMap<Character, Integer>();
        for (int n = 0; n < alph.length(); n++) alphabet.put(alph.charAt(n), n);

        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                mat1[r][c] = sc.nextLine().charAt(r);

        sc.nextLine();

        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                mat2[r][c] = sc.nextLine().charAt(r);


        int smallestDist = Integer.MAX_VALUE;
        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                smallestDist = Math.min(Math.abs(alphabet.get(mat1[r][c])-alphabet.get(mat2[r][c])), smallestDist);
        System.out.println(smallestDist*5000 + " years");


    }
}
