package Sem2.Practice_Problems;

import java.util.*;

public class StudentGradeMap_3_30_2026 {
    public static void main(String[] args) {
        Set<Integer>        studentIds    = new HashSet<>();
        Map<String, Double> studentGrades = new HashMap<>();
        Scanner  sc       = new Scanner(System.in);
        int[]    ids      = {101, 102, 103, 104, 105};
        String[] names    = {"Alice", "Bob", "Charlie", "David", "Eve"};String   topName  = "#";
        double[] scores   = {88.5, 92.0, 79.5, 95.0, 84.0};             double   topScore = 0.0;
        for (int i = 0; i < 5; i++) {
            System.out.println((!studentIds.contains(ids[i]) ? (studentIds.add(ids[i])) ? "" : "duplicate Ignored":""));
            System.out.println((!studentGrades.containsKey(names[i]) ? (studentGrades.put(names[i], scores[i])) : "duplicate Ignored"));
            topScore = Math.max(scores[i], topScore);
            topName = (scores[i]>topScore) ? names[i] : topName;
        }
        System.out.println("Student IDs:\t" +  studentIds + "\nClass Average:\t" + Arrays.stream(scores).sum()/(ids.length)+"Top student:\t" + topName+"\n\nEnter Student ID: ");
        System.out.printf((studentIds.contains(sc.nextInt())) ? "Student Exists" : "Student Not Found");
    }
}
