package Langdocs;

import java.io.*;
import java.util.*;

public class Prog465h {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("Langdats/prog465h.dat"));


        while (file.hasNextInt()) {
            int zeros = 0;
            int nonzeros = 0;
            int[][] mat = new int[file.nextInt()][file.nextInt()];
            for (int r = 0; r < mat.length; ++r)
                for (int c = 0; c < mat[r].length; ++c) {
                    mat[r][c] = file.nextInt();
                    if (mat[r][c]==0) zeros++; else nonzeros++;
                }

            System.out.println("Original Matrix: ");
            for (int r = 0; r < mat.length; ++r) {
                for (int c = 0; c < mat[r].length; ++c)
                    System.out.print(mat[r][c] + " ");
                System.out.println();
            }

            System.out.println("Compressed Matrix: ");
            for (int r = 0; r < mat.length; ++r) {
                for (int c = 0; c < mat[r].length; ++c) {
                    if (mat[r][c]!=0) System.out.printf("%d %d %d\n", r+1, c+1, mat[r][c] );
                }
            }
            if (zeros > nonzeros) {
                System.out.println("The Matrix is Sparse\n The reduced is more Efficient.");
                System.out.println("\n\n");
            }
            else {
                System.out.println("The Matrix is abundant");
                if (zeros == nonzeros) {
                    System.out.println("They are equally efficient");
                }
                System.out.println("\n\n");
            }
        }
    }
}
/*
Original Matrix:
0 0 7 0 0 0
0 0 0 0 -8 0
0 0 0 0 0 0
2 0 0 0 0 0
0 0 0 0 0 0
Compressed Matrix:
1 3 7
2 5 -8
4 1 2
The Matrix is Sparse
 The reduced is more Efficient.



Original Matrix:
0 2 0 3 0 1
8 0 4 0 1 0
0 3 0 1 0 -7
5 0 9 0 6 0
0 2 0 -1 0 7
Compressed Matrix:
1 2 2
1 4 3
1 6 1
2 1 8
2 3 4
2 5 1
3 2 3
3 4 1
3 6 -7
4 1 5
4 3 9
4 5 6
5 2 2
5 4 -1
5 6 7
The Matrix is abundant
They are equally efficient



Original Matrix:
0 0 1 0 0 2
3 0 0 4 0 0
0 0 5 0 0 6
7 0 0 8 0 0
0 0 9 0 0 1
Compressed Matrix:
1 3 1
1 6 2
2 1 3
2 4 4
3 3 5
3 6 6
4 1 7
4 4 8
5 3 9
5 6 1
The Matrix is Sparse
 The reduced is more Efficient.




 */