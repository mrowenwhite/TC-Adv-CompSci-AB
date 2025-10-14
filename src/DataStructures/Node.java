package DataStructures;

public class Node<T> {
    public Node<T> next;
    public Node<T> prev;
    private T data;


    public Node(T data) {
        this.data = data;
    }
    public Node<T> getNext() {
        return next;
    }
}
