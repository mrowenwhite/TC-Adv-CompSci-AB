package Sem2.MSOE2024;

import java.util.Scanner;

public class n1_ExploringAnts {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Side Lengths: ");int l = input.nextInt(), w = input.nextInt(), h = input.nextInt();
        System.out.printf("Distance to Travel: %.3f\n",(Math.sqrt(Math.pow(w, 2) + Math.pow(h, 2))) + (Math.sqrt(Math.pow(w, 2)+Math.pow(l, 2))) + (Math.sqrt(Math.pow(l, 2)+Math.pow(h, 2))));
    }
}
