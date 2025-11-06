package Q1.TreeSetProgram;

public class Student<T extends Comparable<T>> {
    private T name;
    private int grade;
    private int referrals;

    public Student(T name, int grade, int referrals) {
        this.name = name;
        this.grade = grade;
        this.referrals = referrals;
    }

    public T getName() {return name;}
    public int getGrade() {return grade;}
    public int getReferals() {return referrals;}
}
