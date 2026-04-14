package Sem2.Marquette_practice;

import java.util.Scanner;

public class practice3 {
    public static void main(String[] args) {
        int count = 0;
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine().toLowerCase();
        for  (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < vowels.length; j++) {
                if (word.charAt(i) == vowels[j]) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
