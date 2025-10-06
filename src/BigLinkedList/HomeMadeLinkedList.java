package BigLinkedList;

public class HomeMadeLinkedList<T> {
    private Node<T> myRoot;

    public HomeMadeLinkedList() {
        myRoot = null;
    }

    //Add methods from bigLL doc
    public boolean addFront(Node<T> node) {
        this.myNext = node;
        return this.myNext!=null;
    }
    public void printList() {
        Node temp = myRoot;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.myNext;
        }
    }
    public void addLast(Node<T> node) {
        Node temp = node;
        temp.myNext = this.myRoot;
        myRoot = node;

    }


}
