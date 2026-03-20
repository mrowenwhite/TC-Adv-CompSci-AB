package Sem2.Practice_Problems;

public class AutonomousVacuumMatrix {
    public static void main(String[] args) {
        int clean = 0,obsticles = 0;
        boolean lr = true;
        int[][] mat = {
                {0,0,0,0,0},
                {0,2,0,0,0},
                {0,0,0,2,0},
                {0,2,0,0,0},
                {0,2,0,0,0}
        };

        for (int i = 0; i < mat.length; i++){
            if (lr) {
                for (int j = 0; j < mat[0].length; j++) {
                    if (mat[i][j]==0) {
                        clean++;
                        mat[i][j] = 1;
                    }
                    else if (mat[i][j]==2) {
                        obsticles++;
                    }
                }
                lr = false;
            }
            else  {
                for (int j = mat[0].length; j > 0; j--) {
                    if (mat[i][j]==0) {clean++;mat[i][j] = 1;}
                    else if (mat[i][j]==2) obsticles++;
                    }
                }
                lr = true;
            }

        System.out.println("clean spaces: " + clean);
        System.out.println("Obstacles: " + (obsticles));
    }
}
