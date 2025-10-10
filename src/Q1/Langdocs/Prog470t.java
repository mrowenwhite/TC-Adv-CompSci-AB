package Q1.Langdocs;
import java.util.*;
import java.io.*;

public class Prog470t {
    public static void main(String[] args) throws IOException {
        Scanner file1 = new Scanner(new File("Langdats/prg470t1.dat"));
        Scanner file2 = new Scanner(new File("Langdats/prg470t2.dat"));
        int[][] mat = new int[4][4];
        int[][] mat2 = new int[4][4];

        // populate matrices
        while (file1.hasNextLine()) {
            for (int i = 0; i < 4; i++)
                for (int j = 0; j < 4; j++)
                    mat[i][j] = file1.nextInt();
        }
        while (file2.hasNextLine()) {
            for (int i = 0; i < 4; i++)
                for (int j = 0; j < 4; j++)
                    mat2[i][j] = file2.nextInt();
        }






    }
    boolean isMagicSqaure(int[][] mat) {
        boolean myOut = true;
        int[] rowSums = new int[4];
        int[] colSums = new int[4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                //TODO
            }
            //TODO
        }




        return myOut;
    }
}
