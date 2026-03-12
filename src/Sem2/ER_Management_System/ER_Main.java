package Sem2.ER_Management_System;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;


public class ER_Main {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        PriorityQueue<Patient> queue = getPatients();
        while (!queue.isEmpty()) {
            Patient patient = queue.poll();

            ArrayDeque<String> actions = patient.getAilment().getActions();
            Stack<String> actionStack = new Stack<>();
            System.out.printf("%s\t%s\n\n", patient.getName(), patient.getAilment());
            while (!actions.isEmpty()) {
                boolean correctAction = CheckCorrectAction(actions.peek());
                if (correctAction) {
                    actionStack.push(actions.pop());
                    System.out.println("Action Preformed.\n");
                }
            }

            System.out.println("Patient Treated!  Continuing to next Patient\n\n");




        }
        System.out.println("All Patients Treated!\n");


    }

    private static PriorityQueue<Patient> getPatients() throws FileNotFoundException {
        PriorityQueue<Patient> queue = new PriorityQueue<>();
        Map<String, Patient> registry = new HashMap<>(); // patient.uniqueID -> patient
        Scanner sc = new Scanner(new File("src/Sem2/ER_Management_System/patients.txt"));

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] vals =  line.split(", ");
            Patient  patient = new Patient(vals[0], vals[1].strip(), vals[2]);
            if (!registry.containsKey(patient.getID())) {
                registry.put(patient.getID(), patient);
            }
            queue.add(patient);
        }
        return queue;
    }

    public static boolean CheckCorrectAction(String action) {
        System.out.println("Next Action: " + action + "\nIs this Action Correct? \n(y)->proceed\n(n)->try again\n");
        return (input.nextLine().toLowerCase().trim().charAt(0) == 'y');
    }
}
