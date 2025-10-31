package Q1.Test;
import java.util.*;

class MazeTester {


    static boolean[][] visited;

    // Check if it is possible to go to (x, y) from the
    // current position. The function returns false if the
    // cell has value 0 or already visited
    static boolean isSafe(int[][] mat, boolean[][] visited,
                          int x, int y)
    {
        return (x >= 0 && x < mat.length && y >= 0
                && y < mat[0].length && mat[x][y] == 1
                && !visited[x][y]);
    }

    static int shortPath(int[][] mat, int i, int j,
                         int x, int y, int min_dist,
                         int dist)
    {

        if (i == x && j == y) {
            min_dist = Math.min(dist, min_dist);
            return min_dist;
        }

        // set (i, j) cell as visited
        visited[i][j] = true;
        // go to the bottom cell
        if (isSafe(mat, visited, i + 1, j)) {
            min_dist = shortPath(mat, i + 1, j, x, y,
                    min_dist, dist + 1);
        }
        // go to the right cell
        if (isSafe(mat, visited, i, j + 1)) {
            min_dist = shortPath(mat, i, j + 1, x, y,
                    min_dist, dist + 1);
        }
        // go to the top cell
        if (isSafe(mat, visited, i - 1, j)) {
            min_dist = shortPath(mat, i - 1, j, x, y,
                    min_dist, dist + 1);
        }
        // go to the left cell
        if (isSafe(mat, visited, i, j - 1)) {
            min_dist = shortPath(mat, i, j - 1, x, y,
                    min_dist, dist + 1);
        }
        // backtrack: remove (i, j) from the visited matrix
        visited[i][j] = false;
        return min_dist;
    }

    // Wrapper over shortPath() function
    static int shortPathLength(int[][] mat,
                               int[] src, int[] dest)
    {
        if (mat.length == 0 || mat[src[0]][src[1]] == 0
                || mat[dest[0]][dest[1]] == 0)
            return -1;

        int row = mat.length;
        int col = mat[0].length;

        // construct an `M × N` matrix to keep track of
        // visited cells
        visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++)
                visited[i][j] = false;
        }

        int dist = Integer.MAX_VALUE;
        dist = shortPath(mat, src[0], src[1],
                dest[0], dest[1], dist, 0);

        if (dist != Integer.MAX_VALUE)
            return dist;
        return -1;
    }


    public static void main(String[] args)
    {
        int[][] mat = new int[][] {
                { 0, 0, 1, 0, 0, 0, 0},
                { 0, 0, 1, 0, 0, 1, 0},
                { 0, 0, 0, 0, 1, 0, 0},
                { 0, 0, 0, 0, 1, 0, 0},
                { 0, 0, 0, 1, 0, 0, 1},
                { 0, 0, 1, 0, 0, 1, 0},
                { 1, 0, 1, 0, 0, 0, 0},

        };

        int[] src = { 0, 0 };
        int[] dest = { 6, 6 };
        int dist = shortPathLength(mat, src, dest);
        System.out.print(dist);

    }
}