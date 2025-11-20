package Sem1.Langdocs;

import java.util.*;
import java.io.*;

public class Prog335h {

    public static int diceroll(int p, int q) {
        boolean P = p%2==0;
        boolean Q = q%2==0;

        if (P&&!Q) {
            return (2*p)+q;
        }
        else if (!P&&Q) {
            return p+(2*q);
        }
        else {
            return (p!=q)? p+q : 3*p;
        }



    }

    public static void main(String[] args) throws IOException {
        System.out.println("P:\tQ:\tValue:");
         Scanner input = new Scanner(new File("Langdats/Prog127a.dat"));
         while (input.hasNext()) {
             int p = input.nextInt();
             int q = input.nextInt();
             int val = diceroll(p,q);
             System.out.printf("%d\t%d\t%d\n", p, q, val);


         }

    }
}
/*
P:	Q:	Value:
2	5	9
4	4	12
6	2	8
1	3	4
5	5	15
1	2	5
 */