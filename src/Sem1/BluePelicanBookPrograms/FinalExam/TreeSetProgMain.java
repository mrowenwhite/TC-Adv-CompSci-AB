package Sem1.BluePelicanBookPrograms.FinalExam;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class TreeSetProgMain {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("src/Q1/TreeSetProgram/TreeSetProblemData.dat"));
        TreeSet<Student> tSet = new TreeSet<>();
        Iterator<Student> iterator = tSet.iterator();

        int sCount = file.nextInt();
        int rCount = file.nextInt();
        for (int lcv = 0; lcv < sCount; lcv++) { // each student name, class, grade
            String name = file.next();
            file.next();
            int grade = file.nextInt();

            for (Student student : tSet)
                if (student.getName().equals(name))
                    student.setGrade(grade);
            tSet.add(new Student(name, grade));
        }
        for (int lcv = 0; lcv < rCount; lcv++) {
            String[] line = file.nextLine().split(" ");
            String name = line[0];
            for (Student student : tSet) {
                if (student.getName().equals(name)) student.giveReferral();
            }
        }
        for (Student student : tSet) {
            if (student.getGrade() > 89 && (!student.hasReferral())) student.print();
        }
    }
}


