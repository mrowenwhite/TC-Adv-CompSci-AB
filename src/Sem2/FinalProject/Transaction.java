package Sem2.FinalProject;

public class Transaction {
    private String mycat;
    private int myAmount;
    private String myDesc;
    public Transaction(String category, int amount, String description) {
        mycat = category;
        myAmount = amount;
        myDesc = (description.isEmpty()) ? "N/A" : description;
    }

    public String category() {
        return mycat;
    }
    public int amount() {
        return myAmount;
    }
    public String description() {
        return myDesc;
    }

    public String toString() {
        return mycat + "," + myAmount + "," + myDesc + "\n";
    }
}
