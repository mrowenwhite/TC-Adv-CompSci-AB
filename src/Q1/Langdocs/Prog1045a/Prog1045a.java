package Q1.Langdocs.Prog1045a;

import java.util.Scanner;

public class Prog1045a {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        p1045helper list = new p1045helper();
        System.out.print("Enter the number of employees: ");
        int x = input.nextInt();
        for (int lcv = 1; lcv <= x; lcv++)
            list.addlast(lcv);
        System.out.println(list.GetSafeSpot());
    }
}
