package BigLinkedList;

public class Node <T>{
    private T myData;
    private Node myNext;

    public Node(T data) {
        this.myData = data;
    }

    @Override
    public String toString() {
        return String.valueOf(this.myData);
    }
}
