package Q1.Langdocs;
import java.util.*;
import java.io.*;

public class Prog470t {
    public static void main(String[] args) throws IOException {
        Scanner file1 = new Scanner(new File("Langdats/prg470t1.dat"));
        Scanner file2 = new Scanner(new File("Langdats/prg470t2.dat"));
        int[][] mat = new int[4][4];
        int[][] mat2 = new int[4][4];

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

        for (int[] row : mat) {
            for (int i : row)
                System.out.print(i + "\t");
            System.out.println("\t\t" + getSum(row));
        }
        if (isMagicSquare(mat)) System.out.println("Matrix 1 is a Magic Square!");
        else System.out.println("Matrix 1 is not a Magic Square..");
        System.out.println("\n\n\n");

        for  (int[] row : mat2) {
            for (int i : row)
                System.out.print(i + "\t");
            System.out.println("\t\t" + getSum(row));
        }
        for (int lcv = 0; lcv < mat2[0].length; lcv++) {
            System.out.print(getSum(mat2[lcv])+"\t");
        }
        System.out.println("\n\n\n");



        if (isMagicSquare(mat2)) System.out.println("Matrix 2 is a Magic Square!");
        else System.out.println("Matrix 2 is not  a Magic Square..");

    }

    public static boolean isMagicSquare(int[][] mat) {
        int sum = getSum(mat[0]);
        //Check Rows
        for (int i = 1; i < mat.length; i++) {
            if (getSum(mat[i]) != sum)
                return false;
        }
        //Check Cols
        for (int i = 1; i < mat[0].length; i++) {
            if (getSum(mat[0]) != sum)
                return false;
        }
        // Check Diags
        int tempsum = 0;
        for (int r=1; r < mat.length; r++) {
            for (int c=1; c < mat[0].length; c++) {
                if (r==c) tempsum += mat[r][c];
            }
        }
        if (tempsum != sum) return false;

        tempsum = 0;
        for  (int r = 1; r < mat.length; r++) {
            for (int c = 1; c < mat[0].length; c++) {
                if ((r+c)==2) tempsum += mat[r][c];
            }
        }
        if (tempsum != sum) return false;
        return true;
    }


    public static int getSum(int[] arr) {
        int sum = 0;
        for (int i : arr)
            sum += i;
        return sum;
    }
}
