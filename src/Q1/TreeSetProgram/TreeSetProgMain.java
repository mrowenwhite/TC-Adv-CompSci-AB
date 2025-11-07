package Q1.TreeSetProgram;

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
            String   line    = file.nextLine();
            String[] data    = line.split(" ");
            String   name    = data[0];
            String   subject = data[1];
            int lowestGrade  = Integer.parseInt(data[2]);

            tSet.add(new Student(name, lowestGrade, false));
        }
        for (int lcv = 0; lcv < rCount; lcv++) { // each referral, studentName, month, day
            String name = file.next();
            for (Student student : tSet) {
                if (student.getName().equals(name)) {
                    student.giveReferral();
                }
            }
        }
        for  (Student student : tSet) {
            System.out.println(student);
        }


    }
}

