package Langdocs.Prog410t;

import java.util.*;
import java.io.*;

public class Prog410t {
    public static void main(String[] args) throws IOException {
        Scanner f = new Scanner(new File("Langdats/survey.dat"));

        ArrayList<int[]> households = new ArrayList<>();
        while (f.hasNextInt()) {households.add(new int[] {f.nextInt(), f.nextInt(), f.nextInt()});}
        f = new Scanner(new File("Langdats/survey2.dat"));
        while (f.hasNextInt()) {households.add(new int[] {f.nextInt(), f.nextInt(), f.nextInt()});}

        int poverties = 0;
        for (int lcv = 0; lcv < households.size(); lcv++) {
            //p= $3750.00 + $750.00 * (m-2)
            poverties += (households.get(lcv)[1]) ? 1 : 0;

        }

    }
}
