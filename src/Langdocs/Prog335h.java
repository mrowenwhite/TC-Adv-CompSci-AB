package Langdocs;

import java.util.*;
import java.io.*;

public class Prog335h {

    public static int diceroll(int p, int q) {
        boolean pEven = p%2==0;
        boolean qEven = q%2==0;
        return 1;
    }

    public static void main(String[] args) throws IOException {
         Scanner input = new Scanner(new File("Prog127a.dat"));
         while (input.hasNext()) {
             int p = input.nextInt();
             int q = input.nextInt();
         }

    }
}
/*
P	Q	Rule (value of the roll and condition)
	Even	Odd	2P + Q
	Odd 	Even	P + 2Q
	Even	Even	P + Q	When P not = Q
			3P	when P = Q
	odd	Odd	P + Q	when P not  =Q
			3Q	when P = Q
 */