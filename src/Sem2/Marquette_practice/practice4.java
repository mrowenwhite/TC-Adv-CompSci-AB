package Sem2.Marquette_practice;

import java.util.ArrayList;
import java.util.Scanner;

public class practice4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfStudents = Integer.parseInt(sc.nextLine());
        int passed = 0;
        int failed = 0;
        ArrayList<student> students = new ArrayList<student>();


        for (int i = 0; i < numberOfStudents; i++) {
            String[] vals = sc.nextLine().split(" ");
            students.add(new student(vals[0], Double.parseDouble(vals[1]), Double.parseDouble(vals[2]), Double.parseDouble(vals[3])));
        }
        student topstudent = new student("TEST", 0, 0, 0);
        for (student student : students) {
            if (student.getAvgScore()>topstudent.getAvgScore())
                topstudent = student;

            else if (student.getAvgScore()==topstudent.getAvgScore())
                topstudent = (student.name.compareTo(topstudent.name)<0)?student:topstudent;

            passed = Math.toIntExact(students.stream().filter(s -> (s.getAvgScore() >= 60)).count());
            failed = Math.toIntExact(students.stream().filter(s -> (s.getAvgScore() <  60)).count());
        }

        System.out.println(topstudent.name);
        System.out.printf("%.2f\n", topstudent.getAvgScore());
        System.out.println(passed);
        System.out.println(failed);

        System.out.printf("%.2f\n",students.stream().mapToDouble(student::getAvgScore).sum()/(double)students.size());


    }
    public static class student {
        String name;
        double score1, score2,score3;
        public student(String name, double score1, double score2, double score3) {
            this.name = name;
            this.score1 = score1;
            this.score2 = score2;
            this.score3 = score3;
        }
        public double getAvgScore() {
            return (score1 + score2 + score3)/3;
        }
    }
}
