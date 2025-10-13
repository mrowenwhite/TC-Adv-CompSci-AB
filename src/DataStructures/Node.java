package DataStructures;

public class Node<T> {
    private Node<T> next;
    private T data;

    public Node(T data) {
        this.data = data;
    }
    public Node<T> getNext() {
        return next;
    }
}
