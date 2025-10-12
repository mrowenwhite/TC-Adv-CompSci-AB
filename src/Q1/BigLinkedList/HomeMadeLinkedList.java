package Q1.BigLinkedList;

public class HomeMadeLinkedList<T> {
    private Node<T> myRoot;

    public HomeMadeLinkedList() {
        myRoot = null;
    }

    //Add methods from bigLL doc
    public boolean addFront(Node<T> node) {
        Node<T> temp = myRoot;
        while (temp.myNext!=null) {
            if (temp.myNext.myNext==null) {
                temp.myNext.myNext=node;
                break;
            }
            temp=temp.myNext;
        }
        return temp.myNext==node;
    }
    public void printList() {
        Node temp = myRoot;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.myNext;
        }
    }

    public void remove(int n) {

    }

    public void clear() {
        myRoot = null;
    }

    public void addLast(Node<T> node) {
       Node<T> temp = myRoot;
       while (temp.myNext!=null) {}
    }


}