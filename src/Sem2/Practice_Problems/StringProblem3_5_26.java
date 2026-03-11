package Sem2.Practice_Problems;

import java.util.Arrays;
import java.util.Scanner;

public class StringProblem3_5_26 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        String str = sc.nextLine().toLowerCase();
        System.out.println(str);
        System.out.println("Length of String is: " + length(str));
        System.out.println("The Length of the String without spaces is: " + lengthNoSpaces(str));
        System.out.println("The Number of Occurrences of the word \"the\" is: " + countThe(str));
    }


    public static int length(String str) {return str.length();}
    public static int lengthNoSpaces(String str) {return str.replace(" ", "").length();}
    public static int countThe(String str) {
        String[] arr = str.split(" ");
        int count = 0;
        for (String s : arr)
            if (s.equals("the"))count++;
        return count;
    }
}
