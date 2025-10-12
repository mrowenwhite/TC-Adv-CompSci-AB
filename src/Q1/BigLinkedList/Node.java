package Q1.BigLinkedList;

public class Node <T>{
    private T myData;
    public Node myNext;

    public Node(T data) {
        this.myData = data;
    }

    @Override
    public String toString() {
        return String.valueOf(this.myData);
    }
}
