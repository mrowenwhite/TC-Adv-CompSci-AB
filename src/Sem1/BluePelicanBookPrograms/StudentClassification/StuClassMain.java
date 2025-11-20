package Sem1.BluePelicanBookPrograms.StudentClassification;

import java.util.*;
import java.io.*;

public class StuClassMain {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("src/Q1/BluePelicanBookPrograms/StudentClassification/StudentsAndGrades.dat"));
        Map<String, Set<String>> map =  new HashMap<>();
        String[] keys = {"Freshman", "Sophomore", "Junior", "Senior"};
        for (int lcv = 0; lcv < keys.length; lcv++) {
            map.put(keys[lcv], new TreeSet<>());
        }
        while (sc.hasNextLine()) {
            map.get(sc.next()).add(sc.next());
        }
        for (String key : keys) {
            System.out.println(key  + " : " + map.get(key));
        }
    }
}
/*
Freshman : [Fred]
Sophomore : [Ahab, Julie, Solomon]
Junior : [Betty, David, Ruth]
Senior : [Agnes, Bill, Boaz, Jezebel]
 */
