package Sem2.FinalProject;

public class Transaction {
    private final String category;
    private final int amount;
    private final String description;
    public Transaction(String cat, int amt, String desc) {
        this.category = cat;
        this.amount = amt;
        this.description = desc;
    }
    public String getCategory() {return category;}
    public int getAmount() {return amount;}
    public String getDescription() {return description;}
}
