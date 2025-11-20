package Sem1.BigLinkedList;

public class Node <T>{
    public Node<T> mynext;
    private T data;
    public Node<T> myNext;

    public Node(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return String.valueOf(this.data);
    }
    public T getData() {return this.data;}
}
