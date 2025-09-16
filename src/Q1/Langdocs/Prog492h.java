package Q1.Langdocs;

import java.util.*;
import java.io.*;

public class Prog492h {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("Langdats/prog492h.dat"));

        String[][] mat = new String[30][30];
        String[][] ans = new String[30][30];

        int r = 0;
        while (file.hasNextLine()) {
            String line = file.nextLine();
            String[] chars = line.split("");
            mat[r] = chars;
            r++;
        }

        int count = 0;
        /
        for (r=0;r< mat.length;r++) {
            for (int c=0;c<mat[r].length;c++) {
                //1
                if (r>=1) {
                    String ch =  mat[r-1][c];
                    if (ch.equals("*")) {
                        count++;
                    }
                }
                //2
                if (r>=1&&c<=mat[r].length-2)   {
                    String ch =  mat[r-1][c+1];
                    if (ch.equals("*")) {
                        count++;
                }
            }
        }




    }


}
    public static boolean IsAvailable(int r, int c, int[][] matrix) {
        //TODO
    }
}

