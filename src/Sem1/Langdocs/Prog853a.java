package Sem1.Langdocs;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Prog853a {
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

