package Q1.BluePelicanBookPrograms.StudentClassification;

import java.util.*;
import java.io.*;

public class StuClassMain {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("src/Q1/BluePelicanBookPrograms/StudentClassification/StudentsAndGrades.dat"));
        TreeSet<String>[] list = new TreeSet[4];
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] lineArr = line.split(" ");String grade = lineArr[0], name = lineArr[1];
            list[(grade.equals("Freshman")) ? 0 : (grade.equals("Sophomore")) ? 1 : (grade.equals("Junior")) ? 2 : 3].add(name);
        }
        for  (int i = 0; i < list.length; i++) {
            System.out.println(list[i].toString());
        }

    }
}

