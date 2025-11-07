package Q1.TreeSetProgram;

public class Student implements Comparable<Student> {
    private String name;
    private int lowestGrade;
    private boolean hasReferral;

    public Student(String name, int lowestGrade, boolean referrals) {
        this.name = name;
        this.lowestGrade = lowestGrade;
        this.hasReferral = referrals;
    }

    public String getName() {return name;}
    public int getGrade() {return lowestGrade;}
    public boolean getReferal() {return hasReferral;}

    public void giveReferral() {
        hasReferral = true;
    }

    @Override
    public int compareTo(Student o) {
        return  this.name.compareTo(o.name);
    }
}
