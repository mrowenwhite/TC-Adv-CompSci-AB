package Sem2.ER_Management_System;
import java.util.*;

public class Patient implements Comparable<Patient> {
    private final String name;
    private Ailment ailment;
    private Stack<Ailment> TreatmentHistory;
    String uniqueID;

    public Patient (String name, String ailment, String uniqueID) {
        this.name = name;
        this.ailment = new Ailment(ailment);
        this.uniqueID = uniqueID;
    }
    public String getName() {return name;}
    public String getID() {return this.uniqueID;}
    public int getPriority() {return this.ailment.getPriority();}
    public Stack<Ailment> getTreatmentHistory() {return TreatmentHistory;}
    public Ailment getAilment() {
        return this.ailment;
    }

    public int compareTo(Patient p) {
        return Integer.compare(p.getPriority(), this.getPriority());
    }
}
