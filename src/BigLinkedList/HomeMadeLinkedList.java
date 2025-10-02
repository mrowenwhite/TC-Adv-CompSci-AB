package BigLinkedList;

public class HomeMadeLinkedList<Node> {
    private Node myRoot;
    private Node myNext;

    public HomeMadeLinkedList() {
        myRoot = null;
    }

    //Add methods from bigLL doc
    public boolean addFront(Node node) {
        this.myNext = node;
        return this.myNext!=null;
    }
    public void printList() {
        while (this.myNext != null) {
            System.out.println(myNext);
        }
    }


}
