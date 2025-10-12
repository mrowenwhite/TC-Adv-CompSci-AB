package Q1;
import java.util.*;
import java.io.*;

public class Prog470t {
    public static void main(String[] args) throws IOException {
        Scanner file1 = new Scanner(new File("Langdats/prg470t1.dat"));
        Scanner file2 = new Scanner(new File("Langdats/prg470t2.dat"));
        int[][] mat = new int[4][4];
        int[][] mat2 = new int[4][4];

        while (file1.hasNextInt() && file2.hasNextInt()) {
            for (int i = 0; i < 4; i++)
                for (int j = 0; j < 4; j++) {
                    mat[i][j] = file1.nextInt();
                    mat2[i][j] = file2.nextInt();
                }
        }
        printMat(mat);
        System.out.println("Matrix one is " + (isMagicSquare(mat) ? " a Magic Square\n\n\n" : "not a Magic Square\n\n\n"));
        printMat(mat2);
        System.out.println("Matrix two is " + (isMagicSquare(mat2) ? " a Magic Square" : "not a Magic Square"));
    }

    public static boolean isMagicSquare(int[][] mat) {
        int n = mat.length;
        int[] rSum = new int[n], cSum = new int[n];
        int d1 = 0, d2 = 0, target = 0;

        for (int r = 0; r < n; r++) {
            if (mat[r].length != n) return false;
            for (int c = 0; c < n; c++) {
                rSum[r] += mat[r][c];
                cSum[c] += mat[r][c];
                if (r == c) d1 += mat[r][c];
                if (r + c == n - 1) d2 += mat[r][c];
                if (r == 0 && c == n - 1) target = rSum[0];
                if (c == n - 1 && rSum[r] != target) return false;
                if (r == n - 1 && cSum[c] != target) return false;
            }
        }
        return d1 == target && d2 == target;
    }


    public static void printMat(int[][] mat) {
        System.out.println("\n");
        int n = mat.length, rs[] = new int[n], cs[] = new int[n];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                System.out.print(mat[r][c] + "\t");
                rs[r] += mat[r][c];
                cs[c] += mat[r][c];
            }
            System.out.println("| " + rs[r]);
        }
        for (int c = 0; c < n; c++) System.out.print("—\t");
        System.out.println();
        for (int c = 0; c < n; c++) System.out.print(cs[c] + "\t");
        System.out.println("\n");
    }
}
/*


16	3	2	13	| 34
5	10	11	8	| 34
9	6	7	12	| 34
4	15	14	1	| 34
—	—	—	—
34	34	34	34

Matrix one is  a Magic Square





16	3	2	13	| 34
5	10	8	11	| 34
9	6	7	12	| 34
4	15	14	1	| 34
—	—	—	—
34	34	31	37

Matrix two is not a Magic Square

Process finished with exit code 0

 */