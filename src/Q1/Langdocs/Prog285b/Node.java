package Q1.Langdocs.Prog285b;

public class Node {
    private Com myPerson;
    public Node myNext;

    public Node(Com peop) {
        myPerson = peop;
        myNext = null;
    }

    public Com getCom() {
        return myPerson;
    }
}
