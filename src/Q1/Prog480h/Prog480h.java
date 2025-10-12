package Q1.Prog480h;
import java.util.*;
import java.io.*;

public class Prog480h {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("Langdats/Prog480h.txt"));
        LinkedList<Student> students = new LinkedList<>();


        //key
        String[] tempKey = file.nextLine().split(" ");
        int[] key = new int[tempKey.length];
        for (int i = 1; i < tempKey.length; i++) {
            key[i] = Integer.parseInt(tempKey[i]);
        }

        //students
        while (file.hasNextLine()) {
            String line = file.nextLine();
            int id = Integer.parseInt(line.split(" ")[0]);
            int[] scores = new int[10];
            for (int i = 1; i < line.split(" ").length-1; i++) {
                scores[i] = Integer.parseInt(line.split(" ")[i]);
            }
            students.add(new Student(id, scores, key));
        }

        System.out.println("Key: " + Arrays.toString(key) + "\n");

        for (Student student : students) {
            System.out.println(student);
        }
    }
}

/*
HELPER CLASS
package Prog480h;

import java.util.Arrays;

public class Student {
    private int myId;
    private int[] scores;
    private char grade;
    private int[] myKey;

    public Student(int id, int[] scores, int[] key) {
        myKey = key;
        this.myId = id;
        this.scores = scores;
    }

    public int[] getScores() {
        return scores;
    }
    public char getGrade() {
        int p = 0;
        for (int lcv = 1; lcv < scores.length; lcv++) {
            if (scores[lcv] == myKey[lcv]) {
                p+=10;
            }
        }


        return (p>=90) ? 'A' : (p>=80) ? 'B' : (p>=70) ? 'C' : (p>=60) ? 'D' : 'F';
    }
    @Override
    public String toString() {
        return myId + "\t" +  Arrays.toString(scores) + "\t" + getGrade();
    }

}
 */

/*
OUTPUT

Key: [0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1]

180	[0, 0, 1, 1, 0, 1, 0, 1, 1, 0]	C
340	[0, 0, 1, 0, 1, 0, 1, 1, 1, 0]	F
341	[0, 0, 1, 1, 0, 1, 1, 1, 1, 1]	F
401	[0, 1, 1, 0, 0, 1, 0, 0, 1, 1]	C
462	[0, 1, 1, 0, 1, 1, 1, 0, 0, 1]	F
463	[0, 1, 1, 1, 1, 1, 1, 1, 1, 1]	F
464	[0, 0, 1, 0, 0, 1, 0, 0, 1, 0]	A
512	[0, 1, 0, 1, 0, 1, 0, 1, 0, 1]	F
618	[0, 1, 1, 1, 0, 0, 1, 1, 0, 1]	F
619	[0, 0, 0, 0, 0, 0, 0, 0, 0, 0]	D
687	[0, 1, 0, 1, 1, 0, 1, 1, 0, 1]	F
700	[0, 0, 1, 0, 0, 1, 1, 0, 0, 0]	C
712	[0, 0, 1, 0, 1, 0, 1, 0, 1, 0]	D
837	[0, 1, 0, 1, 0, 1, 1, 0, 1, 0]	F
 */
