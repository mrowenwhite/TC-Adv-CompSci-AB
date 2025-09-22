package Q1.Langdocs.Prog285b;

public class Prog285bHelper {
    private Node myroot;

    public Prog285bHelper() {
        myroot = null;
    }

    public void add(Node spot) {
        if (myroot == null) {
            myroot = spot;
        }
        else {
            spot.myNext = myroot;
            myroot = spot;
        }
    }

    public void print() {
        Node temp =  myroot;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.myNext;
        }
    }
}
