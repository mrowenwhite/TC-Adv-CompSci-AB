package Langdocs.Prog410t;

public class Household {
    private int id;
    private int income;
    private int members;

    public Household(int id, int income, int members) {
        this.id      = id;
        this.income  = income;
        this.members = members;
    }

    public int getId()      {
        return this.id;
    }
    public int getIncome()  {
        return this.income; }

    public int getMembers() {
        return this.members;
    }
    public boolean isBelowPovertyLine() {
        return (income < 3700+(750*(members-2)));
    }

    @Override
    public String toString() {
        return id + "\t" + income + "\t" + members;
    }
}
