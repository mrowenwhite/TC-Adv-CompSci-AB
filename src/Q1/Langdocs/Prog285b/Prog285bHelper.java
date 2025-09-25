package Q1.Langdocs.Prog285b;

public class Prog285bHelper {
    private Node myroot;

    public Prog285bHelper() {
        myroot = null;
    }

    public void addFront(Node spot) {
        if (myroot == null) {
            myroot = spot;
        }
        else {
            spot.myNext = myroot;
            myroot = spot;
        }
    }

    public void addBack(Node spot) {
        if (myroot == null) {
            myroot = spot;
        }
        else {
            Node temp = myroot;
            while (temp.myNext!=null) {
                temp = temp.myNext;
            }
            temp.myNext = spot;
        }
    }



    public void print() {
        Node temp =  myroot;
        while (temp != null) {
            System.out.println(temp.getCom());
            temp = temp.myNext;
        }
    }
}
