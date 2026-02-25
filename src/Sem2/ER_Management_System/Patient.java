package Sem2.ER_Management_System;

public class Patient implements Comparable<Patient> {
    private String name;
    private int priority; //1-10

    public Patient (String name, int priority) {
        this.name = name;
        this.priority = priority;
    }
    public String getName() {return name;}
    public int getPriority() {return priority;}

    public int compareTo(Patient p) {
        return Integer.compare(p.getPriority(), this.getPriority());
    }
}
