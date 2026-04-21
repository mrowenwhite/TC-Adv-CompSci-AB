package Sem2.FinalProject;

public record Transaction(String category, int amount, String description) {
    public String toString() {return category + " " + amount + " " + description;}
}
