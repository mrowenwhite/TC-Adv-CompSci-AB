package Q1.Prog480h;

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
