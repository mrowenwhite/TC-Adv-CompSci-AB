package Sem1.BluePelicanBookPrograms.FinalExam;

public class Student implements Comparable<Student> {
    private String name;
    private int lowestGrade;
    private boolean hasReferral;

    public Student(String name, int lowestGrade) {
        this.name = name;
        this.lowestGrade = lowestGrade;
    }

    public String getName() {
        return name;
    }

    public boolean hasReferral() {
        return hasReferral;
    }
    public int getGrade() {
        return lowestGrade;
    }

    public void giveReferral() {
        hasReferral = true;
    }
    public void setGrade(int grade) {
        if (grade<lowestGrade)lowestGrade = grade;
    }

    @Override
    public int compareTo(Student o) {
        return  this.name.compareTo(o.name);
    }

    public void print() {
        System.out.println("Name:\t"+this.name +"\t" +"lowestGrade:\t"+this.lowestGrade+"\t");
    }
}
